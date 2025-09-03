package ge.tbc.testautomation.util.helperClasses;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class MultipleBrowserContextTuple {
  private BrowserContext browserContext;
  private Page page;
  public MultipleBrowserContextTuple(BrowserContext browserContext,Page page){ 
    this.browserContext = browserContext;
    this.page = page;
  }

  public Page getPage() {
    return page;
  }
  public BrowserContext getBrowserContext() {
    return browserContext;
  }
}
