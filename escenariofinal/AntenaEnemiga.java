import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AntenaEnemiga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AntenaEnemiga extends NaveEnemiga implements Observer
{
    public AntenaEnemiga() {
        super(Direccion.ESTE);
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
            if (objetivos[i] != null && objetivos[i].tengoOro()){
                int tamCelda = getWorld().getCellSize();
                objetivos[i].imagenBase = new GreenfootImage("NaveRecolectoraOROfase1ON.png");
                objetivos[i].imagenBase.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
                objetivos[i].actualizarImagen();
                objetivos[i].perderOro();
            }
        }

    }
}
