import greenfoot.*;
import java.util.List;

public class Mundo01 extends MundoBase {

    public Mundo01() {
        super(8, 8, 70);
    }

    protected void generarNaves() {
        agregar(new NaveRecolectoraOro(), 1, 8);
        agregar(new PilotoORO(), 0,8);
    }

    /**
     * Color creado con RGB, ultimo valor da la opacidad   
     */
    protected void generarPOIs() {
        marcarCelda(1, 7, new Color(0, 0, 200, 150));
        //marcarCelda(10, 8, new Color(0 ,255 , 0, 150));
    }

    protected void generarItems() {
        agregar(new Item(), 2, 2);
        agregar(new Item(), 6, 2);
        agregar(new Item(), 7, 5);
    }

    protected void generarCisterna(){
        agregar(new Cisterna(),7,0);
    }

    protected void generarAgujerosNegros(){
        agregar(new AgujeroNegro(),2,4);
        agregar(new AgujeroNegro(),6,4);
    }

    protected void generarAntenasEnemigas(){
        agregar(new AntenaEnemiga(),4,1);
    }

    protected void agregarObservadores() {
        // Obtener todas las naves recolectoras de oro en el mundo
        List<NaveRecolectoraOro> naves = getObjects(NaveRecolectoraOro.class);

        // Obtener todos los agujeros negros en el mundo
        List<AgujeroNegro> agujerosNegros = getObjects(AgujeroNegro.class);

        // Obtener todas las antenas enemigas en el mundo
        List<AntenaEnemiga> antenasEnemigas = getObjects(AntenaEnemiga.class);

        // Iterar sobre cada nave recolectora de oro
        for (NaveRecolectoraOro nave : naves) {
            // Iterar sobre cada agujero negro y agregarlo como observer a la nave
            for (AgujeroNegro agujeroNegro : agujerosNegros) {
                nave.agregarObserver(agujeroNegro);
            }
            for (AntenaEnemiga antenaEnemiga : antenasEnemigas) {
                nave.agregarObserver(antenaEnemiga);
            }
        }
    }

    protected void generarAsteroides() {
        agregar(new Asteroide(), 3, 0);
        agregar(new Asteroide(), 3, 1);
        agregar(new Asteroide(), 3, 2);
        agregar(new Asteroide(), 3, 4);
        agregar(new Asteroide(), 3, 5);
        agregar(new Asteroide(), 3, 7);
        agregar(new Asteroide(), 4, 3);
        agregar(new Asteroide(), 4, 4);
        agregar(new Asteroide(), 4, 5);
        agregar(new Asteroide(), 4, 6);
        agregar(new Asteroide(), 4, 7);
        agregar(new Asteroide(), 0, 4);

        agregar(new MineralDeOro(), 0, 1);
        agregar(new MineralDeOro(), 2, 1);
        agregar(new MineralDeOro(), 5, 6);
    }
}
