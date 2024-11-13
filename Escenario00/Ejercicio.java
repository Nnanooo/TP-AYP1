
public class Ejercicio  
{
    public static void llegarAgujeroNegro(PilotoORO piloto, NaveRecolectoraOro nave){
        piloto.subirse(nave);
        nave.encenderMotores();
        nave.avanzarHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
    }
    
    public static void RecolectarOroYPerderloPorAntena(PilotoORO piloto, NaveRecolectoraOro nave){
        piloto.subirse(nave);
        nave.encenderMotores();
        nave.avanzarHacia(Direccion.NORTE);
        nave.recolectarDesde(Direccion.NORTE);
        nave.avanzarHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.NORTE);
        nave.ataqueEspecial();
    }
    
    public static void RecolectarOroYAtacar(PilotoORO piloto, NaveRecolectoraOro nave){
        piloto.subirse(nave);
        nave.encenderMotores();
        nave.avanzarHacia(Direccion.NORTE);
        nave.recolectarDesde(Direccion.NORTE);
        nave.avanzarHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.ESTE);
        nave.avanzarHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.NORTE);
        nave.ataqueEspecial();
    }
    
    
}
