package ge.tbc.testautomation.steps.magnetoSteps;

import java.util.Map;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;


import ge.tbc.testautomation.Pages.magnetoPages.MagnetoHomePage;
import ge.tbc.testautomation.util.Util;
import ge.tbc.testautomation.util.helperClasses.ProductColorOptions;

public class MagnetoHomeSteps extends MagnetoBaseSteps {
  MagnetoHomePage magnetoHomePage;
  Page page;
  public MagnetoHomeSteps(Page page){  
      super(page);
      this.page = page;
      magnetoHomePage = new MagnetoHomePage(page);
      Util.removeAds(page);
  }
  public MagnetoHomeSteps selectColorAndValidatePicuter(ProductColorOptions productColorOptions){  
    Map<String,String> colors = productColorOptions.productColorsAndTheirSrc;
    String productName = productColorOptions.exactProductName;
    for(String color:colors.keySet()){  
      String currentSrc = colors.get(color);
      Locator curr = magnetoHomePage.getColorChangeBtnByProductTitle(productName, color);
      curr.scrollIntoViewIfNeeded();
      clickUseingJs(curr);
      PlaywrightAssertions.assertThat(magnetoHomePage.getImgByScr(currentSrc)).isVisible();
    }
    return this;
  }

  public ProductsSteps navigateToHotSellerByName(String name){
    magnetoHomePage.getHotSellerItemByName(name).dblclick();
    return new ProductsSteps(page);
  }
}
