package net.redeszone;

public class Prueba {

    public static void main(String[] args) {
        Acceso acceso = new Acceso();
        acceso.añadir(new Cliente("Luis", 1245));
        acceso.añadir(new Cliente("Pedro", 2222));
        acceso.añadir(new Cliente("Juan", 3456));
        acceso.añadir(new Cliente("Diego", 9987));
        acceso.añadir(new Cliente("Maria", 1111));
        acceso.añadir(new Cliente("Eva", 2342));
        acceso.añadir(new Cliente("Carlos", 9874));
        System.out.print("tiempo medio de espera " + acceso.getTiempoMedioEspera() + " segundos \n");

        acceso.atender();
        acceso.atender();
        acceso.atender();
        acceso.atender();
        acceso.atender();
        acceso.atender();
        acceso.atender();
        System.out.print("tiempo medio atendidos " + acceso.getTiempoMedioAtentidos() + " segundos \n");

        /*
            Escribir una clase para controlar el acceso de clientes a un servicio.

            Se guardará una cola de espera de clientes y otra cola de clientes ya atendidos.
                Cada cliente tiene un nombre, un número de móvil.
                Junto al cliente se guarda su fecha y hora de llegada, y su fecha y hora de atención.

            Operaciones
                añadir un cliente
                atender a un cliente
                obtener el tiempo medio de espera de los clientes que aún no han sido atendidos
                obtener el tiempo medio de espera de los clientes ya atendidos
                mostrar el estado de las colas
        */
    }
}
