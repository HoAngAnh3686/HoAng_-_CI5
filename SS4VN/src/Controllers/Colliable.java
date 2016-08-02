package Controllers;

import Models.GameOject;

/**
 * Created by GGG8 on 8/3/2016.
 */
public interface Colliable {
    GameOject getGameOject();
    void onCollide(Colliable colliable);
}
