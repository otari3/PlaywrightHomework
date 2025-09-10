package ge.tbc.testautomation.steps.magnetoSteps;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.magnetoPages.PaymantPage;
import ge.tbc.testautomation.util.Util;
import io.qameta.allure.Step;

public class PaymantSteps extends MagnetoBaseSteps {
  Page page;
  PaymantPage paymantPage;
  Pattern pattern = Pattern.compile("(?<firstName>\\S+)\\s?\\r?\\n" + //
        "(?<lasName>\\s+\\S+)\\s?\\r?\\n" + //
        "(?<adres1>\\s+[^,]+)\\,?\\s?(?<adres2>[^,]+)?\\,?\\s?(?<adres3>.*)?\\s?\\r?\\n" + //
        "(?<city>[^,]+)\\,\\s(?<state>\\S+)\\s(?<zipcode>\\S+)\\r?\\n" + //
        "(?<country>.*)\\s?\\r?\\n" + //
        "(?<phonenumber>\\s+\\d+)");
  Matcher matcher;
  public PaymantSteps(Page page){
    super(page);
    this.page = page;
    paymantPage = new PaymantPage(page);
    Util.removeAds(page);
  }
  private int getShipingPricePositon(String shipingPrice){ 
    PlaywrightAssertions.assertThat(paymantPage.allShipingPricesRows).hasCount(2);
    List<Locator> allPrices = paymantPage.allShipingPrices.all(); 
    for(int i=0;i<allPrices.size();i++){  
      String currPrice = allPrices.get(i).textContent();
      if (currPrice.equals(shipingPrice)) {
        return i+1;
      }
    }
    return -1;
  }
  @Step("Choose Shiping Price")
  public PaymantSteps chooseRadioBtnWithShipingPrice(int shipingPrice){ 
    String formatedShipingPrice = "$%s.00".formatted(shipingPrice);
    int radioBtnIndex = getShipingPricePositon(formatedShipingPrice);
    paymantPage.getRadioBtnWithPositon(radioBtnIndex).click();
    return this;
  }
  @Step("Go To Next Steps")
  public PaymantSteps goToNextSteps(){  
    paymantPage.nextBtn.click();
    return this;
  }
  @Step("Open Apply Discount Section")
  public PaymantSteps openApplyDiscount(){  
    paymantPage.applyDiscountOpen.click();
    return this;
  }
  @Step("Fill Discount Input")
  public PaymantSteps fillDiscountInput(String discountCode){ 
      paymantPage.discountCodeInput.fill(discountCode);
      return this;
  }
  @Step("Click Apply Discount Button")
  public PaymantSteps clickApplyDiscountBtn(){  
    paymantPage.applyDiscountBtn.click();
    return this;
  }
  @Step("Validate Discount Error")
  public PaymantSteps validateDiscountError(){  
    PlaywrightAssertions.assertThat(paymantPage.errorCupon).isVisible();
    return this;
  }
  @Step("Validate Total After Shiping")
  public PaymantSteps validateTotalAfterShiping(int productPrice,int shipingprice){ 
    String formatedFullPrice = "$%s.00".formatted(productPrice+shipingprice);
    PlaywrightAssertions.assertThat(paymantPage.totalAfterShiping).hasText(formatedFullPrice);
    return this;
  }
  //we need to use asssert here if we need to have steps do only one thing and use fluen api too
  @Step("Validate First Name")
  public PaymantSteps validateFirstName(String firstName){  
    if (matcher==null) {
      matcher = pattern.matcher(paymantPage.shipingAdress.textContent().trim());
      matcher.find();
    }
    Assert.assertEquals(matcher.group("firstName").trim(), firstName);
    return this;
  }
  @Step("Validate Last Name")
  public PaymantSteps validateLastName(String lastName){  
    if (matcher==null) {
      matcher = pattern.matcher(paymantPage.shipingAdress.textContent().trim());
      matcher.find();
    }
    Assert.assertEquals(matcher.group("lasName").trim(), lastName);
    return this;
  }
  @Step("Validate Addres 1")
  public PaymantSteps validateAddress1(String adress1){ 
    if (matcher==null) {
      matcher = pattern.matcher(paymantPage.shipingAdress.textContent().trim());
      matcher.find();
    }
    Assert.assertEquals(matcher.group("adres1").trim(), adress1);
    return this;
  }
  @Step("Validate addres2")
  public PaymantSteps validateAddres2(String addres2){  
   if (matcher==null) {
      matcher = pattern.matcher(paymantPage.shipingAdress.textContent().trim());
      System.out.println(paymantPage.shipingAdress.textContent().trim());
      matcher.find();
    }
    if (addres2!=null) {
          Assert.assertEquals(matcher.group("adres2").trim(), addres2); 
    }
    return this;
  }
  @Step("Validate Adres 3")
  public PaymantSteps validateAddres3(String addres3){  
    if (matcher==null) {
      matcher = pattern.matcher(paymantPage.shipingAdress.textContent().trim());
      matcher.find();
    }
    if (addres3!=null) {
          Assert.assertEquals(matcher.group("adres3").trim(), addres3); 
    }
    return this;
  }
  @Step("Validate City")
  public PaymantSteps validateCity(String city){  
    if (matcher==null) {
      matcher = pattern.matcher(paymantPage.shipingAdress.textContent().trim());
      matcher.find();
    }
     Assert.assertEquals(matcher.group("city").trim(), city);
     return this; 
  }
  @Step("Validate State")
  public PaymantSteps validateState(String state){  
    if (matcher==null) {
      matcher = pattern.matcher(paymantPage.shipingAdress.textContent().trim());
      matcher.find();
    }
     Assert.assertEquals(matcher.group("state").trim(), state);
     return this; 
  }
  @Step("Validet Zip Code")
  public PaymantSteps validateZipCode(String zipcode){  
    if (matcher==null) {
      matcher = pattern.matcher(paymantPage.shipingAdress.textContent().trim());
      matcher.find();
    }
     Assert.assertEquals(matcher.group("zipcode").trim(), zipcode);
     return this; 
  }
  @Step("Validate Country")
  public PaymantSteps validateCountry(String country){  
    if (matcher==null) {
      matcher = pattern.matcher(paymantPage.shipingAdress.textContent().trim());
      matcher.find();
    }
    Assert.assertEquals(matcher.group("country").trim(), country);
    return this; 
  }
  @Step("Validet Phone Number")
  public PaymantSteps validatePhoneNumber(String phoneNumber){  
    if (matcher==null) {
      matcher = pattern.matcher(paymantPage.shipingAdress.textContent().trim());
      matcher.find();
    }
    Assert.assertEquals(matcher.group("phonenumber").trim(), phoneNumber);
    return this; 
  }
  @Step("Place Order")
  public PaymantSteps placeOrder(){ 
    paymantPage.placeOrderBtn.click();
    return this;
  }
  @Step("Validate Succsess Page")
  public PaymantSteps validateSuccsesPage(){  
    PlaywrightAssertions.assertThat(paymantPage.thankYouHeader).isVisible();
    return this;
  }

}
