import greenfoot.*;

public class Mundo00 extends MundoBase {

    public Mundo00() {
        super(12, 10, 80);
    }

    protected void generarNaves() {
        agregar(new NaveRecolectoraOro(), 10, 8);
        //agregar(new NaveDeAtaque(), 2, 1);
        //agregar(new NaveRecolectora(), 3, 2);

        //agregar(new NaveExploradoraEnemiga(Direccion.NORTE), 4, 0);
        //agregar(new NaveDeAtaqueEnemiga(Direccion.NORTE), 5, 1);

        agregar(new PilotoORO(), 9,8); 
    }

    /**
     * Color creado con RGB, ultimo valor da la opacidad   
     */
    protected void generarPOIs() {
        marcarCelda(10, 8, new Color(0, 0, 200, 150));
        marcarCelda(1, 1, new Color(0 ,255 , 0, 150));
    }

    protected void generarItems() {
        //agregar(new Item(), 0, 1);
    }

    protected void generarAsteroides() {
        //agregar(new Asteroide(), 0, 2);
        agregar(new MineralDeOro(), 10, 1);
        agregar(new MineralDeOro(), 1, 8);
    }
}
