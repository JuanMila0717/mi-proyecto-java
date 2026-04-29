package datos;

import java.util.List;

public interface CrudInterface<T> {
    public boolean insertar(T obj);
    public boolean actualizar(T obj);
    public boolean eliminar(int id);
    public List<T> listar(String texto);
    public T buscarPorId(int id);
}
