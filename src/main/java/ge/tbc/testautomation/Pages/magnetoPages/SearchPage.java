package ge.tbc.testautomation.Pages.magnetoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SearchPage {
  Page page;
  public Locator searchPageHeader;
  public SearchPage(Page page){  
    this.page = page;
    searchPageHeader = page.locator("//h1//span[contains(text(),'Search results for')]");
  }
  public Locator getProductByTitleLocator(String title){  
   return page.locator("//div[@class='product-item-info']//strong//a[contains(text(),'%s')]".formatted(title));
  }
}
