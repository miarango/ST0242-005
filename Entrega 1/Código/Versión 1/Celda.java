
/**
 * En esta clase se guarda la información de una celda y su contenido
 * @author Helmuth Trefftz
 * @author Carlos Gustavo Vélez Manco
 * @author Maria Isabel Arango
 */
public class Celda {
    /**
     * Determina si cierta celda es un muro
     */
    boolean esMuro;             // True si esta celda es muro (pared)
    /**
     * Determina si cierta celda es la salida(meta)
     */
    boolean esSalida;           // True si esta celda es una salida del laberinto
    /**
     * Determina si cierta celda posee arepitas
     */
    boolean tieneArepita;       // True si esta celda tiene una arepita
    /**
     * Referencia al caracter que ocupa la celda
     */
    Caracter caracter;          // Referenia al caracter que ocupa la celda o null si no hay caracter

    /**
     * Constructor
     * Permite crear una nueva celda
     * @param esMuro true si esta celda es muro, false de lo contrario
     * @param esSalida true si esta celda es Salida, false de lo contrario
     * @param tieneArepita true si esta celda tiene una arepita, false de lo contrario
     * @param caracter  referencia al caracter que ocupa la celda, o null si no hay caracter
     */
    public Celda(boolean esMuro, boolean esSalida, boolean tieneArepita, Caracter caracter) {
        this.esMuro = esMuro;
        this.esSalida = esSalida;
        this.tieneArepita = tieneArepita;
        this.caracter = caracter;
    }

    /**
     * Este metodo retorna el caracter con el que se representa esta celda
     * @return caracter que representa el contenido de la celda
     */
    public char caracterCelda() {
        if(esMuro) {
            return '*';
        } else if(tieneArepita) {
            return '.';
        } else if(caracter != null) {
            return caracter.representacion;
        } else if (esSalida) {
            return 'O';
        } else {
            return ' ';
        }
    }

}