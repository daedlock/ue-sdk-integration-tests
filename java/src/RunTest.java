import com.unificationengine.exceptions.UnificationEngineException;
import com.unificationengine.lib.message.Message;
import com.unificationengine.lib.message.MessageLink;
import com.unificationengine.lib.message.MessageOptions;
import com.unificationengine.lib.message.ReceiverTypes;
import com.unificationengine.models.UEApp;
import com.unificationengine.models.UEConnection;
import com.unificationengine.models.UEUser;

import java.io.IOException;

public class RunTest {

    public static MessageOptions getTestMessage() {
        //Specify Message Options
        MessageOptions options = new MessageOptions();

        //Add a message receiver (My wall)
        options.addReceiver(ReceiverTypes.ME);

        //Add a message receiver (My Page)
        options.addReceiver(ReceiverTypes.PAGE, "PAGE_ID");

        Message m = new Message();

        //Message Subject
        m.setSubject("Subject");

        //Message Image
        m.setImage("https://raw.githubusercontent.com/plu/JPSimulatorHacks/master/Data/test.png");

        //Message Body
        m.setBody("Java SDK Test Message!");


        //Message Link
        MessageLink mLink = new MessageLink();
        mLink.setDesc("Java SDK message desc");
        mLink.setTitle("Java SDK Msg Title");
        mLink.setUri("http://google.com");

        m.setLink(mLink);

        options.setMessage(m);
        return options;
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(System.getProperty("user.dir"));
        Config conf = CommonWrappers.getConfig();
        UEApp app = new UEApp(conf.APP_KEY, conf.APP_SECRET);


        UEUser user = null;
        UEConnection fbConnection = null, twitterConnection = null;
        try {
            user = app.createUser();
            CommonWrappers.printSuccess("Create User");

        } catch (Exception e) {
            CommonWrappers.printError("Create User");
            //No user, we can't run the rest of the test.
            System.exit(0);
        }


        // ADD FACEBOOK CONNECTION
        try {
            fbConnection = user.addConnection("javafb","facebook", conf.FACEBOOK_TOKEN);
            CommonWrappers.printSuccess("Add Facebook Connection");
        } catch (Exception e) {
            CommonWrappers.printError("Add Facebook Connection");
            System.out.println("\t" + e.getMessage());
        }


        // ADD TWITTER CONNECTION
        try {
            twitterConnection = user.addConnection("javatwitter","twitter", conf.TWITTER_TOKEN);
            CommonWrappers.printSuccess("Add Twitter Connection");
        } catch (Exception e) {
            CommonWrappers.printError("Add Twitter Connection");
            System.out.println("\t" + e.getMessage());
        }



        // Post Facebook Profile
        if(fbConnection != null) {
            try {
                fbConnection.sendMessage(getTestMessage());
                CommonWrappers.printSuccess("Post Facebook Profile");
            } catch (Exception e) {
                CommonWrappers.printError("Post Facebook Profile\"");
                System.out.println("\t" + e.getMessage());
            }
        }
        // Post Facebook Page
        // Post Tweet
        if(twitterConnection != null) {
            try {
                twitterConnection.sendMessage(getTestMessage());
                CommonWrappers.printSuccess("Post Tweet");
            } catch (Exception e) {
                CommonWrappers.printError("Post Tweet");
                System.out.println("\t" + e.getMessage());
            }
        }




        // Delete Facebook Connection
        if(fbConnection != null ) {
            try {
                user.removeConnection(fbConnection);
                CommonWrappers.printSuccess("Remove Facebook Connection");
            } catch (UnificationEngineException e) {
                e.printStackTrace();
                CommonWrappers.printError("Remove Facebook Connection");
                System.out.println("\t" + e.getMessage());
            }
        }
        // Delete Twitter Connection
        if(twitterConnection != null) {
            try {
                user.removeConnection(twitterConnection);
                CommonWrappers.printSuccess("Remove Twitter Connection");
            } catch (UnificationEngineException e) {
                e.printStackTrace();
                CommonWrappers.printError("Remove Twitter Connection");
                System.out.println("\t" + e.getMessage());
            }

        }
        // Delete User
        try {
            app.deleteUser(user.getUri());
            CommonWrappers.printSuccess("Delete User");
        } catch (UnificationEngineException e) {
            CommonWrappers.printError("Delete User");
            System.out.println("\t" + e.getMessage());
        }

    }


}
