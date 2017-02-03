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
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
//import prescription_alarm.prescription_alarm;
//import Prescription_alarm.Medicine;

/**
 * FXML Controller class
 *
 * @author User
 */
public class YourpresController implements Initializable {

    @FXML
    private TableView<Medicine> MedicineTable;
    @FXML
    private TableColumn<Medicine, String> MedicineNameColumn;
    @FXML
    private TableColumn<Medicine, String> InstructionsColumn;
    @FXML
    private TableColumn<Medicine, Integer> DoseColumn;

    // Reference to the main application.
    private Prescription_alarm Prescription_alarm;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button DeleteAll;
    @FXML
    private Button BackButton;
    private AlertController alertController;
    Prescription_alarm main;
    private FXMLDocumentController fxmlDocumentController;

    //private ObservableList<Medicine> MedicineData = FXCollections.observableArrayList();
    BufferedReader br = null;

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public YourpresController() throws IOException {
        /*try {
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
        }*/
       
        //this.MedicineTable.setItems(MedicineData);
    }
    public void showinTable(FXMLDocumentController fxmlDocumentController) {
        this.fxmlDocumentController = fxmlDocumentController;
        MedicineTable.setItems(fxmlDocumentController.getList());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MedicineTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        MedicineNameColumn.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
        InstructionsColumn.setCellValueFactory(new PropertyValueFactory<>("Instructions"));
        DoseColumn.setCellValueFactory(new PropertyValueFactory<>("Dose"));
    }
    
   /*public void showinTable(ObservableList a) {
        
        this.MedicineTable.setItems(a);
    }*/

    /*public void setPrescription_alarm(Prescription_alarm Prescription_alarm) {
        this.Prescription_alarm = Prescription_alarm;
        // Add observable list data to the table
        MedicineTable.setItems(Prescription_alarm.getMedicineData());
    }*/

   
    @FXML
    private void HandleDeleteButton(ActionEvent event) {
        ObservableList<Medicine> DataSelected, allData;
        allData = MedicineTable.getItems();
        DataSelected = MedicineTable.getSelectionModel().getSelectedItems();
        allData.removeAll(DataSelected);
        BufferedWriter bw = null;
        try {
            File file = new File("D:\\netbeans\\prescription_alarm\\prescription_alarm\\prescription_alarm\\Info.csv");
            file.delete();
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            bw = new BufferedWriter(fileWriter);
            bw.write("Medicine Name, Instructions, Dose, Continue for, Repeat, Hours, Minute\n");
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for (Medicine data : allData) {
                String st =  data.getMedicineName() + "," + data.getInstructions() + "," + data.getDose() +"\n";
                bw.write(st);
            }
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void HandleDeleteAll(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(YourpresController.class.getResource("Alert.fxml"));
        fXMLLoader.load();
        alertController = fXMLLoader.getController();
        alertController.setYourpresController(this);
        Scene scene = new Scene(fXMLLoader.getRoot());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Sure?");
        stage.show();
    }

    public void ConfirmDeleteAll(boolean flag) {
        if (flag) {
            ObservableList<Medicine> allData;
            allData = MedicineTable.getItems();
            allData.clear();
            try {
                File file = new File("D:\\netbeans\\prescription_alarm\\prescription_alarm\\prescription_alarm\\Info.csv");
                file.delete();
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write("Medicine Name, Instructions, Dose\n");
                System.out.println("Done");
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void HandleBackButton(ActionEvent event) throws IOException {
        Stage current_stage = (Stage) DeleteButton.getScene().getWindow();
        current_stage.close();
        /*FXMLLoader fxmlLoader = new FXMLLoader(FXMLDocumentController.class.getResource("FXMLDocument.fxml"));
        Parent root = fxmlLoader.load();
        FXMLDocumentController fxmlDocumentController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();*/

    }

}
