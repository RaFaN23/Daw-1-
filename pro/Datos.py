import csv
import pandas as pd
import web_scraping as wb
import mysql.connector as conector

def contruir_csv():

    lista_datos = wb.web_scraping()

    conjunto_datos = {tuple(dato.items()) for dato in lista_datos}
    lista_datos = [dict(dato) for dato in conjunto_datos]

    with open('perifericos.csv', 'w', newline='', encoding='utf-8') as archivo_perifericos:
        escritor = csv.writer(archivo_perifericos)

        escritor.writerow(lista_datos[0].keys())

        for periferico in lista_datos:
            escritor.writerow(periferico.values())
contruir_csv()

def convertir_a_excel():
    archivo_csv = pd.read_csv('perifericos.csv')
    archivo_excel =archivo_csv.to_excel('perifericos.xlsx', index=False)
convertir_a_excel()


def conectar_bdd():
    parametro_conexion = {
        'user': 'root',
        'password': 'Am6b23cd24!',
        'host': 'localhost',
        'database': 'perifericosdb',
        'port': 3306,
        'charset': 'utf8',
        'collation': 'utf8_general_ci',
        'use_unicode': True,
        'autocommit': True

    }


    #devoler la conexion
    return conector.connect(**parametro_conexion)

def volcado_datos():

    lista = wb.web_scraping()


    #Abrimos conexion con la bbdd
    conexion = conectar_bdd()

    #Abrimos cursor
    cursor = conexion.cursor()


    #Sentencia INSERT
    script_insercion = 'insert into perifericos (piezas,nombre,precio,precio_iva,imagen) values(%s,%s,%s,%s,%s)'


    for accesorios in lista:
         cursor.execute(script_insercion, (accesorios['piezas'], accesorios['nombre'], accesorios['precio'], accesorios['precio_iva'], accesorios['imagen']))


    #Cerramos la conexion con la base de datos
    conexion.commit()
    conexion.close()

volcado_datos()

def consultar_datos():


    #Abrir conexion
    conexion = conectar_bdd()

    #Abrir cursor
    cursor = conexion.cursor(dictionary=True)

    #Lista de elementos
    lista = []

    #Script de consulta (SELECT)
    script_consulta = "select * from perifericos "

    #Ejecutar la consulta
    cursor.execute(script_consulta)

    #Nos traemos los datos de la consulta anterior
    lista = cursor.fetchall()

    #Cerramos conexion
    conexion.close()

    return lista

consultar_datos()

# def eliminar(id):
#
#     #Abrimos conexion
#     conexion = conectar_bdd()
#
#     #Abir cursor
#     cursor = conexion.cursor()
#
#     #Script Eliminar (DELETE FROM tabla where id = num)
#     script_eliminar = "delete from perifericos where id =" + str(id)
#
#
#     #Ejecutar script
#     cursor.execute(script_eliminar)
#
#     #Cerramos conexion
#     conexion.close()
#
#
# eliminar()