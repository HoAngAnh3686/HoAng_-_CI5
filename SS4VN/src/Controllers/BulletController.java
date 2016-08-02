package Controllers;
import Models.Bullet;
import Models.GameOject;
import views.GameDraw;

/**
 * Created by GGG8 on 8/1/2016.
 */
public class BulletController extends SingleControllers implements Colliable  {
    private static final int SPEED=20;
    public BulletController(Bullet bullet, GameDraw gameDraw) {
        super(bullet, gameDraw);
        this.gameVector.y=-SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if(gameOject.getY() < 100) {
            gameOject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            colliable.getGameOject().destroy();
            this.getGameObject().destroy();
        }
    }
}
