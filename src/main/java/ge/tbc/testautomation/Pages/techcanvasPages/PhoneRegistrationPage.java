package ge.tbc.testautomation.Pages.techcanvasPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PhoneRegistrationPage {
  Page page;
  public Locator firstNameInput;
  public Locator lastNameInput;
  public Locator maleRadioBtn;
  public Locator selectModel;
  public Locator address1Input;
  public Locator address2Input;
  public Locator cityInput;
  public Locator contact1Input;
  public Locator contact2Input;
  public PhoneRegistrationPage(Page page){  
    this.page = page;
    firstNameInput = page.locator("//input[@value='First Name']");
    lastNameInput = page.locator("//input[@value='Last Name']");
    maleRadioBtn = page.locator("//input[@value='male']");
    selectModel = page.locator("//select[@name='model']");
    address1Input = page.locator("//input[@value='Address1']");
    address2Input = page.locator("//input[@value='Address2']");
    cityInput = page.locator("//input[@value='City']");
    contact1Input = page.locator("//input[@value='Contact1']");
    contact2Input = page.locator("//input[@value='Contact2']");
  }
}
