package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;

import ge.tbc.testautomation.Pages.RegistartionPage;
import io.qameta.allure.Step;

public class RegistrationSteps {
  Page page;
  RegistartionPage registartionPage;
  public RegistrationSteps(Page page){ 
    this.page = page;
    registartionPage = new RegistartionPage(page);
  }
  @Step("Fill First Name")
  public RegistrationSteps fillFirstName(String val){ 
    registartionPage.firstNameInput.fill(val);
    return this;
  }
  @Step("Fill Last Name")
  public RegistrationSteps fillLastName(String val){  
    registartionPage.lastNameInput.fill(val);
    return this;
  }
  @Step("Fill Date Of Birth")
  public RegistrationSteps fillDateOfBirth(String val){ 
    registartionPage.dateOfBirth.fill(val);
    return this;
  }
  @Step("Fill Streets")
  public RegistrationSteps fillStreets(String val){ 
    registartionPage.street.fill(val);
    return this;
  }
  @Step("Fill Postal Code")
  public RegistrationSteps fillPostalCodes(String val){ 
    registartionPage.postalCode.fill(val);
    return this;
  }
  @Step("Fill City")
  public RegistrationSteps fillCity(String val){  
    registartionPage.city.fill(val);
    return this;
  }
  @Step("Fill State")
  public RegistrationSteps fillState(String val){ 
    registartionPage.state.fill(val);
    return this;
  }
  @Step("Select Country")
  public RegistrationSteps selectCountry(String val){   
    registartionPage.country.selectOption(val);
    return this;
  }
  @Step("Fill Phone")
  public RegistrationSteps fillPhone(String val){ 
    registartionPage.phone.fill(val);
    return this;
  }
  @Step("Fill Email Adress")
  public RegistrationSteps fillEmailAdress(String val){ 
    registartionPage.emailAdress.fill(val);
    return this;
  }
  @Step("Fill Password")
  public RegistrationSteps fillPassword(String val){  
    registartionPage.password.fill(val);
    return this;
  }
  @Step("Register")
  public boolean register(){
    registartionPage.registerBtn.click();
  try {
    registartionPage.alreadyRegisteredAlert.waitFor(  
    new Locator.WaitForOptions()  
    .setState(WaitForSelectorState.VISIBLE) 
    .setTimeout(2000));
    return true;
  }catch (TimeoutError e) {
     return false;
  }
  }
}
