package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;

import ge.tbc.testautomation.Pages.RegistartionPage;

public class RegistrationSteps {
  Page page;
  RegistartionPage registartionPage;
  public RegistrationSteps(Page page){ 
    this.page = page;
    registartionPage = new RegistartionPage(page);
  }
  public RegistrationSteps fillFirstName(String val){ 
    registartionPage.firstNameInput.fill(val);
    return this;
  }
  public RegistrationSteps fillLastName(String val){  
    registartionPage.lastNameInput.fill(val);
    return this;
  }
  public RegistrationSteps fillDateOfBirth(String val){ 
    registartionPage.dateOfBirth.fill(val);
    return this;
  }
  public RegistrationSteps fillStreets(String val){ 
    registartionPage.street.fill(val);
    return this;
  }
  public RegistrationSteps fillPostalCodes(String val){ 
    registartionPage.postalCode.fill(val);
    return this;
  }
  public RegistrationSteps fillCity(String val){  
    registartionPage.city.fill(val);
    return this;
  }
  public RegistrationSteps fillState(String val){ 
    registartionPage.state.fill(val);
    return this;
  }
  public RegistrationSteps selectCountry(String val){   
    registartionPage.country.selectOption(val);
    return this;
  }
  public RegistrationSteps fillPhone(String val){ 
    registartionPage.phone.fill(val);
    return this;
  }
  public RegistrationSteps fillEmailAdress(String val){ 
    registartionPage.emailAdress.fill(val);
    return this;
  }
  public RegistrationSteps fillPassword(String val){  
    registartionPage.password.fill(val);
    return this;
  }
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
