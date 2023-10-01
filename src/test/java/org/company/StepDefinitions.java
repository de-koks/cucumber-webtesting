package org.company;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    public static final WebDriver webDriver = new ChromeDriver();

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Denis\\tools\\chrome-win64\\chrome.exe");
//        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
    }

    @Given("restaurant url {string}")
    public void restaurant_url(String url) {
        webDriver.get(url);
    }
    @Then("select city {string}")
    public void select_city(String city) {
        final WebElement searchField = webDriver.findElement(By.className("locality-selector-popup__search-input"));
        searchField.sendKeys(city, Keys.ENTER);
    }
    @Then("check that selected city is {string}")
    public void check_that_selected_city_is(String expectedCity) {
        final String actualCity = webDriver.findElement(By.xpath("//a[@data-testid='header__about-slogan-text_link']")).getText();
        assertEquals(expectedCity, actualCity);
    }

    @Then("message {string} is displayed")
    public void message_is_displayed(String expectedMessage) {
        final String actualMessage = webDriver.findElement(By.className("locality-selector-popup__table-empty-text")).getText();
        assertEquals(expectedMessage, actualMessage);
    }

}
