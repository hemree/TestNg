package techproed.tests.Day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_DataProvider {

    /*
        -Data Provider bir çok veriyi test case'lere loop kullanmadan aktarmak için kullanılır.
        TestNG den gelen bir özelliktir. 2 Boyutlu bir Object Array return eder.
         DDT(Data Driven Testing) için kullanılır. Yani 1 den fazla veriyi test case'lerde aynı
        anda kullanmak için kullanılır.
        Kullanımı için @Test notasyonundan sonra parametre olarak dataprovider yazılır ve
        String bir isim belirtilir. Bu belirttiğimiz isimle @DataProvider notasyonu ile method oluşturulur.
         */


    @Test(dataProvider = "urunler")
    public void testDataProvider(String data) { //DataP. 'daki verileri alabilmek için
        // Test methodumuza String bir parametre ataması yaparız
        System.out.println(data);
    }

    @DataProvider(name = "googleTest")
    public static Object[][] urunler() {
        return new Object[][]{{"Volvo"}, {"Mercedes"}, {"Audi"}, {"Honda"}, {"Toyota"}, {"Opel"}, {"BMW"}};
    }

    /*
    Eğer farklı bir test method'u için aynı dataProvider method'u kullanılacaksa
    @DataProvider(name = "googleTest") şeklinde dataprovider notasyonundan sonra name parametresie oluşturduğumuz
    method'un adını yazınız
     */

    @Test(dataProvider = "googleTest")
    public void googleTest(String araclar) {
        //Google sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));

        //{"Volvo"},{"Mercedes"},{"Audi"},{"Honda"},{"Toyota"},{"Opel"},{"BMW"} araçlarını aratınız
        GooglePage googlePage = new GooglePage();
        googlePage.searchBox.sendKeys(araclar + Keys.ENTER);

        //Her aratmmadan sonra sayfa resmi alınız.
        ReusableMethods.tumSayfaResmi();
        ReusableMethods.bekle(2);
        Driver.closeDriver();


    }
}
