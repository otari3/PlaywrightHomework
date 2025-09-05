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
  public Locator signInBtn;
  public Locator accountDropDownBtn;
  public Locator wishListBtnFromDropDown;
  public Locator proceedToCheckOutBtn;
  public Locator burgerAccountBtn;
  public Locator signInBurgerBtn;
  public Locator createAccountBurgerBtn;
  public Locator buregerBtn;
  public Locator menuBugerBtn;
  public Locator whatsNewBurgerBtn;
  public Locator womenBurgerBtn;
  public Locator menBurgerBtn;
  public Locator gearBurgerBtn;
  public Locator salesBurgerBtn;
  public Locator signOutBtn;
  public MagnetoBasePage(Page page){ 
    this.page = page;
    searchInput = page.locator("#search");
    cardDropDown = page.locator("//span[text()='My Cart']/parent::a");
    viewAndEditCartBtn = page.locator("//span[text()='View and Edit Cart']/parent::a");
    storeLogo = page.locator("//a[@aria-label='store logo']");
    signInBtn = page.locator("(//div[@class='message global demo']/following::li[@class='authorization-link']//a)[1]");
    accountDropDownBtn = page.locator("(//div[@class='message global demo']/following::button[@class='action switch'])[1]");
    wishListBtnFromDropDown = page.locator("//div[@aria-hidden='false']//li[@class='link wishlist']//a");
    proceedToCheckOutBtn = page.locator("#top-cart-btn-checkout");
    burgerAccountBtn = page.locator("//a[@href='#store.links']");
    signInBurgerBtn = page.locator("//div[@id='store.links']//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']");
    createAccountBurgerBtn = page.locator("//div[@id='store.links']//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']");
    buregerBtn = page.locator("//span[@data-action='toggle-nav']");
    menuBugerBtn = page.locator("//a[@href='#store.menu']");
    whatsNewBurgerBtn = page.locator("//a[@href='https://magento.softwaretestingboard.com/what-is-new.html']");
    womenBurgerBtn = page.locator("//a[@href='https://magento.softwaretestingboard.com/women.html' and @class='level-top ui-corner-all']");
    menBurgerBtn = page.locator("//a[@href='https://magento.softwaretestingboard.com/men.html' and @class='level-top ui-corner-all']");
    gearBurgerBtn = page.locator("//a[@href='https://magento.softwaretestingboard.com/gear.html' and @class='level-top ui-corner-all']");
    salesBurgerBtn = page.locator("//a[@href='https://magento.softwaretestingboard.com/sale.html']");
    signOutBtn = page.locator("//div[@aria-hidden='false']//li[@class='authorization-link']//a");
  }
}
