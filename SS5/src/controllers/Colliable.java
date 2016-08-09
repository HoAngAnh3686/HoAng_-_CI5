package controllers;

import models.GameObject;

/**
 * Created by GGG8 on 8/7/2016.
 */
public interface Colliable {
    GameObject getGameObject();
    void onCollide(Colliable colliable);
}
