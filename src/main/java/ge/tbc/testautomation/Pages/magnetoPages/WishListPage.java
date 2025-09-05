package ge.tbc.testautomation.Pages.magnetoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WishListPage {
  Page page;
  public String deleteBtn = "//a[@data-role='remove']";
  public WishListPage(Page page){  
    this.page = page;
  }

 public Locator getFavoriteItemWithName(String name){ 
    return page.locator("//a[@title='%s' and not(@data-bind)]/ancestor::li[@class='product-item']".formatted(name));
   }
}
