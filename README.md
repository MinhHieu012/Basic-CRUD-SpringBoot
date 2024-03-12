### Java JDK 17

### Usage

Customize to connect database in resources/application.properties

spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:your_port_db/db_name
spring.datasource.username=db_username
spring.datasource.password=db_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql: true
server.port=port_to_run_project(optional)
