package ge.tbc.testautomation.Pages.magnetoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage {
  Page page;
  public CartPage(Page page){  
    this.page = page;
  }
  public Locator getItemWithPriceAndName(String name,String price){ 
    return page.locator("//a[text()='%s']/ancestor::tr/td[@class='col price']//span[@class='price' and text()='%s']".formatted(name,price));
  }
  public Locator getRemoveItemBtnWithProductName(String name){  
    return page.locator("//a[text()='%s' and not(@data-bind)]/ancestor::tbody//a[@title='Remove item']".formatted(name));
  }
  public Locator getProductByName(String name){ 
    return page.locator("//a[text()='%s' and not(@data-bind)]/ancestor::tbody".formatted(name));
  }
}
