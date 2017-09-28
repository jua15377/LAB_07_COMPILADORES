def isletter(entrada):
	tokenName = "letter"
	letter = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
	respuesta = entrada in letter
	if (respuesta):
		respuesta = '<%s, "%s">'%(tokenName, entrada)
	else:
		respuesta = ""
	return respuesta

def isdigit(entrada):
	tokenName = "digit"
	letter = "0123456789"
	respuesta = entrada in letter
	if (respuesta):
		respuesta = '<%s, "%s">'%(tokenName, entrada)
	else:
		respuesta = ""
	return respuesta

def ishexdigit(entrada):
	tokenName = "hexdigit"
	letter = "igit+"ABCDEF"
	respuesta = entrada in letter
	if (respuesta):
		respuesta = '<%s, "%s">'%(tokenName, entrada)
	else:
		respuesta = ""
	return respuesta

def keyword(palabra):
   lista = ['if','while']
   if palabra in lista:
       return True,lista[lista.index(palabra)]
   else:
       return False,""
#abre el archivo
fileName = raw_input("ingrese el archivo a lexear")
infile = open(fileName, 'r')
salidaSize = 0

for line in infile:
    salida = ''
    palabra = ''
     
    wordsInLine = line.split(" ")
    wordsInLine2 = line.split(" ")
    for w in wordsInLine:
        isKeyword, kindKeyword = keyword(w)
        if isKeyword:
            salida = salida + '<%s, "%s">' % (kindKeyword, w) + ' '
            wordsInLine2.remove(w)
        else:
            for caracter in w:
                if caracter != ' ' and caracter != '\n' and caracter != "\t":
                    salidaSize = len(salida)

                    cadenaTemp = isletter(caracter)
                    if cadenaTemp != "":
                        salida = salida + cadenaTemp
                    cadenaTemp = isdigit(caracter)
                    if cadenaTemp != "":
                        salida = salida + cadenaTemp
                    cadenaTemp = ishexdigit(caracter)
                    if cadenaTemp != "":
                        salida = salida + cadenaTemp                    if salidaSize == len(salida):
                        print 'ERROR: El caracter [%s] no es reconocido por el lexer!!!'%(caracter)
                else:
                    print 'se enccontro espacio en blanco'
    print salida
# Cerramos el fichero.
infile.close()