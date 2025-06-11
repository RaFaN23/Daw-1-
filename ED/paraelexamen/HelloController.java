package org.example.practica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class HelloController {

    @FXML
    private TextField text_navegabilidad;

    @FXML
    private TextField text_ojos;

    @FXML
    private DatePicker pick_fecha;

    @FXML
    private TextField text_referencia;

    @FXML
    private TextField text_peso;

    @FXML
    private Button boton_guardar;

    @FXML
    private ComboBox<String> combobox_tamanyo;

    @FXML
    private TextField text_modelo;

    @FXML
    private TextField text_pvp;

    @FXML
    private TextField text_color;

    @FXML
    private TextField text_disponibilidad;

    @FXML
    public void initialize() {
        ObservableList<String> tamanos = FXCollections.observableArrayList("Grande", "Mediano", "Pequeño");
        combobox_tamanyo.setItems(tamanos);
        combobox_tamanyo.setValue("Mediano");
    }

    @FXML
    protected void onGuardarClick() {
        String referencia = text_referencia.getText();
        String modelo = text_modelo.getText();
        String tamaño = combobox_tamanyo.getValue();
        String color = text_color.getText();
        String ojos = text_ojos.getText();
        String pvpTexto = text_pvp.getText();
        String disponibilidad = text_disponibilidad.getText();
        String navegabilidad = text_navegabilidad.getText();
        LocalDate fecha = pick_fecha.getValue();
        String pesoTexto = text_peso.getText();

        if (referencia.isEmpty() || modelo.isEmpty() || pvpTexto.isEmpty() || pesoTexto.isEmpty() || fecha == null) {
            showAlert(Alert.AlertType.ERROR, "Campos obligatorios", "Por favor, rellena todos los campos necesarios.");
            return;
        }

        try {
            double pvp = Double.parseDouble(pvpTexto);
            double peso = Double.parseDouble(pesoTexto);

            String sql = "MERGE INTO SEÑUELO USING DUAL ON (referencia = ?) " +
                    "WHEN MATCHED THEN UPDATE SET modelo=?, tamaño=?, color=?, ojos=?, pvp=?, disponibilidad=?, navegabilidad=?, fecha=?, peso=? " +
                    "WHEN NOT MATCHED THEN INSERT (referencia, modelo, tamaño, color, ojos, pvp, disponibilidad, navegabilidad, fecha, peso) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = ConexionDB.conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, referencia); // WHERE

                // UPDATE
                stmt.setString(2, modelo);
                stmt.setString(3, tamaño);
                stmt.setString(4, color);
                stmt.setString(5, ojos);
                stmt.setDouble(6, pvp);
                stmt.setString(7, disponibilidad);
                stmt.setString(8, navegabilidad);
                stmt.setDate(9, Date.valueOf(fecha));
                stmt.setDouble(10, peso);

                // INSERT
                stmt.setString(11, referencia);
                stmt.setString(12, modelo);
                stmt.setString(13, tamaño);
                stmt.setString(14, color);
                stmt.setString(15, ojos);
                stmt.setDouble(16, pvp);
                stmt.setString(17, disponibilidad);
                stmt.setString(18, navegabilidad);
                stmt.setDate(19, Date.valueOf(fecha));
                stmt.setDouble(20, peso);

                stmt.executeUpdate();
                showAlert(Alert.AlertType.INFORMATION, "Éxito", "Señuelo guardado correctamente.");
                limpiarCampos();

            } catch (SQLException e) {
                showAlert(Alert.AlertType.ERROR, "Error SQL", e.getMessage());
            }

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Formato incorrecto", "PVP y Peso deben ser números válidos.");
        }
    }

    private void showAlert(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        text_referencia.clear();
        text_modelo.clear();
        combobox_tamanyo.setValue("Mediano");
        text_color.clear();
        text_ojos.clear();
        text_pvp.clear();
        text_disponibilidad.clear();
        text_navegabilidad.clear();
        pick_fecha.setValue(null);
        text_peso.clear();
    }
}