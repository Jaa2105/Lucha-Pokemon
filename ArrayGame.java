import java.util.Scanner;
import java.util.Random;

// Interfaz para ataque
interface Atacante {
    void atacar(SerVivo enemigo); // <- cambio aquí
}

// Interfaz para defensa
interface Defensor {
    void defender(int dano);
}

// Clase abstracta que heredan los seres vivos (jugadores, enemigos)
abstract class SerVivo {
    protected String nombre;
    protected int salud;
    protected int fuerza;

    public SerVivo(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    public abstract void mostrarInfo();

    public boolean estaVivo() {
        return salud > 0;
    }

    public void recibirDanio(int cantidad) {
        salud -= cantidad;
        if (salud <= 0) {
            salud = 0;
            System.out.println(nombre + " ha sido derrotado.");
        } else {
            System.out.println(nombre + " ahora tiene " + salud + " de salud.");
        }
    }
}

// Clase Personaje hereda de SerVivo y implementa Atacante y Defensor
class Personaje extends SerVivo implements Atacante, Defensor {
    private static final String TIPO = "Héroe"; // Constante de tipo
    public static final int TAMANO_CUADRIGA = 5; // Tamaño de la cuadrícula como constante

    public Personaje(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    // Implementación de método de Atacante
    @Override
    public void atacar(SerVivo enemigo) { // <- cambio aquí
        System.out.println(this.nombre + " ataca a " + enemigo.nombre);
        enemigo.recibirDanio(this.fuerza);
    }

    // Implementación de método de Defensor
    @Override
    public void defender(int dano) {
        int danioReducido = dano / 2; // Reducir el daño a la mitad
        this.salud -= danioReducido;
        System.out.println(this.nombre + " se defiende y recibe " + danioReducido + " de daño.");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Salud: " + salud);
        System.out.println("Fuerza: " + fuerza);
    }

    // Método estático para generar un número aleatorio
    public static int generarNumeroAleatorio(int limite) {
        Random random = new Random();
        return random.nextInt(limite);
    }
}

// Clase Enemigo hereda de SerVivo y tiene diferentes tipos de enemigos
class Enemigo extends SerVivo implements Atacante {
    public Enemigo(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Enemigo: " + nombre);
        System.out.println("Salud: " + salud);
        System.out.println("Fuerza: " + fuerza);
    }

    @Override
    public void atacar(SerVivo enemigo) { // <- cambio aquí
        System.out.println(this.nombre + " ataca a " + enemigo.nombre);
        enemigo.recibirDanio(this.fuerza);
    }
}

public class ArrayGame {
    static int SIZE = 5;
    static char[][] grid = new char[SIZE][SIZE];
    static int playerX = 0, playerY = 0;
    static int goalX, goalY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Permitir al jugador escoger el nombre del personaje
        System.out.print("Introduce el nombre de tu pokemon: ");
        String nombrePersonaje = scanner.nextLine();

        // Crear al personaje con el nombre introducido
        Personaje jugador = new Personaje(nombrePersonaje, 100, 20);
        jugador.mostrarInfo();

        // Inicializar la cuadrícula
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '.'; // Asignar espacios vacíos
            }
        }

        // Colocar el objetivo (enemigo) en una posición aleatoria
        goalX = random.nextInt(SIZE);
        goalY = random.nextInt(SIZE);
        grid[goalX][goalY] = 'E'; // 'E' representa al enemigo

        // Colocar al jugador en la cuadrícula
        grid[playerX][playerY] = 'P'; // 'P' representa al jugador

        // Crear una lista de posibles enemigos con características únicas
        Enemigo[] enemigosPosibles = {
            new Enemigo("Pokémon Tierra", 70, 20),
            new Enemigo("Pokémon Agua", 50, 25),
            new Enemigo("Pokémon Fuego", 60, 30),
            new Enemigo("Pokémon Viento", 40, 15)
        };

        // Seleccionar aleatoriamente un enemigo de la lista
        Enemigo enemigo = enemigosPosibles[random.nextInt(enemigosPosibles.length)];
        enemigo.mostrarInfo();

        // Bucle del juego
        while (true) {
            printGrid();
            System.out.print("Move (WASD): ");
            char move = scanner.next().charAt(0);

            // Eliminar al jugador de su posición anterior
            grid[playerX][playerY] = '.';

            // Procesar el movimiento del jugador
            switch (Character.toUpperCase(move)) {
                case 'W':
                    if (playerX > 0) playerX--;
                    break;
                case 'S':
                    if (playerX < SIZE - 1) playerX++;
                    break;
                case 'A':
                    if (playerY > 0) playerY--;
                    break;
                case 'D':
                    if (playerY < SIZE - 1) playerY++;
                    break;
                default:
                    System.out.println("Movimiento inválido.");
            }

            // Colocar al jugador en la nueva posición
            grid[playerX][playerY] = 'P';

            // Verificar si el jugador ha llegado al objetivo (enemigo)
            if (playerX == goalX && playerY == goalY) {
                if (enemigo.estaVivo()) {
                    System.out.println("¡Has encontrado al enemigo! Comienza la batalla.");
                    while (enemigo.estaVivo() && jugador.estaVivo()) {
                        jugador.atacar(enemigo); // Jugador ataca primero
                        if (enemigo.estaVivo()) {
                            enemigo.atacar(jugador); // Enemigo responde
                        }
                    }

                    if (!enemigo.estaVivo()) {
                        System.out.println("¡Has derrotado al enemigo! ¡Has ganado!");
                    } else {
                        System.out.println("¡El enemigo te ha derrotado!");
                    }
                }
                break;
            }
        }

        scanner.close();
    }

    // Función para imprimir la cuadrícula
    static void printGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}