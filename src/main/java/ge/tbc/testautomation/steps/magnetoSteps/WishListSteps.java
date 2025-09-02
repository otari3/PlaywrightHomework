package ge.tbc.testautomation.steps.magnetoSteps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.magnetoPages.WishListPage;
import ge.tbc.testautomation.util.Util;

public class WishListSteps extends MagnetoBaseSteps {
  Page page;
  WishListPage wishListPage;
  public WishListSteps(Page page){ 
    super(page);
    this.page = page;
    this.wishListPage = new WishListPage(page);
    Util.removeAds(page);
  }
  public WishListSteps validateThatItemExistsInWishList(String name){  
   PlaywrightAssertions.assertThat(wishListPage.getFavoriteItemWithName(name)).isVisible();
   return this;
  }
  public WishListSteps hoverToItemInWishlist(String name){ 
    wishListPage.getFavoriteItemWithName(name).hover();
    return this;
  }
  public ProductsSteps navigateToProductsFromWishList(String productName){  
        wishListPage.getFavoriteItemWithName(productName).click();
        return new ProductsSteps(page);
  }
  public WishListSteps removeItemFromWishList(String name){  
      wishListPage.getFavoriteItemWithName(name).locator(wishListPage.deleteBtn).click();
      return this;
  }
  public WishListSteps validateItemDoesNotExistInWishList(String name){  
      PlaywrightAssertions.assertThat(wishListPage.getFavoriteItemWithName(name)).isHidden();
      return this;
  }
}
