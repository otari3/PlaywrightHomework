package ge.tbc.testautomation;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.FavoritSteps;
import ge.tbc.testautomation.steps.HomeSteps;
import ge.tbc.testautomation.steps.RegistrationSteps;
import ge.tbc.testautomation.steps.SignInSteps;
import ge.tbc.testautomation.steps.SoftwareTestingBaseSteps;
import ge.tbc.testautomation.util.helperClasses.RegistrationForm;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
//there is lots of duplicat code here but homework it self is lots of duplicat work so i can not avoid it
public class PacticeSoftwareTestingStep2 extends BaseTest  {
  SoftwareTestingBaseSteps softwareTestingBaseSteps;
  RegistrationSteps registrationSteps;
  SignInSteps signInSteps;
  RegistrationForm firstUser = Constants.FIRSTUSER;
  HomeSteps homeSteps;
  boolean isUserRegistered;
  FavoritSteps favoritSteps;
  @BeforeClass
  public void setUpPage(){ 
    openPage(Constants.PRACTICE_SOFTWARE_URL);
    softwareTestingBaseSteps = new SoftwareTestingBaseSteps(page);
    homeSteps = new HomeSteps(page);
  }

  @Test(priority = 1,description = "Registration Test")
  @Severity(SeverityLevel.BLOCKER)
  public void registerUser(){
  signInSteps = softwareTestingBaseSteps.navigateToSignIn();
  registrationSteps = signInSteps.navigateToRegistrationFrom();
  isUserRegistered = registrationSteps 
        .fillCity(firstUser.city) 
        .fillDateOfBirth(firstUser.dateOfBirth) 
        .fillEmailAdress(firstUser.emailAdress) 
        .fillFirstName(firstUser.firstNameInput)  
        .fillLastName(firstUser.lastNameInput)  
        .fillPassword(firstUser.password) 
        .fillPhone(firstUser.phone) 
        .fillPostalCodes(firstUser.postalCode)  
        .fillState(firstUser.state) 
        .fillStreets(firstUser.street)  
        .selectCountry(firstUser.country)
        .register();
  }
  @Test(priority = 2,description = "Sign in Test")
  @Severity(SeverityLevel.BLOCKER)
  public void siginInTest(){  
    if (isUserRegistered) {
      signInSteps.navigateToSignIn();
    }
    signInSteps 
    .fillEmail(firstUser.emailAdress) 
    .fillPassword(firstUser.password) 
    .clickLoginBtn()  
    .navigateToHome();
  }
  @Test(priority = 3,description = "Favorite Test")
  @Severity(SeverityLevel.CRITICAL)
  public void favouritesTest() throws InterruptedException{ 
    homeSteps 
    .getCatagoryPageByTitle(Constants.RANDOM_PRODUCT)  
    .addCatagoryToFavorits()  
    .navigateToHomePage();

    softwareTestingBaseSteps  
    .openDropDown() 
    .signOut();

    signInSteps.navigateToSignIn()  
    .fillEmail(firstUser.emailAdress) 
    .fillPassword(firstUser.password) 
    .clickLoginBtn()  
    .navigateToHome();

    favoritSteps = softwareTestingBaseSteps 
                  .openDropDown() 
                  .navigateToFavorite() 
                  .findIfItemExistsByTitle(Constants.RANDOM_PRODUCT);
  }

  @Test(priority = 4,description = "Filter Test")
  @Severity(SeverityLevel.NORMAL)
  public void filterTest(){ 
    homeSteps 
    .navigateBackToHomePage() 
    .chooseCatagoryByTitle(Constants.HAMMER_CATAGORY_BNT_TITLE) 
    .validateCatagorySize(Constants.HAMMER_CATAGORY_SIZE) 
    .chooseCatagoryByTitle(Constants.TOOL_BELTS_CATAGORY_BTN_TITLE)  
    .validateCatagorySize(Constants.TOOL_BELTS_CATAGORY_SIZE+Constants.HAMMER_CATAGORY_SIZE);
  }
  @Test(priority = 5,description = "Remove Product From Favorite")
  @Severity(SeverityLevel.CRITICAL)
  public void removeFavouriteTest(){  
    softwareTestingBaseSteps.openDropDown().navigateToFavorite();
    favoritSteps  
    .deleteItemFromFavoritesUseingTitle(Constants.RANDOM_PRODUCT) 
    .findIfItemDoesNotExistByTitle(Constants.RANDOM_PRODUCT);
    softwareTestingBaseSteps.openDropDown().signOut();
    signInSteps.navigateToSignIn()  
    .fillEmail(firstUser.emailAdress) 
    .fillPassword(firstUser.password) 
    .clickLoginBtn()  
    .navigateToHome();
    softwareTestingBaseSteps.openDropDown().navigateToFavorite();
    favoritSteps.findIfItemDoesNotExistByTitle(Constants.RANDOM_PRODUCT);
  }
  @Test(priority = 6,description = "Tag Tests")
  @Severity(SeverityLevel.NORMAL)
  public void tagsTest(){ 
    homeSteps 
    .navigateBackToHomePage()  
    .chooseCatagoryByTitle(Constants.HAMMER_CATAGORY_BNT_TITLE) 
    .getCatagoryPageByTitle(Constants.THOR_HAMMER)  
    .validateCatagorys(Constants.THOR_HAMMER_CATAGORY);
  }

}
