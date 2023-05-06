package techproed.tests.Day24_Properties_Pages.SmokeTest;

import org.openqa.selenium.devtools.v110.input.model.DragData;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class PositiveTest {

    @Test
    public void test01() {

        /*
        Acceptance Criteria:
        Admin olarak, uygulamaya giriş yapabilmeliyim
        https://www.bluerentalcars.com/
        Admin email: jack@gmail.com
        Admin password: 12345
         */

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCar_url"));
        Driver.bekle(1);

        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login1.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("blueRentalCar_email"));
        blueRentalPage.password.sendKeys(ConfigReader.getProperty("blueRentalCar_password"));
        blueRentalPage.login2.click();
        Driver.bekle(1);

        Assert.assertEquals(blueRentalPage.verify.getText(), "Jack Nicholson");

        Driver.bekle(1);

        Driver.closeDriver();
    }
}
