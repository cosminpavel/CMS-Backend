import com.ubb.cms.model.Edition;
import com.ubb.cms.model.User;

import java.util.List;

/**
 * Created by Raul on 25/04/2017.
 */
public interface IConferenceServer {

    List<User> getAllUser();

    List<Edition> getAllEditions();

}
