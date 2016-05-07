def print_error(msg)
    system(File.dirname(__FILE__) + "/../../common/print.sh -error " + "'" + msg + "'")
end

def print_success(msg)
  system(File.dirname(__FILE__) + "/../../common/print.sh -success "  + "'" + msg + "'")
end
