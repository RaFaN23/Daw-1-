package org.example.control_personas3;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AgregarPersonaController {

    @FXML
    private TextField nombre_textfield, apellidos_textfield, edad_textfield;

    private ObservableList<persona> listaPersonas;

    public void setListaPersonas(ObservableList<persona> personas) {
        this.listaPersonas = personas;
    }

    @FXML
    void guardarPersona(ActionEvent event) {
        String nombre = nombre_textfield.getText().trim();
        String apellidos = apellidos_textfield.getText().trim();
        String edadText = edad_textfield.getText().trim();

        if (nombre.isEmpty() || apellidos.isEmpty() || edadText.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Rellena todos los campos.").show();
            return;
        }

        try {
            int edad = Integer.parseInt(edadText);
            persona nueva = new persona(nombre, apellidos, edad);
            listaPersonas.add(nueva);

            new Alert(Alert.AlertType.INFORMATION, "Persona agregada correctamente.").show();
            ((Stage) nombre_textfield.getScene().getWindow()).close();
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Edad inválida.").show();
        }
    }

    @FXML
    void cancelar(ActionEvent event) {
        ((Stage) nombre_textfield.getScene().getWindow()).close();
    }
}
