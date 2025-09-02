package ge.tbc.testautomation.runners;


import java.util.Arrays;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;



public class BaseTest {
  protected BrowserContext browserContext;
  protected Playwright playwright;
  protected Browser browser;
  protected Page page;
  @BeforeClass
  public void setUp(){  
    playwright = Playwright.create();
    BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions(); 
    launchOptions.setArgs(Arrays.asList("--no-sandbox", "--disable-gpu", "--disable-extensions","--start-maximized"));
    launchOptions.setHeadless(false);
    browser = playwright.chromium().launch(launchOptions);
    Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
    contextOptions.setViewportSize(null);
    browserContext = browser.newContext(contextOptions);
    page = browserContext.newPage();
    PlaywrightAssertions.setDefaultAssertionTimeout(10000);
  }
  protected void openPage(String url){  
      page.navigate(url);
  }

  @AfterClass
  public void tearDown(){ 
      browserContext.close();
      browser.close();
      playwright.close();
  }
}
