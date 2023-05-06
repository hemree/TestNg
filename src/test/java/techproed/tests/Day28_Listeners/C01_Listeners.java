package techproed.tests.Day28_Listeners;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

/*
    Listeners; TestNG de bir test'in durumunu ve sonucunu izleyen ve bu duruma yanıt veren bir yapıdır.
    Testlerin passed ve failed olma durumlarını, başlangıç ve bitişini takip eder ve raporlayabilir.
        Bunun için TestNG'den ITestListener arayüzünü(interface) kullanırız. Oluşturduğumuz Listeners
    class'ına ITestListener arayüzündeki methodları Override etmek için implements ederiz.
     */

/*
Class'ı Listener ile ilişkilendirmek için ya Class başına @Listeners() eklenir
Yada XML dosyasına ekleme yapılır.
 */

@Listeners(techproed.utilities.Listeners.class) //Listener class'ın bulunduğu yolu belirtiyoruz.
public class C01_Listeners {

    @Test
    public void successTest() {
        System.out.println("PASS");
        assertTrue(true);
    }


    @Test
    public void failTest() {
        System.out.println("FAIL");
        assertTrue(false);
    }

    @Test
    public void skipTest() {
        System.out.println("SKIP");
        throw new SkipException("Atlandı!!!");
    }

    @Test
    public void failTestTechPro() {
        System.out.println("TechPro FAIL TEST");
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_url"));
        Driver.getDriver().findElement(By.xpath("OLMAYAN XPATH"));
    }


}