package com.aurocraft.test.shellB2b.tests;

import com.aurocraft.test.shellB2b.pages.AuthPage;
import com.aurocraft.test.shellB2b.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

  public WebDriver driver;
  public WebDriverWait wait;

  public AuthPage authPage;
  public MainPage mainPage;


  @BeforeClass
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    authPage = PageFactory.initElements(driver,AuthPage.class);
    mainPage = PageFactory.initElements(driver, MainPage.class);
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }

  @AfterMethod
  public void failed(ITestResult arg0){
    if (arg0.FAILURE == arg0.getStatus()){
      screenFailure();
    }
  }

  public void screenFailure() {
    long now = System.currentTimeMillis();

    try {
      TakesScreenshot ts = (TakesScreenshot)driver;
      File source = ts.getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(source, new File("src/test/java/screenshots/screen" + now + ".png" ));
      System.out.println("The screen is taken");
    } catch (IOException e){
      e.printStackTrace();
    }
  }
}
