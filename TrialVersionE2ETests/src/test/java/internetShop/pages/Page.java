package internetShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    protected WebDriver driver;

    public String validName = "Nameless";
    public String validPhone = "+79591237410";
    public String invalidText = "!\"№;%:?*()_+ 1234567890-= !@#$%^&*()_+ kjhgj";

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(getPageUrl());
    }
    protected String getPageSubUrl() {
        return "";
    }

    private String getPageUrl() {
        return url + getPageSubUrl();
    }

    private String url = "http://intershop6.skillbox.ru/";

    @FindBy(className = "current")
    public WebElement title;

    public String getTitle() {return title.getText();}
}
