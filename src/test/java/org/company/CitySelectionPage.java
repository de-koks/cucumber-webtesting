package org.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CitySelectionPage {

    private final WebDriver webDriver;
    private static final String SEARCH_FIELD_CLASS = "locality-selector-popup__search-input";
    private static final String CITY_NOT_FOUND_MESSAGE_CLASS = "locality-selector-popup__table-empty-text";

    public CitySelectionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void open(String url) {
        webDriver.get(url);
    }

    public void searchCity(String city) {
        final WebElement searchField = webDriver.findElement(By.className(SEARCH_FIELD_CLASS));
        searchField.sendKeys(city, Keys.ENTER);
    }

    public String getCityNotFoundMessage() {
        return webDriver.findElement(By.className(CITY_NOT_FOUND_MESSAGE_CLASS)).getText();
    }
}
