# User's Information  Application
User's-Information-Application is a simple crud application that stores user data.
### The app has following basic features.
- Data is composed of first name, last name, email, address (street, city, state and zip)
- The app creates the following User types (Parent, Child). The child cannot have an address and Must belong to a parent
- App has API to:
    1. Delete user data
    2. Create user data
    3. Update user data
- Data is saved in In-Memory Database (h2)
- Readme file describing how to install/run the application
- Unit Test
### Preparing Environment to run the application
#### Install java 8
To run user's-information-application system must have java environment(Java 8). To install java 8 in your Linux environment
```
sudo apt-get update
sudo apt-get install openjdk-8-jdk
``` 
To check java is installed or not, run
```
java -version
```
#### Install maven
user-data-operator-application is a maven project. To build the jar file system must have maven installed. To install maven, run
```$xslt
sudo apt -y install maven
sudo maven -version
``` 
#### Installing git
It is recommended to install git in the system. To install git
```$xslt
sudo apt install git
git --version
``` 
#### Installing Docker
If anyone wants to run the project on Docker engine, it is must to install Docker. In this application we are going to use MongoDB which also going to run on Docker engine. So it is highly recommended to install docker.
```$xslt
sudo apt-get remove docker docker-engine docker.io containerd runc
sudo apt-get update
sudo apt-get install \
      apt-transport-https \
      ca-certificates \
      curl \
      gnupg-agent \
      software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo apt-key fingerprint 0EBFCD88

sudo add-apt-repository \
     "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
     $(lsb_release -cs) \
     stable"
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io
sudo apt-get install docker-ce=5:20.10.0~3-0~ubuntu-bionic docker-ce-cli=5:20.10.0~3-0~ubuntu-bionic containerd.io
```
Run ```sudo docker images```. If it runs then Docker is installed and running.

#### Database
user's-information-application uses h2(In Memory) database. So no need to install any database

At this point our environment is ready and we are good to go to run the application.
To see the database : if you run jar file then open the browser and go to:
``` 
http://localhost:8083/h2-console/
login with: jdbc url: jdbc:h2:mem:app
username:zakaria
password:zakaria
```
If you run docker image , you can access database :
``` 
http://localhost:9090/h2-console/
login with: jdbc url: jdbc:h2:mem:app
username:zakaria
password:zakaria
```
### Running .jar file in the host machine
Application will be run on the 8083 port of the host machine. To run the application-

- Clone the code from github
``` 
```
- In the target folder .jar file is available. To run the application, go to the target folder and open a terminal. then

```$xslt
java -jar user-app.jar
```
*This app is also containerized and is  available in Docker hub. If Docker is Installed then go to console and run:
```$xslt
docker pull zshuvo26/user-app
docker images
```
make sure that there is zshuvo26/user-app in repository list. Then 
```$xslt
docker run -p 9090:8083 zshuvo26/user-app
```
The app will start running.When run is done then open postman to check the API's at-
```$xslt
http://localhost:9090/api/v1/users
```
### Documentation