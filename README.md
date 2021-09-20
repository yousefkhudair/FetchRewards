# FetchRewards
Fetch Rewards Interview Assessment
 
* POST /createTransaction : Saves a transaction to Transaction List
* POST /spendPoints : Process spend points
* GET /pointsBalance : Provides a Map of all payers and points

### JSON object structure for /createTransaction ###
Ex. 1) { "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }\
Ex. 2) { "payer": "UNILEVER", "points": 200, "timestamp": "2020-10-31T11:00:00Z" }\
Ex. 3) { "payer": "DANNON", "points": -200, "timestamp": "2020-10-31T15:00:00Z" }\
Ex. 4) { "payer": "MILLER COORS", "points": 10000, "timestamp": "2020-11-01T14:00:00Z" }\
Ex. 5) { "payer": "DANNON", "points": 300, "timestamp": "2020-10-31T10:00:00Z" }

### JSON object structure for /spendPoints ###
Ex. { "points": 5000 }


### JSON object structure for /pointsBalance ###
 *NO JSON NEEDED FOR GET REQUEST* 


### How to run Application ###
1. Clone repository
2. Using IDE of choice open file and navigate to InterviewApplication.java and run main
3. Navigate to Postman application (If already downloaded if not download Postman)
4. Select POST request option and use path : * http://localhost:8080/pointsBalance *
