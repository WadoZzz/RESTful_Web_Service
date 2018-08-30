
---- Run with deployed Docker image ----


 //pull project
 
1. git clone https://github.com/WadoZzz/RESTful_Web_Service.git


 //run MYSQL Server
 
2. cd RESTful_Web_Service && docker-compose up

 //connect application to database
 
3. docker run --link mysql-connect:db -p 8085:8080 -it --net restfulwebservice_default wadoz/rest 

4.Go http://localhost:8085/person and use REST request
