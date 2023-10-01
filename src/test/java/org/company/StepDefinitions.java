package org.company;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final CitySelectionPage citySelectionPage;
    public static final CityMenuPage cityMenuPage;

    static {
        webDriver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Denis\\tools\\chrome-win64\\chrome.exe");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        citySelectionPage = new CitySelectionPage(webDriver);
        cityMenuPage = new CityMenuPage(webDriver);
    }

    @Given("restaurant url {string}")
    public void restaurant_url(String url) {
        citySelectionPage.open(url);
    }
    @Then("select city {string}")
    public void select_city(String city) {
        citySelectionPage.searchCity(city);
    }
    @Then("check that selected city is {string}")
    public void check_that_selected_city_is(String expectedCity) {
        final String currentCity = cityMenuPage.getCurrentCity();
        assertEquals(expectedCity, currentCity);
    }

    @Then("message {string} is displayed")
    public void message_is_displayed(String expectedMessage) {
        final String actualMessage = citySelectionPage.getCityNotFoundMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
