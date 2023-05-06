package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalPage {

    public BlueRentalPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement login1;

    @FindBy(xpath = "//*[@type='email']")
    public WebElement email;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement login2;

    @FindBy(xpath = "//button[@id='dropdown-basic-button']")
    public WebElement verify;

    @FindBy(xpath = "(//a[@role='button'])[1]")
    public WebElement logOut;

    @FindBy(xpath = "//button[@class='ajs-button ajs-ok']")
    public WebElement logOutOkay;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement fakeLoginAlert;

}
