package ge.tbc.testautomation.steps;

import java.util.List;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;

import ge.tbc.testautomation.Pages.CatagoryPage;
import io.qameta.allure.Step;

public class CatagorySteps {
  CatagoryPage catagoryPage;
  Page page;
  public CatagorySteps(Page page){ 
    this.page = page;
    catagoryPage = new CatagoryPage(page);
  }
  @Step("Add Catagory To Favorits")
  public CatagorySteps addCatagoryToFavorits(){ 
      catagoryPage.addFavoriteBtn.click();
      PlaywrightAssertions.assertThat(catagoryPage.succsesfulAdd).isVisible();
      return this;
  }
  @Step("Navigate To Home Page")
  public CatagorySteps navigateToHomePage(){  
    catagoryPage.homePageIcon.click();
    return this;
  }
  public CatagorySteps validateCatagorys(List<String> expctedCatagoris){ 
    catagoryPage.catagoryTitle.waitFor( 
      new Locator.WaitForOptions()  
      .setState(WaitForSelectorState.VISIBLE)
    );
    List<String> actualCatagory = catagoryPage.catagorys.all()  
                                                .stream() 
                                                .map(e->e.textContent().trim())  
                                                .toList();  
    if (!actualCatagory.equals(expctedCatagoris)) {
      throw new AssertionError("Expected: "+expctedCatagoris+"Actual: "+actualCatagory);
    }
    return this;
  
  }
    
}
