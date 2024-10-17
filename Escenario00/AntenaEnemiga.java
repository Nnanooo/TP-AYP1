import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AntenaEnemiga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AntenaEnemiga extends NaveEnemiga implements Observador
{
    private boolean estadoActual;
    public int columna;
    public int fila;
    
    
    public AntenaEnemiga(int columna, int fila) {
        super(Direccion.ESTE);
        this.columna = columna;
        this.fila = fila;
    }
    
    

    @Override
    public void actualizar(boolean estado) {
        this.estadoActual = estado;
        // Aquí puedes hacer algo cuando el estado cambia
        if (estadoActual) {
            // Realizar alguna acción
        }
    }

    public void act() {
        // Continuamente puede actuar basándose en el estado
    }
}
