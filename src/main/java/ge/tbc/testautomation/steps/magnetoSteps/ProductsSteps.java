package ge.tbc.testautomation.steps.magnetoSteps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.magnetoPages.ProductsPage;
import ge.tbc.testautomation.util.Util;

public class ProductsSteps extends MagnetoBaseSteps{
  Page page;
  ProductsPage productsPage;
  public ProductsSteps(Page page){ 
    super(page);
    this.page = page;
    productsPage = new ProductsPage(page);
    Util.removeAds(page);
  }
  public ProductsSteps chooseProdcutSize(String size){ 
      if (size!=null) {
        productsPage.getSizeBtn(size).click();
      }
      return this;
  }
  public ProductsSteps chooseProductColor(String color){  
    if (color!=null) {
      productsPage.getColorBtn(color).click();
    }
    return this;
  }
  public ProductsSteps addToCart(){ 
    productsPage.addToCartBtn.click();
    PlaywrightAssertions.assertThat(productsPage.succsesfullyAddedInCartPopUp).isVisible();
    return this;
  }
  public RegistrationSteps navigateToRegistrationByClickingAddToWishList(){ 
    productsPage.addToWishListBtn.click();
    return new RegistrationSteps(page);
  }
  public ProductsSteps validateThatItemIsOutOfStock(String txt){  
      PlaywrightAssertions.assertThat(productsPage.availability).hasText(txt);
      return this;
  }
}
