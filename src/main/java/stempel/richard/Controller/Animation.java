package stempel.richard.Controller;

import stempel.richard.Model.Bullet;
import stempel.richard.Model.Enemy;
import stempel.richard.Model.Player;

import java.util.ArrayList;

public class Animation {

    /**
     * The method which moves the ship.
     *
     * @param player is the ship object.
     * @param left is true if the ship will move left.
     * @param right is true if the ship will move right.
     * */

    public void gamaLoop(Player player, boolean left, boolean right) {
        if (left) {
            player.goLeft();
        }
        if (right) {
            player.goRight();
        }
    }

    /**
     * The function which examines if one of the enemies are hit by one of the bullets.
     *
     * @param enemy is the {@code ArrayList} which contains the enemies.
     * @param bullet is the {@code ArrayList} which contains the visible bullets.
     *
     * @return a pair of indexes. The first is the hitted enemy's index and the other is the hitter bullet's index.*/

    public ArrayList<Integer> hitenemy (ArrayList<Enemy> enemy, ArrayList<Bullet> bullet) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < enemy.size(); i++) {
            for (int k = 0; k < bullet.size(); k++) {
                if (bullet.get(k).getBullet().isVisible() && enemy.get(i).getEnemy().isVisible()
                        && bullet.get(k).getPosY() <= enemy.get(i).getPosY() + 50
                        && bullet.get(k).getPosX() >= enemy.get(i).getPosX() - 20
                        && bullet.get(k).getPosX() <= enemy.get(i).getPosX() + 30) {
                    tmp.add(i);
                    tmp.add(k);
                    enemy.get(i).setLife(enemy.get(i).getLife()-1);
                    bullet.get(k).setHit(true);
                    return tmp;
                }
            }
        }
        return tmp;
    }

    /**
     * This function examine if one of the enemies are reached our ship.
     *
     * @param enemy is the {@code ArrayList} which contains the enemies.
     * @param player is the ship object
     *
     * @return true if the player were hit by one of the enemies.*/

    public boolean hitplayer (ArrayList<Enemy> enemy, Player player) {
        for (int i = 0; i < enemy.size(); i++) {
            if (player.getPosY() <= enemy.get(i).getPosY() + 50) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method decides if all of the enemies are hitted(not visible).
     *
     * @param enemy is the {@code ArrayList} which contains the enemies.
     *
     * @return true if none of the enemies are visible.*/

    public boolean isNotVisible (ArrayList<Enemy> enemy) {
        int count = 0;
        for (int i = 0; i < enemy.size(); i++) {
            if (enemy.get(i).getEnemy().isVisible()) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
