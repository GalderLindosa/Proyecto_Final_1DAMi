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
		
		final String SQL = "SELECT * FROM clients WHERE name_c = ? AND password_c = ?";		
		final String sql1 = "SELECT * FROM workers WHERE name_w = ? AND password_w = ?"; 

		
		
		
		final String sqlInsert = "INSERT INTO CLIENTS VALUES (?,?,?)";
		final String SQLCONSULTA = "SELECT * FROM usuario";
		final String SQLBORRAR = "DELETE FROM usuario WHERE nombre=?";
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
				stmt = con.prepareStatement(sql1);
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
		
		public boolean insertClient(Client client) {
			// TODO Auto-generated method stub
			boolean ok=false;
			if (!checkClient2(client))
			{
				this.openConnection();
				try {
					// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
	
					stmt = con.prepareStatement(sqlInsert);
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
		
		
		
		public boolean borrarUsuario(String usuario) {
			// TODO Auto-generated method stub
			boolean ok=false;
			
				this.openConnection();
				try {
					// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
	
					stmt = con.prepareStatement(SQLBORRAR);
					stmt.setString(1, usuario);
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

}

	
		
	


