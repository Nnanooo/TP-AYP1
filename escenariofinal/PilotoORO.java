import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class PilotoORO extends PilotoBase implements PilotoRecolector{
    
    private NaveRecolectoraOro navePilotada;
    
    @Override
    public void subirse(NaveRecolectoraOro nave) {
        if (navePilotada != null) {
            bajarse();
        }
        navePilotada = nave;        
        navePilotada.recibirPiloto(this);
        actualizarImagen();
    }
    
    @Override
    public void bajarse() {
        navePilotada.bajarPiloto();
        navePilotada = null;
        actualizarImagen();
    }
    
    @Override
    public void actualizarImagen() {
        int tamCelda = getWorld().getCellSize();

        MyGreenfootImage nuevaImagen;
        if (navePilotada != null) {
            nuevaImagen = new MyGreenfootImage(getImage()) {
                public void configurar() {
                    setTransparency(150);
                }
            };
        } else {
            nuevaImagen = new MyGreenfootImage(imagenOriginal) {
                public void configurar() {
                    highlight(getAura());
                }
            };
        }
        nuevaImagen.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(nuevaImagen);
    }
}
