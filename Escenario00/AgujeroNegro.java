import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AgujeroNegro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AgujeroNegro extends ActorBase implements Observer
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

    @Override
    public void accion() {


        Actor[] actor = new Actor[8];
        actor[0]=getOneObjectAtOffset(0, -1, Actor.class);
        actor[1]=getOneObjectAtOffset(0, 1, Actor.class);
        actor[2]=getOneObjectAtOffset(-1, -1, Actor.class);
        actor[3]=getOneObjectAtOffset(-1, 0, Actor.class);
        actor[4]=getOneObjectAtOffset(-1, 1, Actor.class);
        actor[5]=getOneObjectAtOffset(1, -1, Actor.class);
        actor[6]=getOneObjectAtOffset(1, 0, Actor.class);
        actor[7]=getOneObjectAtOffset(1, 1, Actor.class);

        NaveRecolectoraOro[] objetivos = new NaveRecolectoraOro[8];

        for(int i=0; i<actor.length; i++){
            if(!(actor[i] instanceof NaveRecolectoraOro)){
                actor[i] = null;
            }
            objetivos[i] = (NaveRecolectoraOro) actor[i];

        }

        /*int contador=0;
        for(Dañable objetivo:objetivos){
        if (objetivo != null){
        contador ++;
        }
        }
         */

        //Greenfoot.playSound("NaveOroHab.wav");
        for(int i=0; i<objetivos.length; i++){
            if (objetivos[i] != null){
                objetivos[i].setLocation(this.getX(),this.getY());
                objetivos[i].consumirCombustible(50);
            }
        }

    }
}
