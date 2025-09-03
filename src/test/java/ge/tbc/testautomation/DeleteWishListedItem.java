package ge.tbc.testautomation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.magnetoSteps.CartSteps;
import ge.tbc.testautomation.steps.magnetoSteps.MagnetoBaseSteps;
import ge.tbc.testautomation.steps.magnetoSteps.MagnetoHomeSteps;
import ge.tbc.testautomation.steps.magnetoSteps.ProductsSteps;
import ge.tbc.testautomation.steps.magnetoSteps.WishListSteps;
import ge.tbc.testautomation.util.Util;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Test(description = "delete added product from wishlist (OPS-T11)")
@Link("https://otarinozadze1.atlassian.net/projects/OPS?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/v2/testCase/OPS-T11")
public class DeleteWishListedItem extends BaseTest {
  MagnetoBaseSteps magnetoBaseSteps;
  MagnetoHomeSteps magnetoHomeSteps;
  CartSteps cartSteps;
  ProductsSteps productsSteps;
  WishListSteps wishListSteps;
  @BeforeClass
  public void setUpPage(){  
    openPage(Constants.MAGNETO_URL);
    System.out.println("this is conflict from Main Branch 2");
    magnetoBaseSteps = new MagnetoBaseSteps(page);
    magnetoHomeSteps = new MagnetoHomeSteps(page);
  }
  @BeforeMethod
  public void deleteAds(){  
    Util.removeAds(page);
  }

  @Test(priority = 1)
  @Severity(SeverityLevel.BLOCKER)
  public void signInTest(){ 
      magnetoBaseSteps  
      .navigateToSignIn() 
      .fillEmail(Constants.TEST_USER_MAIL)  
      .fillPassword(Constants.TEST_USER_PASSWORD) 
      .clickSignInBtn();
  }

  @Test(priority = 2)
  @Severity(SeverityLevel.NORMAL)
  public void searchItemTest(){ 
    magnetoBaseSteps  
    .sendValueToSearch(Constants.MAGNETO_RADIENT_TEE_PRODUCT);
  }
  @Test(priority = 3)
  @Severity(SeverityLevel.NORMAL)
  public void openSearchedItem(){ 
   productsSteps = magnetoBaseSteps  
    .navigateToSearchResutlsUseingValue(Constants.MAGNETO_RADIENT_TEE_PRODUCT)  
    .navigateToProductUseingTitle(Constants.MAGNETO_RADIENT_TEE_PRODUCT);
  }
  @Test(priority = 4)
  @Severity(SeverityLevel.NORMAL)
  public void addItemToWishListTest(){  
   wishListSteps =  productsSteps 
    .addToWishList()  
    .validateThatItemExistsInWishList(Constants.MAGNETO_RADIENT_TEE_PRODUCT);
  }
  @Test(priority = 5)
  @Severity(SeverityLevel.NORMAL)
  public void removeItemFromWishList(){ 
      wishListSteps 
      .hoverToItemInWishlist(Constants.MAGNETO_RADIENT_TEE_PRODUCT) 
      .removeItemFromWishList(Constants.MAGNETO_RADIENT_TEE_PRODUCT)  
      .validateItemDoesNotExistInWishList(Constants.MAGNETO_RADIENT_TEE_PRODUCT);
  }
}
