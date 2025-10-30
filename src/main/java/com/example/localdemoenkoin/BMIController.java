package com.example.localdemoenkoin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Locale;
import java.util.ResourceBundle;

public class BMIController {
    @FXML private Label lblWeight;
    @FXML private Label lblHeight;
    @FXML private Label lblResult;
    @FXML private TextField txtWeight;
    @FXML private TextField txtHeight;
    @FXML private Button btnCalculate;
    @FXML private Button btnEN;
    @FXML private Button btnFR;
    @FXML private Button btnUR;
    @FXML private Button btnVI;

    private ResourceBundle rb;

    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    public void setLanguage(Locale locale) {
        try {
            rb = ResourceBundle.getBundle("com.example.localdemoenkoin.bundle1", locale);
            updateLabels();
        } catch (Exception e) {
            lblResult.setText("Missing resource bundle for " + locale);
        }
    }

    public void updateLabels() {
        lblWeight.setText(rb.getString("lblWeight.text"));
        lblHeight.setText(rb.getString("lblHeight.text"));
        btnCalculate.setText(rb.getString("btnCalculate.text"));
        lblResult.setText("");
        btnEN.setText("EN");
        btnFR.setText("FR");
        btnUR.setText("UR");
        btnVI.setText("VI");
    }

    @FXML
    public void onCalculateClick(ActionEvent event) {
        try {
            double weight = Double.parseDouble(txtWeight.getText());
            double height = Double.parseDouble(txtHeight.getText()) / 100.0;
            double bmi = weight / (height * height);
            String bmiString = String.format("%.2f", bmi);
            lblResult.setText(rb.getString("lblResult.text") + " " + bmiString);
        } catch (NumberFormatException e) {
            lblResult.setText(rb.getString("lblInvalid.text"));
        }
    }

    @FXML
    public void onENClick(ActionEvent event) {
        setLanguage(new Locale("en", "US"));
    }

    @FXML
    public void onFRClick(ActionEvent event) {
        setLanguage(new Locale("fr", "FR"));
    }

    @FXML
    public void onURClick(ActionEvent event) {
        setLanguage(new Locale("ur", "PK"));
    }

    @FXML
    public void onVIClick(ActionEvent event) {
        setLanguage(new Locale("vi", "VN"));
    }
}
