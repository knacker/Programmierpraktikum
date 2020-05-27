//@author maximilian raspe
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;


public class GUI extends Application {

    public static Label lb_text;
    Button btn_click1;
    Button btn_click2;
    public static TextField field;
    ButtonClickHandler handler1 = new ButtonClickHandler();
    ValueButtonHandler handler2 = new ValueButtonHandler();
    public static Canvas canvas = new Canvas(400, 200);


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        lb_text = new Label("0 Klicks");
        field = new TextField("5");
        btn_click1 = new Button("Klick");
        btn_click2 = new Button("Setze Klicks");
        canvas.getGraphicsContext2D().strokeRect(100 ,100,100,100);
        btn_click1.setOnAction(handler1);
        btn_click2.setOnAction(handler2);


        primaryStage.setTitle("GUI");
        VBox box = new VBox();

        box.getChildren().addAll(lb_text, btn_click1, btn_click2, field, canvas);

        Scene scene = new Scene(box, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
