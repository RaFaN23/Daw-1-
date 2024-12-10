def ejercicio_1():
    cadena=input("Ingrese la cadena que desea ejecutar: ")

    print("Los signos de puntuacion encontrados son:")
    print("numeros de comas: ", cadena.count(","))
    print("numeros de puntos: ", cadena.count("."))
    print("numeros de interrogaciones: ", cadena.count("¿") and cadena.count("?"))
    print("numeros de dos puntos: ", cadena.count(":"))
    print("numeros de parentesis: ", cadena.count("(") and cadena.count(")"))
    print("numeros de corchetes: ", cadena.count("[") and cadena.count("]"))
    print("numeros de puntos: ", cadena.count(";"))
    print("numeros de puntos: ", cadena.count("..."))
    print("numeros de puntos: ", cadena.count("¨"))
    print("numeros de puntos: ", cadena.count("-"))
    print("numeros de puntos: ", cadena.count("!") and cadena.count("¡"))
# ejercicio_1()


def ejercicio_2 ():
    def ahorcado(palabra):
        palabra = palabra.lower()
        letras_adivinadas = []
        vidas = 5
        palabra_oculta = ['_'] * len(palabra)

        while vidas > 0:
            print(f"Palabra: {' '.join(palabra_oculta)}")
            print(f"Vidas restantes: {vidas}")
            letra = input("Adivina una letra: ").lower()

            if letra in letras_adivinadas:
                print("Ya has dicho esa letra. Intenta con otra.")
                continue

            letras_adivinadas.append(letra)

            if letra in palabra:
                print("¡Has acertado!")
                for i, char in enumerate(palabra):
                    if char == letra:
                        palabra_oculta[i] = letra
            else:
                print("Letra incorrecta.")
                vidas -= 1

            if '_' not in palabra_oculta:
                print(f"¡Felicidades! Has adivinado la palabra: {''.join(palabra_oculta)}")
                break
        else:
            print(f"Lo siento, has perdido. La palabra era: {palabra}")


    ahorcado("programacion")

# ejercicio_2()

def ejercicio_3(lista, dominio):

    # Ejemplo de uso
    alumnos = [
        {
        "nombre": "Enrique",
         "apellidos": "García, Migueza",
         "dni": "12345678K",
         "email": "egarciamigueza@safareyes.es"
         },

        {
        "nombre": "Paloma",
        "apellidos": "Machado, López",
        "dni": "12345678Z",
        "email": "pmachadolopez@hotmail.es"
        },

        {
        "nombre": "Antonio",
        "apellidos": "Romero, Domínguez",
        "dni": "12345678A",
         "email": "aromerodominguez@safareyes.es"
        }
    ]

    for alumno in alumnos:
        if alumno["email"].endswith(f"@{dominio}"):
            lista.append(alumno)

    return lista


# Ejemplo de uso
# print(ejercicio_3([], "safareyes.es"))

def ejercicio_3b(alumnos):

    lista_apellidos = []

    for alumno in alumnos:
        lista_apellidos.append(alumno["apellidos"])

    lista_apellidos.sort()

    apelliddo_alumno = lista_apellidos[0]

    for alumno in alumnos:
        if alumno["apellidos"] == apelliddo_alumno:
            return alumno

# print(ejercicio_3b(
    alumnos = [
        {
            "nombre": "Enrique",
            "apellidos": "García, Migueza",
            "dni": "12345678K",
            "email": "egarciamigueza@safareyes.es"
        },

        {
            "nombre": "Paloma",
            "apellidos": "Machado, López",
            "dni": "12345678Z",
            "email": "pmachadolopez@hotmail.es"
        },

        {
            "nombre": "Antonio",
            "apellidos": "Romero, Domínguez",
            "dni": "12345678A",
            "email": "aromerodominguez@safareyes.es"
        }
    ]
# ))
def ejercicio_3c(alumnos):

    lista_dni = []

    for alumno in alumnos:
        lista_dni.append(alumno["dni"][0])

    lista_dni.sort()
    letra_primer_alumno = lista_dni[0]

    for alumno in alumnos:
        if alumno["dni"][0] == letra_primer_alumno:
            return alumno

# print(ejercicio_3c(
    alumnos=[
        {
            "nombre": "Enrique",
            "apellidos": "García, Migueza",
            "dni": "12345678K",
            "email": "egarciamigueza@safareyes.es"
        },
        {
            "nombre": "Paloma",
            "apellidos": "Machado, López",
            "dni": "22345678Z",
            "email": "pmachadolopez@hotmail.es"
        },
        {
            "nombre": "Antonio",
            "apellidos": "Romero, Domínguez",
            "dni": "32345678A",
            "email": "aromerodominguez@safareyes.es"
        }
    ]
