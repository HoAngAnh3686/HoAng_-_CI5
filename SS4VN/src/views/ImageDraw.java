package views;

import Models.GameOject;

import java.awt.*;

/**
 * Created by GGG8 on 7/31/2016.
 */
public class ImageDraw implements GameDraw {
    private Image image;

    public ImageDraw(Image image) {
        this.image = image;
    }

    @Override
    public void draw(Graphics g, GameOject gameOject) {
        g.drawImage(image,gameOject.getX(),gameOject.getY(),
                gameOject.getWidth(),gameOject.getHight(),null);
    }
}
