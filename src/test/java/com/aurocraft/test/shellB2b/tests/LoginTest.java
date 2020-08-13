package com.aurocraft.test.shellB2b.tests;

import com.aurocraft.test.shellB2b.helpers.ConfProperties;
import com.aurocraft.test.shellB2b.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


  @Test
  public void login() {
  authPage.goTo();
  authPage.fillLoginField(ConfProperties.getProperty("login"));
  authPage.fillPasswordField(ConfProperties.getProperty("password"));
  authPage.clickLoginButton();
  mainPage.checkPageIsCorrect();
  }
}
