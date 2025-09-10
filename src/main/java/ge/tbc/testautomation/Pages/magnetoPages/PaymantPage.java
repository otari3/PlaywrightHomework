package ge.tbc.testautomation.Pages.magnetoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PaymantPage {
  Page page;
  public Locator allShipingPrices;
  public Locator allShipingPricesRows;
  public Locator shipingAdress;
  public Locator applyDiscountOpen;
  public Locator discountCodeInput;
  public Locator applyDiscountBtn;
  public Locator errorCupon;
  public Locator totalAfterShiping;
  public Locator nextBtn;
  public Locator placeOrderBtn;
  public Locator thankYouHeader;
  public PaymantPage(Page page){ 
    this.page = page;
    allShipingPrices = page.locator("//span[@class='price']//span[@class='price']");
    allShipingPricesRows = page.locator("//span[@class='price']//span[@class='price']/ancestor::tr");
    shipingAdress = page.locator("(//span[text()='Ship To:']/following::div[@class='shipping-information-content'])[1]");
    applyDiscountOpen = page.getByText("Apply Discount Code");
    discountCodeInput = page.locator("#discount-code");
    applyDiscountBtn = page.locator("//button[@class='action action-apply']");
    errorCupon = page.locator("//div[@class='message message-error error']");
    totalAfterShiping = page.locator("//td[@data-th='Order Total']//span");
    nextBtn = page.locator("//button[@data-role='opc-continue']");
    placeOrderBtn = page.locator("//button[@class='action primary checkout']");
    thankYouHeader = page.locator("//h1[@class='page-title']//span[text()='Thank you for your purchase!']");
  }
  public Locator getRadioBtnWithPositon(int positon){  
    return page.locator("(//input[@type='radio'])[%s]".formatted(positon));
  }
}
