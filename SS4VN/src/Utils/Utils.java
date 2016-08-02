package Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by GGG8 on 7/31/2016.
 */
public class Utils {
    public static Image loadImage(String string){
        try {
            return ImageIO.read(new File(string));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
