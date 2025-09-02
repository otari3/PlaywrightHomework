package ge.tbc.testautomation.Pages;

import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
  Page page;
  public Locator homePageIcon;
  public Locator allCatagoryCards;
  public HomePage(Page page){  
    this.page = page;
    homePageIcon = page.locator("//a[@title='Practice Software Testing - Toolshop']");
    allCatagoryCards = page.locator("//div[@class='container']//a[@class='card']");
  }
  public Locator getProductByTitle(String title){ 
    return page.locator("//a[@class='card']//h5[contains(text(),'%s')]/ancestor::a".formatted(title));
  }
  public Locator getCatagoryCheckBoxByTitle(String title){  
    return page.getByLabel(Pattern.compile(title));
  }
}
