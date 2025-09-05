package ge.tbc.testautomation.Pages.magnetoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MagnetoHomePage {
  Page page;
  public String cssSelectorAds;
  public Locator dismissBtnAd;
  public MagnetoHomePage(Page page){ 
    this.page = page;
    cssSelectorAds = "ins.adsbygoogle.adsbygoogle-noablate";
    dismissBtnAd = page.locator("//div[@id='dismiss-button']");
  }

  public Locator getColorChangeBtnByProductTitle(String productTitle,String color){ 
      return page.locator("//a[@title='%s']/following::div[@attribute-code='color'][1]//div[@aria-label='%s']".formatted(productTitle,color));
  }
  public Locator getImgByScr(String src){ 
    return page.locator("//img[@src='%s' and @class='product-image-photo']".formatted(src));
  }
  public Locator getHotSellerItemByName(String name){ 
    return page.locator("//a[@title='Argus All-Weather Tank']/ancestor::li");
  }
}
