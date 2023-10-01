package org.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CityMenuPage {

    private final WebDriver webDriver;
    private static final String ACTUAL_CITY_XPATH = "//a[@data-testid='header__about-slogan-text_link']";

    public CityMenuPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentCity() {
        return webDriver.findElement(By.xpath(ACTUAL_CITY_XPATH)).getText();
    }
}
