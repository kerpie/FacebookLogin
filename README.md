FacebookLogin
=============

Simple Facebook Login

1. Crear la aplicacion en FB(https://developers.facebook.com/)
2. Para el paso anterior marcar la caja de 'Android Aplicacion Nativa' y llenar los nombres de acuerdo al paquete del proyecto, marcar como 'activado' la opcion de 'Inicio de sesion en Facebook' 
3. Preparar el 'key hash' de acuerdo a la ultima parte del paso 4 segun la guia oficial: https://developers.facebook.com/docs/getting-started/facebook-sdk-for-android/3.0/
4. Descargar el sdk de FB para android y aniadirlo al proyecto
5. Aniadir al archivo manifiesto la etiqueta <meta-data> dentro de la etiqueta <application> e incluir la actividad: <activity android:name="com.facebook.LoginActivity" android:label="@string/app_name" /> para poder aniadirlo
6. En la accion onClick del boton, dentro de la actividad Login, se realiza la extraccion de datos y se almacenan para su uso en otras Actividades.