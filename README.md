# animalfriends


Proyecto Diseño de aplicaciones distribuidas en el que vamos a implementar una web para los amantes de los animales.


## Nombre de la aplicación web
----------------------------

AnimalFriends

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

Altas de mascotas

Altas de usuarios

Compras (productos con descuentos)

# FASE 2
---------
## UML DE ENTIDADES PRINCIPALES 

![Image text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/AnimalFriendsEntidades.png)

## UML ENTIDAD - RELACIÓN

![Image text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/relaciones.jpg)

## DIAGRAMA DE RELACIONES
![Image text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/diagramaRelaciones.png)

## DIAGRAMA DE NAVEGACIÓN
![Image text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/diagramaNavegacion.jpg)


## CAPTURAS DE PANTALLA

1. Pantalla de inicio: (Público) En esta pantalla podremos, loguearnos, registrarnos, o navegar para visualizar localizaciones, animales o productos.

![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/inicio.png)

2. Inicio de sesión (Público) 
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/iniciarSesion.png)

3. Registro (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/Registrarse.png)

4. Ver Animales (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/verAnimales.png)

5. Ver datos del animal (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/datosAnimal.png)

6. Crear un animal (Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/nuevoAnimal.png)

7. Ver localizaciones (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/verlocalizaciones.png)

8. Ver datos de la localizacion (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/datosLocalizacion.png)

9. Añadir localizacion (Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/nuevaLocalizacion.png)

10. Ver Productos (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/verProductos.png)

11. Ver datos de un producto (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/datosProducto.png)

12. Añadir Producto (Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/nuevoProducto.png)

13. Ver un usuario (Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/verUsuario.png)

14. Editar un usuario (Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/versionBuena/AnimalFriends/src/main/resources/raw/capturas/editarUsuario.png)




