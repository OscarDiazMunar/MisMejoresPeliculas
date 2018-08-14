# MisMejoresPeliculas
Hay dos ramas:
master no usa ORM.
orm implementa ORM.

Clean architecture, MVP, Dagger 2, Retrofit 2, Rxjava, The movie db API

La aplicacion esta construida siguiendo clean architecture.
Esta aqrquitectura tiene 3 capas:
Capa Presentation: Implementa el patron MVP
Capa Domain: La capa de negocio. 
Capa Data: se obtienen los datos de una fuente de datos bien sea una database sqlite o un servicio rest, etc. se usa el patron repository.
Para ver el trailer se debe dar click encima de la tarjeta de cada pelicula.

librerias
Se usa rxjava para obtner datos asincronicamente y en segundo plano y ai no bloquear la app.
Se usa dagger 2 para injeccion de dependencias.
Se usa retrofit para consumo de servicios rest.
Se usa butterknife para injection de vistas.
Se usa Glide para cargar imagenes desde una url.
Se uso GSon para serializar y deserializar formato json. 

Principio de responsabilidad única: Una clase debe hacer una sola funcion y todo sus metodos deben estar enfocados a cumplir con esa unica funcion.
Caracteristicas clean code
-enfocado
-No debe ser redundante o repetitivo
-facil legibilidad par aotro desarrollador
-Debe tener el minimo de lineas por metodo
-Debe tener muy pocas dependecias
