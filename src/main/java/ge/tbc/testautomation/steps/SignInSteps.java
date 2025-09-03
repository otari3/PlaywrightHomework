package ge.tbc.testautomation.steps;



import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.SignInPage;

public class SignInSteps {
  Page page;
  SignInPage signInPage;
  public SignInSteps(Page page){ 
    this.page = page;
    signInPage = new SignInPage(page);
  }
  public RegistrationSteps navigateToRegistrationFrom(){  
    signInPage.registerYourAccountLink.click();
    return new RegistrationSteps(page);
  }
  public SignInSteps fillEmail(String val){ 
    signInPage.emailAdressInput.fill(val);
    return this;
  }
  public SignInSteps fillPassword(String val){  
    signInPage.password.fill(val);
    return this;
  }
  public SignInSteps clickLoginBtn(){ 
    signInPage.loginBtn.click();
    PlaywrightAssertions.assertThat(signInPage.myAccountHeader).isVisible();
    return this;
  }
  public SignInSteps navigateToSignIn(){ 
    signInPage.signInbtn.click();
    return this;
  }
  public void navigateToHome(){ 
    signInPage.homePageIcon.click();
  }
}
