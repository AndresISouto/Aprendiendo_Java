gestor conciertos con un recinto con entradas y asistentes
entradas de grada y de pie

asistentes{
nombre
apellidos
dni
email
nacimiento
ver mayoria de edad()
crearAsistente()
}
Entradas{
codigo
precio
asistente
crearEntrada(asistente)
}
grada{
fila
asiento
toString()
}
pista{
back
toString()
}
recinto{
1000 entradas de pista
25000 de grada por filas 1000
entradas[]
entradas vendidas
entradas de back
de pista
de grada
gradasOcupadas[][]
mostrarEntradas()
addEntrada(entrada)
buscarEntrada(email)
validarEmail(asistente)
}
GESTOR CONCIERTOS
1. Reservar entrada // crear entrada asociarla a asistente y meterla en el recinto
2. Mostrar entrada // pasar a to string y busca por id supongo
3. Listar entradas vendidas // llevar la cuenta de las entradas vendidas 
4. Mostrar número de entradas disponibles // llevar la cuenta
0. Salir
   Escoja una opción:
