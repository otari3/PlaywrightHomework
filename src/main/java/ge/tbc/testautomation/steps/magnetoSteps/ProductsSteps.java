package ge.tbc.testautomation.steps.magnetoSteps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.magnetoPages.ProductsPage;
import ge.tbc.testautomation.util.Util;
import io.qameta.allure.Step;

public class ProductsSteps extends MagnetoBaseSteps{
  Page page;
  ProductsPage productsPage;
  public ProductsSteps(Page page){ 
    super(page);
    this.page = page;
    productsPage = new ProductsPage(page);
    Util.removeAds(page);
  }
  @Step("Choose Product Size")
  public ProductsSteps chooseProdcutSize(String size){ 
      if (size!=null) {
        productsPage.getSizeBtn(size).click();
      }
      return this;
  }
  @Step("Choose Product Color")
  public ProductsSteps chooseProductColor(String color){  
    if (color!=null) {
      productsPage.getColorBtn(color).click();
    }
    return this;
  }
  @Step("Add Product To Cart")
  public ProductsSteps addToCart(){ 
    productsPage.addToCartBtn.click();
    PlaywrightAssertions.assertThat(productsPage.succsesfullyAddedInCartPopUp).isVisible();
    return this;
  }
  @Step("Navigate To Registration")
  public RegistrationSteps navigateToRegistrationByClickingAddToWishList(){ 
    productsPage.addToWishListBtn.click();
    return new RegistrationSteps(page);
  }
  @Step("Add Product To WishList")
  public WishListSteps addToWishList(){  
    productsPage.addToWishListBtn.click();
    return new WishListSteps(page);
  }
  @Step("Validate Item Is Out Of Stock")
  public ProductsSteps validateThatItemIsOutOfStock(String txt){  
      PlaywrightAssertions.assertThat(productsPage.availability).hasText(txt);
      return this;
  }
  @Step("Scroll to Review Section")
  public ProductsSteps scrollToReviewsSection(){  
    productsPage.reviewLink.click();
    return this;
  }
  @Step("Validate Reviews Count")
  public ProductsSteps validateReviewsCount(){
    Integer reviewsCount = Integer.parseInt(productsPage.reviewLink.locator(productsPage.reviewCount).textContent());
    PlaywrightAssertions.assertThat(productsPage.allReviews).hasCount(reviewsCount);
    return this;
  }
  @Step("Rate Review")
  public ProductsSteps rateReviewWithStars(String stars){ 
    clickUseingJs(productsPage.getStarts(stars));
    return this;
  }
  @Step("Fill NickName For Review")
  public ProductsSteps fillReviewNickName(String nickName){ 
    productsPage.reviewNickNameField.fill(nickName);
    return this;
  }
  @Step("Fill Review Summery")
  public ProductsSteps fillReviewSummery(String summery){ 
    productsPage.summeryField.fill(summery);
    return this;
  }
  @Step("Fill Review")
  public ProductsSteps fillReview(String review){  
    productsPage.reviewField.fill(review);
    return this;
  }
  @Step("Submite Review")
  public ProductsSteps clickSubmiteReview(){  
    productsPage.submiteReviewField.click();
    return this;
  }
  @Step("Validate Sucsefull Review Alart Message")
  public ProductsSteps validateSucsfullyReviewModarationAlart(){  
    PlaywrightAssertions.assertThat(productsPage.sucsefullySubmitedToModerators).isVisible();
    return this;
  }
}
