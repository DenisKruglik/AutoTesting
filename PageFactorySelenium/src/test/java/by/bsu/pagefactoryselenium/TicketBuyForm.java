package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TicketBuyForm {
    private final static String VALUE_ATTRIBUTE = "value";

    @CacheLookup
    private WebElement mdlArrArea1;

    @CacheLookup
    private WebElement mdlArrLocation1;

    @FindBy(css = "#JS_modulePlaneTicket > p > a")
    @CacheLookup
    private WebElement formOpenButton;

    public String getSelectedArrivalLocation() {
        return mdlArrLocation1.getAttribute(VALUE_ATTRIBUTE);
    }

    public void selectArrivalCountry(String countryName) {
        Select dropdown = new Select(mdlArrArea1);
        dropdown.selectByVisibleText(countryName);
    }

    public void toggleForm() {
        formOpenButton.click();
    }
}
