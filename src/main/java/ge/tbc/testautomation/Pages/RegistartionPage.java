package ge.tbc.testautomation.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegistartionPage {
  Page page;
  public Locator firstNameInput;
  public Locator lastNameInput;
  public Locator dateOfBirth;
  public Locator street;
  public Locator postalCode;
  public Locator city;
  public Locator state;
  public Locator country;
  public Locator phone;
  public Locator emailAdress;
  public Locator password;
  public Locator registerBtn;
  public Locator alreadyRegisteredAlert;
  public RegistartionPage(Page page){  
  this.page = page;
  firstNameInput = page.getByLabel("First name");
  lastNameInput = page.getByLabel("Last name");
  dateOfBirth = page.getByLabel("Date of Birth *");
  street = page.getByLabel("Street");
  postalCode = page.getByLabel("Postal code");
  city = page.getByLabel("City");
  state = page.getByLabel("State"); 
  country = page.getByLabel("Country");
  phone = page.getByLabel("Phone");
  emailAdress = page.getByLabel("Email address");
  password = page.getByLabel("Password");
  registerBtn = page.locator("//button[@data-test='register-submit']");
  alreadyRegisteredAlert = page.locator("//div[text()='A customer with this email address already exists.']");
  }

}
