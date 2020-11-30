
import java.util.Scanner;
/**
 * En esta clase se mantiene la información del tablero.
 * El tablero es una matriz (arreglo de dos dimensiones) de Celdas.
 * Es necesario tener una referencia a juego para poder acceder 
 * a la información del pacman.
 * @author Helmuth Trefftz
 * @author Maria Isabel Arango Palacio
 * @author Carlos Gustavo Vélez Manco
 */
public class Tablero {
    /**
     * Referencia a la clase juego.
     */
    Juego juego;
    /**
     * Es la matriz (arreglo de dos dimensiones) que representa el tablero.
     */
    Celda[][] tablero;
    /**
     * Número de filas de las que se compone el tablero.
     */
    int numFilas;
    /**
     * Número de columnas de las que se compone el tablero.
     */
    int numCols;
    /**
     * Arreglo String en el que se ilustra el tablero.
     */
    String[] archivo = {
        "15 17",
        "*****************",
        "*               *",
        "* ****** ****** *",
        "* *    * *    * *",
        "*               *",
        "* *    * *    * *",
        "* ****** ****** *",
        "*               *",
        "* ****** ****** *",
        "* *    * *    * *",
        "*               *",
        "* *    * *    * *",
        "* ****** ****** *",
        "*               *",
        "*****************",
        "P 1 1",
        "O 13 15",
        "F 7 8",
        "D 4 15"
    };

    /**
     * Constructor
     * Se recibe la referencia al juego, para poder acceder al pacman
     * Se lee el "archivo" con la información del laberinto, la posición
     * del pacman y la salida
     * @param juego 
     */
    public Tablero(Juego juego) {
        this.juego = juego;
        leerArchivo();
    }

    /**
     * En este método se lee el laberinto.
     */
    private void leerArchivo() {
        int i = 0;
        String linea = archivo[i];
        i++;
        Scanner lineScan = new Scanner(linea);
        // Leer el tamaño del tablero en filas y columnas
        numFilas = lineScan.nextInt();
        numCols = lineScan.nextInt();
        // Definir el tamaño del tablero
        tablero = new Celda[numFilas][numCols];
        // Leer cada una de las filas que conforman el laberinto
        for (int fila = 0; fila < numFilas; fila++) {
            linea = archivo[i];
            i++;
            for (int col = 0; col < numCols; col++) {
                char c = linea.charAt(col);
                // esMuro, esSalida, tienearepita, caracter
                if (c == '*') {
                    tablero[fila][col] = new Celda(true, false, false, null);
                }
                if (c == ' ') {
                    tablero[fila][col] = new Celda(false, false, true, null);
                    double Tiene = Math.random();
                    if(Tiene >=0.8){
                        tablero[fila][col].setTieneArepitaExplosiva();
                    }
                }
            }
        }
        // Leer la información adicional. Esto es:
        // (i) La posición del Pacman (empieza por P)
        // (ii) La posición de la salida (empieza por O)
        // En una versión futura se podrían leer las posiciones de los
        // fantasmas.
        while (i < archivo.length) {
            linea = archivo[i];
            i++;
            lineScan = new Scanner(linea.substring(1));
            if (linea.charAt(0) == 'P') {
                // La información del Pacman
                int fila = lineScan.nextInt();
                int col = lineScan.nextInt();
                Posicion posicion = new Posicion(fila, col);
                juego.pacman = new Pacman(Caracter.PACMAN, posicion, '^', Juego.PUNTOS_VIDA_INICIALES);
                tablero[posicion.fila][posicion.col].caracter = juego.pacman;
                tablero[posicion.fila][posicion.col].tieneArepita = false;
            } else if (linea.charAt(0) == 'O') {
                // La información de la salida del laberinto
                int fila = lineScan.nextInt();
                int col = lineScan.nextInt();
                tablero[fila][col].esSalida = true;
                tablero[fila][col].tieneArepita= false;
            }else if(linea.charAt(0) == 'F'){
                //La información del fantasma1
                int fila1 = lineScan.nextInt();
                int col1 = lineScan.nextInt();
                Posicion posicion= new Posicion(fila1,col1);
                juego.fantasma1 = new Fantasma(2, posicion,'w');
                tablero[posicion.fila][posicion.col].caracter = juego.fantasma1;
                tablero[posicion.fila][posicion.col].tieneArepita = false;
            }else if(linea.charAt(0) == 'D'){
                //La información del fantasma2
                int fila2 = lineScan.nextInt();
                int col2 = lineScan.nextInt();
                Posicion posicion= new Posicion(fila2,col2);
                juego.fantasma2 = new Fantasma(2, posicion,'w');
                tablero[posicion.fila][posicion.col].caracter = juego.fantasma2;
                tablero[posicion.fila][posicion.col].tieneArepita = false;
            }
        }
    }

    /**
     * En este método se dibuja el tablero con los respectivos caracteres.
     * A cada celda se le invoca el métoco "caracterCelda", que devuelve
     * un caracter que representa el contenido de la celda.
     */
    public void dibujarTablero() {
        String s = "";
        for (int fila = 0; fila < numFilas; fila++) {
            for (int col = 0; col < numCols; col++) {
                s += tablero[fila][col].caracterCelda();
            }
            s += "\n";
        }
        System.out.println(s);
    }
}
