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
  public WishListSteps addToWishList(){  
    productsPage.addToWishListBtn.click();
    return new WishListSteps(page);
  }
  public ProductsSteps validateThatItemIsOutOfStock(String txt){  
      PlaywrightAssertions.assertThat(productsPage.availability).hasText(txt);
      return this;
  }
  public ProductsSteps scrollToReviewsSection(){  
    productsPage.reviewLink.click();
    return this;
  }
  public ProductsSteps validateReviewsCount(){
    Integer reviewsCount = Integer.parseInt(productsPage.reviewLink.locator(productsPage.reviewCount).textContent());
    PlaywrightAssertions.assertThat(productsPage.allReviews).hasCount(reviewsCount);
    return this;
  }
  public ProductsSteps rateReviewWithStars(String stars){ 
    clickUseingJs(productsPage.getStarts(stars));
    return this;
  }
  public ProductsSteps fillReviewNickName(String nickName){ 
    productsPage.reviewNickNameField.fill(nickName);
    return this;
  }
  public ProductsSteps fillReviewSummery(String summery){ 
    productsPage.summeryField.fill(summery);
    return this;
  }
  public ProductsSteps fillReview(String review){  
    productsPage.reviewField.fill(review);
    return this;
  }
  public ProductsSteps clickSubmiteReview(){  
    productsPage.submiteReviewField.click();
    return this;
  }
  public ProductsSteps validateSucsfullyReviewModarationAlart(){  
    PlaywrightAssertions.assertThat(productsPage.sucsefullySubmitedToModerators).isVisible();
    return this;
  }
}
