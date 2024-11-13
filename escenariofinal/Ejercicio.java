
public class Ejercicio  
{
    public static void primerPaso(PilotoORO piloto, NaveRecolectoraOro nave){
        piloto.subirse(nave);
        nave.encenderMotores();
        nave.avanzarHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.NORTE);
    }

    public static void segundoPaso(PilotoORO piloto, NaveRecolectoraOro nave){
        nave.propulsionHacia(Direccion.NORTE);       
    }

    public static void tercerPaso(PilotoORO piloto, NaveRecolectoraOro nave){
        nave.recolectarDesde(Direccion.NORTE);
        nave.ataqueEspecial();
    }

    public static void cuartoPaso(PilotoORO piloto, NaveRecolectoraOro nave){
        nave.avanzarHacia(Direccion.OESTE);
        nave.avanzarHacia(Direccion.OESTE);
        nave.recolectarDesde(Direccion.NORTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
    }

    public static void quintoPaso(PilotoORO piloto, NaveRecolectoraOro nave){
        nave.avanzarHacia(Direccion.SUR);
        nave.propulsionHacia(Direccion.SUR);
    }

    public static void sextoPaso(PilotoORO piloto, NaveRecolectoraOro nave){
        nave.recolectarDesde(Direccion.OESTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.NORTE);
        nave.propulsionHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.NORTE);
        nave.descargarHacia(Direccion.ESTE);
    }
}
