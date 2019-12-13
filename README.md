
App Usage

**************************
Build
**************************
mvn clean install 
java -jar target/dynamic-pricer-1.1.8.RELEASE.jar 

**************************
Skip Tests
**************************
mvn clean install -DskipTests 

**************************
Debug Mode
**************************

java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar target/dynamic-pricer-1.1.8.RELEASE.jar


**************************
Save Product Survey
**************************
http://localhost:8080/productservey/?data={"barcode":"BC002", "price":11113,	"notes":"NoteshereforServey", "store":"Prizy"}

**************************
GET Product (Single using Barcode)
**************************

http://localhost:8080/product/barcode_product

e.g http://localhost:8080/product/BB001

**************************
GET Product (All)
**************************

http://localhost:8080/product


**************************
Rule File
**************************

Location of rule file is defined in src/main/resources/application.properties
Change the DB_NAME, USERNAME, PASSWORD to name of your MySQL Database name

spring.datasource.url = jdbc:mysql://localhost:3306/DB_NAME
spring.datasource.username:USERNAME
spring.datasource.password:PASSWORD


**************************
Ideal Price Rule
**************************
com/Prizy/Pricer/PriceFormula/PriceFormula.java
Above file implements two methods idealPrice(List<BigDecimal> list) and averagePrice(List<BigDecimal> list).
File excepts input as list type.
Implement these methods to implement the custom RULE.


**************************

**************************


