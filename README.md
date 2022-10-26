### 1. Build Java projects & generate war files.

### 2. Go to the project directory where the "docker-compose.yml" file located. This file includes the all configurations that need to build & run all docker containers.

* Run below command to build your docker images.

> > _docker-compose build_

* Run below command to deploy & run your docker containers.

> > _docker-compose up_

* Run the containers with scaling.

> > _docker-compose up --scale [SERVICE_CONTAINER_NAME]=[NO_OF_CONTAINERS]_

* Stop containers.

> > _docker-compose stop_

### 3. Explanation about "docker-compose.yml".

### **database :**

* This is responsible for get & run a mysql container.
* This has been configured to set a server root password and also to create a new database & users (db:"upwork" | user:"
  upwork" | password:"upwork").
* This db server will be run on port 8010 within the VM and that port has been configured in "docker-compose.yml".

### **server :**

* This is responsible for get & run a tomcat (version 9) server container.
* This will get the already built war file from the "target" directory within the project directory and then copy it to
  the "webapps" directory of tomcat server.
* This tomcat server will be run on port 8020 within the VM and that port has been configured in "application.yml".

### **nginx :**

* This is responsible for get & run nginx server container.
* This server will act as the load balancer for our deployed service.
* Configurations for nginx server is in the "nginx.conf" (check "nginx" directory within the project directory).
* This nginx server will be run on port 80 within the docker container, and it has been exposed to outside using port
  8000 (check "docker-compose.yml").
* When we send a request to port 8000, then it will be automatically redirected to an available service.
* Example :
    * run "**_docker-compose up --scale server=3_**" command.
    * this will start 3 containers of the "server" in this case. Let's say they are service-1, service-2, service-3.
    * Now there are 5 containers are running within our main container.
        * database
        * server (service-1)
        * server (service-2)
        * server (service-3)
        * nginx
    * run below curl command 3 times parallel to test the API.
  > > curl --location --request POST 'http://localhost:8000/authentication-service/v1/auth/login' --header '
  Content-Type: application/json' --data-raw '{"username": "prasadm","password": "123456789"}'
    * first request will be sent to the "service-1"
    * second request will be sent to the "service-2"
    * third request will be sent to the "service-3"