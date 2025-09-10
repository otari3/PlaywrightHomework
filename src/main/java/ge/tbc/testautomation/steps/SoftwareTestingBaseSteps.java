package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;

import ge.tbc.testautomation.Pages.SoftwareTestingBasePage;
import io.qameta.allure.Step;

public class SoftwareTestingBaseSteps {
  Page page;
  SoftwareTestingBasePage softwareTestingBasePage;
  public SoftwareTestingBaseSteps(Page page){
    this.page = page;
    this.softwareTestingBasePage =  new SoftwareTestingBasePage(page);
  }
  @Step("Navigate to Sign In Page")
  public SignInSteps navigateToSignIn(){
    softwareTestingBasePage.signInBtn.click();
    return new SignInSteps(page);
  }
  @Step("Open Drop Down")
  public SoftwareTestingBaseSteps openDropDown(){ 
    softwareTestingBasePage.menu.click();
    return this;
  }
  @Step("Sign Out From Page")
  public SoftwareTestingBaseSteps signOut(){  
    softwareTestingBasePage.signOutBtn.click();
    return this;
  }
  @Step("Navigate To Favorite")
  public FavoritSteps navigateToFavorite(){ 
    softwareTestingBasePage.favorite.click();
    return new FavoritSteps(page);
  }
}
