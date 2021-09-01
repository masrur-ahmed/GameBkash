# GameBkash

In order to run the repository you will need to install: 
1. Postman
2. Jdbc\
And of course spring boot. 


The repo uses in memory H2 database. So you dont need to create any database for this. \
At first please change the artifact id and name or else please change the folder name to "GameBkash" to "BKASH".\
Change the application.properties based on your h2 database JDBC URL and port for spring boot to start. (Here it's 8083)

Finally, Build the maven as clean install. 

The repository is ready to run. 

In order to test the APIs, Please follow the methods in postman.

1. #PostRequest localhost:8083/registerGame/ 
in the body -> raw select Json and put 
{
        "name" : "genshin",
        "maxConcurrentUsers" : 10,
        "perMinuteCost": 10
}\

2. #DeleteRequest localhost:8080/unregisterGame/{gameId} \
3. #PostRequest localhost:8080/addPlayer  --> to get a playerID\
4. #PutRequest localhost:8080/updatePlayer/1\
and body as same as the first one, 
{
    "playerId" : 1,
    "playerName" : "masrur",
    "balance" : 100,
    "phone": "019"

}\
5. #GetRequest localhost:8080/getPlayerDetails/{PlayerId}\
6. #GetRequest localhost:8080/getListOfPlayers\
7. #PostRequest localhost:8083/onBoard\
8. #PutRequest localhost:8083/newGameSession/{playerId}/{gameId}\
9. #DeleteRequest localhost:8083/endGameSession/{SessionId}\
10. #GetRequest localhost:8083/currentActiveSessions\
11. #GetRequest localhost:8083/generateBillForPlayer/{playerID}\



in order to check the database: http://localhost:8083/h2-console/


Things to do soon to update the code: 
1. Include service layer 
2. Move to dynamodb
3. Store the HttpSession in Database
