package techproed.tests.Day24_Properties_Pages.SmokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;


public class NegativeTest extends ReusableMethods {

    @Test
    public void test01() {

        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        //Acceptance Criteria
        //Customer email: fake@bluerentalcars.com
        //Customer password: fakepass
        //Error:
        //User with email fake@bluerentalcars.com not found

        Driver.getDriver().get(ConfigReader.getProperty("fakeBlueRentalCar_url"));

        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login1.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeBlueRentalCar_email"));
        blueRentalPage.password.sendKeys(ConfigReader.getProperty("fakeBlueRentalCar_password"));
        blueRentalPage.login2.click();

        Driver.bekle(2);
        ReusableMethods.tumSayfaResmi();

        Assert.assertTrue(blueRentalPage.fakeLoginAlert.isDisplayed());

        Driver.bekle(1);

        Driver.closeDriver();
    }
}
