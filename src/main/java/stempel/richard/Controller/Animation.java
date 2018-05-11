package stempel.richard.Controller;

import stempel.richard.Model.Bullet;
import stempel.richard.Model.Enemy;
import stempel.richard.Model.Player;

import java.util.ArrayList;

public class Animation {

    public void gamaLoop(Player player, boolean left, boolean right) {
        if (left) {
            player.goLeft();
        }
        if (right) {
            player.goRight();
        }
    }

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

    public boolean hitplayer (ArrayList<Enemy> enemy, Player player) {
        for (int i = 0; i < enemy.size(); i++) {
            if (player.getPosY() <= enemy.get(i).getPosY() + 50) {
                return true;
            }
        }
        return false;
    }

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
