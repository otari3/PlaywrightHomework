package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;

import ge.tbc.testautomation.Pages.SoftwareTestingBasePage;

public class SoftwareTestingBaseSteps {
  Page page;
  SoftwareTestingBasePage softwareTestingBasePage;
  public SoftwareTestingBaseSteps(Page page){
    this.page = page;
    this.softwareTestingBasePage =  new SoftwareTestingBasePage(page);
  }
  public SignInSteps navigateToSignIn(){
    softwareTestingBasePage.signInBtn.click();
    return new SignInSteps(page);
  }
  public SoftwareTestingBaseSteps openDropDown(){ 
    softwareTestingBasePage.menu.click();
    return this;
  }
  public SoftwareTestingBaseSteps signOut(){  
    softwareTestingBasePage.signOutBtn.click();
    return this;
  }
  public FavoritSteps navigateToFavorite(){ 
    softwareTestingBasePage.favorite.click();
    return new FavoritSteps(page);
  }
}
