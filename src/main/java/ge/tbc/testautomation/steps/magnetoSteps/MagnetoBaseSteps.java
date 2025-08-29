package ge.tbc.testautomation.steps.magnetoSteps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.magnetoPages.MagnetoBasePage;
import ge.tbc.testautomation.util.Util;

public class MagnetoBaseSteps {
    MagnetoBasePage magnetoBasePage;
    Page page;
    public MagnetoBaseSteps(Page page){  
      magnetoBasePage = new MagnetoBasePage(page);
      this.page = page;
      Util.removeAds(page);
    }
    public MagnetoBaseSteps sendValueToSearch(String val){  
        magnetoBasePage.searchInput.fill(val);
        return this;
    }
    public SearchSteps navigateToSearchResutlsUseingValue(String val){ 
      Locator searchResults = page.locator(magnetoBasePage.searchResults);
      PlaywrightAssertions.assertThat(searchResults).isVisible();
      Util.handleCustomDropDowns(searchResults.locator("li"), val);
      return new SearchSteps(page);
    }
    public MagnetoBaseSteps openCartDropDown(){ 
      magnetoBasePage.cardDropDown.click();
      return this;
    }
    public CartSteps openCartPageWithDropDown(){ 
      magnetoBasePage.viewAndEditCartBtn.click();
      return new CartSteps(page);
    }
    public void clickUseingJs(Locator elem){  
      page.evaluate("element => element.click()", elem.elementHandle());
    }
}
