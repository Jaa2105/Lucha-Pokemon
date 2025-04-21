# ArrayGame

**ArrayGame** es un sencillo juego de combate por turnos desarrollado en Java, donde controlas un personaje en una cuadrícula, moviéndote hasta encontrar y enfrentarte a un enemigo aleatorio.

## Características

- Sistema de movimiento en una cuadrícula 5x5 (WASD).
- Creación de personaje personalizado (nombre, salud, fuerza).
- Sistema de batalla por turnos contra enemigos.
- Enemigos variados con diferentes características.
- Interfaces para atacar y defender.
- Uso de herencia y clases abstractas para modelar los seres vivos.

## Tecnologías utilizadas

- Java SE
- Programación orientada a objetos (OOP)

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tuusuario/ArrayGame.git
   ```

2. Compila el archivo Java:
   ```bash
   javac ArrayGame.java
   ```

3. Ejecuta el programa:
   ```bash
   java ArrayGame
   ```

## Instrucciones de juego

- Al iniciar, introduce el nombre de tu personaje (tipo pokémon).
- Usa las teclas **W** (arriba), **A** (izquierda), **S** (abajo), **D** (derecha) para moverte.
- Busca al enemigo en la cuadrícula.
- Al encontrarlo, comenzará la batalla.
- Gana derrotando al enemigo en combate.

## Estructura del proyecto

- **`SerVivo`**: Clase abstracta base para personajes y enemigos.
- **`Personaje`**: Hereda de `SerVivo` e implementa `Atacante` y `Defensor`.
- **`Enemigo`**: Hereda de `SerVivo` e implementa `Atacante`.
- **`ArrayGame`**: Contiene la lógica principal del juego.
- **Interfaces**:
  - `Atacante`: Define el método `atacar`.
  - `Defensor`: Define el método `defender`.

## Posibles mejoras futuras

- Agregar múltiples niveles.
- Implementar inventario y objetos.
- Mejorar IA de los enemigos.
- Gráficos utilizando bibliotecas como JavaFX o Swing.

## Autor

- **Tu Nombre** - [Tu GitHub](https://github.com/tuusuario)

## Licencia

Este proyecto está bajo la licencia [MIT](LICENSE).

---

❤ï️ ¡Si te gusta este proyecto, no olvides darle una estrella! ✨

