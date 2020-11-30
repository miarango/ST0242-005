
/**
 * En esta clase se guarda la información acerca del Pacman.
 * Los Fantasmas extienden la clase Caracter, y por lo tanto heredan sus
 * atributos y métodos.
 * @author Helmuth Trefftz.
 * @author Maria Isabel Arango Palacio.
 * @author Carlos Gustavo Vélez Manco.
 */
public class Fantasma extends Caracter{
    int filaf;
    int colf;
    /**
     * Constructor.
     * Crea un fantasma con su respectiva posición, representación.
     */
    public Fantasma(int tipo, Posicion posicion, char representacion) {
       super(tipo, posicion, representacion);
    }
}
