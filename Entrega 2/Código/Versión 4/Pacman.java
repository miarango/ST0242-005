

/**
 * En esta clase se guarda la información acerca del Pacman
 * El Pacman extiende la clase Caracter, y por lo tanto hereda sus
 * atributos y métodos
 * @author Helmuth Trefftz
 * @author Carlos Gustavo Vélez Manco
 * @author Maria Isabel Arango
 */
public class Pacman extends Caracter {
    // Cuántos puntos de vida tiene el Pacman
    /**
     * Almacena los puntos de vida del pacman
     */
    int puntosVida;
    /**
     * Constructor
     * Crea un Pacman con su respectiva posicion, representacion y puntos de vida
     * @param tipo tipo de caracter
     * @param posición actual del pacman en fila y columna
     * @param representacion caracter que representa al pacman
     */
    public Pacman(int tipo, Posicion posicion, char representacion, int puntosVida) {
        super(tipo, posicion, representacion);
        this.puntosVida = puntosVida;
    }

}
