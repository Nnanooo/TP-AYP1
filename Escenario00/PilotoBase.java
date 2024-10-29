import greenfoot.*;

/**
 * Define el comportamiento base para todos los Pilotos de la Batalla Espacial
 */
public abstract class PilotoBase extends ActorBase {
    protected double ESCALA_X = 0.8;
    protected double ESCALA_Y = 0.8;

    protected int aura;

    protected static int ultima = 0;

    public PilotoBase() {
        this.aura = ultima++;
    }

    public Color getAura() {
        return MyGreenfootImage.AURAS[this.aura % MyGreenfootImage.AURAS.length];
    }

    GreenfootImage imagenOriginal = new GreenfootImage(getImage());
}
