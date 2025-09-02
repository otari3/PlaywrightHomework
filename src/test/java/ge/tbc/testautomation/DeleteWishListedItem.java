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
@Test(description = "delete added product from wishlist (OPS-T11)")
public class DeleteWishListedItem extends BaseTest {
  MagnetoBaseSteps magnetoBaseSteps;
  MagnetoHomeSteps magnetoHomeSteps;
  CartSteps cartSteps;
  ProductsSteps productsSteps;
  WishListSteps wishListSteps;
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
  public void signInTest(){ 
      magnetoBaseSteps  
      .navigateToSignIn() 
      .fillEmail(Constants.TEST_USER_MAIL)  
      .fillPassword(Constants.TEST_USER_PASSWORD) 
      .clickSignInBtn();
  }

  @Test(priority = 2)
  public void searchItemTest(){ 
    magnetoBaseSteps  
    .sendValueToSearch(Constants.MAGNETO_RADIENT_TEE_PRODUCT);
  }
  @Test(priority = 3)
  public void openSearchedItem(){ 
   productsSteps = magnetoBaseSteps  
    .navigateToSearchResutlsUseingValue(Constants.MAGNETO_RADIENT_TEE_PRODUCT)  
    .navigateToProductUseingTitle(Constants.MAGNETO_RADIENT_TEE_PRODUCT);
  }
  @Test(priority = 4)
  public void addItemToWishListTest(){  
   wishListSteps =  productsSteps 
    .addToWishList()  
    .validateThatItemExistsInWishList(Constants.MAGNETO_RADIENT_TEE_PRODUCT);
  }
  @Test(priority = 5)
  public void removeItemFromWishList(){ 
      wishListSteps 
      .hoverToItemInWishlist(Constants.MAGNETO_RADIENT_TEE_PRODUCT) 
      .removeItemFromWishList(Constants.MAGNETO_RADIENT_TEE_PRODUCT)  
      .validateItemDoesNotExistInWishList(Constants.MAGNETO_RADIENT_TEE_PRODUCT);
  }
}
