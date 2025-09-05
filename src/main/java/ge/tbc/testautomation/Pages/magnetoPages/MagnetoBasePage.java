package ge.tbc.testautomation.Pages.magnetoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MagnetoBasePage {
  Page page;
  public String searchResults = "//div[@id='search_autocomplete']";
  public Locator searchInput;
  public Locator cardDropDown;
  public Locator viewAndEditCartBtn;
  public Locator storeLogo;
  public MagnetoBasePage(Page page){ 
    this.page = page;
    searchInput = page.locator("#search");
    cardDropDown = page.locator("//span[text()='My Cart']/parent::a");
    viewAndEditCartBtn = page.locator("//span[text()='View and Edit Cart']/parent::a");
    storeLogo = page.locator("//a[@aria-label='store logo']");
  }
}
