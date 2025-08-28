package ge.tbc.testautomation.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SoftwareTestingBasePage {
  Page page;
  public Locator signInBtn;
  public Locator menu;
  public Locator signOutBtn;
  public Locator favorite;
  public SoftwareTestingBasePage(Page page){  
    this.page = page;
    this.signInBtn = page.locator("//a[text()='Sign in']");
    this.menu = page.locator("#menu");
    this.signOutBtn = page.locator("//a[text()='Sign out']");
    this.favorite = page.locator("//a[text()='My favorites']");
  }
}
