package org.example.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HelloController {

    @FXML
    private TextField operador_2_textfield;

    @FXML
    private RadioButton multiplicacion_radiobutton;

    @FXML
    private TextField operador_1_textfield;

    @FXML
    private RadioButton sumar_radiobutton;

    @FXML
    private RadioButton restar_radiobutton;

    @FXML
    private Button boton_operar;

    @FXML
    private TextField resultado_textfield;

    @FXML
    private RadioButton division_radiobutton;


    @FXML
    public void sumar_radiobutton_on(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void multiplicacion_radiobutton_on(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void restar_radiobutton_on(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void division_radiobutton_on(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    void boton_operar_on() {
        try {
            double operador1 = Double.parseDouble(operador_1_textfield.getText());
            double operador2 = Double.parseDouble(operador_2_textfield.getText());
            double resultado = 0.0;

            if (sumar_radiobutton.isSelected()) {
                resultado = operador1 + operador2;
            } else if (restar_radiobutton.isSelected()) {
                resultado = operador1 - operador2;
            } else if (multiplicacion_radiobutton.isSelected()) {
                resultado = operador1 * operador2;
            } else if (division_radiobutton.isSelected()) {
                if (operador2 != 0) {
                    resultado = operador1 / operador2;
                } else {
                    resultado_textfield.setText("Error: División por cero");
                    return;
                }
            } else {
                resultado_textfield.setText("Seleccione una operación");
                return;
            }

            resultado_textfield.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            resultado_textfield.setText("Error: Entrada inválida");
        }
    }
    public void initialize() {
        ToggleGroup toggleGroup = new ToggleGroup();

        sumar_radiobutton.setToggleGroup(toggleGroup);
        restar_radiobutton.setToggleGroup(toggleGroup);
        multiplicacion_radiobutton.setToggleGroup(toggleGroup);
        division_radiobutton.setToggleGroup(toggleGroup);
    }

}