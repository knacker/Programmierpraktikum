//@author maximilian raspe
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

import static java.lang.Math.random;

public class ValueButtonHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {	//malt die anzahl der vierecke
        String t = GUI.field.getText();
        try {
            int num = Integer.parseInt(t);
            ButtonClickHandler.counter = num;
            GUI.lb_text.setText(t + " Klicks");

            GUI.canvas.getGraphicsContext2D().clearRect(0,0, 400, 200);
            for(int i = 1; i <= ButtonClickHandler.counter; i++) {
                GUI.canvas.getGraphicsContext2D().strokeRect(400 / ButtonClickHandler.counter, 200/ ButtonClickHandler.counter, 100 / i, 100 / i);
                GUI.canvas.getGraphicsContext2D().fillRect(400 / ButtonClickHandler.counter, 200/ ButtonClickHandler.counter, 100 / i, 100 / i);
                GUI.canvas.getGraphicsContext2D().setFill(Color.DARKTURQUOISE);
            }
        } catch(NumberFormatException e) {
            System.out.println("Keine Zahl");
        }
    }
}
