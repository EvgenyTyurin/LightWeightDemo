import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Heavy part of tree class (image)
 */

class TreeImage {
    private Image treeImage;

    TreeImage(String imgName) {
        BufferedImage img = null;
        try {
            File file = new File(imgName);
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert img != null;
        treeImage = SwingFXUtils.toFXImage(img, null);
    }

    void draw(GraphicsContext graphicsContext, double x, double y) {
        graphicsContext.drawImage(treeImage, x, y);
    }

}
