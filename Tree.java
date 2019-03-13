/**
 * Lightweight part of tree class (coordinates)
 */

import javafx.scene.canvas.GraphicsContext;

class Tree {
    private double x,y;
    private TreeImage treeImage;

    Tree(double x, double y, TreeImage treeImage) {
        this.x = x;
        this.y = y;
        this.treeImage = treeImage;
    }

    void draw(GraphicsContext graphicsContext) {
        treeImage.draw(graphicsContext, x, y);
    }

}
