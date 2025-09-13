package ge.tbc.testautomation.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ge.tbc.testautomation.util.helperClasses.RegistrationFormForTechCanvas;

public class DataBaseStep {
  public static ArrayList<RegistrationFormForTechCanvas> getAllRegistrationInformation(Connection connection){ 
           try {
            String SQL = "SELECT * FROM RegistrationData;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            ArrayList<RegistrationFormForTechCanvas> result = new ArrayList<>();
            while (resultSet.next()) {
              result.add(new RegistrationFormForTechCanvas( 
                resultSet.getInt("id"),   
                resultSet.getString("firstName"),  
                resultSet.getString("lastName"),  
                resultSet.getString("gender"),  
                resultSet.getString("model"), 
                resultSet.getString("address1"),  
                resultSet.getString("address2"),  
                resultSet.getString("city"),  
                resultSet.getString("contact1"),  
                resultSet.getString("contact2") 
                 ));
            }
            return result;
           } catch (SQLException e) {
              throw new RuntimeException(e);
           }
  }
}
