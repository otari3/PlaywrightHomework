package ge.tbc.testautomation.util.helperClasses;

public class RegistrationFormForTechCanvas {
  public int id;
  public String firstName;
  public String lastName;
  public String gender;
  public String model;
  public String address1;
  public String address2;
  public String city;
  public String contact1;
  public String contact2;
  public RegistrationFormForTechCanvas(int id,String firstName,String lastName,String gender,String model,String address1,String address2,String city,String contact1,String contact2){ 
      this.id = id;
      this.firstName = firstName;
      this.lastName =lastName;
      this.gender =gender;
      this.model = model;
      this.address1 = address1;
      this.address2 = address2;
      this.city = city;
      this.contact1 = contact1;
      this.contact2 =contact2;
  }
}
