package presentacion;

import datos.ClienteDAO;
import entidades.Cliente;

public class TestCliente {

    public static void main(String[] args) {

        ClienteDAO dao = new ClienteDAO();

        dao.insertar(new Cliente(0, "Juan", "juan@gmail.com"));

        for (Cliente c : dao.listar()) {
            System.out.println(c.getId() + " - " + c.getNombre() + " - " + c.getCorreo());
        }

        Cliente cliente = dao.buscarPorId(1);
        if (cliente != null) {
            System.out.println("Encontrado: " + cliente.getNombre());
        }

        if (cliente != null) {
            cliente.setNombre("Juan Actualizado");
            dao.actualizar(cliente);
        }

        dao.eliminar(1);
    }
}
