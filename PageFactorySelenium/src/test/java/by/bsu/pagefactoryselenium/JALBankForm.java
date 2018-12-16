package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JALBankForm {
    @FindBy(css = "#JS_modulePlaneTicket > h2:nth-child(20) > a")
    private WebElement jalBankTab;

    @FindBy(className = "loginBtn")
    private WebElement submitButton;

    private WebElement member_no;

    @FindBy(className = "inr_jmbLoginError")
    private WebElement errorMesageBox;

    private WebElement access_cd;

    public void selectJALBankTab() {
        jalBankTab.click();
    }

    public void submit() {
        submitButton.submit();
    }

    public void enterMemberNumber(String number) {
        member_no.sendKeys(number);
    }

    public boolean isErrorMessageDisplayed() {
        return errorMesageBox.isDisplayed();
    }

    public void enterPIN(String pin) {
        access_cd.sendKeys(pin);
    }
}
