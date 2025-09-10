package ge.tbc.testautomation;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.runners.MultipleContextBaseTest;
import ge.tbc.testautomation.steps.HomeSteps;
import ge.tbc.testautomation.steps.RegistrationSteps;
import ge.tbc.testautomation.steps.SignInSteps;
import ge.tbc.testautomation.steps.SoftwareTestingBaseSteps;
import ge.tbc.testautomation.util.helperClasses.RegistrationForm;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class PacticeSoftwareTestingStep3 extends MultipleContextBaseTest {
  SoftwareTestingBaseSteps softwareTestingBaseSteps;
  SignInSteps signInSteps;
  RegistrationSteps registrationSteps;
  HomeSteps homeSteps;
  RegistrationForm currUser;
  @BeforeMethod
  public void registerAndOpenPage(){ 
    openPage(Constants.PRACTICE_SOFTWARE_URL);
    currUser = Constants.multipleUsers.get(currUserIndex);
    softwareTestingBaseSteps = new SoftwareTestingBaseSteps(page);
    signInSteps = softwareTestingBaseSteps.navigateToSignIn();
    registrationSteps = signInSteps.navigateToRegistrationFrom();
    homeSteps = new HomeSteps(page);
    boolean isRegistered = registrationSteps  
                          .fillCity(currUser.city)  
                          .fillDateOfBirth(currUser.dateOfBirth)  
                          .fillEmailAdress(currUser.emailAdress)  
                          .fillFirstName(currUser.firstNameInput) 
                          .fillLastName(currUser.lastNameInput) 
                          .fillPassword(currUser.password)  
                          .fillPhone(currUser.phone)  
                          .fillPostalCodes(currUser.postalCode) 
                          .fillState(currUser.state)  
                          .fillStreets(currUser.street) 
                          .selectCountry(currUser.country)
                          .register();
    if (isRegistered) {
        signInSteps.navigateToSignIn();   
    }
    signInSteps.fillEmail(currUser.emailAdress) 
    .fillPassword(currUser.password)  
    .clickLoginBtn();
    homeSteps.navigateBackToHomePage();
  }
  @Test(priority = 1,description = "Favorite Test")
  @Severity(SeverityLevel.CRITICAL)
  public void favouritesTest(){ 
  homeSteps
    .getCatagoryPageByTitle(Constants.RANDOM_PRODUCT) 
    .addCatagoryToFavorits()  
    .navigateToHomePage();

  softwareTestingBaseSteps.openDropDown().signOut();

  signInSteps.navigateToSignIn()  
  .fillEmail(currUser.emailAdress)  
  .fillPassword(currUser.password)  
  .clickLoginBtn();

  softwareTestingBaseSteps  
  .openDropDown() 
  .navigateToFavorite() 
  .findIfItemExistsByTitle(Constants.RANDOM_PRODUCT);
  
  }
  @Test(priority = 2,description = "Filter Test")
  @Severity(SeverityLevel.CRITICAL)
  public void filterTest(){ 
    homeSteps
    .chooseCatagoryByTitle(Constants.HAMMER_CATAGORY_BNT_TITLE)  
    .validateCatagorySize(Constants.HAMMER_CATAGORY_SIZE) 
    .chooseCatagoryByTitle(Constants.TOOL_BELTS_CATAGORY_BTN_TITLE) 
    .validateCatagorySize(Constants.HAMMER_CATAGORY_SIZE+Constants.TOOL_BELTS_CATAGORY_SIZE);
  }
  @Test(priority = 3,description = "Remove From Favorite")
  @Severity(SeverityLevel.CRITICAL)
  public void removeFavouriteTest(){  
    homeSteps 
    .getCatagoryPageByTitle(Constants.RANDOM_PRODUCT) 
    .addCatagoryToFavorits()  
    .navigateToHomePage();

    softwareTestingBaseSteps  
    .openDropDown() 
    .navigateToFavorite() 
    .deleteItemFromFavoritesUseingTitle(Constants.RANDOM_PRODUCT) 
    .findIfItemDoesNotExistByTitle(Constants.RANDOM_PRODUCT);

  }
  @Test(priority = 4,description = "Tag Tests")
  @Severity(SeverityLevel.CRITICAL)
  public void tagsTest(){ 
    homeSteps 
    .chooseCatagoryByTitle(Constants.HAMMER_CATAGORY_BNT_TITLE) 
    .getCatagoryPageByTitle(Constants.THOR_HAMMER)  
    .validateCatagorys(Constants.THOR_HAMMER_CATAGORY);
  }
}
