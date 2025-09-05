package ge.tbc.testautomation.steps.magnetoSteps;



import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.magnetoPages.SearchPage;
import ge.tbc.testautomation.util.Util;


public class SearchSteps extends MagnetoBaseSteps {
  Page page;
  SearchPage searchPage;
  public SearchSteps(Page page){ 
    super(page);
    searchPage = new SearchPage(page);
    this.page = page;
    Util.removeAds(page);
  }
  public ProductsSteps navigateToProductUseingTitle(String title){
    PlaywrightAssertions.assertThat(searchPage.searchPageHeader).isVisible();
    clickUseingJs(searchPage.getProductByTitleLocator(title));
    return new ProductsSteps(page);
  }
}
