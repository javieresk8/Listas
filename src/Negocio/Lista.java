package Negocio;
public class Lista {
    public Nodo inicio;
    
    public Lista(){
        this.inicio= null;
        
    }
    
    public boolean estaVacia(){
        return this.inicio == null;
    }
    
    public void removeLast(){
        Nodo puntero,anterior= null;
        puntero = this.inicio;
        
        if(!estaVacia()){
            //El caso en el que solo hay un nodo
            if(puntero.enlace == null){
                this.inicio = null;
            } else {
                
                while(puntero!=null){
                    //Si es nulo el enlace, estamos en el ultimo nodo
                    if(puntero.enlace == null){
                        anterior.enlace=null; //Aqui esta el ultimo nodo, lo borramos
                    }
                    anterior = puntero; //Dejamos un paso atras
                    puntero = puntero.enlace; //Avanzamos
                }
            }
        }
    }
    //La soguiente  funcion toma como parametro el indice y devuelve el valor del nodo
    public int getNodo(int i){
        Nodo puntero;
        int contador = 0;
        puntero= this.inicio;
        if(!estaVacia()){
            while(puntero!=null){
                if(contador == i){
                    return puntero.numero;
                }
                puntero = puntero.enlace;
                contador ++;
            }
        } 
        return -1;
        
    }
    
    public void deleteNodo(int i){
        Nodo puntero, anterior = null;
        puntero = this.inicio;
        int contador = 0;
        if(!estaVacia()){
            while(puntero!=null){
                if(i == 0){
                    //Caso en el que se encuentra el nodo y esta al inicio
                    this.inicio = puntero.enlace;
                    //puntero.enlace = null;
                    break;
                } else if(contador == i ) {
                    //Caso en el que lo encuentra pero esta en el medio o al final
                    anterior.enlace = puntero.enlace;
                    break;
                }
                anterior = puntero;
                puntero=puntero.enlace;
                contador++;
            }
        }
    }
    public void addFinal(int n){
        Nodo puntero,nuevo;
        puntero = this.inicio;
        nuevo = new Nodo(n);
        if(!estaVacia()){
            while(puntero!=null){
                if(puntero.enlace == null){
                    puntero.enlace = nuevo;
                    break;
                }
                puntero=puntero.enlace;
            }
        } else {
            this.inicio = new Nodo(n);
        }
    }
    
    public void insertarOrdenado(int n){
        Nodo nuevo,puntero, anterior = null;
        puntero = this.inicio;
        boolean bandera = false;
        nuevo = new Nodo(n);
        
        if(estaVacia()){
            this.inicio = nuevo;
        }else{
            while(puntero!=null){
                if(nuevo.numero <= puntero.numero){
                    bandera = true;
                    //Veamos si estamos al inicio o en el medio
                    if(puntero==inicio){
                        nuevo.enlace = puntero;
                        inicio = nuevo; 
                        break;
                    } else {
                        nuevo.enlace = puntero;
                        anterior.enlace = nuevo;
                        break;
                    }
                } else {
                    anterior = puntero;
                    puntero = puntero.enlace;
                    
                }
                
            }
            if(bandera == false)
                addFinal(n);
                   
        }
    }
    
    public void addAfter(Nodo actual,int n){
        //Vamos a tener que crear un nodo para pasarle como parametro 
        Nodo puntero, aux;
        puntero = this.inicio;
        
        if(!estaVacia()){
            while(puntero!=null){
                if(actual.numero == puntero.numero){
                    //Insertamos el nodo
                    //tenemos dos casos, si esta al final el nodo 
                    if(puntero.enlace == null){
                        puntero.enlace = new Nodo(n);
                        break;
                    } else { // en esta caso estamos en el medio
                        aux = puntero.enlace;
                        puntero.enlace = new Nodo(n,aux);
                        break;
                    }
                }
                puntero = puntero.enlace;
            }
        }
        
    }
    
    public String toString(){
        String salida = "";
        Nodo puntero= this. inicio;
        if(!estaVacia()){
            while(puntero!=null){
                salida+=puntero.numero+" ";
                puntero = puntero.enlace;
                
            }
            
        } else {
            salida = "Esta vacia";
        }
        return salida;
        
    }
    
}
