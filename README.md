Como ejecutar: 
Al tener relacionado el gestor de proyectos MAVEN, los goals que se utilizan son los siguientes: 
_mvn clean test verify_


* Precondiciones: 
EL usuario debe tener una cuenta en Gmail
El usuario de gmail no se debe estar guardado automaticamente

Escenario: Buscar correos en mi cuenta Gmail que se relacionen con mi proceso

* Pasos: 

	LoginPage:
	1. Ingreso a la pagina principal de Gmail: https://mail.google.com
	2. Digito usuario Gmail, luego boton Next. 
	   |usuario             |
	   |email@gmail.com| //Esta es una cuenta de correo de prueba
	   
	3. Digito contraseña, luego click en botón Next. 
		|password  |
		|yyy  |

	HomePage:
	4. Ingreso al home de mi cuenta Gmail. 
	5. Busco en mi bandeja de entrada que existan correos con remitente: 
	   |email                      |
	   |email1@sura.com.co| 
	   |email2@sura.com.co      |
	   |email3@sura.com.co |
	   
	6. Si existe correo, se abre el correo entrante

	EmailPage
	7. Leo y guardo el cuerpo del mensaje para saber que sigue en el proceso.
	8. envío correo leído a etiqueta Importantes y la elimino de la bandeja de entrada.

* Postcondiciones: 

9. Salgo correctamente de mi sesion, click botón superior derecho, luego click en abrir


* Criterio de aceptación: 
Si el caso de prueba encuentra correo relacionado con el proceso laboral, el caso de prueba fué exitoso. 