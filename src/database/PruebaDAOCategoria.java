package database;

import datos.CategoriaDAO;
import entidades.Categoria;

public class PruebaDAOCategoria {
    public static void main(String[] args) {
        CategoriaDAO datos = new CategoriaDAO();

        Categoria nueva = new Categoria();
        nueva.setNombre("Lácteos");
        
        if (datos.insertar(nueva)) {
            System.out.println("EXITO: Categoría insertada.");
        } else {
            System.out.println("ERROR: No se pudo insertar.");
        }

        System.out.println("Lista de categorías en la DB:");
        for (Categoria item : datos.listar()) {
            System.out.println("ID: " + item.getId() + " | Nombre: " + item.getNombre());
        }
    }
}

