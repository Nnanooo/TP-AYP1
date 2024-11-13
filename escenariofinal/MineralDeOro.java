import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MineralDeOro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MineralDeOro extends Asteroide{

    protected final int tamañoInicial = 100;
    
    /**
     * Inicializa un AsteroiodeDeMineral con tamaño aleatorio entre 251 y 500 puntos
     */
    public MineralDeOro() {
        this.tamaño = this.tamañoInicial;
    }

    /**
     * post: Se reducirá el tamaño del AsteroideDeMineral conforme la cantidad
     * solicitada, siguiendo las reglas de existencia y limitaciones del turno
     * 
     * @param cantidad es la cantidad de mineral a entregar
     * @return la cantidad que pudo ser extraida, limitada por las existencias y por
     *         {@link #EXTRACCION_MAXIMA}
     */
    public void entregarMineralORO() {
        this.tamaño = 0;

        actualizarImagen();
        Explosion.en(getWorld(), this.getX(), this.getY());
        if (this.tamaño <= 0) {
            getWorld().removeObject(this);
        }
    }

    /**
     * {@link AsteroideDeMineral#tamañoInicial}
     * 
     * @return el tamaño inicial del AsteroideDeMineral
     */
    protected int obtenerTamañoMaximo() {
        return this.tamañoInicial;
    }
    
}
