package ge.tbc.testautomation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.magnetoSteps.CartSteps;
import ge.tbc.testautomation.steps.magnetoSteps.MagnetoBaseSteps;
import ge.tbc.testautomation.steps.magnetoSteps.MagnetoHomeSteps;

public class MagnetoTests2 extends BaseTest {
  MagnetoBaseSteps magnetoBaseSteps;
  MagnetoHomeSteps magnetoHomeSteps;
  CartSteps cartSteps;
  @BeforeClass
  public void setUpPage(){  
    openPage(Constants.MAGNETO_URL);
    magnetoBaseSteps = new MagnetoBaseSteps(page);
    magnetoHomeSteps = new MagnetoHomeSteps(page);
  }

  @Test(priority = 1)
  public void reviewNumberTest(){ 
    magnetoHomeSteps  
    .navigateToHotSellerByName(Constants.MAGNETO_RADIENT_TEE_PRODUCT) 
    .scrollToReviewsSection() 
    .validateReviewsCount();
  }

  @Test(priority = 2)
  public void purchaseItem(){ 
    magnetoBaseSteps  
    .navigateToSignIn() 
    .fillEmail(Constants.TEST_USER_MAIL)  
    .fillPassword(Constants.TEST_USER_PASSWORD) 
    .clickSignInBtn() 
    .openWishListPageWithDropDownBtn()  
    .validateThatItemExistsInWishList(Constants.MAGNETO_RANDOM_PRODUCT) 
    .navigateToProductsFromWishList(Constants.MAGNETO_RANDOM_PRODUCT) 
    .chooseProdcutSize(Constants.MAGNETO_RANDOM_PRODUCT_SIZE) 
    .chooseProductColor(Constants.MAGNETO_RANDOM_PRODUCT_COLOR) 
    .addToCart()  
    .openCartDropDown() 
    .navigateToPaymantPage()  
    .chooseRadioBtnWithShipingPrice(Constants.SHIPING_PRICE)  
    .goToNextSteps()  
    .openApplyDiscount()  
    .fillDiscountInput(Constants.INVALID_DISCOUNT_CODE) 
    .clickApplyDiscountBtn()  
    .validateDiscountError()  
    .validateTotalAfterShiping(Constants.RANDOM_PRODUCT_PRICE, Constants.SHIPING_PRICE) 
    .validateAddres2(Constants.USER_ADRESS.userAdress2) 
    .validateAddres3(Constants.USER_ADRESS.userAddres3) 
    .validateAddress1(Constants.USER_ADRESS.userAdress1)  
    .validateCity(Constants.USER_ADRESS.city) 
    .validateCountry(Constants.USER_ADRESS.country) 
    .validateFirstName(Constants.USER_ADRESS.userFirstName) 
    .validateLastName(Constants.USER_ADRESS.userLastName) 
    .validatePhoneNumber(Constants.USER_ADRESS.phoneNumber) 
    .validateState(Constants.USER_ADRESS.state) 
    .validateZipCode(Constants.USER_ADRESS.zipCode) 
    .placeOrder() 
    .validateSuccsesPage();
  }
  //creating new context for mobile making so we wont be loged in
  @Test(priority = 3)
  public void mobileNavigationTest(){
    page.close();
    browserContext.close();
    browserContext = browser.newContext();
    page = browserContext.newPage();
    openPage(Constants.MAGNETO_URL);
    page.setViewportSize(412, 915);
    new MagnetoBaseSteps(page)  
    .openBurger()
    .clickAccountBurgerBtn()  
    .validateCreateAccountBurrgerBtn()  
    .validateSignInBurgerBtn()  
    .openMenuBurger() 
    .validateMenBurgerBtn() 
    .validateWomenBurgerBtn() 
    .validateSalesBtn() 
    .validateGearBugergerBtn()  
    .validateWhatsNewBurgerBtn();
  }

}
