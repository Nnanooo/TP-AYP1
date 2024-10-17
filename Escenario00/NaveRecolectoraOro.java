import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class NaveRecolectoraOro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NaveRecolectoraOro extends NaveAliada implements Atacante {
    /**
     * Representa el estado de los motores de la {@link NaveDeAtaque}.
     */
    protected boolean motoresEncendidos = false;
    protected PilotoBase piloto;
    private boolean OroEquipado = false;
    private List<AntenaEnemiga> antenasEnemigas = new ArrayList<>();
    private boolean estado = false;
    public int columna;
    public int fila;

    
    /**
     * Inicializa una nueva NaveDeAtaque con los motores apagados
     */
    public NaveRecolectoraOro(int columna, int fila) {
        super();
        this.columna = columna;
        this.fila = fila;
    }
    
    public void agregarAntenaEnemiga(AntenaEnemiga ant) {
        antenasEnemigas.add(ant);
    }

    /*public void eliminarAntenaEnemiga(AntenaEnemiga ant) {
        antenasEnemigas.remove(ant);
    }*/

    public void notificarAntenasEnemigas() {
        for (AntenaEnemiga ant : antenasEnemigas) {
            ant.actualizar(estado);
        }
    }

    public void cambiarEstado(boolean nuevoEstado) {
        this.estado = nuevoEstado;
        notificarAntenasEnemigas();
    }


    
    
    

    /**
     * Inicializa una nueva NaveDeAtaque con los motores apagados. Este constructor
     * es empleado mayormente para la creación de escenarios.
     * 
     * @param direccion es la orientación con la que se creará la NaveDeAtaque
     * @param carga     es la carga de combustible inicial de la NaveDeAtaque
     */
    public NaveRecolectoraOro(Direccion direccion, int carga) {
        super();
        setDireccion(direccion);
        this.combustible = carga;
    }

    /**
     * pre: posee combustible {@link NaveAliada#combustible} y los motores se
     * encuentran apagados {@link NaveDeAtaque#motoresEncendidos} <br/>
     * post: encenderá sus motores
     */
    public void encenderMotores() {
        if (this.combustible > 0 && !this.motoresEncendidos && this.piloto != null) {
            this.motoresEncendidos = true;
            Greenfoot.playSound("engine-on.wav");
            int tamCelda = getWorld().getCellSize();
            imagenBase = new GreenfootImage("NaveRecolectoraOROfase1ON.png");
            imagenBase.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
            actualizarImagen();
        }
    }

    /**
     * pre: la nave debe tener {@link NaveAliada#combustible} disponible para operar
     * el sistema de recolección <br>
     * post: el {@link NaveAliada#combustible} se incrementará en la mayor cantidad
     * que pueda extraer <br>
     * post: consumirá {@link #obtenerConsumoPorMovimiento()} al realizar la
     * extracción
     * 
     * @param direccion es la dirección desde la cual intentará recolectar
     * @param cantidad  es la cantidad a recolectar. Se limitará automáticamente
     *                  según el orígen de recolección y la capacidad total de carga
     */
    public void recolectarDesde(Direccion direccion) {
        if (this.combustible <= 0) {
            return;
        }

        setDireccion(direccion);
        actualizarImagen();
        Greenfoot.delay(20);
        consumirCombustible(obtenerConsumoPorMovimiento());

        Actor actor = getOneObjectAtOffset(this.direccion.dx, this.direccion.dy, Actor.class);
        if (!(actor instanceof MineralDeOro)) {
            return;
        }

        MineralDeOro objetivo = (MineralDeOro) actor;
        if (objetivo != null && OroEquipado == false) {
            objetivo.entregarMineralORO();
            int tamCelda = getWorld().getCellSize();
            imagenBase = new GreenfootImage("NaveRecolectoraOROfase2ON.png");
            imagenBase.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
            actualizarImagen();
            OroEquipado = true;
        }
    }

    /**
     * pre: los motores se encuentran encendidos
     * {@link NaveDeAtaque#motoresEncendidos} <br/>
     * post: apagará sus motores
     */
    public void apagarMotores() {
        if (this.motoresEncendidos) {
            this.motoresEncendidos = false;
            Greenfoot.playSound("engine-off.wav");
            int tamCelda = getWorld().getCellSize();
            imagenBase = new GreenfootImage("NaveRecolectoraOROfase1-OFF.png");
            imagenBase.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
            actualizarImagen();
        }
    }

    /**
     * {@inheritDoc}
     */
    protected boolean puedeActuar() {
        return super.puedeActuar() && this.motoresEncendidos;
    }

    /**
     * {@inheritDoc} <br>
     * post: si se agota el {@link NaveAliada#combustible}, se apagarán los motores
     */
    protected void consumirCombustible(int cantidad) {
        super.consumirCombustible(cantidad);
        if (combustible <= 0) {
            this.apagarMotores();
        }
    }

    /**
     * pre: La NaveDeAtaque {@link #puedeActuar()} <br>
     * post: El {@link NaveAliada#combustible} se reducirá en
     * {@link #obtenerConsumoPorAtaque()}. Si en la dirección deseada hay un
     * {@link Dañable}, éste recibirá {@link #obtenerDaño()}.
     * 
     * @param direccion
     */
    public void ataqueHabilidad(Direccion direccion) {
        if (OroEquipado == false) {
            return;
        }
        this.direccion = direccion;
        actualizarImagen();
        setRotation(direccion.rotacion);
        Greenfoot.delay(20);
        consumirCombustible(obtenerConsumoPorAtaque());

        Actor actor = getOneObjectAtOffset(this.direccion.dx, this.direccion.dy, Actor.class);
        if (!(actor instanceof Dañable)) {
            return;
        }
        Dañable objetivo = (Dañable) actor;
        if (objetivo != null) {
            Greenfoot.playSound("NaveOroHab.wav");
            objetivo.recibirDañoDe(this);
        }
    }

    /**
     * @see NaveAliada#moverHacia(Direccion)
     */
    public void avanzarHacia(Direccion direccion) {
        super.moverHacia(direccion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int obtenerCombustible() {
        return super.obtenerCombustible();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    int obtenerCombustibleMaximo() {
        return 150;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int obtenerDaño() {
        return 35;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    int obtenerConsumoPorMovimiento() {
        return 7;
    }

    /**
     * @return la cantidad de combustible que consume realizar un ataque
     */
    int obtenerConsumoPorAtaque() {
        return 10;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean estaEnElBorde() {
        return super.estaEnElBorde();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hayVacioHacia(Direccion direccion) {
        return super.hayVacioHacia(direccion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hayAsteroideHacia(Direccion direccion) {
        return super.hayAsteroideHacia(direccion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hayItemHacia(Direccion direccion) {
        return super.hayItemHacia(direccion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hayNaveHacia(Direccion direccion) {
        return super.hayNaveHacia(direccion);
    }

    /**
     * pre: La NaveDeAtaque {@link #puedeActuar()} <br>
     * post: Obtiene la salud de una NaveDeAtaqueEnemiga o Asteroide, en
     * cierta Direccion.
     * 
     * @param direccion
     * @return la salud de una nave enemiga o el tamaño de un asteroide
     */
    public int escanearIndicadorHacia(Direccion direccion) {
        int valor = 0;
        if (hayNaveHacia(direccion)) {
            NaveDeAtaqueEnemiga nave = (NaveDeAtaqueEnemiga) getOneObjectAtOffset(direccion.dx, direccion.dy,
                    NaveDeAtaqueEnemiga.class);
            valor = nave.obtenerSalud();
        } else if (hayAsteroideHacia(direccion)) {
            Asteroide asteroide = (Asteroide) getOneObjectAtOffset(direccion.dx, direccion.dy, Asteroide.class);
            valor = asteroide.obtenerTamaño();
        }
        return valor;
    }

    public void recibirPiloto(PilotoBase piloto) {
        this.piloto = piloto;
        actualizarImagen();
    }

    public void bajarPiloto() {
        if(!this.motoresEncendidos){
            this.piloto = null;
            actualizarImagen();
        }
    }

    @Override
    protected void actualizarImagen() {
        int tamCelda = getWorld().getCellSize();
        GreenfootImage image = getImage();
        image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(image);

        MyGreenfootImage canvas = new MyGreenfootImage(imagenBase.getWidth(),
                imagenBase.getHeight() + getWorld().getCellSize() / 3);

        canvas.setColor(Color.BLACK);
        canvas.fillRect(4, imagenBase.getHeight() - 2, getWorld().getCellSize() - 6, 12);
        canvas.setColor(obtenerColorDeBarraIndicadora());

        canvas.fillRect(6, imagenBase.getHeight(),
            (int) ((getWorld().getCellSize() - 10) * obtenerProporcionDeBarraIndicadora()), 8);

        canvas.rotate(360 - direccion.rotacion);

        canvas.drawImage(imagenBase, 0, getWorld().getCellSize() / 6);
        setImage(canvas);

        if (this.piloto != null) {
            canvas.highlight(this.piloto.getAura());
        }
    }
}

