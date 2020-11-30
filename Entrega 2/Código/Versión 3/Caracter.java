
/**
 * Información acerca del Caracter
 * Tanto el Pacman como los Fantasmas son caracteres
 * @author Helmuth Trefftz
 * @author Maria Isabel Arango Palacio
 * @author Carlos Gustavo Vélez Manco
 */
public class Caracter {
    // Constantes para definir los tipos de caracteres
    /**
     * Constante con la que se define el caracter pacman.
     */
    public static final int PACMAN = 1;
    /**
     * Constante con la que se define el caracter fantasma.
     */
    public static final int FANTASMA = 2;
    /**
     * Tipo de caracter definido.
     */
    protected int tipo;
    /**
     * Posición  de caracter definido.
     */
    protected Posicion posicion;
    /**
     * Caracter con el que se representa el caracter definido.
     */
    protected char representacion;
    
    /**
     * Constructor.
     * Lee el tipo, posición y representación del caracter.
     * @param tipo tipo de caracter (ver las constantes al comienzo de la clase Caracter)
     * @param posicion posición actual del caracter en fila y columna
     * @param representacion  caracter que representa a este caracter
     */
    public Caracter(int tipo, Posicion posicion, char representacion) {
        this.tipo = tipo;
        this.posicion = posicion;
        this.representacion = representacion;
    }
    
    /**
     * Método.
     * Asigna una posición.
     */
    public void setFilaYColumna(int fila, int col){
        this.posicion.fila = fila;
        this.posicion.col = col;
    }
}

