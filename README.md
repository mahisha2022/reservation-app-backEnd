# Reservation App

## Authors 
* Alexander Ackermann
* Austin Alex
* Mahlet Drar

 -- we built restaurant reservation app that enable restaurant owners to manage their 
 --reservations, and customers can view restaurant information and easily make reservations. 
 --Our application uses latest web technologies, including java, spring framework, spring mvc, spring data, typescript, angular, and Rest.

DataBase schema:

Our app uses a relational database to store and manage data related to restaurants, 
reservations and customers. The relations between the tables are established using foreign keys.. 
for example the reservation table has a foreign keys to restaurant and customer tables.

API Design:

We uses a Restful API to enable communication between the front-end and back end components . The api consists of several endpoints such as
Restaurant endpoints: this endpoint allows clients to create a new restaurant, retrieve a list of restaurant by id , address or name,
Reservation endpoint that allow clients to make reservations, and retrieve existing reservations
Customer endpoint- this end point allows customers to manage their information.

Spring Data
We used spring data to map our model with the relational database and to perform CRUD operations
