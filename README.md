# animalfriends


Proyecto Diseño de aplicaciones distribuidas en el que vamos a implementar una web para los amantes de los animales.


## Nombre de la aplicación web
----------------------------

amigosanimales

## Descripción
-------------

En esta aplicación los usuarios podrán buscar destinos vacacionales, como por ejemplo playas, hoteles y demás alojamientos y servicios, a los que podrán acceder con animales. Además, los usuarios registrados podrán reservar habitaciones en dichos hoteles y acceder a un catálogo de cursos y productos con posibles descuentos exclusivos.

## Funcionamiento de la aplicación
---------------------------------

### Parte Pública

Playas a las que poder ir con nuestro perro (Público), Hoteles que aceptan mascotas (público), cuidados para nuestra mascota (público), cuidadores y alojamientos para perros (público)

### Parte Privada

Gestión de reservas, altas y bajas para establecimiento, sección proveedores para ofertas (privado, proveedor. Necesita registro)

Solicitud de reservas de usuarios en estos servicios (privado, cliente. Necesita registro)

Cursos de adiestramiento y agilidad (privado, cliente, para socios con ofertas, necesita registro)

Descuentos exclusivos en accesorios y piensos para mascotas (privado, cliente. Necesita registro)

## Entidades
-----------

Usuario: pueden ser proveedores o clientes. Los proveedores pueden publicar o bien sus establecimientos (hoteles) y gestionar las reservas o productos para animales a la venta, pudiendo añadir ofertas a los mismos. Los clientes pueden reservar habitaciones en ellos, así como acceder a un catálogo de ofertas

Mascotas: se podrá hacer un filtrado por tipo de mascotas o bien para buscar información sobre sus cuidados o para filtrar los alojamientos

Productos: los proveedores pueden publicarlos y decidir distintas categorías para los mismos (perro, juguete...)

Localizaciones: Habrá tanto hoteles a los que se podrá acceder desde la parte privada como lugares como playas a los que se podrá acceder de forma pública

## Funcionalidades del servicio interno
--------------------------------------

gestion de reservas

Altas en servicios

Altas de usuarios

Compras (productos con descuentos)
