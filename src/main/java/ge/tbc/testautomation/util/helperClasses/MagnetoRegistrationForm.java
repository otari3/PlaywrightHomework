package ge.tbc.testautomation.util.helperClasses;


public class MagnetoRegistrationForm {
  public String firstName;
  public String lastName;
  public String email;
  public String password;
  public String passwordConformation;
  public MagnetoRegistrationForm(String firstName,String lastName,String email,String password,String passwordConformation){
    this.firstName =firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.passwordConformation = passwordConformation;
  }
}
