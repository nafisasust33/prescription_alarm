/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescription_alarm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Nafisa
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    private YourpresController yourpresController;    
    @FXML
    private Button newpres;
    Prescription_alarm main;
    private ObservableList<Medicine> MedicineData = FXCollections.observableArrayList();
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        /*System.out.println("ok");
         FXMLLoader fxmlLoader= new FXMLLoader(FXMLDocumentController.class.getResource("addpress.fxml"));
         System.out.println("ok");
         fxmlLoader.load();
         System.out.println("ok");
         Scene scene = new Scene(fxmlLoader.getRoot());
         System.out.println("ok");
         Stage stage = new Stage();
         stage.setScene(scene);
         stage.setTitle("Add Prescription");
         stage.show();*/
        
        FXMLLoader fxmlLoader = new FXMLLoader(FXMLDocumentController.class.getResource("addpres.fxml"));
        //System.out.println("ok");
        Parent root = fxmlLoader.load();
        AddpresController addpresController = fxmlLoader.getController();        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Prescription");
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void buttonClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXMLDocumentController.class.getResource("yourpres.fxml"));
        fxmlLoader.load();
        Scene scene = new Scene(fxmlLoader.getRoot());
        yourpresController = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Your Prescription");
        stage.setResizable(false);
        stage.show();
        
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(new File("D:\\netbeans\\prescription_alarm\\prescription_alarm\\prescription_alarm\\Info.csv")));
            String line = "";
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                Medicine data = new Medicine();
                data.setMedicineName(arr[0]);
                data.setInstructions(arr[1]);
                data.setDose(Integer.parseInt(arr[2]));
                data.setContinueFor(Integer.parseInt(arr[3]));
                data.setrepeat(Integer.parseInt(arr[4]));
                data.setHours(Integer.parseInt(arr[5]));
                data.setMinutes(Integer.parseInt(arr[6]));
                //System.out.println(data.getMedicineName());
                MedicineData.add(data);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        yourpresController.showinTable(this);
    }

    public ObservableList<Medicine> getList() {
        return MedicineData;
    }
    
}
