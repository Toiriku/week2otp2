package com.example.localdemoenkoin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Map;

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

    private Map<String, String> localizedStrings;

    public void initialize() {
        setLanguage(new Locale("en"));
    }

    private void setLanguage(Locale locale) {
        lblResult.setText("");
        localizedStrings = LocalizationService.getLocalizedStrings(locale);

        lblWeight.setText(localizedStrings.getOrDefault("weight", "Weight"));
        lblHeight.setText(localizedStrings.getOrDefault("height", "Height"));
        btnCalculate.setText(localizedStrings.getOrDefault("calculate", "Calculate"));

        localizedStrings.put("language_code", locale.getLanguage());

        btnEN.setText("EN");
        btnFR.setText("FR");
        btnUR.setText("UR");
        btnVI.setText("VI");
    }

    @FXML
    public void onCalculateClick(ActionEvent actionEvent) {
        try {
            double weight = Double.parseDouble(txtWeight.getText());
            double height = Double.parseDouble(txtHeight.getText()) / 100.0;
            double bmi = weight / (height * height);

            DecimalFormat df = new DecimalFormat("#0.00");

            lblResult.setText(localizedStrings.getOrDefault("result", "Your BMI is") + " " + df.format(bmi));

            String language = localizedStrings.get("language_code");
            BMIResultService.saveResult(weight, height * 100, bmi, language);

        } catch (NumberFormatException e) {
            lblResult.setText(localizedStrings.getOrDefault("invalid", "Invalid input"));
        }
    }

    @FXML public void onENClick(ActionEvent event) { setLanguage(new Locale("en")); }
    @FXML public void onFRClick(ActionEvent event) { setLanguage(new Locale("fr")); }
    @FXML public void onURClick(ActionEvent event) { setLanguage(new Locale("ur")); }
    @FXML public void onVIClick(ActionEvent event) { setLanguage(new Locale("vi")); }

}
