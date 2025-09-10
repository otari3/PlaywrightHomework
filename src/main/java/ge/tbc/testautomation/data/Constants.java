package ge.tbc.testautomation.data;

import java.util.List;
import java.util.Map;

import ge.tbc.testautomation.util.helperClasses.MagnetoRegistrationForm;
import ge.tbc.testautomation.util.helperClasses.ProductColorOptions;
import ge.tbc.testautomation.util.helperClasses.RegistrationForm;
import ge.tbc.testautomation.util.helperClasses.UserAdress;

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

  public static final ProductColorOptions MAGNETO_FIRST_PRODUCT =   
  new ProductColorOptions("Radiant Tee" , Map.of(  
    "Blue","https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/w/s/ws12-blue_main_1.jpg",
    "Orange","https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/w/s/ws12-orange_main_1.jpg",
    "Purple","https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/w/s/ws12-purple_main_1.jpg"
  ));
  public static final ProductColorOptions MAGNETO_SECOND_PRODUCT =   
  new ProductColorOptions("Breathe-Easy Tank" , Map.of(  
    "White","https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/w/t/wt09-white_main_1.jpg",
    "Yellow","https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/w/t/wt09-yellow_main_1.jpg",
    "Purple","https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/w/t/wt09-purple_main_1.jpg"
  ));
  public static final ProductColorOptions MAGNETO_THIRD_PRODUCT =   
  new ProductColorOptions("Argus All-Weather Tank" , Map.of(  
    "Gray","https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/m/t/mt07-gray_main_1.jpg"
  ));
  public static final String MAGNETO_URL = "https://magento.softwaretestingboard.com/";
  public static final String MAGNETO_RANDOM_PRODUCT = "Argus All-Weather Tank";
  public static final String MAGNETO_RANDOM_PRODUCT_PRICE = "$22.00";
  public static final String MAGNETO_RANDOM_PRODUCT_SIZE = "XL";
  public static final String MAGNETO_RANDOM_PRODUCT_COLOR = "Gray";
  public static final MagnetoRegistrationForm MAGNETO_USER =  
  new MagnetoRegistrationForm("test123", "test321", "randomEmal582312@mail.ru", "Test12345.", "Test12345.");
  public static final String OUT_OF_STOCK = "Out of Stock";
  public static final String MAGNETO_RADIENT_TEE_PRODUCT = "Radiant Tee";
  public static final String TEST_USER_MAIL = "Testtt12345@gmail.com";
  public static final String TEST_USER_PASSWORD = "thisIsMyTestPassword1234.";
  public static final int SHIPING_PRICE = 5;
  public static final String INVALID_DISCOUNT_CODE = "123456";
  public static final int RANDOM_PRODUCT_PRICE = 22;
  public static final UserAdress USER_ADRESS = new UserAdress("test1234", "test456", "testadress", null,  
  null, "testcity", "Alaska", "12345-6789", "United States", "56565656");
  public static final String REVIEW_NICK_NAME = "testname";
  public static final String REVIEW_SUMMERY = "tesstsummery";
  public static final String REVIEW = "testreview";
  public static final String REVIEW_STARS = "3";
}
