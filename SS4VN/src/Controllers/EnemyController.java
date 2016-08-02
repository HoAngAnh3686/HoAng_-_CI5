package Controllers;

import Models.EnemyPlane;
import Models.GameOject;
import views.GameDraw;

import java.util.Random;

/**
 * Created by GGG8 on 8/1/2016.
 */
public class EnemyController extends SingleControllers implements Colliable {
    private static final int SPEED=10;

    public EnemyController(EnemyPlane enemyPlane, GameDraw gameDraw) {
        super(enemyPlane, gameDraw);
        Random rd= new Random();
        if (rd.nextInt(2)==0) {
            this.gameVector.y= SPEED;
        }
        else this.gameVector.x=SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if(gameOject.getY() > 700) {
            gameOject.destroy();
        }
    }

}
