import requests
from bs4 import BeautifulSoup



#Importar librerias

#Pedir codigo fuente
def obtener_contenido_pagina():
        url = 'https://www.dell.com/es-es/shop/gaming-gaming-accessories/ar/6488'
        respuestas = requests.get(url).content
        return respuestas
accesorios = {

    'piezas': None,
    'nombre': None,
    'precio': None,
    'precio_iva': None,
    'imagen': None
}
#Creamos un diccionario para saber que vamos a pillar
lista = []
#creamos la macrolista

def transformar_sopa():
    respuestas = obtener_contenido_pagina()
    soup = BeautifulSoup(respuestas, "html.parser")
    return soup
#Extramos de modo que nos de un HTML mas limpio
soup = transformar_sopa()
content = soup.find_all('article', {'class': 'stack-accessories ps-stack'})
#cogemos el contenido que queremos en este caso las cajas de producctos


def web_scraping():
    repeteciones = 0

    for respuestas in content:
        if repeteciones == 12:
            break

        #hacemos una lista nueva
        nueva_caja = accesorios.copy()

        piezas_accesorios = respuestas.find('div', {'class': 'ps-product-detail-info'}).text.replace('\n', '')
        nueva_caja["piezas"] = piezas_accesorios

        nombre_accesorios = respuestas.find('h3').text.replace('\n', '')
        nueva_caja["nombre"] = nombre_accesorios

        precio_accesorio = respuestas.find('div', {'class': 'ps-dell-price ps-simplified'}).text.replace('\n', '').replace(' ','').replace('PreciodeDell','').replace('€','').replace(',','.')
        nueva_caja["precio"] = precio_accesorio

        precio_iva_accesorio = respuestas.find('div', {'class': 'ps-del ps-dell-price-without-tax'}).text.replace('\n', '').replace(' ','').replace('€','').replace('excluyendoelIVA','').replace(',','.')
        nueva_caja["precio_iva"] = precio_iva_accesorio

        imagen_accesorio = respuestas.find('img')['src']
        nueva_caja["imagen"] = imagen_accesorio
    #hacemos todos los pedidos a la pagina

        lista.append(nueva_caja)
        #metemos la lista en la macrolista
        repeteciones +=1
    return lista

print(web_scraping())