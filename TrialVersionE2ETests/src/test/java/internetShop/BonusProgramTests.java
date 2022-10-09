package internetShop;

import internetShop.pages.BonusProgram;
import org.junit.Assert;
import org.junit.Test;

public class BonusProgramTests extends TestBase{

    @Test
    public void bonusProgramPage_openBonusProgramPage_pageIsOpen() {
        //arrange
        var page = new BonusProgram(driver);
        //act
        page.open();
        //assert
        Assert.assertEquals(page.errorMessageTitleText, "Бонусная Программа", page.getTitle());
    }

    @Test
    public void bonusProgramPage_enterValidData_successfulRegistrationCard() {
        //arrange
        var page = new BonusProgram(driver);
        //act
        page.open();
        page.enterNameAndPhone().issueCardButton.click();

        //assert
        Assert.assertEquals(page.errorMessageRegistrationCardText, "Ваша карта оформлена!",
                page.getSuccessfulRegistrationCard());
    }

    @Test
    public void bonusProgramPage_allFieldsIsEmpty_errorMassageIsVisible() {
        //arrange
        var page = new BonusProgram(driver);
        //act
        page.open();
        page.issueCardButton.click();
        //assert
        Assert.assertEquals(page.errorMassageNameAndPhoneFields,
                "Поле \"Имя\" обязательно для заполнения\n" +
                "Поле \"Телефон\" обязательно для заполнения",page.getNameAndPhoneIsErrorMassage());
    }

    @Test
    public void bonusProgramPage_invalidNameAndPhone_errorMassageIsVisible() {
        //arrange
        var page = new BonusProgram(driver);
        //act
        page.open();
        page.userNameInput.sendKeys(page.invalidText);
        page.phoneInput.sendKeys(page.invalidText);
        page.issueCardButton.click();
        //assert
        Assert.assertEquals(page.errorMassageNameAndPhoneFields,
                "Введен неверный формат телефона",
                page.getNameAndPhoneIsErrorMassage());
    }

    @Test
    public void bonusProgramPage_allFieldsIsEmpty_borderColorIsRed() {
        //arrange
        var page = new BonusProgram(driver);
        //act
        page.open();
        page.phoneInput.sendKeys(page.validPhone);
        page.issueCardButton.click();
        //assert
        Assert.assertEquals(page.errorMassageNameAndPhoneFields,
                "Поле \"Имя\" обязательно для заполнения",
                page.getNameAndPhoneIsErrorMassage());
    }
}
