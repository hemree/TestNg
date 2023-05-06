package techproed.tests.Day25_ExcelUtils;

import jdk.management.jfr.ConfigurationInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

public class C03_BlueRentalExcelTest02 {

    @Test
    public void excelTest01() {

        /*
        EXCEL dosyasindaki tum email ve passwordler ile
        BlueRentalCar sayfasina gidip login olalim?
         */

        ExcelUtils excelUtils = new ExcelUtils("src/test/java/Resources/mysmoketestdata.xlsx", "customer_info");
        //Sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("fakeBlueRentalCar_url"));

        //Bir Loop oluşturup Excel dosyasında ki tüm verileri girdirelim.
        for (int i = 1; i <= excelUtils.rowCount(); i++) {
            BlueRentalPage blueRentalPage = new BlueRentalPage();

            String email = excelUtils.getCellData(i, 0);
            String password = excelUtils.getCellData(i, 1);

            blueRentalPage.login1.click();
            blueRentalPage.email.sendKeys(email + Keys.TAB + password + Keys.ENTER);
            Driver.bekle(1);
            Assert.assertTrue(blueRentalPage.verify.isDisplayed());

            blueRentalPage.verify.click();
            blueRentalPage.logOut.click();
            Driver.bekle(1);
            blueRentalPage.logOutOkay.click();
        }
        Driver.closeDriver();

    }
}
