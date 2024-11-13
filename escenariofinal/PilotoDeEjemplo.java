public class PilotoDeEjemplo extends PilotoBase implements PilotoAtacante{    
    
    private NaveDeAtaque navePilotada;
    
    @Override
    public void subirse(NaveDeAtaque nave) {
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
    
    

    void despegar() {
        navePilotada.encenderMotores();
    }

    void avanzarAlNortePor(int casilleros) {
        for (int pasos = 0; pasos < casilleros; pasos++) {
            navePilotada.avanzarHacia(Direccion.NORTE);
        }
    }

    int destruirAsteroideHacia(Direccion direccion) {
        int ataques = 0;
        while (navePilotada.hayAsteroideHacia(direccion)) {
            navePilotada.atacarHacia(direccion);
            ataques++;
        }
        return ataques;
    }

    void llegarALaBaseNorte() {
        avanzarAlNortePor(5);
        destruirAsteroideHacia(Direccion.NORTE);
        avanzarAlNortePor(3);
    }
}
