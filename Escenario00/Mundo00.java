import greenfoot.*;

public class Mundo00 extends MundoBase {

    public Mundo00() {
        super(12, 10, 80);
    }

    protected void generarNaves() {
        agregar(new NaveRecolectoraOro(), 1, 8);
        //agregar(new NaveDeAtaque(), 2, 1);
        //agregar(new NaveRecolectora(), 3, 2);

        //agregar(new NaveExploradoraEnemiga(Direccion.NORTE), 4, 0);
        //agregar(new NaveDeAtaqueEnemiga(Direccion.NORTE), 5, 1);

        agregar(new PilotoORO(), 0,8); 
    }

    /**
     * Color creado con RGB, ultimo valor da la opacidad   
     */
    protected void generarPOIs() {
        marcarCelda(1, 8, new Color(0, 0, 200, 150));
        marcarCelda(10, 8, new Color(0 ,255 , 0, 150));
    }

    protected void generarItems() {
        agregar(new Item(), 0, 0);
    }

    protected void generarAsteroides() {
        agregar(new Asteroide(), 3, 1);
        agregar(new Asteroide(), 3, 2);
        agregar(new Asteroide(), 3, 0);
        agregar(new Asteroide(), 4, 2);
        agregar(new Asteroide(), 4, 3);
        agregar(new Asteroide(), 2, 2);
        agregar(new Asteroide(), 5, 3);
        agregar(new Asteroide(), 6, 3);
        
        agregar(new MineralDeOro(), 2, 1);
        agregar(new MineralDeOro(), 5, 2);
        agregar(new MineralDeOro(), 11, 3);
    }
}
