
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;
/**
 *
 * @author beastieux
 */
public class Conexion {
 
    public CachedRowSet Function(String sql)
    {
            try
            {
                    Class.forName("Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/integ","root","n0m3l0");
                    Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);
 
                    ResultSet rs= s.executeQuery(sql);
 
                    CachedRowSet crs = new CachedRowSetImpl();
                    crs.populate(rs);
 
                    rs.close();
                    s.close();
                    con.close();
 
                    return crs;
 
            }
            catch(Exception e)
            {
                   System.out.println(e.getMessage());
            }
 
            return null;
    }
 
    public void StoreProcedure(String sql)
    {
 
            try
            {
                    Class.forName("Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","n0m3l0");
                    Statement s = con.createStatement();
 
                    s.execute(sql);
 
                    s.close();
                    con.close();
 
            }
            catch(Exception e)
            {
                   System.out.println(e.getMessage());
            }
    }
    
    
}
