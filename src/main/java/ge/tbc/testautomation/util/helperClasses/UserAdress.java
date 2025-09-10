package ge.tbc.testautomation.util.helperClasses;

public class UserAdress {
  public String userFirstName;
  public String userLastName;
  public String userAdress1;
  public String userAdress2;
  public String userAddres3;
  public String city;
  public String state;
  public String zipCode;
  public String country;
  public String phoneNumber;
  public UserAdress(String userFirstName,String userLastName,String userAdress1,String userAdress2,String userAddres3,String city,String state,String zipCode,String country,String phoneNumber){  
      this.userFirstName = userFirstName;
      this.userLastName = userLastName;
      this.userAdress1 = userAdress1;
      this.userAdress2 = userAdress2;
      this.userAddres3 = userAddres3;
      this.city = city;
      this.state = state;
      this.zipCode = zipCode;
      this.country = country;
      this.phoneNumber = phoneNumber;
  }
}
