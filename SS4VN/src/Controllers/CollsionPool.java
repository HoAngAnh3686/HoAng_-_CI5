package Controllers;

import Models.GameOject;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by GGG8 on 8/3/2016.
 */
public class CollsionPool implements BaseControllers{

    private Vector<Colliable> colliableVector;

    private CollsionPool() {
        colliableVector = new Vector<Colliable>();
    }

    public void add(Colliable colliable) {
        this.colliableVector.add(colliable);
    }


    @Override
    public void run() {
        for(int i = 0; i < colliableVector.size() - 1; i ++) {
            for(int j = i + 1; j < colliableVector.size(); j++) {
                Colliable ci = colliableVector.get(i);
                Colliable cj = colliableVector.get(j);

                GameOject gi = ci.getGameOject();
                GameOject gj = cj.getGameOject();

                if(gi.overlap(gj)) {
                    ci.onCollide(cj);
                    cj.onCollide(ci);
                }
            }
        }

        Iterator<Colliable> colliableIterator = colliableVector.iterator();
        while(colliableIterator.hasNext()) {
            Colliable colliable = colliableIterator.next();
            if(!colliable.getGameOject().isLife())
                colliableIterator.remove();
        }
    }

    @Override
    public void draw(Graphics g) {

    }

    public static final CollsionPool instance = new CollsionPool();
}
