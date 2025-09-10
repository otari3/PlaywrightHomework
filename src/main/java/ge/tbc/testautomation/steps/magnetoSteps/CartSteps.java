package ge.tbc.testautomation.steps.magnetoSteps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.magnetoPages.CartPage;
import ge.tbc.testautomation.util.Util;
import io.qameta.allure.Step;

public class CartSteps extends MagnetoBaseSteps {
  Page page;
  CartPage cartPage;
  public CartSteps(Page page){ 
    super(page);
    this.page = page;
    cartPage = new CartPage(page);
    Util.removeAds(page);
  }
  @Step("Validate That Item Exist With Correct Name And Correct Price In Cart")
  public CartSteps validateIfItemExistWithNameAndPrice(String name,String price){ 
    PlaywrightAssertions.assertThat(cartPage.getItemWithPriceAndName(name, price)).isVisible();;
    return this;
  }
  @Step("Delete Item From Cart")
  public CartSteps deleteItemFromCart(String itemName){  
    clickUseingJs(cartPage.getRemoveItemBtnWithProductName(itemName));
    return this;
  }
  @Step("Validate Item Does Not Exist In Cart")
  public CartSteps validateItemDoesNotExistInCart(String itemName){ 
    PlaywrightAssertions.assertThat(cartPage.getProductByName(itemName)).isHidden();
    return this;
  }
}
