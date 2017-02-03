/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescription_alarm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Nafisa
 */
public class Prescription_alarm extends Application {
    private Stage primaryStage;
    private ObservableList<Medicine> MedicineData = FXCollections.observableArrayList();
    YourpresController yourpresController;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        FXMLLoader fxmlLoader= new FXMLLoader(Prescription_alarm.class.getResource("FXMLDocument.fxml"));
        fxmlLoader.load();
        Scene scene = new Scene(fxmlLoader.getRoot());
        stage.setScene(scene);
        stage.setTitle("Prescription Alarm");
        stage.show();
        
        File file = new File("\\Info.csv");
        if (!file.exists()) {
            file.createNewFile();
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write("Medicine Name, Instructions, Dose, Continue for, Repeat, Hours, Minute\n");
                //System.out.println("Done");
                bw.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
        
        //FXMLLoader fxmlLoader1= new FXMLLoader(Prescription_alarm.class.getResource("yourpres.fxml"));
        //fxmlLoader1.load();
        //yourpresController = fxmlLoader1.getController(); 
        //yourpresController.showinTable(this);
        
    }
    public ObservableList<Medicine> getList() {
        return MedicineData;
    }
    /**
     * Constructor
     */
    public Prescription_alarm() {
        // Add some sample data
        //MedicineData.add(new Medicine("aa", "aa", 1, 2, 3));
    }

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
