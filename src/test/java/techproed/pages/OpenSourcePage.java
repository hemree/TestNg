package techproed.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

    /*
    Locate'lerimizi tek bir yerde düzenli bir şekilde tutabilmek için:
        1-İlk olarak oluşturduğumuz page class'ımızda bir construtor oluştururuz.
        2-PageFactory class'ından initelements methodu ile driver'ı tanıtırız.
        3-@FindBy notasyonu kullanarak locate'lerimizi alırız.
     */

    public OpenSourcePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement login;

    @FindBy(xpath = "//h6")
    public WebElement dashboard;

}
