package database;

public class PruebaConexion {

    public static void main(String[] args) {

        Conexión con = new Conexión();
        con.conectar();

        if (con.cadena != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("Desconectado");
        }
    }
}
