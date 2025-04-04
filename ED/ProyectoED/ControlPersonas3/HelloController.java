package org.example.control_personas3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    @FXML
    private Button boton_eliminar, boton_modificar, boton_agregar;

    @FXML
    private TableColumn<persona, String> columna_nombre, columna_apellidos;

    @FXML
    private TableColumn<persona, Integer> columna_edad;

    @FXML
    private TableView<persona> tabla_registrarse;

    private ObservableList<persona> personas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        columna_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columna_apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        columna_edad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        tabla_registrarse.setItems(personas);
    }

    @FXML
    void abrirVentanaAgregarPersona(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("agregar-persona-view.fxml"));
            Parent root = loader.load();

            AgregarPersonaController controller = loader.getController();
            controller.setListaPersonas(personas);

            Stage stage = new Stage();
            stage.setTitle("Agregar nueva persona");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            tabla_registrarse.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void boton_eliminar_on(ActionEvent event) {
        persona seleccionada = tabla_registrarse.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            personas.remove(seleccionada);
        } else {
            System.out.println("Seleccione una persona para eliminar");
        }
    }

    @FXML
    void boton_modificar_on(ActionEvent event) {
        persona seleccionada = tabla_registrarse.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            TextInputDialog dialog = new TextInputDialog(seleccionada.getNombre());
            dialog.setTitle("Modificar Persona");
            dialog.setHeaderText("Ingrese nuevos datos:");

            dialog.setContentText("Nuevo nombre:");
            String nuevoNombre = dialog.showAndWait().orElse(seleccionada.getNombre());

            dialog.setContentText("Nuevos apellidos:");
            String nuevoApellido = dialog.showAndWait().orElse(seleccionada.getApellidos());

            dialog.setContentText("Nueva edad:");
            String nuevaEdadText = dialog.showAndWait().orElse(String.valueOf(seleccionada.getEdad()));

            try {
                int nuevaEdad = Integer.parseInt(nuevaEdadText);
                seleccionada.setNombre(nuevoNombre);
                seleccionada.setApellidos(nuevoApellido);
                seleccionada.setEdad(nuevaEdad);

                tabla_registrarse.refresh();
            } catch (NumberFormatException e) {
                System.err.println("Edad inválida.");
            }
        } else {
            System.out.println("Seleccione una persona para modificar.");
        }
    }
}
