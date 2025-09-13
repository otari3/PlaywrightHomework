package ge.tbc.testautomation.steps.techCanvasSteps;

import com.microsoft.playwright.Page;

import ge.tbc.testautomation.Pages.techcanvasPages.PhoneRegistrationPage;

public class PhoneRegistrationSteps {
  Page page;
  PhoneRegistrationPage phoneRegistrationPage;
  public PhoneRegistrationSteps(Page page){  
    phoneRegistrationPage = new PhoneRegistrationPage(page);
  }
  public PhoneRegistrationSteps fillFirstName(String firstName){  
    phoneRegistrationPage.firstNameInput.fill(firstName);
    return this;
  }
  public PhoneRegistrationSteps fillLastName(String lastName){  
    phoneRegistrationPage.lastNameInput.fill(lastName);
    return this;
  }
  public PhoneRegistrationSteps selectMaleGender(){ 
    phoneRegistrationPage.maleRadioBtn.click();
    return this;
  }
  public PhoneRegistrationSteps selectModelName(String modelName){  
    phoneRegistrationPage.selectModel.selectOption(modelName);
    return this;
  }
  public PhoneRegistrationSteps fillAddress1(String address1){ 
    phoneRegistrationPage.address1Input.fill(address1);
    return this;
  }
  public PhoneRegistrationSteps fillAddress2(String address2){ 
    phoneRegistrationPage.address2Input.fill(address2);
    return this;
  }
  public PhoneRegistrationSteps fillCity(String city){ 
      phoneRegistrationPage.cityInput.fill(city);
      return this;
  }
  public PhoneRegistrationSteps fillContact1(String contact1){  
    phoneRegistrationPage.contact1Input.fill(contact1);
    return this;
  }
  public PhoneRegistrationSteps fillContact2(String contact2){  
    phoneRegistrationPage.contact2Input.fill(contact2);
    return this;
  }
}
