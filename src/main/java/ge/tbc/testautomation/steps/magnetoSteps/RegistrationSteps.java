package ge.tbc.testautomation.steps.magnetoSteps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.magnetoPages.RegistrationPage;
import ge.tbc.testautomation.util.Util;

public class RegistrationSteps {
  Page page;
  RegistrationPage registrationPage;
  public RegistrationSteps(Page page){  
    this.page = page;
    this.registrationPage = new RegistrationPage(page);
    Util.removeAds(page);
  }
  public RegistrationSteps navigateToCreateAccountFrom(){ 
    registrationPage.creatAccoutBtn.dblclick();
    return this;
  }
  public RegistrationSteps fillFirstName(String val){ 
    registrationPage.firstName.fill(val);
    return this;
  }
  public RegistrationSteps fillLastName(String val){  
    registrationPage.lastName.fill(val);
    return this;
  }
  public RegistrationSteps fillEmail(String val){ 
    registrationPage.email.fill(val);
    return this;
  }
  public RegistrationSteps fillPassword(String val){  
    registrationPage.password.fill(val);
    return this;
  }
  public RegistrationSteps fillConfirmPassword(String val){
    Util.removeAds(page);
    registrationPage.passwordConformation.fill(val);
    return this;
  }
  public RegistrationSteps clickRegister(){ 
    registrationPage.registerBtn.click();
    return this;
  }
  public RegistrationSteps validateThatItemExistInWishList(String name){ 
    PlaywrightAssertions.assertThat(registrationPage.getFavoriteItemWithName(name)).isVisible();
    return this;
  }
  public RegistrationSteps validateThatSuccsesMessageIsVissable(String name){ 
    PlaywrightAssertions.assertThat(registrationPage.getSuccsesAlartWithProductTitle(name)).isVisible();;
    return this;
  }
  public RegistrationSteps validateThatWelcomeMesageIsCorrect(String firstName,String lastName){  
    PlaywrightAssertions.assertThat(registrationPage.getWelcomeMesage(firstName, lastName)).isVisible();;
    return this;
  }
}
