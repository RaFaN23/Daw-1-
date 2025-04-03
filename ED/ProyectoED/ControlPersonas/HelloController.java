package org.example.controldepersonas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    @FXML
    private TableColumn<persona, String> columna_nombre;

    @FXML
    private Button boton_agregar;

    @FXML
    private TextField nombre_textfield;

    @FXML
    private TextField apellidos_textfield;

    @FXML
    private TableColumn<persona, String> columna_apellidos;

    @FXML
    private TableColumn<persona, Integer> columna_edad;

    @FXML
    private TextField edad_textfield;

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
    public void boton_agregar_on(javafx.event.ActionEvent actionEvent) {

        String nombre = nombre_textfield.getText();
        String apellidos = apellidos_textfield.getText();
        String edadText = edad_textfield.getText();


        if (!nombre.isEmpty() && !apellidos.isEmpty() && !edadText.isEmpty()) {
            try {
                int edad = Integer.parseInt(edadText);


                persona nuevapersona = new persona(nombre, apellidos, edad);
                personas.add(nuevapersona);


                nombre_textfield.clear();
                apellidos_textfield.clear();
                edad_textfield.clear();

            } catch (NumberFormatException e) {
                System.err.println("La edad debe ser un número válido");
            }
        }
    }
}