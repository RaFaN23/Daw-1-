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
        self.editar_boton.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.pagina_editar))
        self.borrar_boton.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.pagina_borrar))
        self.ver_boton.clicked.connect(self.cargar_datos_tabla)
        #botones funcion
        self.actualizar.clicked.connect(self.crear_nuevo_perifericos)

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
        nuevo_perifericos["imagen"] = float(self.linea_imagen.text())
        crear_nueva(nuevo_perifericos)

        self.linea_piezas.setText("")
        self.linea_nombre.setText("")
        self.linea_precio.setText("")
        self.linea_precio_iva.setText("")
        self.linea_imagen.setText("")


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = MainWindow()
    ventana.show()
    sys.exit(app.exec_())
