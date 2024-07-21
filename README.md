# prueba-tecnica-bolivar

para ejecutar el proyecto se debe compilar el docker-compose.yml y cuando se consuman los endpoint colocar en la cabecera Content-Type=application/json es necesario para que no arroje error, adicionalmente se ejecuta la sincronizacion con la api de rick y morty automaticamente al cargar la aplicacion.

### URLs de prueba

#### Obtener todas las ubicaciones

```bash
curl --location 'http://localhost:8080/api/locations' \
--header 'Content-Type: application/json'
```
```bash
curl --location 'http://localhost:8080/api/locations/1' \
--header 'Content-Type: application/json'
```
```bash
curl --location 'http://localhost:8080/api/locations' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Miguel",
    "type": "Planet 15648",
    "dimension": "Dimension C-13754681"
}'
```
```bash
curl --location --request PUT 'http://localhost:8080/api/locations/169' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Miguel",
    "type": "Planet 155",
    "dimension": "Dimension C-13754681",
    "created": "2024-07-20T23:46:39.729435055"
}'
```
```bash
curl --location --request DELETE 'http://localhost:8080/api/locations/169' \
--header 'Content-Type: application/json'
```
#### Obtener todos los personajes
```bash
curl --location 'http://localhost:8080/api/characters' \
--header 'Content-Type: application/json'
```
```bash
curl --location 'http://localhost:8080/api/characters/1' \
--header 'Content-Type: application/json'
```
```bash
curl --location 'http://localhost:8080/api/characters' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Miguel Calderon",
    "status": "Alive",
    "species": "Human",
    "type": "",
    "gender": "Male",
    "origin": 3,
    "location": 3,
    "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
}'
```
```bash
curl --location 'http://localhost:8080/api/characters' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Miguel Calderon",
    "status": "Alive",
    "species": "Human",
    "type": "",
    "gender": "Male",
    "origin": 3,
    "location": 3,
    "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
}'
```
```bash
curl --location --request DELETE 'http://localhost:8080/api/characters/827' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Miguel Calderon 123456",
    "status": "Alive",
    "species": "Human",
    "type": "",
    "gender": "Male",
    "origin": 3,
    "location": 3,
    "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
    "created": "2024-07-21T04:37:23.6555583"
}'
```
