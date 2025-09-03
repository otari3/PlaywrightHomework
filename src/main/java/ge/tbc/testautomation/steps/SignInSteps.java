package ge.tbc.testautomation.steps;



import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.SignInPage;
import io.qameta.allure.Step;

public class SignInSteps {
  Page page;
  SignInPage signInPage;
  public SignInSteps(Page page){ 
    this.page = page;
    signInPage = new SignInPage(page);
  }
  @Step("Navigate To Registration Page")
  public RegistrationSteps navigateToRegistrationFrom(){  
    signInPage.registerYourAccountLink.click();
    return new RegistrationSteps(page);
  }
  @Step("Fill Sign In Email")
  public SignInSteps fillEmail(String val){ 
    signInPage.emailAdressInput.fill(val);
    return this;
  }
  @Step("Fill Sign In Password")
  public SignInSteps fillPassword(String val){  
    signInPage.password.fill(val);
    return this;
  }
  @Step("Log In To Page")
  public SignInSteps clickLoginBtn(){ 
    signInPage.loginBtn.click();
    PlaywrightAssertions.assertThat(signInPage.myAccountHeader).isVisible();
    return this;
  }
  @Step("Navigate To Sign In")
  public SignInSteps navigateToSignIn(){ 
    signInPage.signInbtn.click();
    return this;
  }
  @Step("Navigate To Home")
  public void navigateToHome(){ 
    signInPage.homePageIcon.click();
  }
}
