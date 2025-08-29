package ge.tbc.testautomation.util.helperClasses;

import java.util.Map;

public class ProductColorOptions {
  public String exactProductName;
  public Map<String,String> productColorsAndTheirSrc;

  public ProductColorOptions(String exactProductName,Map<String,String> productColorsAndTheirSrc ){ 
    this.exactProductName = exactProductName;
    this.productColorsAndTheirSrc = productColorsAndTheirSrc;
  }
}
