var UEClient = require('ue-node-sdk');
var Promise = require ("bluebird");

var printSuccess = require(__dirname + "/lib/common_wrappers.js").printSuccess;
var printError = require(__dirname + "/lib/common_wrappers.js").printError;

var conf = require(__dirname + "/../common/conf.json");
var app = new UEClient(conf.APP_KEY, conf.APP_SECRET);

var message = {
  "receivers":[
    {
      "name":"Me"
    }
  ],
  "message":{
    "subject":"Test Subject",
    "body": "Test Message",
    "image":"http://images.hngn.com/data/thumbs/full/163112/650/0/0/0/anonymous.jpg",
    "link":{
      "uri": "http://google.com",
      "description": "Test Link Description",
      "title":"Test Link title"
    }
  }
};
// CREATE USER
app.createUser().then(function (user) {
  printSuccess("Create User");
  return user;
})
.catch(function (err) {
  printError("Create User");
  console.log("\t" + err.info.replace("\n",""));
})
.then(function(user){
  //Promises for all connections. We wait for them to complete to remove the user
  var connections = [];
  var fbConnection,twConnection;
  // ADD FACEBOOK CONNECTION
  connections.push(
    user.addConnection("Fb_node","facebook", conf.SERVICE_TOKENS.FACEBOOK)
    .then(function (facebookConnection) {
      printSuccess("Add Facebook Connection");
      fbConnection = facebookConnection;
      return facebookConnection;
    })
    .catch(function (err) {
      printError("Add Facebook Connection");
      console.log("\t" + err.info.replace("\n",""));
    })
    .then(function(facebookConnection){
      if(!facebookConnection) return;
      return facebookConnection.sendMessage(message)

    }).then(function (uris) {
      if(uris.length)
        printSuccess("Post Facebook Profile");
      else {
        printError("Post Facebook Profile");

      }
    })
    .catch(function(err) {
      printError("Post Facebook Profile");
    })
    .then(function () {
      if(fbConnection){
        return user.removeConnection(fbConnection.name);
      }
    })
    .then(function () {
      if(!fbConnection) return;
      printSuccess("Remove Facebook Connection");
    })
    .catch(function () {
      printError("Remove Facebook Connection")
      console.log("\t" + err.info.replace("\n",""));
    })

  )





  // ADD TWITTER CONNECTION
  connections.push(
    user.addConnection("Tw_node","twitter", conf.SERVICE_TOKENS.TWITTER)
    .then(function (twitterConnection) {
      printSuccess("Add Twitter Connection");
      twConnection = twitterConnection;
      return twitterConnection;
    })
    .catch(function (err) {
      printError("Add Twitter Connection");
      console.log("\t" + err.info.replace("\n",""));
    })
    .then(function(twitterConnection){
      if(!twitterConnection) return;
        return twitterConnection.sendMessage(message)

    }).then(function (uris) {
      if(uris.length)
        printSuccess("Post Tweet");
      else {
        printError("Post Tweet");

      }
    })
    .catch(function(err) {
      printError("Post Tweet");
    })
    .then(function () {
      if(twConnection){
        return user.removeConnection(twConnection.name);
      }
    })
    .then(function () {
      if(!twConnection) return;
      printSuccess("Remove Twitter Connection");
    })
    .catch(function () {
      printError("Remove Twitter Connection")
      console.log("\t" + err.info.replace("\n",""));
    })

  )



  //Wait for all connection related stuff to finish (post msgs, tweets)
  Promise.all(connections).then(function () {
    //Clean up, delete user
    app.deleteUser(user)
    .then(function(){
      printSuccess("Delete User");
    })
    .catch(function (error) {
      printError("Delete User");
      console.log("\t" + err.info.replace("\n",""));
    })
  })

})
