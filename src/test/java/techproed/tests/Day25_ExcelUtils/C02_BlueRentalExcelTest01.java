package techproed.tests.Day25_ExcelUtils;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

public class C02_BlueRentalExcelTest01 {

    @Test
    public void excelTest01() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/Resources/mysmoketestdata.xlsx", "customer_info");
        String email = excelUtils.getCellData(1, 0);
        String password = excelUtils.getCellData(1, 1);
        System.out.println(email);
        System.out.println(password);

        //Bluerantal car adresine gidelim.
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCar_url"));
        //Excel dosyamızdan aldıgımız ılk emaıl ve password ıle sayfaya login olalım.
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login1.click();
        blueRentalPage.email.sendKeys(email);
        blueRentalPage.password.sendKeys(password);
        blueRentalPage.login2.click();

        //Login oldugumuzu dogrulayalım.
        Assert.assertTrue(blueRentalPage.verify.isDisplayed());
        Driver.bekle(1);
        //Çıkış yapalım
        blueRentalPage.verify.click();
        blueRentalPage.logOut.click();
        Driver.closeDriver();
    }
}
