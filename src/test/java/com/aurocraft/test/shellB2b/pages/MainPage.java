package com.aurocraft.test.shellB2b.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

  public MainPage (WebDriver driver) {
    super(driver);
  }

  public void checkPageIsCorrect() {
    isElementDisplayed(By.xpath("//div[@class= \"c-company-name\"]"));
  }
}
