import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from Datos import *
class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        uic.loadUi("Dell_app.ui", self)  # Carga el archivo .ui directamente

        self.inicio_boton.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.pagina_inicio))
        self.nuevo_boton.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.pagina_nuevo))
        self.editar_boton.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.pagina_editar))
        self.borrar_boton.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.pagina_borrar))
        self.ver_boton.clicked.connect(self.cargar_datos_tabla)

    def cargar_datos_tabla(self):
        self.stackedWidget.setCurrentWidget(self.pagina_buscar)
        accesorios, columnas = consultar_datos()
        self.Tabla_productos.setRowCount(len(accesorios))

        for fila, accesorio in enumerate(accesorios, start=0):
            for columna, accesorio in enumerate(accesorios.values(), start=0):
                self.Tabla_productos.setItem(fila, columna, QTableWidgetItem(str(accesorio)))
        self.Tabla_productos.resizeColumnsToContents()


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = MainWindow()
    ventana.show()
    sys.exit(app.exec_())
