package ge.tbc.testautomation.util;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Util {
  
  public static void handleCustomDropDowns(Locator elements,String text){  
      elements.filter(new Locator.FilterOptions().setHasText(text)).first().click();
  }
  public static void removeAds(Page page){
    page.waitForFunction("document.readyState === 'complete'");
    String jsFunction = """
          if(()=>document.querySelectorAll('ins.adsbygoogle.adsbygoogle-noablate').length>0){
              document.querySelectorAll('ins.adsbygoogle.adsbygoogle-noablate').forEach(e => e.remove()); 
          }
    """;
    page.evaluate(jsFunction);
  }

  }

