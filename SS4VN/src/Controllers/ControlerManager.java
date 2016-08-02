package Controllers;
import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by GGG8 on 8/1/2016.
 */
public class ControlerManager implements BaseControllers{
    private Vector<SingleControllers> singleControllersesVector;

    public ControlerManager() {
        singleControllersesVector = new Vector<SingleControllers>();
    }
    public void add(SingleControllers singleControllers){
        this.singleControllersesVector.add(singleControllers);
    }

    @Override
    public void draw(Graphics g) {
        for (SingleControllers singleControllers : this.singleControllersesVector){
            singleControllers.draw(g);
        }
    }

    @Override
    public void run() {
        Iterator<SingleControllers> singleControllersIterator= this.singleControllersesVector.iterator();
      while (singleControllersIterator.hasNext()){
            SingleControllers singleControllers = singleControllersIterator.next();
            if (!singleControllers.getGameObject().isLife())singleControllersIterator.remove();
          else singleControllers.run();

        }

    }
}
