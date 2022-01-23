# pawa

* First, let's run our docker-compose.yml file. Run the command in the Docker folder's directory.
* docker-compose up -d. With this command, we will run mysql.

* Open the eureka, gateway, auth and pawatask microservices respectively on your ide, 
  or continue from the command line and run the commands below for each microservice in order.

  => gradlew bootRun
  
  Then run the commands in order in the client project's(pawa-task-client) directory;
  
  * npm install
  * npm start
  
  
  * You can reach the swagger document of the service.
  * http://localhost:8090/swagger-ui.html#/
  
  
