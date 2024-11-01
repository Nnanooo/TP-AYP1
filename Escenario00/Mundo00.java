import greenfoot.*;
import java.util.List;

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
        agregar(new AntenaEnemiga(),0,2);

        agregar(new PilotoORO(), 0,8);
    }

    /**
     * Color creado con RGB, ultimo valor da la opacidad   
     */
    protected void generarPOIs() {
        marcarCelda(1, 8, new Color(0, 0, 200, 150));
        //marcarCelda(10, 8, new Color(0 ,255 , 0, 150));
    }

    protected void generarItems() {
        agregar(new Item(), 0, 0);
    }

    protected void generarCisterna(){
        agregar(new CisternaVacia(),9,8);
    }

    protected void generarAgujeroNegro(){
        agregar(new AgujeroNegro(),8,6);
        agregar(new AgujeroNegro(),8,3);
        agregar(new AgujeroNegro(),3,3);
        //agregarObservadoresAGuerras();
    }

    protected void agregarObservadores() {
        // Obtener todas las naves recolectoras de oro en el mundo
        List<NaveRecolectoraOro> naves = getObjects(NaveRecolectoraOro.class);

        // Obtener todos los agujeros negros en el mundo
        List<AgujeroNegro> agujerosNegros = getObjects(AgujeroNegro.class);

        // Iterar sobre cada nave recolectora de oro
        for (NaveRecolectoraOro nave : naves) {
            // Iterar sobre cada agujero negro y agregarlo como observer a la nave
            for (AgujeroNegro agujeroNegro : agujerosNegros) {
                nave.agregarObserver(agujeroNegro);
            }
        }
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
