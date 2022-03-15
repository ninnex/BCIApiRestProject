# BCIApiRestProject
Api Rest Project for BCI

Hola!

Para correr el proyecto primero se debe clonar el repositorio del proyecto
https://github.com/ninnex/BCIApiRestProject.git

Luego se puede correr con el comando gradle bootRun, esto levantará el proyecto en el puerto 8080

La url principal del proyecto es http://localhost:8080

Para ver la documentación del proyecto se puede usando la herramienta Swagger a través de la URL 
http://localhost:8080/swagger-ui.html
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

# Creación de Usuario POST Method:

![Screenshot POST Agregar usuario](https://user-images.githubusercontent.com/38047248/158485421-91eec119-6dda-4596-b73d-9e70ecc4dad0.jpg)

# Obtención de Usuario guardado GET Method:

![Screenshot GET obtener Usuario por uuid](https://user-images.githubusercontent.com/38047248/158485568-d953d416-610d-4764-90ee-bb0f6502f813.jpg)

# Error de Usuario no econtrado

![Screenshot Error Usuario no econtrado](https://user-images.githubusercontent.com/38047248/158485764-c83fd9af-7ffc-4dcb-ac37-5c9b66736a71.jpg)

# Error de usuario duplicado 

![Screenshot Error Usuario duplicado](https://user-images.githubusercontent.com/38047248/158485603-d549863c-e3f2-48b9-ac77-1c346271cfe3.jpg)

# Error de formato de correo inválido

![Screenshot Error Email inválido](https://user-images.githubusercontent.com/38047248/158485654-5f7b7e9c-870c-42f4-9891-ca93c1b25db9.jpg)

# Error de password inseguro 

![Screenshot Error password inseguro](https://user-images.githubusercontent.com/38047248/158485692-fe855f6c-9fb9-4f58-b590-012c012f2bac.jpg)

# Herramienta Swagger http://localhost:8080/swagger-ui.html

![Screenshot Swagger herramienta](https://user-images.githubusercontent.com/38047248/158485861-0f84ad71-0614-4598-ade0-55cf538d563c.jpg)

# Consola de base de datos H2

 ![Screenshot H2 consola](https://user-images.githubusercontent.com/38047248/158486175-e4020a96-0f0a-40e0-97d5-b0f538116576.jpg)




Muchas gracias por tu tiempo  :)


