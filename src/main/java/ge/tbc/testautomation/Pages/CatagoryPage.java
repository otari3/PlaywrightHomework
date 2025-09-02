package ge.tbc.testautomation.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CatagoryPage {
  Page page;
  public Locator addFavoriteBtn;
  public Locator succsesfulAdd;
  public Locator homePageIcon;
  public Locator catagorys;
  public Locator catagoryTitle;
  public CatagoryPage(Page page){  
    this.page = page;
    addFavoriteBtn = page.locator("#btn-add-to-favorites");
    succsesfulAdd = page.locator("//div[@aria-label='Product added to your favorites list.']");
    homePageIcon = page.locator("//a[@title='Practice Software Testing - Toolshop']");
    catagorys = page.locator("//h1[@data-test='product-name']/following::p[1]//span");
    catagoryTitle = page.locator("//h1[@data-test='product-name']");
  }
}
