package utils;

import dataObjects.UserDTO;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class UserDataReder {

    private final String userDataFile = "userinfo.yaml";
    private Yaml yaml;
    private UserDTO user;
    private InputStream inputStream;

    public UserDTO getUser(String userName) {
        user = new UserDTO();
        yaml = new Yaml(new Constructor(UserDTO.class));
        inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(userDataFile);

        Iterable<Object> objects = yaml.loadAll(inputStream);

        for (Object object : objects)
            if (((UserDTO) object).getUserName().equalsIgnoreCase(userName))
                user = (UserDTO) object;

        return user;
    }

}
