import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from Datos import *

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        uic.loadUi("Dell_app.ui", self)  # Carga el archivo .ui directamente
        self.stackedWidget.setCurrentWidget(self.pagina_inicio)
        #botones para cambiar de pestaña
        self.inicio_boton.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.pagina_inicio))
        self.nuevo_boton.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.pagina_nuevo))
        self.borrar_boton.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.pagina_borrar))
        self.editar_boton.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.pagina_editar))
        self.ver_boton.clicked.connect(self.cargar_datos_tabla)
        #botones funcion
        self.actualizar.clicked.connect(self.crear_nuevo_perifericos)
        self.borrar.clicked.connect(self.borrar_nuevo_perifericos)
        self.ver_datos_boton_borrar.clicked.connect(self.ver_datos_borrar)
        self.ampliar.clicked.connect(self.ampliar_ventana)
        self.desampliar.clicked.connect(self.desampliar_ventana)
        self.editar.clicked.connect(self.actualizar_registro)
    def cargar_datos_tabla(self):
        self.stackedWidget.setCurrentWidget(self.pagina_buscar)
        perifericos = consultar_datos()

        self.tabla_buscar.setRowCount(len(perifericos))

        for fila, periferico in enumerate(perifericos, start=0):
            for columna, perifericos in enumerate(periferico.values(), start=0):
                self.tabla_buscar.setItem(fila, columna, QTableWidgetItem(str(perifericos)))
        self.tabla_buscar.resizeColumnsToContents()

    def crear_nuevo_perifericos(self):
        nuevo_perifericos = dict()
        nuevo_perifericos["Piezas"] = self.linea_piezas.text()
        nuevo_perifericos["Nombre"] = self.linea_nombre.text()
        nuevo_perifericos["Precio"] = float(self.linea_precio.text())
        nuevo_perifericos["Precio_iva"] = float(self.linea_precio_iva.text())
        nuevo_perifericos["imagen"] = self.linea_imagen.text()
        crear_nueva(nuevo_perifericos)

        self.linea_piezas.setText("")
        self.linea_nombre.setText("")
        self.linea_precio.setText("")
        self.linea_precio_iva.setText("")
        self.linea_imagen.setText("")

    def borrar_nuevo_perifericos(self):


        id = self.Line_EliminarID.text()

        eliminar(id)
        self.Line_EliminarID.setText("")

    def ampliar_ventana(self):
        self.showMaximized()

    def desampliar_ventana(self):
        self.showNormal()
    def ver_datos_borrar(self):
        perifericos = consultar_datos()

        self.tabla_borrar.setRowCount(len(perifericos))

        for fila, periferico in enumerate(perifericos, start=0):
            for columna, perifericos in enumerate(periferico.values(), start=0):
                self.tabla_borrar.setItem(fila, columna, QTableWidgetItem(str(perifericos)))
        self.tabla_borrar.resizeColumnsToContents()

    def actualizar_registro(self):
        try:
            caja_perifericos = {
                'id': self.label_id.text().strip(),
                'piezas': self.label_piezas.text().strip(),
                'nombre': self.label_nombre.text().strip(),
                'precio': float(self.label_precio.text().strip()),
                'precio_iva': float(self.label_precio_iva.text().strip()),
                'imagen': self.label_imagen.text().strip()
            }

            actualizar_datos(caja_perifericos)

            self.label_id.setText("")
            self.Label_piezas.setText("")
            self.label_nombre.setText("")
            self.label_precio.setText("")
            self.label_precio_iva.setText("")
            self.label_imagen.setText("")

            QMessageBox.information(self, "Guardado", "Tu registro se ha actualizado correctamente.")
        except Exception as e:
            QMessageBox.critical(self, "Error", f"Error al actualizar el registro: {e}")


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = MainWindow()
    ventana.show()
    sys.exit(app.exec_())
