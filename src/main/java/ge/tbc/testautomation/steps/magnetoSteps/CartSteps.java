package ge.tbc.testautomation.steps.magnetoSteps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.magnetoPages.CartPage;
import ge.tbc.testautomation.util.Util;

public class CartSteps extends MagnetoBaseSteps {
  Page page;
  CartPage cartPage;
  public CartSteps(Page page){ 
    super(page);
    this.page = page;
    cartPage = new CartPage(page);
    Util.removeAds(page);
  }

  public CartSteps validateIfItemExistWithNameAndPrice(String name,String price){ 
    PlaywrightAssertions.assertThat(cartPage.getItemWithPriceAndName(name, price)).isVisible();;
    return this;
  }
  public CartSteps deleteItemFromCart(String itemName){  
    clickUseingJs(cartPage.getRemoveItemBtnWithProductName(itemName));
    return this;
  }
  public CartSteps validateItemDoesNotExistInCart(String itemName){ 
    PlaywrightAssertions.assertThat(cartPage.getProductByName(itemName)).isHidden();
    return this;
  }
}
