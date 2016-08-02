package Controllers;

import Models.GameOject;
import Models.GameVector;
import views.GameDraw;

import java.awt.*;

/**
 * Created by GGG8 on 8/1/2016.
 */
public class SingleControllers implements BaseControllers,Colliable{
    protected GameOject gameOject;
    private GameDraw gameDraw;
    protected GameVector gameVector;

    public SingleControllers(GameOject gameOject, GameDraw gameDraw) {
        this.gameOject = gameOject;
        this.gameDraw = gameDraw;
        this.gameVector= new GameVector();
    }
    public GameOject getGameObject() {
        return gameOject;
    }
    @Override
    public void draw(Graphics g) {
        gameDraw.draw(g,gameOject);
    }

    @Override
    public void run() {
        gameOject.move(this.gameVector);
    }

    @Override
    public GameOject getGameOject() {
        return gameOject;
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
