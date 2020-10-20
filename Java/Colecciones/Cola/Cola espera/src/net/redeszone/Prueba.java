package net.redeszone;


public class Prueba {

    public static void main(String[] args) {

        Acceso acceso = new Acceso();
        // cliente -> Nombre, numero movil
        // añadimos clientes a la cola de espera por el orden de llegada, nos registramos con nombre y numero de telefono
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
    }    
}
