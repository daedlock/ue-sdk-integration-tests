<?php
error_reporting(0);
require_once __DIR__ . "/vendor/autoload.php";
require_once __DIR__ . "/lib/common_wrappers.php";
use UnificationEngine\Models\UEApp;
use UnificationEngine\Models\UEUser;

$conf = json_decode(file_get_contents(__DIR__ . "/../common/conf.json"), true);

$app = new UEApp($conf["APP_KEY"],$conf["APP_SECRET"]);

// CREATE USER
try {
  ob_start();
  $user = $app->create_user();
  ob_end_clean();
  print_success("Create User");
}
catch(Exception $e){
  ob_end_clean();
  print_error("Create User");
  echo "\t" . $e->getMessage() . "\n";
}


// ADD FACEBOOK CONNECTION
try {
  ob_start();
  $fb_connection = $user->add_connection("fb","facebook",$conf["SERVICE_TOKENS"]["FACEBOOK"]);
  ob_end_clean();
  print_success("Add Facebook Connection");
}
catch(Exception $e){
  ob_end_clean();
  print_error("Add Facebook Connection");
  echo "\t" . $e->getMessage() . "\n";
}


// ADD TWITTER CONNECTION
try {
  ob_start();
  $twitter_connection = $user->add_connection("tw","twitter",$conf["SERVICE_TOKENS"]["TWITTER"]);
  ob_end_clean();
  print_success("Add Twitter Connection");
}
catch(Exception $e){
  ob_end_clean();
  print_error("Add Twitter Connection");
  echo "\t" . $e->getMessage() . "\n";
}



// POST FACEBOOK PROFILE
$options = array(
    "receivers" => array(
        array(
            "name" => "Me"
        ),
        array(
            "name" => "Pae",
            "id" => "PAGE_ID_HERE"
        )
    ),
    "message" => array(
        "subject" => "test",
        "body" => "ABC",
        "image" => "http://politibits.blogs.tuscaloosanews.com/files/2010/07/sanford_big_dummy_navy_shirt.jpg",
        "link" => array(
            "uri" => "http://google.com",
            "description" => "link desc",
            "title" => "link title"
        )
    )
);

//POST TWEET
if($twitter_connection){
  $uris = $twitter_connection->send_message($options);
  if(count($uris) > 0){
    print_success("Post Tweet");
  }
  else {
    print_error("Post Tweet");
  }
}


//POST FB
if($fb_connection){
  $uris = $fb_connection->send_message($options);
  if(count($uris) > 0){
    print_success("Post Facebook Profile");
  }
  else {
    print_error("Post Facebook Profile");
  }
}


//TODO: POST FACEBOOK PAGE



//DELETE FACEBOOK CONNECTION
if($user->remove_connection($fb_connection->name)){
  print_success("Remove Facebook Connection");
}
else {
  print_error("Remove Facebook Connection");

}

//DELETE TWITTER CONNECTION
if($user->remove_connection($twitter_connection->name)){
  print_success("Remove Twitter Connection");
}
else {
  print_error("Remove Twitter Connection");

}

if($app->delete_user($user)){
  print_success("Delete User");
}
else {
  print_error("Delete User");
}
