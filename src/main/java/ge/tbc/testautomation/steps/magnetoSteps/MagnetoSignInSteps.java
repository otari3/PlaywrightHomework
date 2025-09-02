package ge.tbc.testautomation.steps.magnetoSteps;

import com.microsoft.playwright.Page;

import ge.tbc.testautomation.Pages.magnetoPages.MagnetoSignInPage;
import ge.tbc.testautomation.util.Util;

public class MagnetoSignInSteps extends MagnetoBaseSteps {
  Page page;
  MagnetoSignInPage magnetoSignInPage;
  public MagnetoSignInSteps(Page page){  
    super(page);
    this.page = page;
    this.magnetoSignInPage = new MagnetoSignInPage(page);
    Util.removeAds(page);
  }
  public MagnetoSignInSteps fillEmail(String email){  
    magnetoSignInPage.email.fill(email);
    return this;
  }
  public MagnetoSignInSteps fillPassword(String password){ 
      magnetoSignInPage.password.fill(password);
      return this;
  }
  public MagnetoSignInSteps clickSignInBtn(){ 
    magnetoSignInPage.signInBtn.click();
    Util.removeAds(page);
    return this;
  }
}
