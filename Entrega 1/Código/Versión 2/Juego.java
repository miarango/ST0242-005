
import java.util.Scanner;
/**
 * Esta clase maneja el juego
 * Se tiene una referencia al tablero y al pacman
 * En esta clase se hace la interacción con el usuario
 * @author Helmuth Trefftz
 * @author Maria Isabel Arango Palacio
 * @author Carlos Gustavo Vélez Manco
 */
public class Juego {
    /**
     * El número de puntos iniciales de vida del pacman.
     */
    public static final int PUNTOS_VIDA_INICIALES = 10;
    /**
     * Referencia a la clase tablero.
     */
    Tablero tablero;
    /**
     * Referencia a la clase pacman.
     */
    Pacman pacman;
    /**
     * Constructor.
     * Se crea un tablero.
     */
    public Juego() {
        tablero = new Tablero(this);
    }

    /**
     * En este método se realiza la interacción con el usuario.
     */
    public void jugar() {
        boolean ganaElJuego = false;
        tablero.dibujarTablero();
        Scanner in = new Scanner(System.in);
        String linea = in.nextLine();
        while (!linea.equals("q") && !ganaElJuego) {
            int fila = pacman.posicion.fila;
            int col = pacman.posicion.col;
            int nuevaFila = fila;
            int nuevaCol = col;
            switch (linea) {
                case "a":
                    nuevaCol = col - 1;
                    break;
                case "d":
                    nuevaCol = col + 1;
                    break;
                case "w":
                    nuevaFila = fila - 1;
                    break;
                case "s":
                    nuevaFila = fila + 1;
                    break;
            }
            if (validarCasilla(nuevaFila, nuevaCol)) {
                Celda anterior = tablero.tablero[fila][col];
                Celda nueva = tablero.tablero[nuevaFila][nuevaCol];
                nueva.caracter = pacman;
                anterior.tieneArepita = false;
                nueva.tieneArepita =false;
                anterior.caracter = null;
                pacman.posicion = new Posicion(nuevaFila, nuevaCol);
                if(nueva.tieneArepitaExplosiva==true){
                    pacman.puntosVida = pacman.puntosVida - 5;
                }else if (nueva.tieneArepitaExplosiva==false){
                    pacman.puntosVida = pacman.puntosVida + 1;
                }
                
                if(nueva.esSalida== true){
                    ganaElJuego = true;
                    break;
                }
                
                if(pacman.puntosVida <=0){
                    ganaElJuego = false;
                    break;
                }
            }
            System.out.println("Puntos de vida: "+pacman.puntosVida);
            tablero.dibujarTablero();
            linea = in.nextLine();
        }
        if(ganaElJuego) {
            System.out.println("Has ganado el juego, ¡felicitaciones!");
        }else if(!ganaElJuego){
            System.out.println("Has perdido el juego, vuelve a intentarlo");
        }
    }

    /**
     * En este metodo se chequean las siguientes condiciones:
     * (i) Que el usuario no se salga de las filas del tablero
     * (ii) Que el usuario no se salga de las columnas del tablero
     * (iii) Que la posición no sea un muro
     * (iv) Que no haya un caracter en esa posición
     * 
     * @param nuevaFila Fila hacia donde se quiere mover el usuario
     * @param nuevaCol Columna hacia donde se quiere mover el usuario
     * @return true si es una jugada válida, false de lo contrario
     */
    private boolean validarCasilla(int nuevaFila, int nuevaCol) {
        //EDITADO
        Celda nueva = tablero.tablero[nuevaFila][nuevaCol];
        if(nuevaFila > 16 || nuevaCol > 15){
            return false;
        }
        if(nueva.esMuro== true){
            return false;
        }
        if(nueva.caracter == null){
            // Tener en cuenta en la versión 3
            return true;
        }
        return true;
        //EDITADO
    }
}
