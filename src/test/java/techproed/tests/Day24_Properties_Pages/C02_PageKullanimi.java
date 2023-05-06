package techproed.tests.Day24_Properties_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PageKullanimi {

    @Test
    public void test1() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("opensource_url"));
        /*
            Yukardaki adress için 20 adet test methodu oluşturursak sonrasında yukardaki url'de bir değişiklik
        olduğunda bütün test methodlarından tek tek url düzeltmek yerine bir kere .properties dosyamdan
        url'li düzeltirim ve bu bizim için daha hızlı daha düzenli ve daha kolay olur
         */
        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        //Driver.getDriver().findElement(By.xpath("locate"));
        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.username.sendKeys(ConfigReader.getProperty("username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("password"));
        openSourcePage.login.click();

        Driver.bekle(3);
        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());

        Driver.closeDriver();
    }
}
