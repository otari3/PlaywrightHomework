package ge.tbc.testautomation.steps.magnetoSteps;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.magnetoPages.MagnetoBasePage;
import ge.tbc.testautomation.util.Util;

public class MagnetoBaseSteps {
    MagnetoBasePage magnetoBasePage;
    Page page;
    public MagnetoBaseSteps(Page page){  
      magnetoBasePage = new MagnetoBasePage(page);
      this.page = page;
      Util.removeAds(page);
    }
    public MagnetoBaseSteps sendValueToSearch(String val){  
        magnetoBasePage.searchInput.fill(val);
        return this;
    }
    public SearchSteps navigateToSearchResutlsUseingValue(String val){ 
      Locator searchResults = page.locator(magnetoBasePage.searchResults);
      PlaywrightAssertions.assertThat(searchResults).isVisible();
      Util.handleCustomDropDowns(searchResults.locator("li"), val);
      return new SearchSteps(page);
    }
    public MagnetoBaseSteps openCartDropDown(){ 
      magnetoBasePage.cardDropDown.click();
      page.waitForTimeout(500);
      return this;
    }
    public CartSteps openCartPageWithDropDown(){ 
      magnetoBasePage.viewAndEditCartBtn.click();
      return new CartSteps(page);
    }
    public void clickUseingJs(Locator elem){  
      page.evaluate("element => element.click()", elem.elementHandle());
    }
    public MagnetoSignInSteps navigateToSignIn(){ 
      magnetoBasePage.signInBtn.click();
      return new MagnetoSignInSteps(page);
    }
    public MagnetoBaseSteps openAccountDropDown(){  
      magnetoBasePage.accountDropDownBtn.click();
      return this;
    }
    //for some reason we need to do this action twice to actully navigate
    public WishListSteps openWishListPageWithDropDownBtn(){ 
      for(int i=0;i<2;i++){ 
        openAccountDropDown();
        magnetoBasePage.wishListBtnFromDropDown.click();
      }
      return new WishListSteps(page);
    }
    public PaymantSteps navigateToPaymantPage(){  
      magnetoBasePage.proceedToCheckOutBtn.click();
      return new PaymantSteps(page);
    }
    public MagnetoBaseSteps clickAccountBurgerBtn(){  
      magnetoBasePage.burgerAccountBtn.click();
      return this;
    }
    public MagnetoBaseSteps validateSignInBurgerBtn(){  
      PlaywrightAssertions.assertThat(magnetoBasePage.signInBurgerBtn).isVisible();
      return this;
    }
    public MagnetoBaseSteps validateCreateAccountBurrgerBtn(){  
      PlaywrightAssertions.assertThat(magnetoBasePage.createAccountBurgerBtn).isVisible();
      return this;
    }
    public MagnetoBaseSteps openBurger(){ 
      magnetoBasePage.buregerBtn.click();
      return this;
    }
    public MagnetoBaseSteps openMenuBurger(){ 
      magnetoBasePage.menuBugerBtn.click();
      return this;
    }
    public MagnetoBaseSteps validateMenBurgerBtn(){ 
      PlaywrightAssertions.assertThat(magnetoBasePage.menBurgerBtn).isVisible();
      return this;
    }
    public MagnetoBaseSteps validateWomenBurgerBtn(){ 
      PlaywrightAssertions.assertThat(magnetoBasePage.womenBurgerBtn).isVisible();
      return this;
    }
    public MagnetoBaseSteps validateWhatsNewBurgerBtn(){  
      PlaywrightAssertions.assertThat(magnetoBasePage.whatsNewBurgerBtn).isVisible();
      return this;
    }
    public MagnetoBaseSteps validateGearBugergerBtn(){  
      PlaywrightAssertions.assertThat(magnetoBasePage.gearBurgerBtn).isVisible();
      return this;
    }
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
