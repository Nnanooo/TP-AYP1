import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AgujeroNegro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AgujeroNegro extends ActorBase
{
    private double ESCALA_X = 1.75;
    private double ESCALA_Y = 1.15;
    
    /**
     * Establece la imagen con la escala definida
     */
    @Override
    protected void actualizarImagen() {
        int tamCelda = getWorld().getCellSize();
        GreenfootImage image = getImage();
        image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(image);
    }
}
