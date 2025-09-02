package ge.tbc.testautomation.Pages;

import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignInPage {
  Page page;
  public Locator registerYourAccountLink;
  public Locator emailAdressInput;
  public Locator password;
  public Locator loginBtn;
  public Locator signInbtn;
  public Locator myAccountHeader;
  public Locator homePageIcon;
  public SignInPage(Page page){ 
    this.page = page;
    registerYourAccountLink = page.getByText(Pattern.compile("Register your account"));
    emailAdressInput = page.getByLabel("Email address *");
    password = page.getByLabel("Password *");
    loginBtn = page.locator("//input[@data-test='login-submit']");
    signInbtn = page.locator("//a[text()='Sign in']");
    myAccountHeader = page.locator("//h1[text()='My account']");
    homePageIcon = page.locator("//a[@title='Practice Software Testing - Toolshop']");
  }
}
