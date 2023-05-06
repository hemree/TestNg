package techproed.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.internal.FactoryMethod;
import techproed.utilities.Driver;

public class TestCenterTechProPage {

    public TestCenterTechProPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='exampleInputEmail1']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='exampleInputPassword1']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement login;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement dashboard;

    @FindBy(xpath = "//*[@class='btn btn-dark']")
    public WebElement logOut;

    @FindBy(xpath = "//*[text()='Login Page']")
    public WebElement loginPage;


}
