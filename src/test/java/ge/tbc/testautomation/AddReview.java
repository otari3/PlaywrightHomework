package ge.tbc.testautomation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.magnetoSteps.MagnetoBaseSteps;
import ge.tbc.testautomation.steps.magnetoSteps.MagnetoHomeSteps;
import ge.tbc.testautomation.steps.magnetoSteps.ProductsSteps;
import ge.tbc.testautomation.util.Util;
@Test(description = "submit review to moderation (OPS-T12)")
public class AddReview  extends BaseTest {
  MagnetoBaseSteps magnetoBaseSteps;
  MagnetoHomeSteps magnetoHomeSteps;
  ProductsSteps productsSteps;
  @BeforeClass
  public void setUpPage(){  
    openPage(Constants.MAGNETO_URL);
    magnetoBaseSteps = new MagnetoBaseSteps(page);
    magnetoHomeSteps = new MagnetoHomeSteps(page);
  }
  @BeforeMethod
  public void deleteAds(){  
    Util.removeAds(page);
  }
  @Test(priority = 1)
  public void openProdactFromHotSellers(){  
    productsSteps = magnetoHomeSteps  
    .navigateToHotSellerByName(Constants.MAGNETO_RADIENT_TEE_PRODUCT);
  }
  @Test(priority = 2)
  public void scrollToReviewSection(){  
    productsSteps.scrollToReviewsSection();
  }
  @Test(priority = 3)
  public void addReview(){  
    productsSteps 
    .fillReview(Constants.REVIEW) 
    .fillReviewNickName(Constants.REVIEW_NICK_NAME) 
    .fillReviewSummery(Constants.REVIEW_SUMMERY)  
    .rateReviewWithStars(Constants.REVIEW_STARS)  
    .clickSubmiteReview();
  }
  @Test(priority = 4)
  public void validateReviewAlert(){  
    productsSteps.validateSucsfullyReviewModarationAlart();
  }
}
