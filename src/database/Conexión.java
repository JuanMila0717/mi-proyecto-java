package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexión {

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String db = "db_sistema";
    private final String user = "root";
    private final String password = "";

    public Connection cadena;

    public Conexión() {
        this.cadena = null;
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            cadena = DriverManager.getConnection(url + db, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return cadena;
    }

    public void desconectar() {
        try {
            if (cadena != null) {
                cadena.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
