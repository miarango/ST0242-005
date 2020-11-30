

/**
 * Esta clase permite guardar la fila y columna de una posición
 * @author Helmuth Trefftz
 * @author Maria Isabel Arango Palacio
 * @author Carlos Gustavo Vélez Manco
 */
public class Posicion {
    /**
     * Número de fila.
     */
    int fila;
    /**
     * Número de columna.
     */
    int col;
    /**
     * Constructor.
     * Crea una posición con su respectivo número de fila y columna.
     * @param fila número de fila.
     * @param columna número de columna.
     */
    public Posicion(int fila, int col) {
        this.fila = fila;
        this.col = col;
    }
}
