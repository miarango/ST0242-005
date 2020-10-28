
import java.util.Random;
/**
 * En esta clase se guarda la información de una celda y su contenido
 * @author Helmuth Trefftz
 * @author Maria Isabel Arango Palacio
 * @author Carlos Gustavo Vélez Manco
 */
public class Celda {
    /**
     * Determina si en la respectiva celda existe un muro.
     */
    boolean esMuro;             // True si esta celda es muro (pared)
    /**
     * Determina la meta del pacman.
     */
    boolean esSalida;           // True si esta celda es una salida del laberinto
    /**
     * Determina si en la respectiva celda hay una arepita.
     */
    boolean tieneArepita;       // True si esta celda tiene una arepita
    /**
     * Determina si la arepita es mala para el pacman.
     */
    boolean tieneArepitaExplosiva;
    /**
     * Referencia al caracter que ocupa la celda.
     */
    Caracter caracter;          // Referenia al caracter que ocupa la celda o null si no hay caracter

    /**
     * Constructor.
     * Permite crear una celda.
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
     * Retorna el caracter con el que se representa esta celda.
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
    
    /**
     * Permite asignar a una celda una arepita explosiva.
     */
    public void setTieneArepitaExplosiva(){
        tieneArepitaExplosiva = true;
    }
}