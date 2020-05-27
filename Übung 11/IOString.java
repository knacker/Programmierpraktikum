import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;

public class IOString extends Application {

    public static void main(String[] args) throws IOException {
        launch(args);
        leseAusDatei("test");
        schreibeInDatei("text", "test");
    }

    public static void schreibeInDatei(String text, String filename) throws IOException {

        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
    }
    public static String leseAusDatei(String dateiname) throws IOException {

        String dateitext;
        String ausgabe = "";

        BufferedReader br = null;
        FileReader fr = null;

        fr = new FileReader(dateiname);
        br = new BufferedReader(fr);
        while((dateitext = br.readLine()) != null) {
            ausgabe += dateitext;
        }
        return ausgabe;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lb_text = new Label("text");
        TextField field = new TextField("text");
        TextArea area = new TextArea("text");
        Button btn_click1 = new Button("lesen");
        Button btn_click2 = new Button("schreiben");

        btn_click1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    leseAusDatei("test");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_click2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    schreibeInDatei("text", "test");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
