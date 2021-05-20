package tarea2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLAccess {
	
    /*
     * Almacenamos la conexión con nuestra bd en 
     * un objeto de tipo Connection. La abrimos cuando
     * queremos empezar a operar con la BD y siempre
     * debemos cerrarla al finalizar.
     */
    private static Connection connect = null;
    private Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static String host;
    
    /*
     * Almacena el resultado de las consultas en un dato de 
     * tipo ResultSet, que tiene sus propios métodos para trabajar
     * con las tablas y columnas.
     */
    private ResultSet resultSet = null;

    /*
     * Almacenamos los datos de conexi�n con nuestra BD.
     */
    final private static String user = "root";
    final private static String passwd = "12345678";
    
    /**
     * Establece el nombre de la base de datos para conectar
     * @param database 
     */
    public void setDatabase(String database) {   
        this.host = "localhost:3306/"+database;
    }
    
    public static Connection dbConnect() throws Exception {
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este �nicamente es para 
             * las BD MySQL.
             */
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            return DriverManager.getConnection("jdbc:mysql://" + host + "?"
                    		+ "user=" + user + "&password=" + passwd );
            
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }
    
    
    public static void insertAlumno(int idAlumno, String nombre, String apellidos,  String DNI, int edad) throws Exception {
        try {
            connect = dbConnect();
            
            preparedStatement = connect
                .prepareStatement("insert into alumnos(ID_alumno,Nombre,Apellidos,DNI,Edad) "
                        + "values (?,?,?,?,?)" );
            
            preparedStatement.setInt(1, idAlumno);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellidos);
            preparedStatement.setString(4, DNI);
            preparedStatement.setInt(5, edad);
            preparedStatement.executeUpdate();
        } catch(Exception e){
            throw e;
        } finally {
            //close();
        }
    }
    
    public static void insertNota(int id_nota, int id_alumno, String nombreAsignatura, double nota) throws Exception {
        try {
            connect = dbConnect();
            
            preparedStatement = connect
                .prepareStatement("insert into notas(ID_notas,ID_alumno,Nombre_asignatura,Nota) "
                        + "values (?,?,?,?)" );
            
            preparedStatement.setInt(1, id_nota);
            preparedStatement.setInt(2, id_alumno);
            preparedStatement.setString(3, nombreAsignatura);
            preparedStatement.setDouble(4, nota);
            preparedStatement.executeUpdate();
        } catch(Exception e){
            throw e;
        } finally {
            //close();
        }
    }
   
    public ResultSet readTable(String table) throws Exception {
        try {
            connect = dbConnect();
            
            /*
             * Creamos statement para que la BD nos permita realizar
             * consultas
             */
            statement = connect.createStatement();
            /*
             * Almacenamos en resultTest el resultado de ejecutar la consulta
             * select.
             */
            resultSet = statement
                .executeQuery("select * from "+table);
            
            //System.out.println("QUERY ---> select * from usuarios");
            return resultSet;
            
        } catch (Exception e) {
        	throw e;
        } 
    }

    /**
     * Pre: ---
     * Post: cerramos todas las conexiones abiertas, el resultSet
     * 		y el statement. Si no se cierran correctamente, puede
     * 		ocurrir que las consultas no devuelvan el resultado esperado.
     * 		Además, si dejamos muchas conexiones a la BD abiertas
     * 		podemos llegar a saturarla y no aceptará más conexiones. 
     */
    private void close() {
        try {
            if (resultSet != null) {
                    resultSet.close();
            } if (statement != null) {
                    statement.close();
            } if (connect != null) {
                    connect.close();
            }
        } catch (Exception e) {}
    }

}