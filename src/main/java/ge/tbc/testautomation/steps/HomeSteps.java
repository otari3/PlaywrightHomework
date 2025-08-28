package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.HomePage;

public class HomeSteps {
  Page page;
  HomePage homePage;
  public HomeSteps(Page page){ 
    this.page = page;
    this.homePage = new HomePage(page);
  }
  public CatagorySteps getCatagoryPageByTitle(String title){  
    homePage.getProductByTitle(title).click();
    return new CatagorySteps(page);
  }
  public HomeSteps navigateBackToHomePage(){  
    homePage.homePageIcon.click();
    return this;
  }
  public HomeSteps chooseCatagoryByTitle(String title){ 
    homePage.getCatagoryCheckBoxByTitle(title).click();
    return this;
  }
  public HomeSteps validateCatagorySize(int size){  
    PlaywrightAssertions.assertThat(homePage.allCatagoryCards).hasCount(size);
    return this;
  }
  
}
