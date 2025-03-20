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
		
		final String SQLLoginCliente = "SELECT * FROM clients WHERE id_c = ? AND password_c = ?";	//(IniciarSesion Cliente)	(Hecho)
		final String SQLLoginTrabajador = "SELECT * FROM workers WHERE name_w = ? AND password_w = ?";  //(IniciarSesion Trabajadores) (Hecho)
		final String sqlInsertClient = "INSERT INTO CLIENTS VALUES (?,?,?)"; //(CrearCliente) (Hecho)
		final String SQLBORRARProducto = "DELETE FROM client WHERE id_c=?"; //BorrarCliente
		final String SQLDeleteProduct = "UPDATE product SET prize =? WHERE id_p =?"; //ModificarProducto 
		
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
				stmt = con.prepareStatement(SQLLoginCliente);
	            stmt.setString(1, client.getclient_name());
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
				stmt = con.prepareStatement(SQLLoginTrabajador);
	            stmt.setString(1, worker.getworker_name());
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
				stmt = con.prepareStatement(sqlInsertClient);
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
		
		public boolean insertClient(Client client) {
			// TODO Auto-generated method stub
			boolean ok=false;
			if (!checkClient2(client))
			{
				this.openConnection();
				try {
					// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
	
					stmt = con.prepareStatement(sqlInsertClient);
					stmt.setString(2, client.getclient_name());
					stmt.setString(3, client.getclient_password());
					stmt.setInt(1, client.getclient_id());
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
		
		
		
		public boolean borrarProducto(Product producto) {
			// TODO Auto-generated method stub
			boolean ok=false;
			
				this.openConnection();
				try {
					// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
	
					stmt = con.prepareStatement(SQLDeleteProduct);
					stmt.setString(1, producto.getproduct_id());
					if (stmt.executeUpdate()>0) {
						ok=true;
					}
					
				/*	private String product_name;
					private double price;
					private int stock;
					private Product_Category category;
					private String product_id;
				*/
		            stmt.close();
		            con.close();
				  } catch (SQLException e) {
		             System.out.println("Error al verificar credenciales: " + e.getMessage());
		        }
			
				return ok;			
			
		}

}

	
		
	


