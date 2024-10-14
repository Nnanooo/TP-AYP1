import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PilotoORO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PilotoORO extends PilotoBase{
    @Override
    public void subirse(NaveDeAtaque nave) {
        super.subirse(nave);
    }
    
    @Override
    public void bajarse() {
        super.bajarse();
    }

    void despegar() {
        navePilotada.encenderMotores();
    }
}
