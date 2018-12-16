package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CityLangFormTest {
    private final static String URL = "https://www.jal.com/index.html";

    private final static String CITY_NAME = "Moscow";

    private final static String RUSSIAN_LANGUAGE = "РУССКИЙ";

    private WebDriver driver;

    @BeforeClass
    public void setupPage() {
        driver = Driver.getInstance();
        driver.get(URL);
    }

    @Test
    public void shouldSuggestedLanguageSwitchToRussianWhenMoscowIsChosen() {
        CityLangForm form = PageFactory.initElements(driver, CityLangForm.class);
        form.selectCity(CITY_NAME);
        String lang = form.getLanguageSelected();
        Assert.assertEquals(RUSSIAN_LANGUAGE, lang);
    }
}
