package rpg.entities;

import rpg.enums.Stats;
import java.util.HashMap;

public class Player {
    private String name;
    private HashMap<Stats, Integer> stats;

    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
    }

    public String getName() {
        return this.name;
    }

    public HashMap<Stats, Integer> getStats() {
        return this.stats;
    }

    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }

    public void attack(Enemy enemy) {
        int attackPower = this.stats.get(Stats.ATTACK);
        int enemyDefense = enemy.getStats().get(Stats.DEFENSE);
        int damage = Math.max(attackPower - enemyDefense, 0); // Asegúrate de que el daño no sea negativo

        if (damage > 0) {
            enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
            System.out.println(this.name + " ataca a " + enemy.getName() + " por " + damage + " de daño!");
        } else {
            System.out.println(this.name + " ataca a " + enemy.getName() + " pero no causa daño!");
        }
    }

    public void prepareDefense() {
        System.out.println(name + " se está preparando para defenderse.");
        // Lógica de defensa puede ser implementada aquí
    }
}