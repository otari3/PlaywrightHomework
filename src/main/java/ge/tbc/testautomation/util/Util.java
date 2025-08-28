package ge.tbc.testautomation.util;

import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;

public class Util {
  
  public static void handleCustomDropDowns(Locator elements,String text){  
      elements.filter(new Locator.FilterOptions().setHasText(Pattern.compile(text))).click();
  }
}
