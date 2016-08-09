package controllers;

import models.Grift;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by GGG8 on 8/9/2016.
 */
public class GriftManager extends ControllerManager {
    private int count;

    private GriftManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        Random rand = new Random();
        if(count == 500) {
            count = 0;
            int enX = rand.nextInt(600);
            int enY = rand.nextInt(600);
            GriftController griftController = new GriftController(
                    new Grift(enX, enY),
                    new ImageDrawer("resources/enemy_plane_yellow_1.png")
            );
            this.add(griftController);
        }
        else if (count == 250) {
            int enX = rand.nextInt(700);
            int enY = 0;
            GriftControllers griftController = new GriftControllers(
                    new Grift(enX,enY),
                    new ImageDrawer("resources/plane1.png")
            );
            this.add(griftController);
        }
    }
    public final static GriftManager instance = new GriftManager();

}
