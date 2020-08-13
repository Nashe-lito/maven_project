package com.aurocraft.test.shellB2b.pages;

import com.aurocraft.test.shellB2b.helpers.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage extends BasePage {

  public AuthPage(WebDriver driver) {
    super(driver);
  }


  public void goTo() {
    driver.get(ConfProperties.getProperty("url"));
  }

  public void fillLoginField(String login) {
    type(By.xpath("//input[@class=\"c-input\"]"), login);
  }

  public void fillPasswordField(String password) {
    type(By.xpath("//input[@class=\"c-password__input\"]"), password);
  }

  public void clickLoginButton() {
    click(By.cssSelector("[class=\"c-button c-button--primary\"]"));
  }
}
