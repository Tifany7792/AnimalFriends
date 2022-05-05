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

![Image text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/AnimalFriendsEntidades.png)



## UML ENTIDAD - RELACIÓN

![Image text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/relaciones.jpg)

## DIAGRAMA DE RELACIONES
![Image text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/diagramaRelaciones.png)

## DIAGRAMA DE NAVEGACIÓN
![Image text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/diagramaNavegacion.jpg)


## CAPTURAS DE PANTALLA

1. Pantalla de inicio: (Público) En esta pantalla podremos, loguearnos, registrarnos, o navegar para visualizar localizaciones, animales o productos.

![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/inicio.png)

2. Inicio de sesión (Público) 
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/iniciarSesion.png)

3. Registro (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/Registrarse.png)

4. Ver Animales (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/verAnimales.png)

5. Ver datos del animal (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/datosAnimal.png)

6. Crear un animal (Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/nuevoAnimal.png)

7. Ver localizaciones (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/verlocalizaciones.png)

8. Ver datos de la localizacion (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/datosLocalizacion.png)

9. Añadir localizacion (Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/nuevaLocalizacion.png)

10. Ver Productos (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/verProductos.png)

11. Ver datos de un producto (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/datosProducto.png)

12. Añadir Producto (Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/nuevoProducto.png)

13. Ver un usuario (Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/verUsuario.png)

14. Editar un usuario (Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/capturas/editarUsuario.png)


# FASE 3
---------
## CREACIÓN ARCHIVO JAR
----------------------------
### 1.- COMPILACIÓN DE PROYECTO

Primero debemos compilar el proyecto del servicio interno, debemos realizarlo dando botón derecho sobre raíz del proyecto y elegimos: `Run as --> Maven build...`
Una vez arrancado, nos aparecerá una ventana en la cual debemos poner package en la línea que está señalada con Goals.
Una vez le demos a run, estaremos atentos a la consola hasta que aparezca BUILD SUCCESS que determinará que hemos terminado, unas líneas más arriba nos aparece el directorio donde se ha guardado nuestro archivo .jar.
Por defecto sera: `carpetaProyecto\target\nombreProyecto.jar`

Ahora compilaremos la aplicación principal. Para ello primero tendremos que ejecutar el servicio interno o si no nos fallará.
Repetimos los mismo pasos, pero con el proyecto de la aplicación principal.
Copiamos los archivos .jar y los llevamos a la máquina virtual. 
Este proceso se puede hacer de muchas maneras, nosotros lo hemos realizado a través de enviarlo por correo electrónico.

### 2.-PREPARACIÓN DE LA MÁQUINA VIRTUAL

Debemos instalar una máquina virtual, en nuestro caso hemos usado virtualBox la cual hemos descargado en https://www.virtualbox.org/ ,para evitar usar más espacio del necesario recomendamos seguir los pasos de instalación seleccionando la instalación mínima.

Instalaremos JRE necesario para ejecutar nuestra aplicación.

Abriremos una consola y pondremos el siguiente comando: `sudo apt update`

Una vez realizado ese paso, vamos a comprobar si tenemos Java mediante la sentencia: java -version. Debería salirnos un mensaje de que dicho comando no ha sido encontrado, si no, entonces ya lo tendremos instalado y podremos saltar este paso.

Instalamos JRE predeterminado con el comando: `sudo apt install openjdk-11-jre-headless`

Para comprobar que ya sí tenemos Java instalado, ejecutamos el comando: `java -version`.

Ahora instalaremos mysql server y msql workbench de la siguiente manera:

Instalaremos primero mysql server con el siguiente comando:
`sudo apt-get install mysql-server`

Una vez instalado, comprobaremos que se ha hecho correctamente con:
`sudo mysql`

Si nos muestra la versión de MySQL y nos aparece mysql > , es que se habrá instalado correctamente.
En caso de que no sea así, se recomienda ejecutar de nuevo el comando sudo apt-get update y volver a repetir lo anterior.
Ahora instalaremos el banco de trabajo para facilitar el manejo de la base de datos. 
Este será un entorno gráfico de MySQL. Lo instalamos mediante el comando: 
`sudo snap install mysql-workbench-community`

Ahora tenemos que establecer la contraseña usada en las propiedades del proyecto de la aplicación principal para acceder a la BD. Para ello accederemos a mysql con privilegios de administrador: 
`sudo mysql -u root -p`

Una vez dentro de la consola de mysql, introducimos los siguientes comandos:
`use mysql
SELECT User, Host, plugin FROM mysql.user;
UPDATE user SET plugin='mysql_native_password' WHERE User='root';
FLUSH PRIVILEGES;`

