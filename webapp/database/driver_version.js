const mongodb = require('mongodb');
const mongodbClient = mongodb.MongoClient;

// set host and port for mongodb connection
const mongodbHost = '130.61.73.74';
const mongodbPort = '27017';

// set mongodb connection url
const url = 'mongodb://' + mongodbHost + ':' + mongodbPort;

// check MongoDB connection and print node.js driver version into the console
mongodbClient.connect(url, { useNewUrlParser: true }, (err, client) => {

    if (err) throw err;

    console.log(client.topology.clientInfo);
    document.getElementById("demo").innerHTML = client.topology.clientInfo

    client.close();
});