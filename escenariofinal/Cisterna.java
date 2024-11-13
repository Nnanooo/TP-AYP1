import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cisterna extends ActorBase
{

    private boolean estaLlena = false;

    public void recibirOroDesde(NaveRecolectoraOro nave) {
        if (!estaLlena && nave.tengoOro()) {
            estaLlena = true;
            imagenBase = new GreenfootImage("CISTERNA-LLENA.png");
            actualizarImagen(); // Llama a actualizarImagen para aplicar la escala y establecer la imagen
        }   
    }

    private double ESCALA_X = 1.15;
    private double ESCALA_Y = 1.15;    
    @Override
    protected void actualizarImagen() {
        if (imagenBase != null) {
            int tamCelda = getWorld().getCellSize();
            imagenBase.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
            setImage(imagenBase);  // Aplica la escala y establece la imagen del objeto
        }
    }
}
