package view;

import controller.PetController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;


public class PetView extends Application {
    private PetController controller;
    private GraphicsContext gc;
    private final int canvasSize = 400;
    private ImageView img;
    private boolean flip;
    private SnapshotParameters params;
    private double mouseX, mouseY;

    // !!!!!!!!!!!!!!!!!!1
    // Is this supposed to move only when mouse moves and event onmousemoved triggers?
    // or is the pet supposed to keep moving while mouse is hovering over the canvas
    // but not moving and not triggering the movement event?
    // true == pet moves constantly
    // false == pet stops when mouse stops moving WHILE hovering still over the canvas
    // CLICKING switches between modes
    private boolean useBG = true;


    @Override
    public void start(Stage stage) throws Exception {
        controller = new PetController(this);
        img = new ImageView(controller.getImg());
        Canvas canvas = new Canvas(canvasSize, canvasSize);
        gc = canvas.getGraphicsContext2D();

        params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        AnimationTimer animator = new AnimationTimer() {
            @Override
            public void handle(long l) {
                controller.update();
                updateCanvas();
            }
        };

        canvas.setOnMouseClicked(event -> {
            if (useBG)
                animator.stop();
            else
                animator.start();
            useBG = !useBG;
        });

        canvas.setOnMouseMoved(event -> {
            mouseX = event.getX(); mouseY = event.getY();
            controller.target(mouseX, mouseY);
            flip = mouseX < controller.getX();

            if(useBG)
                animator.start();
            else{
                controller.update(mouseX, mouseY);
                updateCanvas();
            }
        });

        canvas.setOnMouseExited(event -> {
            animator.stop();
        });

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, canvasSize, canvasSize);

        stage.setTitle("Cute Pet");
        stage.setScene(scene);
        stage.show();
    }

    public synchronized void updateCanvas(){
        gc.clearRect(0, 0, canvasSize, canvasSize);
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, canvasSize, canvasSize);

        img.setRotationAxis(Rotate.Y_AXIS);
        if (flip) img.setRotate(180);
        else img.setRotate(0);

        gc.drawImage(img.snapshot(params, null)
                , controller.getX()-(img.getImage().getWidth()/2)
                , controller.getY()-(img.getImage().getHeight()/2));
    }
}
