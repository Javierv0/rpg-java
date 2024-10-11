package rpg.entities;

import rpg.enums.Stats;
import java.util.HashMap;

public class Enemy {

    private String name;
    private HashMap<Stats, Integer> stats;

    public Enemy(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.stats.put(Stats.MAX_HP, 50);
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 5);
        this.stats.put(Stats.DEFENSE, 2);
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

    public void attack(Player player) {
        int attackPower = this.stats.get(Stats.ATTACK);
        int playerDefense = player.getStats().get(Stats.DEFENSE);
        int damage = Math.max(attackPower - playerDefense, 0); // Asegúrate de que el daño no sea negativo

        if (damage > 0) {
            player.getStats().put(Stats.HP, player.getStats().get(Stats.HP) - damage);
            System.out.println(this.name + " ataca a " + player.getName() + " por " + damage + " de daño!");
        } else {
            System.out.println(this.name + " ataca a " + player.getName() + " pero no causa daño!");
        }
    }
}