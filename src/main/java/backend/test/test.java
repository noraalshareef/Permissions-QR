package backend.test;
import backend.db.Broker;
import backend.db.ConnectionManager;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import javax.naming.NamingException;
import java.sql.*;
import java.text.ParseException;

public class test
{

    public static void main (String ... args) throws SQLException, NamingException, ParseException {

        Connection con =ConnectionManager.getFullStopConnection();
        Broker.setPossiblePemission(con,1089,true,"kk","kk","2020-09-12","2020-09-12","l",false);

        /*String SQL = " INSERT INTO [dbo].[Permit] (ID, IS_PERMANENT, REASON ,PLACE, FIRST_DATE , SECOND_DATE , ATTACHMENT, NEED_REVISION, IS_PERMITTED)" +
                "VALUES (?, ?, ?,?, ?, ? , ? ,?,?);" ;

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQL);
            stmt.setLong(1, 10895566);
            stmt.setBoolean(2, true);
            stmt.setString(3, "kk");
            stmt.setString(4, "kk");
            stmt.setDate(5, Date.valueOf("2020-09-12"));
            stmt.setDate(6, Date.valueOf("2020-09-12"));
            stmt.setString(7, "l");
            stmt.setBoolean(8, false);
            stmt.setBoolean(9, false);

            stmt.executeUpdate();

        } finally {
            ConnectionManager.close(stmt, con);
        }
*/
    }
}