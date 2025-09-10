package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.HomePage;
import io.qameta.allure.Step;

public class HomeSteps {
  Page page;
  HomePage homePage;
  public HomeSteps(Page page){ 
    this.page = page;
    this.homePage = new HomePage(page);
  }
  @Step("Go to Catagory")
  public CatagorySteps getCatagoryPageByTitle(String title){  
    homePage.getProductByTitle(title).click();
    return new CatagorySteps(page);
  }
  @Step("Navigate To Home Page")
  public HomeSteps navigateBackToHomePage(){  
    homePage.homePageIcon.click();
    return this;
  }
  @Step("Choose Catagory")
  public HomeSteps chooseCatagoryByTitle(String title){ 
    homePage.getCatagoryCheckBoxByTitle(title).click();
    return this;
  }
  @Step("Validate Catagory")
  public HomeSteps validateCatagorySize(int size){  
    PlaywrightAssertions.assertThat(homePage.allCatagoryCards).hasCount(size);
    return this;
  }
  
}
