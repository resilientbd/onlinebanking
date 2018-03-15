package g;
import java.sql.*;
public class GetCon {
private GetCon(){}

public static Connection con;
static{
	try {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bnlivein_lict","bnlivein_lict","java@1234");
} catch (Exception e) {
		
		e.printStackTrace();
	} 
	
}
public static Connection getCon(){
	return con;
}



public static int getPrimaryKey(){
	int nextvalue=0;
	Connection con=GetCon.getCon();
	PreparedStatement ps2;
	try {
	
	ps2=con.prepareStatement("select javatpointnewaccount.nextval from dual");
	
	ResultSet rs=ps2.executeQuery();
	rs.next();
	nextvalue=rs.getInt(1);

	
	
} catch (SQLException e) {
		
		e.printStackTrace();
	}
return nextvalue;

}
}

