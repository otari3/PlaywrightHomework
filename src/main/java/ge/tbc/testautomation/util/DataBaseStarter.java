package ge.tbc.testautomation.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseStarter {
  public static void setUpRegistrationDataBase(Connection connection){ 
      try {
        connection.createStatement().executeUpdate( 
                  "use Registration;\n" + //
                  "create table RegistrationData (\n" + //
                  "   id int,\n" + //
                  "   firstName varchar(50),\n" + //
                  "   lastName varchar(50),\n" + //
                  "   gender varchar(50),\n" + //
                  "   model varchar(50),\n" + //
                  "   address1 varchar(50),\n" + //
                  "   address2 varchar(50),\n" + //
                  "   city varchar(50),\n" + //
                  "   contact1 varchar(50),\n" + //
                  "   contact2 varchar(50),\n" + //
                  "   primary key (id)\n" + //
                  ");\n" + //
                  " \n" + //
                  "insert into RegistrationData values (1001, 'Zaza', 'Zazadze', 'male', 'Mega 123 Large screen', 'someaddress1', 'someaddress2', 'Zugdidi', 'somecontact1', 'somecontact2');\n" + //
                  "insert into RegistrationData values (1002, 'girogi', 'giorgadyye', 'male', 'Mega 123 Medium screen', 'someaddress2', 'someaddress3', 'kutaisi', 'somecontact2', 'somecontact3');\n" + //
                  "insert into RegistrationData values (1005, 'zura', 'zurabidze', 'male', 'Serene Pad 64G', 'someaddress3', 'someaddress4', 'anaklia', 'somecontact3', 'somecontact4');\n" + //
                  "insert into RegistrationData values (1006, 'irakli', 'irakladze', 'male', 'Serene Pad 64G', 'someaddress4', 'someaddress4', 'tbilisi', 'somecontact4', 'somecontact6');\n" + //
                  "insert into RegistrationData values (1007, 'mari', 'mariamidze', 'male', 'Serene Pad 32G', 'someaddress5', 'someaddress5', 'zestaponi', 'somecontact5', 'somecontact7');\n" + //
                  "");
      } catch (SQLException e) {
        e.printStackTrace();
      }
  }
}
