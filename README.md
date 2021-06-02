# gcp_project
A very small project that uses Google Cloud Platform to run a web server and a mySQL server.
the database has one single table of courses each with their own  

Subject Code (ex. CMPT)  
Course Code (ex. 101)  
Name (ex. Intro to Computing)  
Description (ex. This course deals with....)  

This web app is written in Java and uses Spring.

## How to run this project

### Set-up 
#### VMs
first things first you'll need to [create a GCP project](https://console.cloud.google.com/home)
then, a mySQL instance and a compute engine VM. You can read more about setting those up [here](https://cloud.google.com/compute/docs/how-to).

once those are created you'll need to connect the two together so the web server can read and write to the database
(Read up on that [here](https://cloud.google.com/architecture/mysql-remote-access)).

In order to access the web app, the web server will need a public IP address (read how to set that up [here](https://cloud.google.com/compute/docs/ip-addresses)).

#### Web App
After the VMs' are ready to go, you need to set up the environment for the web app. The easiest way to do this is with [docker](https://docs.docker.com/get-started/)
or you can use the `./mvnw` command included in the project (read more [here](https://spring.io/quickstart)).

### Demo
The last step is to get the project running. Make sure both the web server and mySQL server are running  
using the Cloud Shell, start the web app with either a `docker run [image path]` or `./mvnw spring-boot:run`.

once the web app is running, open the terminal and `curl` to the web server's external IP address  
the web app has two endpoints `/add` and `/all`  

first to add a course to the DB  
`curl [IP address]/add CMPT 101 "Intro to Computing" "short description"`  

this will respond with a "course saved" message  
then we can view the course we just created  
`curl [IP address]/all`

