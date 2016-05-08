import com.google.gson.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by deadlock on 5/7/16.
 */
public class CommonWrappers {


    public static void printError(String msg) throws IOException, InterruptedException {

        ProcessBuilder pb = new ProcessBuilder("../../common/print.sh","-error",msg);
        pb.inheritIO();
        Process p = pb.start();
        p.waitFor();

    }

    public static void printSuccess(String msg) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("../../common/print.sh","-success",msg);
        pb.inheritIO();
        Process p = pb.start();
        p.waitFor();
    }

    public static Config getConfig() throws IOException {
        String json = FileUtils.readFileToString(new File("../../common/conf.json"));
        JsonObject conf = new JsonParser().parse(json).getAsJsonObject();
        Config config = new Config();
        config.APP_KEY = conf.get("APP_KEY").getAsString();
        config.APP_SECRET = conf.get("APP_SECRET").getAsString();
        config.FACEBOOK_TOKEN = conf.get("SERVICE_TOKENS").getAsJsonObject().get("FACEBOOK").getAsString();
        config.TWITTER_TOKEN = conf.get("SERVICE_TOKENS").getAsJsonObject().get("TWITTER").getAsString();
        return config;
    }
}
