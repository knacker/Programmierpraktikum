//@author maximilian raspe
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class ButtonClickHandler implements EventHandler<ActionEvent> {	
    public static int counter = 0;
    @Override
    public void handle(ActionEvent event) {	//setzt die klickzahl höher und malt die vierecke
        counter++;
        GUI.lb_text.setText(counter + " Klicks");
        GUI.canvas.getGraphicsContext2D().clearRect(0,0, 400, 200);
        for(int i = 1; i <= counter; i++) {
            GUI.canvas.getGraphicsContext2D().strokeRect(400 / counter, 200/ counter, 100 / i, 100 / i);
            GUI.canvas.getGraphicsContext2D().fillRect(400 / ButtonClickHandler.counter, 200/ ButtonClickHandler.counter, 100 / i, 100 / i);
            GUI.canvas.getGraphicsContext2D().setFill(Color.DARKTURQUOISE);
        }

    }

}
