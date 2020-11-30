/**
 * Información acerca del Caracter
 * Tanto el Pacman como los Fantasmas son caracteres
 * @author Helmuth Trefftz
 * @author Carlos Gustavo Vélez Manco
 * @author Maria Isabel Arango
 */
public class Caracter {
    // Constantes para definir los tipos de caracteres
    /**
     * Constante con la que se define el caracter principal (Pacman)
     */
    public static final int PACMAN = 1;
    /**
     * Constante con la que se define el caracter fantasma
     */
    public static final int FANTASMA = 2;
    /**
     * Tipo de caracter definido
     */
    public static final int CAMINO = 3;
    protected int tipo;
    /**
     * Posicion del caracter definido en fila y columna
     */
    protected Posicion posicion;
    /**
     * Caracter con el que se representa caracter definido
     */
    protected char representacion;

    /**
     * Constructor
     * Se lee el tipo, posicion y representacion del caracter
     * @param tipo tipo de caracter (ver las constantes al comienzo de la clase Caracter)
     * @param posicion posición actual del caracter en fila y columna
     * @param representacion  caracter que representa a este caracter
     */
    public Caracter(int tipo, Posicion posicion, char representacion) {
        this.tipo = tipo;
        this.posicion = posicion;
        this.representacion = representacion;
    }
    
}

