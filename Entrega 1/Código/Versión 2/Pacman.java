
/**
 * En esta clase se guarda la información acerca del Pacman
 * El Pacman extiende la clase Caracter, y por lo tanto hereda sus
 * atributos y métodos
 * @author Helmuth Trefftz
 * @author Maria Isabel Arango Palacio
 * @author Carlos Gustavo Vélez Manco
 */

public class Pacman extends Caracter {
    /**
     * Almacena los puntos del vida del pacman.
     */
    int puntosVida;
    /**
     * Constructor.
     * Crea un pacman con su respectiva posición, representación y puntos de vida.
     * @param tipo tipo de caracter.
     * @param posicion posición actual del caracter en fila y columna.
     * @param representacion  caracter que representa al pacman.
     */
    public Pacman(int tipo, Posicion posicion, char representacion, int puntosVida) {
        super(tipo, posicion, representacion);
        this.puntosVida = puntosVida;
    }

}
