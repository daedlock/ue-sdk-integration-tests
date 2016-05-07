require "ue-ruby-sdk"
require "json"
require File.dirname(__FILE__) + "/lib/common_wrappers"


#Takes a boolean value and a msg, then prints success or error msg based on bool value
def report_test_result success, msg
  if(success)
    print_success msg
  else
    print_error msg
  end
end


conf = JSON.parse File.read "../common/conf.json"
app = UEApp.new(conf["APP_KEY"],conf["APP_SECRET"])


# CREATE USER
user = app.create_user
report_test_result user, "Create User"

# ADD FACEBOOK CONNECTION
fb_connection = user.add_connection "fbruby","facebook", conf["SERVICE_TOKENS"]["FACEBOOK"]
if fb_connection.class.name == "UEConnection"
  print_success "Add Facebook Connection"
else
  print_error "Add Facebook Connection"
  puts "\t" + fb_connection[:info]
end


# ADD TWITTER CONNECTION
twitter_connection = user.add_connection "twruby","twitter", conf["SERVICE_TOKENS"]["TWITTER"]
if twitter_connection.class.name == "UEConnection"
  print_success "Add Twitter Connection"
else
  print_error "Add Twitter Connection"
  puts "\t" + twitter_connection[:info]
end




options = {
    receivers:[
        {
            name: "Me"
        }
    ],
    message:{
        subject:"Test Message for Ruby SDK",
        body: "UnificationEngine",
        image:"http://politibits.blogs.tuscaloosanews.com/files/2010/07/sanford_big_dummy_navy_shirt.jpg",
        link:{
            uri: "http://google.com",
            description: "link desc",
            title:"link title"
        }
    }
}

# POST FACEBOOK PROFILE
if fb_connection.class.name == "UEConnection"
  report_test_result fb_connection.send_message(options).count > 0, "Post Facebook Profile"
end
# POST TWEET
if twitter_connection.class.name == "UEConnection"
  report_test_result twitter_connection.send_message(options).count > 0, "Post Tweet"
end
# POST FB
# TODO: POST FACEBOOK PAGE


# DELETE FACEBOOK CONNECTION
if fb_connection.class.name == "UEConnection"
  report_test_result user.remove_connection(fb_connection.name), "Remove Facebook Connection"
end
# DELETE TWITTER CONNECTION
if twitter_connection.class.name == "UEConnection"
  report_test_result user.remove_connection(twitter_connection.name), "Remove Twitter Connection"
end


# DELETE USER
report_test_result app.delete_user(user), "Delete User"
