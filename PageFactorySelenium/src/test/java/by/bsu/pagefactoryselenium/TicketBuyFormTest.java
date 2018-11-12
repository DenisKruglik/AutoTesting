package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TicketBuyFormTest {
    private final static String URL = "http://www.ru.jal.co.jp/rul/en/?city=MOW";

    private final static String CHROMEDRIVER_PATH = "D:/Program Files/chromedriver.exe";

    private final static String COUNTRY = "Австралия";

    private final static String EXPECTED_CITY = "SYD";

    private WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void shouldArrivalCityChangeToSydneyWhenAustraliaIsSelected() {
        driver.get(URL);
        TicketBuyForm form = PageFactory.initElements(driver, TicketBuyForm.class);
        form.toggleForm();
        form.selectArrivalCountry(COUNTRY);
        String cityName = form.getSelectedArrivalLocation();
        Assert.assertEquals(EXPECTED_CITY, cityName);
    }

    @AfterSuite
    public void quit() {
        driver.quit();
    }
}