# ))


def calcular_media_y_evaluacion(notas):
    media = sum(notas) / len(notas)

    if media < 5:
        return "Suspenso"
    elif 5 <= media < 7:
        return "Aprobado"
    elif 7 <= media < 9:
        return "Notable"
    else:
        return "Sobresaliente"


# Ejemplo de uso
notas = [5.6, 7, 6.2, 8]
resultado = calcular_media_y_evaluacion(notas)
print(f"La nota media es: {sum(notas) / len(notas)}")
print(f"Evaluación: {resultado}")


def contar_mayusculas_consonantes(texto):
    consonantes = "BCDFGHJKLMNPQRSTVWXYZ"
    contador = 0
    for letra in texto:
        if letra in consonantes:
            contador += 1
    return contador

# Ejemplo de uso
texto = "Finalmente tras el día de ayer el Real Madrid y el Barcelona siguen adelante en la Copa del Rey"
resultado = contar_mayusculas_consonantes(texto)
print(f"Número de letras mayúsculas y consonantes: {resultado}")



def filtrar_numeros(lista_numeros):
    resultado = []
    for numero in lista_numeros:
        if numero.is_integer() and numero % 2 == 0 and numero % 3 == 0:
            resultado.append(int(numero))
    return resultado

# Ejemplo de uso
lista_numeros = [4.5, 6, 10.3, 12.4, 15.0, 18, 24]
resultado = filtrar_numeros(lista_numeros)
print(f"Números enteros divisibles entre 2 y 3: {resultado}")


def valorar_futbolistas(futbolistas, num_personas):
    valoraciones = {}

    for futbolista in futbolistas:
        valoraciones[futbolista] = []
        print(f"-------------------------VALORACIÓN {futbolista.upper()}-------------------------")
        for i in range(num_personas):
            nota = float(input(f"Persona {i + 1} → "))
            valoraciones[futbolista].append(nota)

    print("-----------------------RESUMEN VALORACIONES----------------------")
    for futbolista, notas in valoraciones.items():
        media = sum(notas) / len(notas)
        print(f"{futbolista} (Media Obtenida) → {media}")


# Ejemplo de uso
futbolistas = ["Haaland", "Mbappe", "Vinicius Jr"]
num_personas = 2
valorar_futbolistas(futbolistas, num_personas)


def coches_mas_de_dos_puertas(coches):
    coches_filtrados = [coche for coche in coches if coche['puertas'] > 2]
    coches_ordenados = sorted(coches_filtrados, key=lambda x: x['puertas'])
    return [coche['modelo'] for coche in coches_ordenados]

# Ejemplo de uso
coches = [
    {"modelo": "Gallardo", "marca": "Lamborghini", "tipo": "Deportivo", "puertas": 3},
    {"modelo": "Murciélago GT", "marca": "Lamborghini", "tipo": "Carrera", "puertas": 2},
    {"modelo": "Twingo", "marca": "Renault", "tipo": "Normal", "puertas": 5}
]
resultado = coches_mas_de_dos_puertas(coches)
print(f"Coches con más de 2 puertas: {resultado}")



def filtrar_por_marca(coches, marca):
    return [coche for coche in coches if coche['marca'] == marca]

# Ejemplo de uso
marca = "Lamborghini"
resultado = filtrar_por_marca(coches, marca)
print(f"Coches de la marca {marca}: {resultado}")



def construir_diccionarios(modelos, marcas, tipos, puertas):
    return [{"modelo": modelo, "marca": marca, "tipo": tipo, "puertas": puerta} for modelo, marca, tipo, puerta in zip(modelos, marcas, tipos, puertas)]

# Ejemplo de uso
modelos = ["Gallardo", "Murciélago GT", "Twingo"]
marcas = ["Lamborghini", "Lamborghini", "Renault"]
tipos = ["Deportivo", "Carrera", "Normal"]
puertas = [3, 2, 5]
resultado = construir_diccionarios(modelos, marcas, tipos, puertas)
print(f"Lista de diccionarios: {resultado}")


def mostrar_palabras(lista_palabras, numeros):
    if len(lista_palabras) != len(numeros):
        print("No puedo realizar la operación")
        return

    for palabra, num in zip(lista_palabras, numeros):
        print((palabra + ' ') * num)

# Ejemplo de uso
lista_palabras = ["hola", "cómo", "estás"]
numeros = [5, 1, 1]
mostrar_palabras(lista_palabras, numeros)
