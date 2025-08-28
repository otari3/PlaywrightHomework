package ge.tbc.testautomation.util.helperClasses;



public class RegistrationForm {
  public String firstNameInput;
  public String lastNameInput;
  public String dateOfBirth;
  public String street;
  public String postalCode;
  public String city;
  public String state;
  public String country;
  public String phone;
  public String emailAdress;
  public String password;
  public RegistrationForm(String firstNameInput,String lastNameInput, 
                          String dateOfBirth,String street,String postalCode,String city,String state,  
                          String country,String phone,String emailAdress,String password) 
            {  
              this.firstNameInput = firstNameInput;
              this.lastNameInput = lastNameInput;
              this.dateOfBirth = dateOfBirth;
              this.street = street;
              this.postalCode = postalCode;
              this.city = city;
              this.state = state;
              this.country = country;
              this.phone = phone;
              this.emailAdress = emailAdress;
              this.password = password;
            }
  public String getCity() {
    return city;
  }
  public String getCountry() {
    return country;
  }
  public String getDateOfBirth() {
    return dateOfBirth;
  }
  public String getEmailAdress() {
    return emailAdress;
  }
  public String getFirstNameInput() {
    return firstNameInput;
  }
  public String getLastNameInput() {
    return lastNameInput;
  }
  public String getPassword() {
    return password;
  }
  public String getPhone() {
    return phone;
  }
  public String getPostalCode() {
    return postalCode;
  }
  public String getState() {
    return state;
  }
  public String getStreet() {
    return street;
  }

}
