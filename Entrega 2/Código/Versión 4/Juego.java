
import java.util.Random;
/**
 * Esta clase maneja el juego
 * Se tiene una referencia al tablero y al pacman
 * En esta clase se hace la interacción con el usuario
 * @author Helmuth Trefftz
 * @author Carlos Gustavo Vélez Manco
 * @author Maria Isabel Arango
 */
public class Juego {
    /**
     * El número de puntos de vida iniciales del pacman
     */
    public static final int PUNTOS_VIDA_INICIALES = 10;
    /**
     * Referencia a la clase tablero
     */
    Tablero tablero;
    /**
     * Referencia a la clase Pacman
     */
    Pacman pacman;

    /**
     * Constructor
     * Se crea un tablero
     */
    public Juego() {
        tablero = new Tablero(this);
    }

    /**
     * En este método se realiza la interacción con el usuario
     */
    public void jugar() {
        boolean ganaElJuego = false;
        tablero.dibujarTablero();
        while (!ganaElJuego) {
             int fila = pacman.posicion.fila;
             int col = pacman.posicion.col;
             int nuevaFila = fila;
             int nuevaCol = col;
           
             Celda validar0 = tablero.tablero[fila][col+1]; //Derecha
             Celda validar1 = tablero.tablero[fila][col-1]; //Izquierda
             Celda validar2 = tablero.tablero[fila-1][col]; //Arriba
             Celda validar3 = tablero.tablero[fila+1][col]; //Abajo
             /**
             int mover = (int)(Math.random()*3);
             
             //Derecha
                 if(mover == 0 && !(validar0.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col + 1;
                 }
             //Izquierda
                 else if(mover == 1 && !(validar1.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col -1;
                 }
             //Arriba
                  else if(mover == 1 && !(validar2.esCamino)){
                     nuevaFila = fila - 1;
                     nuevaCol = col;
                  }
             //Abajo
                  else if(mover == 2 && !(validar3.esCamino)){
                      nuevaFila = fila + 1;
                      nuevaCol = col;
                  }
                  else{
                      nuevaFila = fila;
                      nuevaCol = col;
                  }
             */
             //Cero muros
             if(!validar0.esMuro && !validar1.esMuro && !validar2.esMuro && !validar3.esMuro){
                 int mover = (int)(Math.random()*2);
                 //Derecha
                 if(mover == 0 && !(validar0.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col + 1;
                 }
                 //Izquierda
                 else if(mover == 1 && !(validar1.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col -1;
                 }
             } 
             // 1 muro
             //muro a la derecha
             else if(validar0.esMuro && !validar1.esMuro && !validar2.esMuro && !validar3.esMuro){
                  int mover = (int)(Math.random()*3);
                  //Izquierda
                  if(mover == 0 && !(validar1.esCamino)){
                      nuevaFila = fila;
                      nuevaCol = col - 1;
                  }
                  //Abajo
                  else if(mover == 2 && !(validar3.esCamino)){
                      nuevaFila = fila + 1;
                      nuevaCol = col;
                  }
             } 
             //muro a la izquierda
             else if(!validar0.esMuro && validar1.esMuro && !validar2.esMuro && !validar3.esMuro){
                  int mover = (int)(Math.random()*3);
                  //Derecha
                  if(mover == 0 && !(validar0.esCamino)){
                      nuevaFila = fila;
                      nuevaCol = col +1;
                  }
                  //Abajo
                  else if(mover == 2 && !(validar3.esCamino)){
                      nuevaFila = fila + 1;
                      nuevaCol = col;
                  }
             }
             //muro arriba
             else if(!validar0.esMuro && !validar1.esMuro && validar2.esMuro && !validar3.esMuro){
                  int mover = (int)(Math.random()*3);
                  //Derecha
                  if(mover == 0 && !(validar0.esCamino)){
                      nuevaFila = fila;
                      nuevaCol = col +1;
                  }
                  //Abajo
                  else if(mover == 2 && !(validar3.esCamino)){
                      nuevaFila = fila + 1;
                      nuevaCol = col;
                  }
             }
             //Muro abajo
             else if(!validar0.esMuro && !validar1.esMuro && !validar2.esMuro && validar3.esMuro){
                 int mover = (int)(Math.random()*3);
                 //Derecha
                 if(mover == 0 && !(validar0.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col +1;
                 }
                 //Izquierda
                 else if(mover == 1 && !(validar1.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col - 1;
                 }
                 //Arriba
                 else if(mover == 2 && !(validar2.esCamino)){
                     nuevaFila = fila - 1;
                     nuevaCol = col;
                 }
             }
             //2 muros
             //Derecha e izquierda
             else if(validar0.esMuro && validar1.esMuro && !validar2.esMuro && !validar3.esMuro){
                 int mover = (int)(Math.random()*2);
                 //Arriba
                 if(mover == 0 && !(validar2.esCamino)){
                     nuevaFila = fila - 1;
                     nuevaCol = col;
                 }
                 //Abajo
                 else if(mover == 1 && !(validar3.esCamino)){
                     nuevaFila = fila + 1;
                     nuevaCol = col;
                 }
             }
             //Arriba y abajo
             else if(!validar0.esMuro && !validar1.esMuro && validar2.esMuro && validar3.esMuro){
                 int mover = (int)(Math.random()*2);
                 //Derecha
                 if(mover == 0 && !(validar0.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col +1;
                 }
                 //Izquierda
                 else if(mover == 1 && !(validar1.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col - 1;
                 }
             }
             //Arriba izquierda
             else if(!validar0.esMuro && validar1.esMuro && validar2.esMuro && !validar3.esMuro){
                 int mover = (int)(Math.random()*2);
                 //Derecha
                 if(mover == 0 && !(validar0.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col +1;
                 }
                 //Abajo
                 else if(mover == 1 && !(validar3.esCamino)){
                     nuevaFila = fila + 1;
                     nuevaCol = col;
                 }
             }
             //Arriba derecha
             else if(validar0.esMuro && !validar1.esMuro && validar2.esMuro && !validar3.esMuro){
                 int mover = (int)(Math.random()*2);
                 //Izquierda
                 if(mover == 0 && !(validar1.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col -1;
                 }
                 //Abajo
                 else if(mover == 1 && !(validar3.esCamino)){
                     nuevaFila = fila + 1;
                     nuevaCol = col;
                 }
             }
             //Abajo izquierda
             else if(!validar0.esMuro && validar1.esMuro && !validar2.esMuro && validar3.esMuro){
                 int mover = (int)(Math.random()*2);
                 //Derecha
                 if(mover == 0 && !(validar0.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col +1;
                 }
                 //Arriba
                 else if(mover == 1 && !(validar2.esCamino)){
                     nuevaFila = fila - 1;
                     nuevaCol = col;
                 }
             }
             //Abajo derecha
             else if(validar0.esMuro && !validar1.esMuro && !validar2.esMuro && validar3.esMuro){
                 int mover = (int)(Math.random()*2);
                 //Izquierda
                 if(mover == 0 && !(validar1.esCamino)){
                     nuevaFila = fila;
                     nuevaCol = col -1;
                 }
                 //Arriba
                 else if(mover == 1 && !(validar2.esCamino)){
                     nuevaFila = fila -1;
                     nuevaCol = col;
                 }
             }
             else{
                     nuevaFila = fila;
                     nuevaCol = col;
             }
             

             if (validarCasilla(nuevaFila, nuevaCol)) {
                 Celda anterior = tablero.tablero[fila][col];
                 Celda nueva = tablero.tablero[nuevaFila][nuevaCol];
                 nueva.esCamino = true;
                 nueva.caracterCelda();
                 anterior.caracter = null;
                 pacman.posicion = new Posicion(nuevaFila, nuevaCol);
                 if(nueva.esSalida == true){
                     ganaElJuego = true;
                     break;
                 }
             }
            tablero.dibujarTablero();
         }
         if(ganaElJuego) {
             System.out.println("Has ganado el juego, ¡felicitaciones!");
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
        Celda nueva = tablero.tablero[nuevaFila][nuevaCol];
        if(nuevaFila > 16 || nuevaCol > 15){
            return false;
        }
        if(nueva.esMuro == true){
            return false;
        }
        if(nueva.caracter == null){
            return true;
        }
        return true;
    }
}
