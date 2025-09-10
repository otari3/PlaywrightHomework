package ge.tbc.testautomation.Pages.magnetoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductsPage {
  Page page;
  public Locator addToCartBtn;
  public Locator succsesfullyAddedInCartPopUp;
  public Locator addToWishListBtn;
  public Locator  availability;
  public String reviewCount = "//span[@itemprop='reviewCount']";
  public Locator reviewLink;
  public Locator allReviews;
  public Locator reviewNickNameField;
  public Locator summeryField;
  public Locator reviewField;
  public Locator submiteReviewField;
  public Locator sucsefullySubmitedToModerators;
  public ProductsPage(Page page){  
    this.page = page;
    addToCartBtn = page.locator("//button[@title='Add to Cart']");
    succsesfullyAddedInCartPopUp = page.locator("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    addToWishListBtn = page.locator("//button[@id='product-addtocart-button']/following::a[@class='action towishlist'][1]");
    availability = page.locator("//div[@title='Availability']");
    reviewLink = page.locator("//a[@class='action view']");
    allReviews = page.locator("//li[@class='item review-item']");
    reviewNickNameField = page.locator("#nickname_field");
    summeryField = page.locator("#summary_field");
    reviewField = page.locator("#review_field");
    submiteReviewField = page.locator("//button[@class='action submit primary']");
    sucsefullySubmitedToModerators = page.locator("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)' and text()='You submitted your review for moderation.']");
  }

  public Locator getSizeBtn(String size){  
    return page.locator("//div[@aria-labelledby='option-label-size-143']//div[text()='%s']".formatted(size));
  }
  public Locator getColorBtn(String color){ 
    return page.locator("//div[@aria-labelledby='option-label-color-93']//div[@option-label='%s']".formatted(color));
  }
  public Locator getStarts(String star){  
    return page.locator("//label[@class='rating-%s']".formatted(star));
  }
}
