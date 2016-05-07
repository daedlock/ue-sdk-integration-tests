require "ue-ruby-sdk"
require "json"
require File.dirname(__FILE__) + "/lib/common_wrappers"

print_success "Success Ruby Test"


conf = JSON.parse File.read "../common/conf.json"

print_error "Fail Ruby Test"

puts "Running Test";
app = UEApp.new("UE_APP_ID","UE_APP_SECRET")

puts app.inspect
