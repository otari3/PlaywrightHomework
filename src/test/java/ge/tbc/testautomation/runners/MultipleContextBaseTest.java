package ge.tbc.testautomation.runners;

import java.util.Arrays;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleContextBaseTest {
  Playwright playwright;
  Browser browser;
  protected BrowserContext browserContext;
  protected Page page;
  protected Integer currUserIndex = 0;
  @BeforeClass
  public void setUp(){  
    playwright = Playwright.create();
    playwright = Playwright.create();
    BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions(); 
    launchOptions.setArgs(Arrays.asList("--no-sandbox", "--disable-gpu", "--disable-extensions"));
    browser = playwright.chromium().launch(launchOptions);
  }

  @BeforeMethod
  public void setUpContextAndPage(){  
    browserContext = browser.newContext();
    page = browserContext.newPage();
  }

  protected void openPage(String url){  
    page.navigate(url);
  }

  @AfterMethod
  public void tearDownContext(){  
    browserContext.close();
    page.close();
    currUserIndex++;
  }
  @AfterClass
  public void tearDown(){ 
    browser.close();
  }

}
