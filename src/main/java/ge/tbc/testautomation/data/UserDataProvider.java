package ge.tbc.testautomation.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import org.testng.annotations.DataProvider;

import ge.tbc.testautomation.util.helperClasses.RegistrationFormForTechCanvas;

public class UserDataProvider {
  @DataProvider(name = "userDataProvider")
  public static Object[][] userDataProvider(){  
    try(Connection connection = MSSQLConnection.connect()){ 
      ArrayList<RegistrationFormForTechCanvas> allUsers = DataBaseStep.getAllRegistrationInformation(connection);
      Object[][] data = new Object[allUsers.size()][1];
      for(int i = 0;i<allUsers.size();i++){ 
        data[i][0] = allUsers.get(i);
      }
      connection.close();
      return data;
      
    } catch (SQLException e) {
     throw new RuntimeException(e);
    }
  }
}
