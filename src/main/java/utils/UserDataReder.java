package utils;

import dataObjects.UserDTO;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import java.io.InputStream;

public class UserDataReder {

    private final String userDataFile = "userinfo.yaml";

    public UserDTO getUser(String userName){
        UserDTO user = new UserDTO();

        Yaml yaml = new Yaml(new Constructor(UserDTO.class));
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(userDataFile);

         Iterable<Object> objects =  yaml.loadAll(inputStream);

         for (Object object : objects)
             if(((UserDTO)object).getUserName().equalsIgnoreCase(userName))
                 user = (UserDTO)object;

        return user;
    }

}
