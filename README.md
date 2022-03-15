# BCIApiRestProject
Api Rest Project for BCI

Hola!

Para correr el proyecto primero se debe clonar el repositorio del proyecto
https://github.com/ninnex/BCIApiRestProject.git
Luego se puede correr con el comando gradle bootRun, esto levantará el proyecto en el puerto 8080
La url principal del proyecto es http://localhots:8080
Para ver la documentación del proyecto se puede usando la herramienta Swagger a través de la URL 
localhost:8080/swagger-ui.html
donde encontrarás dos principales request. El POST para agregar usuarios nuevos y el GET para obtener usuarios ya guardados
Para almacenar usuario debes enviar el json en el body del método POST
Para obtener un usuario almacenado debes enviar el uuid en la url del método GET
localhost:8080/{uuid}
Se uso la base de datos en memoria H2 y Java Persistence Api
Se uso UUID autogenerados para los usuarios y token
Se agregaron prueba unitaria usando JUnit5 y Mockito
Se hicieron las validaciones solicitada para la creación de usuario (email repetido, formato de email, contraseña segura, etc)
Se agregó manejo de errores

Se agregaron en la carpeta principal del proyecto imágenes referenciales para un mayor entendimiento del sistema corriendo

Muchas gracias por tu tiempo.
