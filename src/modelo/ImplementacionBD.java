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
		
		
		final String SQL = "SELECT * FROM clients WHERE name_c = ? AND password_c = ?";		//Iniciar Sesión
		final String sql1 = "SELECT * FROM workers WHERE name_w = ? AND password_w = ?"; //COMPROBARUSUARIO
		final String sqlInsert = "INSERT INTO usuario VALUES (?,?)"; //INSERTARUSUARIO
		final String SQLCONSULTA = "SELECT * FROM clients"; //VISUALIZAR
		final String SQLBORRAR = "DELETE FROM usuario WHERE nombre=?"; //BORRAR USUARIO
		final String SQLMODIFICAR = "UPDATE usuario SET contrasena=? WHERE nombre=?"; //MODIFICAR
		
		// Para la conexi n utilizamos un fichero de configuaraci n, config que
		// guardamos en el paquete control:
		public ImplementacionBD() {
			this.configFile = ResourceBundle.getBundle("modelo.configClase");
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
		
		/* public boolean insertarUsuario(Usuario usuario) {
			// TODO Auto-generated method stub
			boolean ok=false;
			if (!comprobarUsuario1(usuario))
			{
				this.openConnection();
				try {
					// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
	
					stmt = con.prepareStatement(sqlInsert);
					stmt.setString(1, usuario.getNombre());
					stmt.setString(2, usuario.getContrasena());
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
			
			
		} */
		public boolean actualizarUsuario(Usuario usuario) {
			// TODO Auto-generated method stub
			boolean ok=false;
			
				this.openConnection();
				try {
					// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
	
					stmt = con.prepareStatement(SQLMODIFICAR);
					stmt.setString(2, usuario.getNombre());
					stmt.setString(1, usuario.getContrasena());
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
		
		public Map<String, Usuario> consultaUsuarios() { //visualizar
			// TODO Auto-generated method stub
			
			ResultSet rs = null;
			Usuario usuario;
			Map<String, Usuario> equipos = new TreeMap<>();

			// Abrimos la conexi n
			this.openConnection();

			try {
				stmt = con.prepareStatement(SQLCONSULTA);

				rs = stmt.executeQuery();

				// Leemos de uno en uno
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setNombre(rs.getString("nombre"));
					usuario.setContrasena(rs.getString("contrasena"));
					equipos.put(usuario.getNombre(), usuario);
				}
				rs.close();
	            stmt.close();
	            con.close();
			} catch (SQLException e) {
				System.out.println("Error de SQL");
				e.printStackTrace();
			}
			return equipos;

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

	
		
	


