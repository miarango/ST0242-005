
import java.util.Scanner;
import java.util.Random;
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
     * Referencia a la clase Tablero.
     */
    Tablero tablero;
    /**
     * Referencia a la clase Pacman.
     */
    Pacman pacman;
    /**
     * Referencia a la clase Fantasma.
     */
    Fantasma fantasma1;
    Fantasma fantasma2;
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
                // Mover hacia la izquierda.
                case "a":
                    nuevaCol = col - 1;
                    break;
                //Mover hacia la derecha.
                case "d":
                    nuevaCol = col + 1;
                    break;
                //Mover hacia arriba.
                case "w":
                    nuevaFila = fila - 1;
                    break;
                //Mover hacia abajo.
                case "s":
                    nuevaFila = fila + 1;
                    break;
            }
            //Características iniciales fantasma1
            int filaf1 = fantasma1.posicion.fila;
            int colf1 = fantasma1.posicion.col;
            int nuevaFilaf1 = filaf1;
            int nuevaColf1 = colf1;
            Celda validar1 = tablero.tablero[filaf1][colf1-1]; //Casilla a la izquierda.
            Celda validar2 = tablero.tablero[filaf1][colf1+1]; //Casilla a la derecha.
            Celda validar3 = tablero.tablero[filaf1-1][colf1]; //Casilla superior.
            Celda validar4 = tablero.tablero[filaf1+1][colf1]; //Casilla inferior.
            //Características iniciales fantasma2
            int filaf2 = fantasma2.posicion.fila;
            int colf2 = fantasma2.posicion.col;
            int nuevaFilaf2 = filaf2;
            int nuevaColf2 = colf2;
            Celda validar5 = tablero.tablero[filaf2][colf2-1]; //Casilla a la izquierda.
            Celda validar6 = tablero.tablero[filaf2][colf2+1]; //Casilla a la derecha.
            Celda validar7 = tablero.tablero[filaf2-1][colf2]; //Casilla superior.
            Celda validar8 = tablero.tablero[filaf2+1][colf2]; //Casilla inferior.
            while(filaf1<14  && colf1<16 && filaf2<14 && colf2<16){
                //Fantasma1 persiguiendo al pacman.
                if(fila == filaf1){
                    if(col > colf1 && !validar2.esMuro){
                        // Se mueve hacia la derecha.
                        nuevaFilaf1 = filaf1;
                        nuevaColf1 = colf1+2;
                        if(nuevaColf1 >0 && nuevaColf1<16){
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }else{
                            nuevaColf1 = colf1;
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }
                    }else if(col < colf1 && !validar1.esMuro){
                        //Se mueve hacia la izquierda.
                        nuevaFilaf1 = filaf1;
                        nuevaColf1 = colf1-2;
                        if(nuevaColf1 >0 && nuevaColf1<16){
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }else{
                            nuevaColf1 = colf1;
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }
                    }
                }else if(col == colf1){
                    if(fila > filaf1 && !validar4.esMuro){
                        //Se mueve hacia abajo.
                        nuevaColf1 = colf1;
                        nuevaFilaf1 = filaf1+2;
                        if(nuevaFilaf1 >0 && nuevaFilaf1<16){
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }else{
                            nuevaFilaf1 = filaf1;
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }
                    }else if(fila < filaf1 && !validar3.esMuro){
                        //Se mueve hacia arriba.
                        nuevaColf1 = colf1;
                        nuevaFilaf1 = filaf1-2;
                        if(nuevaFilaf1 >0 && nuevaFilaf1<16){
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }else{
                            nuevaFilaf1 = filaf1;
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }
                    }
                }
                //Fantasma1 moviendose de forma aleatoria
                else{
                    int mover1 = (int)(Math.random()*4);
                    if(mover1 ==0 && !validar1.esMuro){
                        //Se mueve hacia la izquierda.
                        nuevaFilaf1 = filaf1;
                        nuevaColf1 = colf1 - 2;
                        if(nuevaColf1 >0 && nuevaColf1<16){
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }else{
                            nuevaColf1 = colf1;
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }
                    }
                    if(mover1 ==1 && !validar2.esMuro){
                        //Se mueve hacia la derecha.
                        nuevaFilaf1 = filaf1;
                        nuevaColf1 = colf1 + 2;
                        if(nuevaColf1 >0 && nuevaColf1<16){
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }else{
                            nuevaColf1 = colf1;
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }
                    }
                    if(mover1 ==2 && !validar3.esMuro){
                        //Se mueve hacia arriba.
                        nuevaColf1 = colf1;
                        nuevaFilaf1 = filaf1 - 2;
                        if(nuevaFilaf1 >0 && nuevaFilaf1<16){
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }else{
                            nuevaFilaf1 = filaf1;
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }
                    }
                    if(mover1 ==3 && !validar4.esMuro){
                        //Se mueve hacia abajo.
                        nuevaColf1 = colf1;
                        nuevaFilaf1 = filaf1 + 2;
                        if(nuevaFilaf1 >0 && nuevaFilaf1<16){
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }else{
                            nuevaFilaf1 = filaf1;
                            fantasma1.setFilaYColumna(nuevaFilaf1,nuevaColf1);
                        }
                    }
                }
                //Fantasma2 persiguiendo al pacman.
                if(fila == filaf2){
                    if(col > colf2 && !validar6.esMuro){
                        // Se mueve hacia la derecha.
                        nuevaFilaf2 = filaf2;
                        nuevaColf2 = colf2+2;
                        if(nuevaColf2 >0 && nuevaColf2<16){
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }else{
                            nuevaColf2 = colf2;
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }
                    }else if(col < colf2 && !validar5.esMuro){
                        //Se mueve hacia la izquierda.
                        nuevaFilaf2 = filaf2;
                        nuevaColf2 = colf2-2;
                        if(nuevaColf2 >0 && nuevaColf2<16){
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }else{
                            nuevaColf2 = colf2;
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }
                    }
                }else if(col == colf2){
                    if(fila > filaf2 && !validar8.esMuro){
                        //Se mueve hacia abajo.
                        nuevaColf2 = colf2;
                        nuevaFilaf2 = filaf2+2;
                        if(nuevaFilaf2 >0 && nuevaFilaf2<16){
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }else{
                            nuevaFilaf2 = filaf2;
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }
                    }else if(fila < filaf2 && !validar7.esMuro){
                        //Se mueve hacia arriba.
                        nuevaColf2 = colf2;
                        nuevaFilaf2 = filaf2-2;
                        if(nuevaFilaf2 >0 && nuevaFilaf2<16){
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }else{
                            nuevaFilaf2 = filaf2;
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }
                    }
                }//Fantasma2 moviendose de forma aleatoria
                else{
                    int mover2 = (int)(Math.random()*4);
                    if(mover2 ==0 && !validar5.esMuro){
                        //Se mueve hacia la izquierda.
                        nuevaFilaf2 = filaf2;
                        nuevaColf2 = colf2 - 2;
                        if(nuevaColf2 >0 && nuevaColf2<16){
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }else{
                            nuevaColf2 = colf2;
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }
                    }
                    if(mover2 ==1 && !validar6.esMuro){
                        //Se mueve hacia la derecha.
                        nuevaFilaf2 = filaf2;
                        nuevaColf2 = colf2 + 2;
                        if(nuevaColf2 >0 && nuevaColf2<16){
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }else{
                            nuevaColf2 = colf2;
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }
                    }
                    if(mover2 ==2 && !validar7.esMuro){
                        //Se mueve hacia arriba.
                        nuevaColf2 = colf2;
                        nuevaFilaf2 = filaf2 - 2;
                        if(nuevaFilaf2 >0 && nuevaFilaf2<16){
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }else{
                            nuevaFilaf2 = filaf2;
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }
                    }
                    if(mover2 ==3 && !validar8.esMuro){
                        //Se mueve hacia abajo.
                        nuevaColf2 = colf2;
                        nuevaFilaf2 = filaf2 + 2;
                        if(nuevaFilaf2 >0 && nuevaFilaf2<16){
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }else{
                            nuevaFilaf2 = filaf2;
                            fantasma2.setFilaYColumna(nuevaFilaf2,nuevaColf2);
                        }
                    }
                }
                break;
            }
            if (validarCasilla(nuevaFila, nuevaCol, nuevaFilaf1, nuevaColf1)) {
                //Crear nueva posición del pacman
                Celda anterior = tablero.tablero[fila][col];
                Celda nueva = tablero.tablero[nuevaFila][nuevaCol];
                nueva.caracter = pacman;
                anterior.tieneArepita = false;
                nueva.tieneArepita =false;
                anterior.caracter = null;
                pacman.posicion = new Posicion(nuevaFila, nuevaCol);
                
                //Crear nueva posición del fantasma1.
                Celda anteriorf1 = tablero.tablero[filaf1][colf1];
                Celda nuevaf1 = tablero.tablero[nuevaFilaf1][nuevaColf1];
                nuevaf1.caracter = fantasma1;
                anteriorf1.tieneArepita = true;
                nuevaf1.tieneArepita = false;
                fantasma1.posicion = new Posicion(nuevaFilaf1, nuevaColf1);
                //Excepciones
                // fantasma1 en la posicion anterior al pacman.
                if(anterior == nuevaf1){
                    anterior.caracter = fantasma1;
                }
                //fantasma1 y arepas.
                if(anteriorf1 == nueva){
                    anteriorf1.tieneArepita = false;
                }
                //Arepas
                if(nueva.tieneArepitaExplosiva==true){
                    pacman.puntosVida = pacman.puntosVida - 5;
                }else if (nueva.tieneArepitaExplosiva==false){
                    pacman.puntosVida = pacman.puntosVida + 1;
                }
                
                //Casos de derrota.
                if(nueva == nuevaf1){
                    ganaElJuego = false;
                    break;
                }
                if(pacman.puntosVida <=0){
                    ganaElJuego = false;
                    break;
                }
                //Casos de victoria.
                if(nueva.esSalida== true){
                    ganaElJuego = true;
                    break;
                }
            }
            if (validarCasilla(nuevaFila, nuevaCol, nuevaFilaf2, nuevaColf2)) {
                //Crear nueva posición del pacman
                Celda anterior = tablero.tablero[fila][col];
                Celda nueva = tablero.tablero[nuevaFila][nuevaCol];
                nueva.caracter = pacman;
                anterior.tieneArepita = false;
                nueva.tieneArepita =false;
                anterior.caracter = null;
                pacman.posicion = new Posicion(nuevaFila, nuevaCol);
                
                //Crear nueva posición del fantasma2.
                Celda anteriorf2 = tablero.tablero[filaf2][colf2];
                Celda nuevaf2 = tablero.tablero[nuevaFilaf2][nuevaColf2];
                nuevaf2.caracter = fantasma2;
                anteriorf2.tieneArepita = true;
                nuevaf2.tieneArepita = false;
                fantasma2.posicion = new Posicion(nuevaFilaf2, nuevaColf2);
                
                //Excepciones
                // fantasma2 en la posicion anterior al pacman.
                if(anterior == nuevaf2){
                    anterior.caracter = fantasma2;
                }
                //fantasma2 y arepas.
                if(anteriorf2 == nueva){
                    anteriorf2.tieneArepita = false;
                }
                
                //Casos de derrota.
                if(nueva == nuevaf2){
                    ganaElJuego = false;
                    break;
                }
                if(pacman.puntosVida <=0){
                    ganaElJuego = false;
                    break;
                }
                //Casos de victoria.
                if(nueva.esSalida== true){
                    ganaElJuego = true;
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
    private boolean validarCasilla(int nuevaFila, int nuevaCol, int nuevaFilaf1, int nuevaColf1) {
        //Condiciones del pacman.
        Celda nueva = tablero.tablero[nuevaFila][nuevaCol];
        if(nuevaFila > 14 || nuevaCol > 16){
            return false;
        }
        if(nueva.esMuro== true){
            return false;
        }
        if(nueva.caracter == null){
            return true;
        }
        //Condiciones de los fantasmas.
        Celda nuevaf = tablero.tablero[nuevaFilaf1][nuevaColf1];
        if(nuevaf.esMuro == true){
            return false;
        }
        return true;
    }
}
