
import java.util.Scanner;
/**
 * En esta clase se mantiene la información del tablero
 * El tablero es una matriz de Celdas
 * Es necesario tener una referencia a juego para poder acceder 
 * a la información del pacman
 * @author Carlos Gustavo Vélez Manco
 * @author Maria Isabel Arango
 */

public class Tablero {
    /**
     * Es la referencia a juego para poder acceder a la información
     */
    Juego juego;
    /**
     * Es la matriz (arreglo de dos dimensiones) que  conforma el tablero
     */
    Celda[][] tablero;
    /**
     * Numero de filas de las que se compone el tablero
     */
    int numFilas;
    /**
     * Numero de columnas de las que se compone el tablero
     */
    int numCols;
    /**
     * Arreglo de String en el que se ilustra y guarda el tablero
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
            "O 13 15"
        };

    /**
     * Constructor
     *  Se recibe la referencia al juego, para poder acceder al pacman
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
     * 
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
                    tablero[fila][col] = new Celda(false, false, false, null);
                }
            }
        }
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
            } else if (linea.charAt(0) == 'O') {
                // La información de la salida del laberinto
                int fila = lineScan.nextInt();
                int col = lineScan.nextInt();
                tablero[fila][col].esSalida = true;
            }
        }

    }

    /**
     * En este método se dibuja el tablero con los caracteres respectivos.
     * A cada celda se le invoca el métoco "caracterCelda", que devuelve
     * el caracter que representa el contenido de la celda.
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
