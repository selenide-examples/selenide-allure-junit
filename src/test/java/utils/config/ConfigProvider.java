package utils.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {


    Config config = readConfig();

    static Config readConfig(){
        return
//                ConfigFactory.systemProperties().hasPath("testProfile")
//               ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
//               :
                ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");


    static String getLogin(String userRole){
        return readConfig().getString(String.format("usersParams.%s.login", userRole));
    }

    static String getPassword(String userRole){
        return readConfig().getString(String.format("usersParams.%s.password", userRole));
    }
}
