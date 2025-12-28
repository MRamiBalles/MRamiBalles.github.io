import praat-parselmouth

print("Inserte el texto a reproducir : ")
palabra = input()
print("Inserte el nombre del archivo con el que lo desea guardar : ")
wav = input()
print("Palabra = " + palabra)
print("Fichero  = " + wav)

listaLetras = [x for x in palabra]
print("Lista de letras = ")

for letra in listaLetras:
    print(letra)

error = False
prosodia = "?" in palabra
if prosodia:
    palabra = palabra.split("?")

if 'r' == listaLetras[0]:
    error = True

n = len(listaLetras)
i = 0
while i < n and not error:
    if 'r' == listaLetras[i] and listaLetras[i+1] == 's':
        error = True

    if error and (i+2) < n:
        break
    
    palabraBuscada = palabraBuscada + [listaLetras[i] + listaLetras[i+1]]
    i += 1
    
    if error:
        print('Error en la pronunciacion')
    else:
        print('Pronunciado correcto')

    create_sound(palabra, archivoPalabra, source, destination)

    file = dest + os.sep + "%s.wav" % i
    praat += "Leyendo..%s\n" % file

    if i == 0:
        praat2 += "Seleccionar sonido %s\n" % i
        else
        praat2 += "Incluir sonido %s\n" % i

praat3 = "Concatenando.. %s\n"
praat3 += "Concatenando.. %s\n"
praat3 += "Escribiendo fichero wav.. %s" % "Resultados" + os.sep + archivoPalabra