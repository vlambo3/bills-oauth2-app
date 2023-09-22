<a name="readme-top"></a>
# Proyecto BILLS-SYSTEM


## Objetivo
Si quiere conocer acerca de como implementar una **ARQUITECTURA DE SEGURIDAD DE MICROSERVICIOS** a través de un Identity and Access Management, lo invito a clonar mi repo y a seguir los pasos que detallo más abajo.

Sabes lo que es un IAM? El IAM es quien se encarga de la **administración de las identidades** de los usuarios de un sistema, como los nombres de usuario, contraseñas, credenciales, roles, etc, y la **gestión de los permisos de acceso** a los recursos que pueda poseer el sistema o aplicación en sí. 

Es decir que maneja tanto la **autenticación** (verificación de la identidad del usuario) como la **autorización** (determinar los permisos de acceso del usuario).

**El objetivo principal de un IAM** es asegurar que los usuarios tengan acceso adecuado a los recursos y servicios necesarios realizar su trabajo, mientras se protegen los datos confidenciales y se minimiza el riesgo de violaciones de seguridad.

Como IAM vamos a usar *Keycloak* desarrollado por **RedHat**, que es una solución de inicio de sesión único para aplicaciones web y servicios RESTful. El objetivo de Keycloak es facilitar el desarrollo de aplicaciones y la protección de las aplicaciones y sus servicios. 
En cuanto a la seguridad vamos a seguir el protocolo de OAuht2.	

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ABOUT THE PROJECT -->
## Acerca del Proyecto
La aplicación a la que le vamos a implementar seguridad se trata de tres servicios **ms-gateway**, **s-bills** y **ms-users**, todos registrados en **Eureka Server** (**ms-discovery**). 

La aplicación permite que solo usuarios autenticados puedan ingresar a ella a través de su API GATEWAY, para eso usa el flujo de Authorization code que intercambia un código por un Access Token con el **AUTHORIZATION SERVER**. 
El servicio ms-gateway será un **CLIENT**.

Los usuarios autenticados pueden consultar en el servicio ms-bills todas las facturas y quienes tengan el rol de admin podrán filtrar las facturas por id de usuario, además los usuarios que pertenezcan al grupo *PROVIDERS*, son los únicos autorizados a crear facturas. En este caso ms-bills será un **RESOURCE SERVER**.

El servicio ms-users se comunica a través de **OPENFEIGN** con ms-bills para consultar las facturas por id de usuario, también permite consultar a los usuarios registrados por su id o username. El servicio de usuarios será un **RESOURCE SERVER** y también será un **CLIENT** pero que en este caso usará el flujo *CLIENT CREDENTIALS* para comunicarse con ms-bills y la librería **keycloak admin** para hacer consultas a los usuarios regitrados en Keycloak.

A continuación puede observar un esquema de la arquitectura descripta.

![image](https://github.com/vlambo3/bills-oauth2-app/assets/86501009/ffb39cb6-5337-40ad-a0e6-1db8e5cfb945)


<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Construido con

El proyecto está construído con jdk 17, usando Spring Boot, Spring JPA, Spring MVC, Spring Cloud, OAuth2 y Keycloak Admin.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Comencemos!
Puede clonar este repositorio ejecutando el comando git clone junto con la url : https://github.com/vlambo3/bills-oauth2-app desde su consola de Git Bash
  ```
  git clone https://github.com/vlambo3/bills-oauth2-app
  ```
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Instalación
Para probar servicios, luego de clonarlo puede correr la imagen de Keycloak en su Docker Desktop con el comando:
  ```
  docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.0.1 start-dev
  ```
Este comando inicia Keycloak exponiendolo en el puerto 8080 y crea un usuario administrador inicial con el nombre de usuario admin y la contraseña admin.
A continuación deberá crear un reino en Keycloak usando el nombre “bills-system”, crear sus CLIENTS para los servicios ms-gateway y ms-users y reemplazar los nombres y las secret en ambos servicios. Deberá configurar a su servicio ms-users para que pueda administrar a los usuario en Keycloak y así posteriormente poder hacer consultas. Deberá crear el rol de ADMIN y algunos usuarios para comenzar las pruebas.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contacto

Project Link: [https://github.com/vlambo3/bills-oauth2-app](https://github.com/vlambo3/bills-oauth2-app)

LinkedIn Profile: [https://www.linkedin.com/in/vanina-a-godoy/](https://www.linkedin.com/in/vanina-a-godoy/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>
