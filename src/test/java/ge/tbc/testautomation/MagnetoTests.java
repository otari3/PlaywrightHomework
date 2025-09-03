package ge.tbc.testautomation;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.magnetoSteps.CartSteps;
import ge.tbc.testautomation.steps.magnetoSteps.MagnetoBaseSteps;
import ge.tbc.testautomation.steps.magnetoSteps.MagnetoHomeSteps;
import ge.tbc.testautomation.util.Util;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;




public class MagnetoTests extends BaseTest{
  MagnetoBaseSteps magnetoBaseSteps;
  MagnetoHomeSteps magnetoHomeSteps;
  CartSteps cartSteps;
  @BeforeClass
  public void setUpPage(){  
    openPage(Constants.MAGNETO_URL);
    System.out.println("this is conflict from Main Branch 2");
    magnetoBaseSteps = new MagnetoBaseSteps(page);
    magnetoHomeSteps = new MagnetoHomeSteps(page);
    Util.removeAds(page);
  }

  @Test(priority = 1,description = "Color Change Test")
  @Severity(SeverityLevel.MINOR)
  public void colorChangeTest(){ 
    magnetoHomeSteps.selectColorAndValidatePicuter(Constants.MAGNETO_FIRST_PRODUCT) 
                    .selectColorAndValidatePicuter(Constants.MAGNETO_SECOND_PRODUCT)  
                    .selectColorAndValidatePicuter(Constants.MAGNETO_THIRD_PRODUCT);
  }
  @Test(priority = 2,description = "Add To Cart From Search")
  @Severity(SeverityLevel.CRITICAL)
  public void addToCartTest(){  
   cartSteps = magnetoBaseSteps  
    .sendValueToSearch(Constants.MAGNETO_RANDOM_PRODUCT)  
    .navigateToSearchResutlsUseingValue(Constants.MAGNETO_RANDOM_PRODUCT) 
    .navigateToProductUseingTitle(Constants.MAGNETO_RANDOM_PRODUCT) 
    .chooseProdcutSize(Constants.MAGNETO_RANDOM_PRODUCT_SIZE)  
    .chooseProductColor(Constants.MAGNETO_RANDOM_PRODUCT_COLOR) 
    .addToCart()  
    .openCartDropDown() 
    .openCartPageWithDropDown() 
    .validateIfItemExistWithNameAndPrice(Constants.MAGNETO_RANDOM_PRODUCT, Constants.MAGNETO_RANDOM_PRODUCT_PRICE);
  }
  @Test(dependsOnMethods = {"addToCartTest"},priority = 3,description = "Delete Item From Cart")
  @Severity(SeverityLevel.CRITICAL)
  public void deleteFromCart(){ 
    cartSteps.deleteItemFromCart(Constants.MAGNETO_RANDOM_PRODUCT)  
    .validateItemDoesNotExistInCart(Constants.MAGNETO_RANDOM_PRODUCT);
  }

  @Test(priority = 4,description = "Save Items To Favorite While Unauthorized")
  @Severity(SeverityLevel.BLOCKER)
  public void saveToFavoritesWhileUnauthorizedTest(){
   magnetoBaseSteps  
    .sendValueToSearch(Constants.MAGNETO_RANDOM_PRODUCT)  
    .navigateToSearchResutlsUseingValue(Constants.MAGNETO_RANDOM_PRODUCT) 
    .navigateToProductUseingTitle(Constants.MAGNETO_RANDOM_PRODUCT) 
    .navigateToRegistrationByClickingAddToWishList()  
    .navigateToCreateAccountFrom()  
    .fillConfirmPassword(Constants.MAGNETO_USER.password) 
    .fillEmail(Constants.MAGNETO_USER.email)  
    .fillFirstName(Constants.MAGNETO_USER.firstName)  
    .fillLastName(Constants.MAGNETO_USER.lastName)  
    .fillPassword(Constants.MAGNETO_USER.password)  
    .clickRegister()  
    .validateThatItemExistInWishList(Constants.MAGNETO_RANDOM_PRODUCT)  
    .validateThatSuccsesMessageIsVissable(Constants.MAGNETO_RANDOM_PRODUCT) 
    .validateThatWelcomeMesageIsCorrect(Constants.MAGNETO_USER.firstName, Constants.MAGNETO_USER.lastName);
  }
  @Test(priority = 5,description = "out of stock test")
  @Severity(SeverityLevel.CRITICAL)
  public void outOfStockOfferTest(){  
     magnetoBaseSteps  
    .sendValueToSearch(Constants.MAGNETO_RANDOM_PRODUCT)  
    .navigateToSearchResutlsUseingValue(Constants.MAGNETO_RANDOM_PRODUCT) 
    .navigateToProductUseingTitle(Constants.MAGNETO_RANDOM_PRODUCT) 
    .validateThatItemIsOutOfStock(Constants.OUT_OF_STOCK);
  }
}
