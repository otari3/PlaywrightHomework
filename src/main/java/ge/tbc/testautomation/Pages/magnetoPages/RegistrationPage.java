package ge.tbc.testautomation.Pages.magnetoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegistrationPage {
  Page page;
  public Locator creatAccoutBtn;
  public Locator firstName;
  public Locator lastName;
  public Locator email;
  public Locator password;
  public Locator passwordConformation;
  public Locator registerBtn;
  public RegistrationPage(Page page){  
    this.page = page;
    creatAccoutBtn = page.locator("//div[@class='actions-toolbar']//a[@href='https://magento.softwaretestingboard.com/customer/account/create/' and not(@data-bind)]");
    firstName = page.locator("#firstname");
    lastName = page.locator("#lastname");
    email = page.locator("#email_address");
    password = page.locator("#password");
    passwordConformation = page.locator("#password-confirmation");
    registerBtn = page.locator("//button[@title='Create an Account']");
  }
  public Locator getFavoriteItemWithName(String name){ 
    return page.locator("//a[@title='%s' and not(@data-bind)]/ancestor::li[@class='product-item']".formatted(name));
  }
  public Locator getSuccsesAlartWithProductTitle(String name){ 
      return page.locator("//div[@class='message-success success message']//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)' and contains(text(),'%s')]".formatted(name));
  }
  public Locator getWelcomeMesage(String firtname,String lastName){ 
    String welcomeMessage = "Welcome, %s %s!".formatted(firtname,lastName);
    return page.locator("//div[@class='message global demo']/following::span[@class='logged-in' and text()='%s'][1]".formatted(welcomeMessage));
  }
}
