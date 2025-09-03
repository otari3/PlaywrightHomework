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
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Test(description = "submit review to moderation (OPS-T12)")
@Link("https://otarinozadze1.atlassian.net/projects/OPS?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/v2/testCase/OPS-T12")
public class AddReview  extends BaseTest {
  MagnetoBaseSteps magnetoBaseSteps;
  MagnetoHomeSteps magnetoHomeSteps;
  ProductsSteps productsSteps;
  @BeforeClass
  public void setUpPage(){  
    openPage(Constants.MAGNETO_URL);
    System.out.println("this is conflictFile 1");
    magnetoBaseSteps = new MagnetoBaseSteps(page);
    magnetoHomeSteps = new MagnetoHomeSteps(page);
  }
  @BeforeMethod
  public void deleteAds(){  
    Util.removeAds(page);
  }
  @Test(priority = 1)
  @Severity(SeverityLevel.NORMAL)
  public void openProdactFromHotSellers(){  
    productsSteps = magnetoHomeSteps  
    .navigateToHotSellerByName(Constants.MAGNETO_RADIENT_TEE_PRODUCT);
  }
  @Test(priority = 2)
  @Severity(SeverityLevel.NORMAL)
  public void scrollToReviewSection(){  
    productsSteps.scrollToReviewsSection();
  }
  @Test(priority = 3)
  @Severity(SeverityLevel.NORMAL)
  public void addReview(){  
    productsSteps 
    .fillReview(Constants.REVIEW) 
    .fillReviewNickName(Constants.REVIEW_NICK_NAME) 
    .fillReviewSummery(Constants.REVIEW_SUMMERY)  
    .rateReviewWithStars(Constants.REVIEW_STARS)  
    .clickSubmiteReview();
  }
  @Test(priority = 4)
  @Severity(SeverityLevel.NORMAL)
  public void validateReviewAlert(){  
    productsSteps.validateSucsfullyReviewModarationAlart();
  }
}
