package techproed.tests.Day28_Listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.NoSuchElementException;

@Listeners(techproed.utilities.Listeners.class)
public class C01_ListenersTest {

    /*
    Bir Class'da Listeners Kullanabilmek için Class'dan önce @Listeners Notasyonu eklememiz gerekir.
    Notasyon içine Parametre olarak oluşturmuş olduğumuz,
    Utilities Package'ı altında'li Listeners Class'ının yolunu belirtmemiz gerekir.
     */

    @Test
    public void test1() {
        System.out.println("PASSED");
        Assert.assertTrue(true);
        Assert.assertEquals(2, 2);
    }

    @Test
    public void test2() {
        System.out.println("FAILED");
        Assert.assertTrue(false);
    }

    @Test
    public void test3() {
        System.out.println("SKIP");
        throw new SkipException("Method Atlandı");
    }

    @Test
    public void test4() {
        System.out.println("NO SUCH ELEMENT EXCEPTION");
        throw new NoSuchElementException();

        /*
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Driver.getDriver().findElement(By.xpath("sdgskmgdsşggsrjn"));
        */
    }

}
