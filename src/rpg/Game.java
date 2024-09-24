package rpg;

import rpg.entities.Player;
import rpg.entities.Enemy;

import java.util.Scanner;

public class Game {
    private Player player;
    private Enemy enemy;

    public Game() {
        this.player = new Player("Hero");
        this.enemy = new Enemy("Goblin");
    }

    public void startGame() {
        System.out.println("¡El combate ha comenzado entre " + player.getName() + " y " + enemy.getName() + "!");

        while (player.isAlive() && enemy.isAlive()) {
            playerTurn();
            if (enemy.isAlive()) {
                enemyTurn();
            }
        }

        displayResult();
    }

    private void playerTurn() {
        System.out.println("\nTurno de " + player.getName());
        System.out.println("1. Atacar");
        System.out.println("2. Defenderse");
        System.out.println("3. Usar poción");
        System.out.print("Elige una opción: ");

        int option = getPlayerOption();
        switch (option) {
            case 1:
                player.attack(enemy); // Atacar al enemigo
                break;
            case 2:
                player.prepareDefense(); // Prepararse para defenderse
                break;
            case 3:
                System.out.println(player.getName() + " usa una poción."); // Lógica para usar poción
                break;
            default:
                System.out.println("Opción inválida. Se pierde el turno.");
                break;
        }
    }

    private void enemyTurn() {
        System.out.println("\nTurno de " + enemy.getName());
        enemy.attack(player); // El enemigo ataca al jugador
    }

    private int getPlayerOption() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        if (scanner.hasNextInt()) {
            option = scanner.nextInt();
        } else {
            System.out.println("Entrada inválida. Se pierde el turno.");
            scanner.next(); // Limpiar entrada no válida
        }

        return option;
    }

    private void displayResult() {
        if (player.isAlive()) {
            System.out.println("¡Has derrotado al enemigo " + enemy.getName() + "!");
        } else {
            System.out.println("Juego terminado. Fuiste derrotado por " + enemy.getName() + ".");
        }
    }
}