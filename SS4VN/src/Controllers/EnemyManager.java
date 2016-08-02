package Controllers;

import Models.EnemyBullet;
import Models.EnemyPlane;
import Utils.Utils;
import views.ImageDraw;
import java.util.Random;


/**
 * Created by GGG8 on 8/1/2016.
 */
public class EnemyManager extends ControlerManager {
    private EnemyManager() {
        super();

        }

    @Override
    public void run() {
        super.run();
            Random rd = new Random();
            EnemyController enemyController = new EnemyController(
                    new EnemyPlane(rd.nextInt(600), rd.nextInt(200)),
                    new ImageDraw(Utils.loadImage("resources/plane1.png")));
            this.add(enemyController);
            EnemyBulletController enemyBulletController = new EnemyBulletController(
                    new EnemyBullet(enemyController.gameOject.getX(), enemyController.gameOject.getY()),
                    new ImageDraw(Utils.loadImage("resources/enemy_bullet.png")));
            this.add(enemyBulletController);

        }

    public final static EnemyManager instance = new EnemyManager();
}
