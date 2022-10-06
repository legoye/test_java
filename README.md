# test_java
 
 Programa de practica en java
 
 Se utilizó 
 H2 Como base de datos
 Spring security para la generación del JWT
 JPA
 Spring boot 
 Maven
 
 para probar 
 
 1.- generar token con el siguiente CURL :
 
 curl --location --request POST 'http://localhost:8080/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "admin",
    "password": "password"
}'

2.- Una vez generado probar el enpoint de creación de usuario

sustituyendo el bearer token por el generado en el  curl anterior

curl --location --request POST 'http://localhost:8080/users' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY2NTAzNjY3MywiaWF0IjoxNjY1MDE4NjczfQ.ni2cCbo_RqvMBsjpiRSOviinlDHv7GEVJz9uyM3TrO_B7N95OHhc8VfdYZnqioDzZ9sh9h4Gf781eXYTXX_G_A' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Juan Rodriguez",
"email": "juan@rodriguez.org",
"password": "hunter2",
"phones": [
{
"number": "1234567",
"cityCode": "1",
"contryCode": "57"
}
]
}
'
 
