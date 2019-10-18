package com.arquitecturajava.ejemplo1;

// aca arranque. Con esta interfaz. La idea es moldear un telefono con las opciones de prender y apagar y que valide
// el telefono pertenece a una persona

// por default son abstractas y publicas
/* public interface Validar {
    void encender();
    void apagar();
    boolean validarCodigo(int numero);
    boolean validarPatron(String patron);
    boolean validarHuella(String patronHuella);
    boolean validarRostro(String patronRostro);

    // notar que es todo una prueba, no paso huella y rostro y tampoco entidades asi, solamente strings que refieran a eso
} */

// la interfaz de arriba tiene muchas responsabilidades, deberia una de ser activar y otra de validar
/*
public interface Activar {
    void encender();
    void apagar();
} */

/*
public interface Validar {
    boolean validarCodigo(int numero);
    boolean validarPatron(String patron);
    boolean validarHuella(String patronHuella);
    boolean validarRostro(String patronRostro);
}*/

// esta interfaz de validar aun esta mal, bien porque solo cumple una responsabilidad. Mal porque es dificil de extender, el que la
// implemente esta obligado a definir muchos metodos inncesarios, por ejemplo, un android comun solo tendria el patron a validar y los demas
// deberian estar vacios o lanzar una excpecion. O Me creo mas interfaces o veo la forma de otro pensamiento. En realidad
// el telefono valida la persona introduciendo la informacion, asi que

public interface Validar {
    public boolean validar(Persona persona);
}

