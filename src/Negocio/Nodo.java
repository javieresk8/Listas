package Negocio;

public class Nodo {
    int numero;
    Nodo enlace;
    
    //Constructores de los dos casos
    public Nodo(int obj){
        this.numero = obj;
        this.enlace = null;
    }
    
    public Nodo(int obj, Nodo enlace){
        this.numero=obj;
        this.enlace= enlace;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    
}
