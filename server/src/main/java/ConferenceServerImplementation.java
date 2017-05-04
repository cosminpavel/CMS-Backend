import com.ubb.cms.model.Edition;
import com.ubb.cms.model.User;
import com.ubb.cms.services.UserService;

import java.util.List;

/**
 * Created by Raul on 25/04/2017.
 */




public class ConferenceServerImplementation implements IConferenceServer {

    private UserService userService;


    public ConferenceServerImplementation(UserService userService)
    {
        this.userService = userService;
    }


    @Override
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @Override
    public List<Edition> getAllEditions() {
        return null;
    }
}
