package org.example.practica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;

public class Tabla {
    // Elementos del FXML
    @FXML private Button boton_tabla;
    @FXML private ComboBox<String> combobox_tabla;
    @FXML private TextField modelo_tabla;
    @FXML private TableView<Senuelo> tablaSenuelos;
    @FXML private TableColumn<Senuelo, String> colModelo;
    @FXML private TableColumn<Senuelo, String> colTamanyo;
    @FXML private TableColumn<Senuelo, String> colColor;
    @FXML private TableColumn<Senuelo, String> colNavegabilidad;
    @FXML private TableColumn<Senuelo, String> colOjos;
    @FXML private TableColumn<Senuelo, Double> colPeso;
    @FXML private TableColumn<Senuelo, String> colDisponibilidad;
    @FXML private TableColumn<Senuelo, Double> colPVP;
    @FXML private TableColumn<Senuelo, String> colReferencia;

    private ObservableList<Senuelo> datosSenuelos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar ComboBox
        combobox_tabla.setItems(FXCollections.observableArrayList("Todos", "Grande", "Mediano", "Pequeño"));
        combobox_tabla.setValue("Todos");

        // Configurar columnas de la tabla
        colReferencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colTamanyo.setCellValueFactory(new PropertyValueFactory<>("tamanyo"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colNavegabilidad.setCellValueFactory(new PropertyValueFactory<>("navegabilidad"));
        colOjos.setCellValueFactory(new PropertyValueFactory<>("ojos"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colDisponibilidad.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));
        colPVP.setCellValueFactory(new PropertyValueFactory<>("pvp"));

        // Cargar datos
        cargarDatosDeBD();

        // Configurar filtros
        configurarFiltros();
    }

    private void cargarDatosDeBD() {
        datosSenuelos.clear();

        String sql = "SELECT * FROM SEÑUELO";

        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Senuelo senuelo = new Senuelo(
                        rs.getString("referencia"),
                        rs.getString("modelo"),
                        rs.getString("tamaño"),
                        rs.getString("color"),
                        rs.getString("navegabilidad"),
                        rs.getString("ojos"),
                        rs.getDouble("peso"),
                        rs.getString("disponibilidad"),
                        rs.getDouble("pvp")
                );
                datosSenuelos.add(senuelo);
            }

            // Aplicar filtros
            aplicarFiltros();

        } catch (SQLException e) {
            mostrarAlerta("Error al cargar datos: " + e.getMessage());
        }
    }

    private void configurarFiltros() {
        // Listener para cambios en los filtros
        modelo_tabla.textProperty().addListener((obs, oldVal, newVal) -> aplicarFiltros());
        combobox_tabla.valueProperty().addListener((obs, oldVal, newVal) -> aplicarFiltros());
    }

    private void aplicarFiltros() {
        FilteredList<Senuelo> datosFiltrados = new FilteredList<>(datosSenuelos, senuelo -> {
            // Filtro por modelo
            String filtroModelo = modelo_tabla.getText().toLowerCase();
            boolean coincideModelo = senuelo.getModelo().toLowerCase().contains(filtroModelo);

            // Filtro por tamaño
            String tamanyoSeleccionado = combobox_tabla.getValue();
            boolean coincideTamanyo = tamanyoSeleccionado.equals("Todos") ||
                    senuelo.getTamanyo().equalsIgnoreCase(tamanyoSeleccionado);

            return coincideModelo && coincideTamanyo;
        });

        SortedList<Senuelo> datosOrdenados = new SortedList<>(datosFiltrados);
        datosOrdenados.comparatorProperty().bind(tablaSenuelos.comparatorProperty());
        tablaSenuelos.setItems(datosOrdenados);
    }

    @FXML
    private void handleBotonTabla() {
        // Acción para el botón "nuevo"
        modelo_tabla.clear();
        combobox_tabla.setValue("Todos");
        cargarDatosDeBD();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}