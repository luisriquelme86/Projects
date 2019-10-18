public class ArranqueInterfaz {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Canario canario = new Canario();
        hacerCantar(persona);
        hacerCantar(canario);
    }

    public static void hacerCantar(Cantante c) {
        c.cantar();
    }
}
