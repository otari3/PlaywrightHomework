package ge.tbc.testautomation.Pages.magnetoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MagnetoSignInPage {
  Page page;
  public Locator email;
  public Locator password;
  public Locator signInBtn;
  public MagnetoSignInPage(Page page){ 
      this.page = page;
      email = page.locator("#email");
      password = page.locator("//input[@id='pass' and not(@data-bind)]");
      signInBtn = page.locator("//button[@class='action login primary']");
  }
}
