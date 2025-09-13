package ge.tbc.testautomation;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.data.MSSQLConnection;
import ge.tbc.testautomation.data.UserDataProvider;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.techCanvasSteps.PhoneRegistrationSteps;
import ge.tbc.testautomation.util.helperClasses.RegistrationFormForTechCanvas;

public class RegistrationTests extends BaseTest {
  Connection connection;
  PhoneRegistrationSteps phoneRegistrationSteps;

  @BeforeSuite
  public void connectToDataBase(){  
    connection = MSSQLConnection.connect();
  }
  //uncomment code to set up data base if not already 
  @BeforeClass
  public void setUpPage(){
    // DataBaseStarter.setUpRegistrationDataBase(connection);
    openPage(Constants.TECH_CANVES_URL_REGISTRATION);
    phoneRegistrationSteps = new PhoneRegistrationSteps(page);
  }
  //demo site sometimes does not load possible chromium issue so i could not test all 5 of them but it should work 
  //fill your database information in database.properties i am useing mac so our ports will be different
  @Test(dataProvider = "userDataProvider",dataProviderClass = UserDataProvider.class)
  public void registrationTest(RegistrationFormForTechCanvas registrationValues){
    phoneRegistrationSteps  
    .fillFirstName(registrationValues.firstName)  
    .fillFirstName(registrationValues.lastName) 
    .selectMaleGender() 
    .selectModelName(registrationValues.model)  
    .fillAddress1(registrationValues.address1)  
    .fillAddress2(registrationValues.address2)  
    .fillCity(registrationValues.city)  
    .fillContact1(registrationValues.contact1)  
    .fillContact2(registrationValues.contact2);
    page.reload();
  }
  @AfterSuite
  public void closeConnection() throws SQLException{  
    connection.close();
  }
}
