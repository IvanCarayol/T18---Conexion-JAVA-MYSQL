import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

	static String bd = "t14_ej8_piezas_proveedores"; 
	static String login = "root"; 
	static String password = "1234"; 
	static String url = "jdbc:mysql://localhost:3306/" + bd;

	public static void main(String[] args) {

		Connection conn = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection(url, login, password);
			String sURL = url;
			conn = DriverManager.getConnection(sURL,login,password);
			if (conn != null) {
				System.out.println("-Abierta base de datos " + url + " - Ok");

				Statement st = conn.createStatement();// Permite comandos SQL
				st.executeUpdate(
						"INSERT INTO piezas (Nombre) VALUES ROW(\"Tornillo\"), ROW (\"Alicate\"), ROW (\"Taladro\"), ROW (\"Generador\"), ROW (\"Piston\")");
				
				System.out.println("-Añadir registros a la tabla - Ok");
			
				conn.close();// Cerrar base de datos
				System.out.println("-Cerrar base de datos " + url + " - Ok");
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}

	}

}
