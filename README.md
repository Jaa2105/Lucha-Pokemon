# ArrayGame

**ArrayGame** is a simple turn-based combat game developed in Java. You control a character on a grid, moving around to find and face a random enemy.

## Features

- 5x5 grid-based movement system (WASD).
- Custom character creation (Name, Health, Strength).
- Turn-based battle system against enemies.
- Varied enemies with different characteristics.
- Attack and Defense interfaces.
- Use of inheritance and abstract classes to model living beings.

## Technologies Used

- Java SE
- Object-Oriented Programming (OOP)

## Installation

1. Clone this repository:
   ```bash
   git clone [https://github.com/yourusername/ArrayGame.git](https://github.com/yourusername/ArrayGame.git)

Compile the Java file:
javac ArrayGame.java

Run the program:
java ArrayGame

## How to Play
- At the start, enter your character's name (Pokémon style).

- Use the keys W (up), A (left), S (down), and D (right) to move.

- Search for the enemy on the grid.

- Once found, the battle will begin.

- Win by defeating the enemy in combat.

## Project Structure
- SerVivo (Living Being): Abstract base class for characters and enemies.

- Personaje (Character): Inherits from SerVivo and implements Atacante and Defensor.

- Enemigo (Enemy): Inherits from SerVivo and implements Atacante.

- ArrayGame: Contains the main game logic.

Interfaces:

  - Atacante (Attacker): Defines the atacar method.

  - Defensor (Defender): Defines the defender method.

## Future Improvements

- Add multiple levels.

- Implement an inventory and items system.

- Improve enemy AI.

- Add graphics using libraries like JavaFX or Swing.

## Author

Jaime Alonso Amador - Jaa2105

## License

This project is licensed under the MIT License.

