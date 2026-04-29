package datos;

import database.Conexión;
import database.Conexión;
import entidades.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente> {

    @Override
    public boolean insertar(Cliente c) {
        String sql = "INSERT INTO cliente(nombre, correo) VALUES (?, ?)";

        try {
            Conexión con = new Conexión();
            Connection cn = con.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCorreo());

            ps.executeUpdate();
            con.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try {
            Conexión con = new Conexión();
            Connection cn = con.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setCorreo(rs.getString("correo"));

                lista.add(c);
            }

            con.desconectar();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    @Override
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id=?";
        Cliente c = null;

        try {
            Conexión con = new Conexión();
            Connection cn = con.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setCorreo(rs.getString("correo"));
            }

            con.desconectar();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

    @Override
    public boolean actualizar(Cliente c) {
        String sql = "UPDATE cliente SET nombre=?, correo=? WHERE id=?";

        try {
            Conexión con = new Conexión();
            Connection cn = con.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCorreo());
            ps.setInt(3, c.getId());

            ps.executeUpdate();
            con.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM cliente WHERE id=?";

        try {
            Conexión con = new Conexión();
            Connection cn = con.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            con.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
    
    
    
  
    
