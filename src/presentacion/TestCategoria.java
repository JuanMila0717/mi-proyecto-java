package presentacion;

import datos.CategoriaDAO;
import entidades.Categoria;

public class TestCategoria {

    public static void main(String[] args) {

        CategoriaDAO dao = new CategoriaDAO();

        dao.insertar(new Categoria(0, "Bebidas", "Productos líquidos"));

        for (Categoria c : dao.listar()) {
            System.out.println(c.getId() + " - " + c.getNombre() + " - " + c.getDescripcion());
        }

        Categoria cat = dao.buscarPorId(1);
        if (cat != null) {
            System.out.println("Encontrado: " + cat.getNombre());
        }

        if (cat != null) {
            cat.setNombre("Bebidas Editadas");
            cat.setDescripcion("Nueva descripción");
            dao.actualizar(cat);
        }

        dao.eliminar(1);
    }
}
