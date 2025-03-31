package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class ImplementacionBD implements UsuarioDAO{
	// Atributos
	private Connection con;
	private PreparedStatement stmt;

	// Los siguientes atributos se utilizan para recoger los valores del fich de
	// configuraci n
	private ResourceBundle configFile;
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	// Sentencias SQL

	final String SQL = "SELECT * FROM clients WHERE ID_C = ? AND PASSWORD_C = ?";		
	final String sql1 = "SELECT * FROM workers WHERE id_w = ? AND password_w = ?"; 
	final String SQLDUpdateProduct = "UPDATE products SET prize =? WHERE id_p =?"; //ModificarProducto 

	final String sqlInsertClient = "INSERT INTO CLIENTS VALUES (?,?,?)";
	final String sqlInsertProduct = "INSERT INTO PRODUCTS VALUES (?,?,?,?)";
	final String SQLCONSULTA = "SELECT * FROM products";
	final String SQLDELETEPRODUCT = "DELETE FROM products WHERE id_p=?";
	final String SQLMODIFICAR = "UPDATE usuario SET contrasena=? WHERE nombre=?";

	// Para la conexi n utilizamos un fichero de configuaraci n, config que
	// guardamos en el paquete control:
	public ImplementacionBD() {
		this.configFile = ResourceBundle.getBundle("config");
		this.driverBD = this.configFile.getString("Driver");
		this.urlBD = this.configFile.getString("Conn");
		this.userBD = this.configFile.getString("DBUser");
		this.passwordBD = this.configFile.getString("DBPass");
	}

	private void openConnection() {
		try {
			con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean comprobarCliente(Client client){
		// Abrimos la conexion
		boolean existe=false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQL);
			stmt.setInt(1, client.getclient_id());
			stmt.setString(2, client.getclient_password());
			ResultSet resultado = stmt.executeQuery();

			//Si hay un resultado, el usuario existe
			if (resultado.next()) {
				existe = true;
			}
			resultado.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}
		return existe;
	}

	public boolean comprobarTrabajador(Worker worker){
		// Abrimos la conexion
		boolean existe=false;
		this.openConnection();


		try {
			stmt = con.prepareStatement(sql1);
			stmt.setString(1, worker.getId_trabajador());
			stmt.setString(2, worker.getworker_password());
			ResultSet resultado = stmt.executeQuery();

			//Si hay un resultado, el usuario existe
			if (resultado.next()) {
				existe = true;
			}


			resultado.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}

		return existe;
	}

	public boolean checkClient2(Client client){
		// Abrimos la conexion
		boolean existe=false;
		this.openConnection();


		try {
			stmt = con.prepareStatement(sql1);
			stmt.setInt(1, client.getclient_id());
			ResultSet resultado = stmt.executeQuery();

			//Si hay un resultado, el usuario existe
			if (resultado.next()) {
				existe = true;
			}


			resultado.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}

		return existe;
	}

	public boolean insertClient(Client client) { //añadirTrabajador (1)
		// TODO Auto-generated method stub
		boolean ok=false;
		if (!checkClient2(client))
		{
			this.openConnection();
			try {
				// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

				stmt = con.prepareStatement(sqlInsertClient);
				stmt.setInt(1, client.getclient_id());
				stmt.setString(2, client.getclient_name());
				stmt.setString(3, client.getclient_password());
				if (stmt.executeUpdate()>0) {
					ok=true;
				}

				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al verificar credenciales: " + e.getMessage());
			}
		}
		return ok;

	}
	
	public boolean insertProduct(Product producto) { //añadirTrabajador (1)
		// TODO Auto-generated method stub
		boolean ok=false;
		
			this.openConnection();
			try {
				// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

				stmt = con.prepareStatement(sqlInsertProduct);
				stmt.setString(1, producto.getproduct_id());
				stmt.setString(2, producto.getproduct_name());
				stmt.setDouble(3, producto.getprice());
				stmt.setInt(4, producto.getStock());
				stmt.setLong(5,producto.getcategory());
				if (stmt.executeUpdate()>0) {
					ok=true;
				}

				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al verificar credenciales: " + e.getMessage());
			}
		
		return ok;

	}

	public Map<String, Product> MostrarProducto() {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		Product producto;
		Map<String, Product> productos = new TreeMap<>();

		// Abrimos la conexion
		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLCONSULTA);

			rs = stmt.executeQuery();

			// Leemos de uno en uno
			while (rs.next()) {
				producto = new Product();
				producto.setproduct_name(rs.getString("NAME_P"));
				producto.setprice(rs.getDouble("PRIZE"));
				producto.setproduct_id(rs.getString("ID_P"));
				producto.setStock(rs.getInt("STOCK"));
				productos.put(producto.getproduct_name(), producto);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		}
		return productos;

	}	

	public boolean modificarPrecio(Product producto) { //MODIFICAR
		// TODO Auto-generated method stub
		boolean ok=false;
		this.openConnection();
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(SQLDUpdateProduct);
			stmt.setString(2, producto.getproduct_id());
			stmt.setDouble(1, producto.getprice());
			if (stmt.executeUpdate()>0) {
				ok=true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}
		return ok;						
	}

	public boolean deleteProduct (String producto) {
		// Abrimos la conexion
		boolean existe=false;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLDELETEPRODUCT);
			stmt.setString(1, producto);
			if(stmt.executeUpdate()>0) {
				existe=true;
			}



			stmt.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			System.out.println(e);
		}

		return existe;	
	}
}






