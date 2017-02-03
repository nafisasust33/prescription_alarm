/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescription_alarm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddpresController implements Initializable {

    @FXML
    private Button CancelButton;
    @FXML
    private Button SaveButton;
    @FXML
    private TextField name_field;
    @FXML
    private TextField instructions_field;
    @FXML
    private TextField dose_field;
    @FXML
    private TextField continue_field;
    @FXML
    private TextField repeat_field;
    @FXML
    private TextField hours_field;
    @FXML
    private TextField minutes_field;
    @FXML
    private DatePicker dp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void HandleCancelButton(ActionEvent event) {
        Stage current_stage = (Stage) CancelButton.getScene().getWindow();
        current_stage.close();
    }
      /*private static String reverse(String input){
       String date,month,year;
      year= input.substring(0, 4);
      month=input.substring(5, 7);
      date=input.substring(8, 10);
       
       return date+"/"+month+"/"+year;
   }*/

    @FXML
    private void HandleSaveButton(ActionEvent event) throws IOException, ParseException {
        Medicine medicine = new Medicine();
        medicine.setMedicineName(name_field.getText());
        medicine.setInstructions(instructions_field.getText());
        medicine.setDose(Integer.parseInt(dose_field.getText()));
        medicine.setContinueFor(Integer.parseInt(continue_field.getText()));
        medicine.setrepeat(Integer.parseInt(repeat_field.getText()));
        medicine.setHours(Integer.parseInt(hours_field.getText()));
        medicine.setMinutes(Integer.parseInt(minutes_field.getText()));

        String st =dp.getEditor().getText();
        DateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
        //reverse(st);
        System.out.println(st);
        DateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy");
        String formattedDate = outputFormat.format(inputFormat.parse(st));
        medicine.setStart(formattedDate);

//        st = hours_field.getText() + ":" + minutes_field.getText() + " " + st;
//        inputFormat = new SimpleDateFormat("HH:mm dd-MM");
//        outputFormat = new SimpleDateFormat("dd MMMM hh:mm a");
//        formattedDate = outputFormat.format(inputFormat.parse(st));
//        medicine.setRemin(formattedDate);
//
//        data.setDatePassed(Integer.parseInt(remind_month.getText()), (Integer.parseInt(remind_date.getText())));
//       
//        st = data.getEvent_name() + "," + data.getEvent_at() + "," + data.getRemind_me_at()  + "," + data.isDatePassed() + "\n";
//        //System.out.println(st);
//        WriteinFile(st);
//        table.getItems().add(data);
//        event_name.clear();
//        dp.getEditor().clear();
//        remind_date.clear();
//        remind_month.clear();
//        remind_hour.clear();
//        remind_minute.clear();
        // MedicineTable.getItems().add(medicine);
        try {
            File file = new File("Info.csv");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(name_field.getText());
            bw.write(",");
            bw.write(instructions_field.getText());
            bw.write(",");
            bw.write(dose_field.getText());
            bw.write(",");
            bw.write(continue_field.getText());
            bw.write(",");
            bw.write(repeat_field.getText());
            bw.write(",");
            bw.write(hours_field.getText());
            bw.write(",");
            bw.write(minutes_field.getText());
            bw.write(",");
            bw.write(formattedDate);
            bw.newLine();
            bw.close();
            //fileWriter.append(String.valueOf(medicine.getMedicineName()));
        } catch (IOException e) {
        }

        Stage current_stage = (Stage) SaveButton.getScene().getWindow();
        current_stage.close();

        /*FXMLLoader fxmlLoader = new FXMLLoader(FXMLDocumentController.class.getResource("yourpres.fxml"));
         //System.out.println("ok");
         Parent root = fxmlLoader.load();
         YourpresController YourpresController = fxmlLoader.getController();
         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.setScene(scene);
         stage.setTitle("Your Prescription");
         stage.show();*/
         //System.out.println("Date "+dp.getAccessibleText());
    }

}
