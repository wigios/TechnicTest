Seguimiento proceso laboral
Meta: Seguir los emails que me envian y tienen relacion a mi proceso de ingreso laboral
@author wigios

Narrative:
In order to estar enterado de la respuesta de la entrevista de mi oferta laboral
As an interesado en un puesto laboral
I want to revisar la recepcion del correo electronico en mi cuenta de gmail

Scenario: TC100 - buscando correos en mi cuenta Gmail sobre mi proceso
Given el usuario ingresa a login de Gmail con cuenta con usuario 'wigiosauto@gmail.com' y pass 'aqws1234'
When el usuario esta en la bandeja de entrada busco que exista correo con remitente '<remitente>'
Then se abre el correo entrante y se visualiza el texto con el paso a seguir en el proceso

Examples:
|remitente                  |
|alejandrorendon@sura.com.co|
|ceacevedo@sura.com.co      |
|successfactors@sura.com.co |