De esta manera estamos cambiando la manera que tiene mysql de autentificar el acceso a las bases de datos.
Para acabar salimos de la consola de mysql con el comando exit.
Ahora hay que generar la contraseña de la base de datos, con el siguiente comando:  `mysqladmin -u root password [password]`
(En [password] poner la contraseña que se ha establecido en application.properties en la sentencia spring.datasource.password.)

Finalmente, para evitar un error a la hora de conectarnos a la base de datos, tendremos que otorgar los permisos ssh necesarios para que funcionen correctamente. 
Lo haremos con los siguientes comandos: 
`snap connect mysql-workbench-community:password-manager-service` 
`snap connect mysql-workbench-community:ssh-keys`

Dado que la base de datos utiliza un schema de nombre animalfriends, tendremos que ejecutar dentro de mysql el comando:
`CREATE SCHEMA animalfriends`

Finalmente tendremos instalado y operativo mysql en nuestra máquina virtual, lista para ejecutar la aplicación.
Tenemos que abrir los puertos para acceder a la aplicacion desde otra maquina.
Como se especifica que en la maquina virtual solo tenemos que estar ejecutando la aplicacion, accederemos a ella desde nuestra maquina principal. 
Para ello tenemos que abrir los puertos y conectarlos. 
En el administrador de VirtualBox, accederemos a la configuración de nuestra máquina virtual.En la ventana de configuración accedemos a Red --> Avanzadas --> y clickamos en reenvío de puertos.
Añadimos una nueva regla clickando en el simbolo + de la derecha y en Puerto Anfitrión y Puerto Invitado ponemos 8443, que es el puerto establecido en la aplicación para https.
Ponemos el nombre que queramos a la regla y clickamos en aceptar.

### 3.-EJECUTAMOS LAS APLICACIONES

Una vez que tenemos los archivos ejecutables en nuestra máquina virtual, vamos a abrir dos consolas en el directorio que se encuentran estos ficheros.

Primero tendremos que ejecutar el servicio interno con el comando: 
`java -jar nombreficheroServicioInterno.jar`
Vemos que se estará ejecutando correctamente y hacemos lo mismo con la aplicación principal.

Una vez ejecutando ambos programas en la máquina virtual, abriremos un navegador en otra máquina y accederemos a la aplicación mediante la dirección (en nuestro caso) https://localhost:8443/home . Y ya podremos navegar por ella.


## Pantallas de la aplicacion

Se han realizado pequeños cambios respecto a las pantallas de la fase dos, sobre todo añadiendo alguna modificación más en el css y añadiendo vistas de usuario/administrador

1. Pantalla de inicio (Público vs Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/home.jpg)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/homeLogged.jpg)

2. Inicio de sesión (Público) 
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/login.jpg)

3. Registro (Público)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/register.jpg)

4. Ver Animales (Público/Usuario vs Admin)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/listAnimals.jpg)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/listAnimalsAdmin.jpg)

5. Ver localizaciones (Público/Usuario vs Admin)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/listLocations.jpg)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/listLocationsAdmin.jpg)

6. Ver Productos (Público/Usuario vs Admin)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/listProducts.jpg)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/listProductsAdmin.jpg)

7. Ver un usuario (Privado)
![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/showUsuario.jpg)


## Diagrama de clases y templates

![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/screen/diagrama.jpg)


# FASE 4
---------

## Video


## Interfaz Servicio Interno

La web se comunica con el servicio interno utilizando el puerto 8080 del servicio interno [http](http://correo:8080/), donde "correo" hace referencia al nombre del contenedor del servicio interno dockerizado.

## Docker Compose 

Para ejecutar nuestra aplicación, basta con instalar docker, descargar el fichero "docker-compose.yml", ir a la carpeta donde se encuentra el archivo y ejecutar `docker-compose up`
Una vez ejecutado `docker-compose up` podemos escribir [http](https://localhost/home) y nos llevará a la página inicial.

## Haproxy

Para poder usar haproxy hemos necesitado generar la clave pem siguiendo los pasos de la web [http](https://serversforhackers.com/c/using-ssl-certificates-with-haproxy). Esto es necesario si se quiere probar a dockerizar el archivo haproxy.cfg. En caso de que no sea de interés, se puede saltar este paso.

## Diagrama de clases
Se han añadido dos nuevas clases: CacheController.java y SessionConfiguration.java.
Diagrama actualizado: 

## Diagrama de Docker Compose

![Image_text](https://github.com/Tifany7792/animalfriends/blob/practicaDad/AnimalFriends/src/main/resources/raw/uml-docker.png)
