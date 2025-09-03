package ge.tbc.testautomation.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FavoritePage {
  Page page;
  public Locator allFavoritItems;
  public FavoritePage(Page page){  
      this.page = page;
      allFavoritItems = page.locator("//div[@class='card mb-3']");
  }
}
