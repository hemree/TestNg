package techproed.tests.Day24_Properties_Pages;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestCenterTechProPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_PageKullanimi {

    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenter_url"));


        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterTechProPage testCenterTechProPage = new TestCenterTechProPage();
        testCenterTechProPage.username.sendKeys(ConfigReader.getProperty("kullaniciAdi"));
        Driver.bekle(1);
        testCenterTechProPage.password.sendKeys(ConfigReader.getProperty("KullaniciPassword"));
        Driver.bekle(1);
        testCenterTechProPage.login.click();
        Driver.bekle(1);

        Assert.assertTrue(testCenterTechProPage.dashboard.isDisplayed());


        //Sayfadan cikis yap ve cikis yapildigini test et
        testCenterTechProPage.logOut.click();
        Driver.bekle(1);

        Assert.assertTrue(testCenterTechProPage.loginPage.isDisplayed());

        Driver.closeDriver();
    }
}
