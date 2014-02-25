import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jvdb {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con = DriverManager
				.getConnection("jdbc:derby:wombat;create=true");
		Statement stmt = con.createStatement();
		stmt.execute("CREATE TABLE users (username VARCHAR(10), password VARCHAR(10))");

		stmt.execute("INSERT INTO users (username, password) VALUES ('asd','123456')");
		//INSERT INTO Employees (FirstName, SecondName) VALUES ('Nenko', 	'Tabakov');
		stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT password,username FROM users");
		while (rs.next()) {
			String user = rs.getString("username");
			String pass = rs.getString("password");
			System.out.print(user);
			System.out.println(pass);
		}
		stmt.execute("DROP TABLE users");
	}
}
