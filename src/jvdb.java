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
		stmt.execute("CREATE TABLE users (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,INCREMENT BY 1), username VARCHAR(10), password VARCHAR(10))");

		stmt.execute("INSERT INTO users (username, password) VALUES ('user0','123456')");
		stmt.execute("INSERT INTO users (username, password) VALUES ('user1','123123')");
		stmt.execute("INSERT INTO users (username, password) VALUES ('user2','121212')");
		stmt.execute("INSERT INTO users (username, password) VALUES ('user3','654321')");
		stmt.execute("INSERT INTO users (username, password) VALUES ('user4','111111')");
		//INSERT INTO Employees (FirstName, SecondName) VALUES ('Nenko', 	'Tabakov');
		stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM users");
		while (rs.next()) {
			String id = rs.getString("id");
			String user = rs.getString("username");
			String pass = rs.getString("password");
			System.out.println(id + " " + user + " " + pass);
			//System.out.println(pass);
		}
		stmt.execute("DROP TABLE users");
	}
}
