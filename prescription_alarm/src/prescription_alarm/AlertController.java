/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescription_alarm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AlertController implements Initializable {
    @FXML
    private Button OKButton;
    @FXML
    private Button CancButton;
    @FXML
    private TextField ConfirmText;
    private YourpresController yourpresController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleOKButton(ActionEvent event) {
        String st = ConfirmText.getText();
        if(st.equals("Yes")) yourpresController.ConfirmDeleteAll(true);
        Stage current_stage = (Stage) OKButton.getScene().getWindow();
        current_stage.close();
    }
    
    public void ConfirmDelete() {
        
    }
    public void setYourpresController(YourpresController yourpresController) {
        this.yourpresController = yourpresController;
    }

    @FXML
    private void HandleCancButton(ActionEvent event) {
        Stage current_stage = (Stage) CancButton.getScene().getWindow();
        current_stage.close();
    }
    
}
