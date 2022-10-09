package internetShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BonusProgram extends Page {
    private String subUrl = "bonus/";

    public String errorMessageTitleText = "Не отобразилость наименование раздела";
    public String errorMessageRegistrationCardText = "Не отобразилость уведомление об успешном оформлениик карты";
    public String errorMassageNameAndPhoneFields = "Не отобразилость уведомление о некоректных введенных данных или поля не заполнены";

    @FindBy(id = "bonus_username")
    public WebElement userNameInput;
    @FindBy(id = "bonus_phone")
    public WebElement phoneInput;

    @FindBy(xpath = "//*[@id ='bonus_main']//*[text()='Оформить карту']")
    public WebElement issueCardButton;

    @FindBy(xpath = "//*[@id ='bonus_main']//*[text()='Ваша карта оформлена!']")
    public WebElement successfulRegistrationCardText;
    @FindBy(id = "bonus_content")
    public WebElement errorMassageNameAndPhoneFieldsIsEmptyText;

    @Override
    protected String getPageSubUrl() {
        return subUrl;
    }

    public BonusProgram(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String getSuccessfulRegistrationCard() {
        return successfulRegistrationCardText.getText();
    }

    public BonusProgram enterNameAndPhone() {
        userNameInput.sendKeys(validName);
        phoneInput.sendKeys(validPhone);
        return this;
    }
    public String  getNameAndPhoneIsErrorMassage() {
        return errorMassageNameAndPhoneFieldsIsEmptyText.getText();
    }

}
