import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//  w w w  . ja v  a 2  s.c om
public class Datepicker extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage stage) {
    VBox vbox = new VBox(20);
    Scene scene = new Scene(vbox, 400, 400);
    stage.setScene(scene);

    DatePicker checkInDatePicker = new DatePicker();

    vbox.getChildren().add(checkInDatePicker);

    stage.show();
  }
}