package datos;

import java.util.List;

public interface DAO<T> {

    boolean insertar(T obj);
    boolean actualizar(T obj);
    boolean eliminar(int id);
    List<T> listar();
    T buscarPorId(int id);
}