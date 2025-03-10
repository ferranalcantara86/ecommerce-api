1. **Título**: `# Ecommerce API` 
2. **Descripción** 
Este proyecto es una API para un sistema de ecommerce. A continuación se detallan los pasos necesarios para ejecutar y levantar la aplicación en tu entorno local.
3. **Requisitos previos** (Java y Maven).
 4. **Comandos para clonar el repositorio**. 
Primero, clona el repositorio en tu máquina local usando el siguiente comando: (```bash git clone https://github.com/ferranalcantara86/ecommerce-api.git)
5. **Comandos para navegar al directorio** del proyecto.(cd ecommerce-api)
 6. **Comando para construir el proyecto** (`mvn clean install`). 
7. **Comando para ejecutar las pruebas** (`mvn test`).
 8. **Comando para levantar el servidor** (`mvn spring-boot:run`). 
9. **Cómo detener el servidor** (Ctrl + C). 
10. **Estructura de carpetas** básica del proyecto. 
ecommerce-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ecommerce_api/
│   │   │           └── service/
│   │   │               └── CartService.java
│   │   ├── resources/
│   │   │   ├── application.properties  # Configuración de la aplicación
│   ├── test/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ecommerce_api/
│   │   │           └── service/
│   │   │               └── CartServiceTest.java  # Pruebas unitarias
├── pom.xml  # Archivo de configuración de Maven
└── README.md

11. **Endpoints disponibles** (GET, POST, DELETE).

