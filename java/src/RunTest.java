import com.unificationengine.exceptions.UnificationEngineException;
import com.unificationengine.models.UEApp;
import com.unificationengine.models.UEUser;

import java.io.IOException;

public class RunTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(System.getProperty("user.dir"));
        Config conf = CommonWrappers.getConfig();
        UEApp app = new UEApp(conf.APP_KEY, conf.APP_SECRET);


        try {
            UEUser user = app.createUser();
            CommonWrappers.printSuccess("Create User");

        } catch (Exception e) {
            CommonWrappers.printError("Create User");
        }

    }


}
