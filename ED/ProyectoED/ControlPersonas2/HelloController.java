package org.example.control_persona2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    @FXML
    private Button boton_eliminar;

    @FXML
    private Button boton_modificar;

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
    public void boton_agregar_on(ActionEvent actionEvent) {
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


    @FXML
    void boton_modificar_on(ActionEvent event) {
        persona seleccionada = tabla_registrarse.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            String nuevoNombre = nombre_textfield.getText().trim();
            String nuevoApellido = apellidos_textfield.getText().trim();
            String nuevaEdadText = edad_textfield.getText().trim();

            if (!nuevoNombre.isEmpty() && !nuevoApellido.isEmpty() && !nuevaEdadText.isEmpty()) {
                try {
                    int nuevaEdad = Integer.parseInt(nuevaEdadText);


                    seleccionada.setNombre(nuevoNombre);
                    seleccionada.setApellidos(nuevoApellido);
                    seleccionada.setEdad(nuevaEdad);

                    nombre_textfield.clear();
                    apellidos_textfield.clear();
                    edad_textfield.clear();


                    tabla_registrarse.refresh();
                } catch (NumberFormatException e) {
                    System.err.println("Error: La edad debe ser un número válido");
                }
            } else {
                System.out.println("Todos los campos deben estar llenos para modificar.");
            }
        } else {
            System.out.println("Seleccione una persona para modificar.");
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
}
