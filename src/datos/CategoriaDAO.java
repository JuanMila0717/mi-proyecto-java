package datos;

import database.Conexión;
import database.Conexión;
import entidades.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements DAO<Categoria> {

    @Override
    public boolean insertar(Categoria c) {
        String sql = "INSERT INTO categoria(nombre, descripcion) VALUES (?, ?)";

        try {
            Conexión con = new Conexión();
            Connection cn = con.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());

            ps.executeUpdate();
            con.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try {
            Conexión con = new Conexión();
            Connection cn = con.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setDescripcion(rs.getString("descripcion"));

                lista.add(c);
            }

            con.desconectar();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    @Override
    public Categoria buscarPorId(int id) {
        String sql = "SELECT * FROM categoria WHERE id=?";
        Categoria c = null;

        try {
            Conexión con = new Conexión();
            Connection cn = con.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setDescripcion(rs.getString("descripcion"));
            }

            con.desconectar();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

    @Override
    public boolean actualizar(Categoria c) {
        String sql = "UPDATE categoria SET nombre=?, descripcion=? WHERE id=?";

        try {
            Conexión con = new Conexión();
            Connection cn = con.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
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
        String sql = "DELETE FROM categoria WHERE id=?";

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