package net.redeszone;
import java.util.Calendar;
import java.util.LinkedList;

public class Acceso {

    private LinkedList<Cliente> colaEspera = new LinkedList<Cliente>();
    private LinkedList<Cliente> colaAtentidos = new LinkedList<Cliente>();
    public long sumador = 123456;

    public void añadir(Cliente cliente) {
        cliente.setFechaLlegada(Calendar.getInstance().getTimeInMillis() + sumador);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(cliente.getFechaLlegada());
        System.out.print("El cliente " + cliente.getNombre() + " de movil " + cliente.getNumeroMovil() + " tiene fecha de llegada " + cal.getTime() + " y se añadio a la cola \n");
        // System.out.print("cliente.getFechaLlegada() " + cliente.getFechaLlegada() + "\n");
        colaEspera.add(cliente);
        sumador += 123456;
    }

    public void atender() {
        Cliente cliente = colaEspera.getFirst();
        cliente.setFechaAtencion(Calendar.getInstance().getTimeInMillis() + sumador);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(cliente.getFechaAtencion());
        System.out.print("El cliente " + cliente.getNombre() + " se atendio en la fecha " + cal.getTime() + " y se removio de la cola \n");
        // System.out.print("cliente.getFechaAtencion() " + cliente.getFechaAtencion() + "\n");
        colaEspera.remove();
        colaAtentidos.add(cliente);
        sumador += sumador;
    }

    public double getTiempoMedioEspera() {
        long tiempoEspera = 0;
        for (Cliente cliente: colaEspera) {
            tiempoEspera += cliente.getFechaLlegada() - Calendar.getInstance().getTimeInMillis();
        }
        return ((tiempoEspera / colaEspera.size()) / 1000) / 60;
    }

    public double getTiempoMedioAtentidos() {
        long tiempoEspera = 0;
        for (Cliente cliente: colaAtentidos) {
            tiempoEspera += cliente.getFechaAtencion() - cliente.getFechaLlegada();
        }
        return ((tiempoEspera / colaAtentidos.size()) / 1000) / 60;
    }
}
