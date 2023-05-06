package techproed.tests.Day26_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class C01_DataProviderTest01 {

    @DataProvider(parallel = true)
    public Object[][] customerData() {
        String path = "src/test/java/Resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";

        //Excel Utils objesi oluşturarak  getDataArray() methodu ile iki boyutlu String Array'i DataProvider olarak return ediyorum
        ExcelUtils excelUtils = new ExcelUtils(path, sheetName);
        return excelUtils.getDataArrayWithoutFirstRow();
    }


    @Test(dataProvider = "customerData")
    public void dataProviderExcelTest(String email, String password) {
        //Sayfaya gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCar_url"));


        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login1.click();
        blueRentalPage.email.sendKeys(email);
        blueRentalPage.password.sendKeys(password);
        ReusableMethods.bekle(2);
        blueRentalPage.login2.click();

        Driver.closeDriver();
    }
}
