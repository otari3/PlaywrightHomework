package ge.tbc.testautomation.steps;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import ge.tbc.testautomation.Pages.FavoritePage;
import io.qameta.allure.Step;

public class FavoritSteps {
  Page page;
  FavoritePage favoritePage;
  public FavoritSteps(Page page){ 
    this.page = page;
    favoritePage = new FavoritePage(page);
  }
  @Step("Find if Item Exist By Title")
  public FavoritSteps findIfItemExistsByTitle(String title){  
      PlaywrightAssertions.assertThat(  
        favoritePage.allFavoritItems
                      .filter(new Locator.FilterOptions()  
                          .setHas(page.locator("//h5[text()='%s']".formatted(title))))
      ).hasCount(1);
      return this;
  }
  @Step("Delete Itme Useing Title")
  public FavoritSteps deleteItemFromFavoritesUseingTitle(String title){ 
    Locator itemToDelete = favoritePage.allFavoritItems.filter(new Locator.FilterOptions()  
                                                         .setHas(page.locator("//h5[text()='%s']"  
                                                          .formatted(title))));
    itemToDelete.locator("//button[@data-test='delete']").click();;
    return this;
  }
  @Step("Find If Item Does Not Exists In Favorite")
  public FavoritSteps findIfItemDoesNotExistByTitle(String title){  
        PlaywrightAssertions.assertThat(  
          favoritePage.allFavoritItems.filter(new Locator.FilterOptions() 
                                                            .setHas(page.locator("//h5[text()='%s']"  
                                                                          .formatted(title)))  

          )
        ).hasCount(0);
        return this;

  }
}
