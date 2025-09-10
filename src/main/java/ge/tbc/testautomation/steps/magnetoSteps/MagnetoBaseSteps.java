package ge.tbc.testautomation.steps.magnetoSteps;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.magnetoPages.MagnetoBasePage;
import ge.tbc.testautomation.util.Util;
import io.qameta.allure.Step;

public class MagnetoBaseSteps {
    MagnetoBasePage magnetoBasePage;
    Page page;
    public MagnetoBaseSteps(Page page){  
      magnetoBasePage = new MagnetoBasePage(page);
      this.page = page;
      Util.removeAds(page);
    }
    @Step("Send Value To Search Input")
    public MagnetoBaseSteps sendValueToSearch(String val){  
        magnetoBasePage.searchInput.fill(val);
        return this;
    }
    @Step("Naviget To Search Result Querys Useing val {}")
    public SearchSteps navigateToSearchResutlsUseingValue(String val){ 
      Locator searchResults = page.locator(magnetoBasePage.searchResults);
      PlaywrightAssertions.assertThat(searchResults).isVisible();
      Util.handleCustomDropDowns(searchResults.locator("li"), val);
      return new SearchSteps(page);
    }
    @Step("Open Cart Drop Down")
    public MagnetoBaseSteps openCartDropDown(){ 
      magnetoBasePage.cardDropDown.click();
      page.waitForTimeout(500);
      return this;
    }
    @Step("Open Cart Page From Cart Drop Down")
    public CartSteps openCartPageWithDropDown(){ 
      magnetoBasePage.viewAndEditCartBtn.click();
      return new CartSteps(page);
    }
    public void clickUseingJs(Locator elem){  
      page.evaluate("element => element.click()", elem.elementHandle());
    }
    @Step("Navigate to Sign In Page")
    public MagnetoSignInSteps navigateToSignIn(){ 
      magnetoBasePage.signInBtn.click();
      return new MagnetoSignInSteps(page);
    }
    public MagnetoBaseSteps openAccountDropDown(){  
      magnetoBasePage.accountDropDownBtn.click();
      return this;
    }
    //for some reason we need to do this action twice to actully navigate
    @Step("Open WishList From Drop Down")
    public WishListSteps openWishListPageWithDropDownBtn(){ 
      for(int i=0;i<2;i++){ 
        openAccountDropDown();
        magnetoBasePage.wishListBtnFromDropDown.click();
      }
      return new WishListSteps(page);
    }
    @Step("Navigate To Paymant Page")
    public PaymantSteps navigateToPaymantPage(){  
      magnetoBasePage.proceedToCheckOutBtn.click();
      return new PaymantSteps(page);
    }
    @Step("Click Account Burger")
    public MagnetoBaseSteps clickAccountBurgerBtn(){  
      magnetoBasePage.burgerAccountBtn.click();
      return this;
    }
    @Step("Validate Sign In burger Btn")
    public MagnetoBaseSteps validateSignInBurgerBtn(){  
      PlaywrightAssertions.assertThat(magnetoBasePage.signInBurgerBtn).isVisible();
      return this;
    }
    @Step("Validate Create Account Burger Button")
    public MagnetoBaseSteps validateCreateAccountBurrgerBtn(){  
      PlaywrightAssertions.assertThat(magnetoBasePage.createAccountBurgerBtn).isVisible();
      return this;
    }
    @Step("Open Burger")
    public MagnetoBaseSteps openBurger(){ 
      magnetoBasePage.buregerBtn.click();
      return this;
    }
    @Step("Open Menu In Burger")
    public MagnetoBaseSteps openMenuBurger(){ 
      magnetoBasePage.menuBugerBtn.click();
      return this;
    }
    @Step("Validate Burger Men Button")
    public MagnetoBaseSteps validateMenBurgerBtn(){ 
      PlaywrightAssertions.assertThat(magnetoBasePage.menBurgerBtn).isVisible();
      return this;
    }
    @Step("Validate Burger Women Button")
    public MagnetoBaseSteps validateWomenBurgerBtn(){ 
      PlaywrightAssertions.assertThat(magnetoBasePage.womenBurgerBtn).isVisible();
      return this;
    }
    @Step("Validate Whats New Burger Button")
    public MagnetoBaseSteps validateWhatsNewBurgerBtn(){  
      PlaywrightAssertions.assertThat(magnetoBasePage.whatsNewBurgerBtn).isVisible();
      return this;
    }
    @Step("Validate Gear")
    public MagnetoBaseSteps validateGearBugergerBtn(){  
      PlaywrightAssertions.assertThat(magnetoBasePage.gearBurgerBtn).isVisible();
      return this;
    }
    @Step("Validate Sales Button")
    public MagnetoBaseSteps validateSalesBtn(){ 
      PlaywrightAssertions.assertThat(magnetoBasePage.salesBurgerBtn).isVisible();
      return this;
    }
    public MagnetoBaseSteps signOut(){ 
        openAccountDropDown();
        magnetoBasePage.signOutBtn.click();
        Util.removeAds(page);
      return this;
    }
}
