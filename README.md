# Bits-Banco
## Tecnologias.
* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
*   [Angular](https://angular.io/guide/router-tutorial) - FrontEnd
* 	[Git](https://git-scm.com/) - Free and Open-Source distributed version control system 
* 	[SQL](https://url/) - Base de Datos MariaDB
* 	[PrimeNg](https://url/) - libreria de estilos


## Tener Encuenta.

- Se utilizo una Base de datos MariaDb. Por favor Cambiar el Enrutamiento del servidor de Datos en el YML.(Actualizar las Url de enlase donde se ejecuto el Script Sql DB).
- Comandos y rutas nativas para banck y front. (No Cambia).

## Endpoint Creados cliente
 - GET http://localhost:9090/bits/cliente/version
 - GET http://localhost:9090/bits/cliente
         
	      (Params) ?id = id_cliente
	      (Params) ?id = todos

 - POST http://localhost:9090/bits/cliente
 
       {
            "nombreCliente":  "String", 
            "direccionCliente":  "String",
            "telefonoCliente":  "long"
       }
                               
         
- PUT http://localhost:9090/bits/cliente
  
       {
          "idCliente": "long",
          "nombreCliente":  "String", 
          "direccionCliente":  "String",
          "telefonoCliente":  "long"
       }
                          
 - DELETE http://localhost:9090/bits/cliente
 
     	 (Params) ?id = id_cliente

---

## Endpoint Creados cuenta
 - GET http://localhost:9090/bits/cuenta/version
 - GET http://localhost:9090/bits/cuenta

        (Params) ?id = id_cuenta
        (Params) ?id = todos

- POST http://localhost:9090/bits/cuenta

		{
		"cliente":  "long", 
		"numeroCuenta":  "long ",
		"saldoCuenta":  "long"
		}
       
 - PUT http://localhost:9090/bits/cuenta
  
		{
		"idCuenta ": "long";
		"cliente":  "long", 
		"numeroCuenta":  "long ",
		"saldoCuenta":  "long"
		}
       
- DELETE http://localhost:9090/bits/cuenta

      (Params) ?id = id_cuenta

---

## Endpoint Creados movimiento
 - GET http://localhost:9090/bits/movimiento/version
 - GET http://localhost:9090/bits/movimiento
 
		{
		"idCliente":  "long", 
		"fechaInicio":  "dd/MM/yyyy",
		"fechaFin":  "dd/MM/yyyy"
		}

- POST http://localhost:9090/bits/movimiento

		{
		"cuenta": "long", 
		"tipoMovimiento":  "String ",
		"fechaMovimiento":  " dd/MM/yyyy ",
		"valorMovimiento":  " long "
		}
  
