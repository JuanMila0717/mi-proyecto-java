package database;

import datos.CategoriaDAO;
import entidades.Categoria;

public class PruebaCategoria {

    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();

        // 1. Probar insertar con el nuevo campo
        Categoria nueva = new Categoria();
        nueva.setNombre("Electrónica");
        nueva.setDescripcion("Dispositivos móviles y accesorios"); // Nuevo campo
        
        if (dao.insertar(nueva)) {
            System.out.println("Insertado correctamente");
        } else {
            System.out.println("No se pudo insertar");
        }

        // 2. Probar listar incluyendo la descripción
        System.out.println("--- LISTA DE CATEGORÍAS ---");
        for (Categoria c : dao.listar()) {
            System.out.println("ID: " + c.getId() 
                             + " | Nombre: " + c.getNombre() 
                             + " | Descripción: " + c.getDescripcion()); // Nuevo campo
        }
    }
}


