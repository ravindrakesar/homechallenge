package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {
    protected static String PARENT_PROJECT_PATH = "";
    static {
        try {
            PARENT_PROJECT_PATH = Paths.get(Utils.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().getParent().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    protected final static String REGISTER_INPUTDATA_FILE_FOLDER = PARENT_PROJECT_PATH + "\\src\\main\\java\\data\\";

    public static String getGlobalValue(String property) throws IOException, URISyntaxException {

        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(PARENT_PROJECT_PATH + "\\src\\test\\java\\utilities\\global.properties");
        prop.load(fileInputStream);
        return prop.getProperty(property);
    }
}
