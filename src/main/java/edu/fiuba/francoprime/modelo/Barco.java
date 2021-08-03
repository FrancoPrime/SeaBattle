package edu.fiuba.francoprime.modelo;

public class Barco {

    private int espaciosSinTocar;

    public Barco(int espacio){
        this.espaciosSinTocar = espacio;
    }

    public void tocar(){
        if(this.espaciosSinTocar == 0)
            throw new BarcoYaDestuidoException();
        this.espaciosSinTocar--;
    }

    public boolean estaDestruido(){
        return (this.espaciosSinTocar == 0);
    }

    public int tamanio(){
        return this.espaciosSinTocar;
    }
}
