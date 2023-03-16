# Product_Catalogue

<<<<<Product Catalogue Web Application>>>>>

-------------------------------------
application.properties
"app.upload.dir" is the file upload location.
"app.upload.file" is the input excel filename for storing in database.

SQL details are mentioned in here.
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=root
spring.datasource.password=root
# Data JPA Properties
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
---------------------------------------
Steps
1 - select the excel file to upload in location.
2 - click yes for storing excel data to sql.
3 - type the product name or product code to find the top most parent.
4 - provide a product name to find the child products of it.
5 - click yes to find the active and non-active products in db.
6 - press yes to find the average product price per Category L1 and Category L2.
---------------------------------------
TOOLS:
Spring Tool Suite 4 Version: 4.17.2.RELEASE
MySQL workbench 8.0.32
jdk 17
