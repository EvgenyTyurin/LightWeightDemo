import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

/**
 * Lightweight pattern demo
 * Mar 2019 Evgeny Tyurin
 */

public class LightWeightDemo extends Application {

    private static final double WINDOW_WIDTH = 1000;
    private static final double WINDOW_HEIGHT = 1000;
    private static final String TREE_GREEN_PNG = "src/png/tree_green.png";
    public static final int TREES_NUMBER = 100000;

    @Override
    public void start(Stage primaryStage) {
        // Preparing JavaFX stuff...
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane, WINDOW_WIDTH, WINDOW_HEIGHT, Color.WHITE);
        Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        // Generate constant heavy part with image
        TreeImage treeImage = new TreeImage(TREE_GREEN_PNG);
        // Generate Lightweight changing part - tree coordinates
        Random random = new Random();
        for (int treeCounter = 1; treeCounter <= TREES_NUMBER; treeCounter++) {
            double x = random.nextDouble() * WINDOW_WIDTH;
            double y = random.nextDouble() * WINDOW_HEIGHT;
            Tree tree = new Tree(x, y, treeImage);
            tree.draw(graphicsContext);
        }

        // Show window with drawings
        stackPane.getChildren().addAll(canvas);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
