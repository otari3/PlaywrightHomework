package ge.tbc.testautomation.data;

import java.util.List;

import ge.tbc.testautomation.util.helperClasses.RegistrationForm;

public class Constants {
  public static final String PRACTICE_SOFTWARE_URL = "https://practicesoftwaretesting.com/";
  public static final Integer PRACTICE_SOFTWARE_USER_AMOUNT = 1;
  public static final RegistrationForm FIRSTUSER =  
  new RegistrationForm("thisistest", "testtestes", "2000-12-27", "teststreet",  
  "123456", "testcity", "teststate", "Angola", "21321412412", 
  "testemail@mail.ru", "thisIsMyTestPassword1234.");
  public static final String RANDOM_PRODUCT = "Combination Pliers";
  public static final String HAMMER_CATAGORY_BNT_TITLE = "Hammer";
  public static final int HAMMER_CATAGORY_SIZE = 7;
  public static final String TOOL_BELTS_CATAGORY_BTN_TITLE = "Tool Belts";
  public static final int TOOL_BELTS_CATAGORY_SIZE = 1;
  public static final String THOR_HAMMER = " Thor Hammer ";
  public static final List<String> THOR_HAMMER_CATAGORY = List.of("Hammer","ForgeFlex Tools");
  public static final List<RegistrationForm> multipleUsers = List.of( 
    new RegistrationForm("thisistest", "testtestes", "2000-12-27", "teststreet",  
    "123456", "testcity", "teststate", "Angola", "21321412412", 
    "testemail0@mail.ru", "thisIsMyTestPassword1234."),
    new RegistrationForm("testuser1", "testtestes", "2000-12-27", "teststreet",  
    "123456", "testcity", "teststate", "Angola", "21321412412", 
    "testemail1@mail.ru", "thisIsMyTestPassword1234."),
    new RegistrationForm("testuser2", "testtestes", "2000-12-27", "teststreet",  
    "123456", "testcity", "teststate", "Angola", "21321412412", 
    "testemail2@mail.ru", "thisIsMyTestPassword1234."),
    new RegistrationForm("testuser3", "testtestes", "2000-12-27", "teststreet",  
    "123456", "testcity", "teststate", "Angola", "21321412412", 
    "testemail3@mail.ru", "thisIsMyTestPassword1234.")
  );
}
