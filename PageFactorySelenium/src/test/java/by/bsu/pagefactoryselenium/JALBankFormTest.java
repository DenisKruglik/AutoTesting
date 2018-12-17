package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JALBankFormTest {
    private WebDriver driver;

    private JALBankForm form;

    @BeforeClass
    public void pageSetup() {
        driver = Driver.getInstance();
        form = PageFactory.initElements(driver, JALBankForm.class);
    }

    @Test
    public void shouldGetErrorMessageWhenMemberNumber23Entered() throws InterruptedException {
        form.selectJALBankTab();
        form.enterMemberNumber("23");
        form.submit();
        Thread.sleep(2000);
        boolean gotError = form.isErrorMessageDisplayed();
        Assert.assertTrue(gotError);
    }

    @Test(dependsOnMethods = {"shouldGetErrorMessageWhenMemberNumber23Entered"})
    public void shouldGetErrorMessageWhenPIN23Entered() throws InterruptedException {
        form.enterMemberNumber("1234567");
        form.enterPIN("23");
        Thread.sleep(2000);
        boolean gotError = form.isErrorMessageDisplayed();
        Assert.assertTrue(gotError);
    }
}
