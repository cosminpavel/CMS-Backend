import com.ubb.cms.model.*;
import com.ubb.cms.model.utils.PaperStatus;
import com.ubb.cms.repository.AbstractRepository;
import com.ubb.cms.repository.IRepository;
import com.ubb.cms.repository.PaperRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by Alexandra Muresan on 4/5/2017.
 */
public class Main {

    public static void main(String[] args) {

//        UserRepository userRepository = new UserRepository();
        //userRepository.addUser( new User(4,"raul","abc","raul","raul","muresan","abc"));
        //userRepository.deleteUser(3);


        //Participation participation = new Participation(new UserEditionEmb(),true);

        /*ist<User> list = userRepository.getAll();
        System.out.println("lista ID Useri");
        for(User user : list)
        {
            System.out.println(user.getId());
        }*/

        //User user = userRepository.findById(3);
        //System.out.println(user.getName() + " " + user.getSurname() + " " + user.getUsername());


        //Conference conference = new Con

        /*Configuration con = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Conference.class).addAnnotatedClass(Edition.class).addAnnotatedClass(ConferenceSession.class).addAnnotatedClass(User.class).addAnnotatedClass(SessionChair.class).addAnnotatedClass(Participation.class).addAnnotatedClass(Paper.class).addAnnotatedClass(Review.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        User user = new User(1,"raul","abc","raul","raul","muresan","abc");
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.save(user);
        t.commit();
        sf.close();
        System.out.println("Done");*/

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring-repository.xml");
        IRepository<Paper> paperRepository = applicationContext.getBean(PaperRepository.class);
        SessionFactory sessionFactory = applicationContext.getBean(SessionFactory.class);
        IRepository<Edition> editionIRepository = new AbstractRepository<>(sessionFactory, Edition.class);
        IRepository<User> userIRepository = new AbstractRepository<>(sessionFactory, User.class);
        IRepository<Conference> conferenceIRepository = new AbstractRepository<>(sessionFactory, Conference.class);
        IRepository<ConferenceSession> conferenceSessionIRepository = new AbstractRepository<>(sessionFactory, ConferenceSession.class);

        Integer conferenceId = (Integer) conferenceIRepository.save(new Conference("Conf 1asdad"));
        Edition edition = new Edition(
                conferenceIRepository.findById(conferenceId),
                new Date(),
                new Date(),
                "Edition 1",
                new Date(),
                new Date()
        );
        User author = new User(
                "username1",
                "pass1",
                "user@email.com",
                "name",
                "surname1",
                "what does tag mean?"
        );

        Integer userId = (Integer) userIRepository.save(author);
        Integer editionId = (Integer) editionIRepository.save(edition);

        ConferenceSession conferenceSession = new ConferenceSession(
                editionIRepository.findById(editionId),
                new Date(),
                "Location should not be a string"
        );
        Integer confId = (Integer) conferenceSessionIRepository.save(conferenceSession);

        Paper test = new Paper(
                conferenceSessionIRepository.findById(confId),
                userIRepository.findById(userId),
                editionIRepository.findById(editionId),
                PaperStatus.InReview,
                "Some title",
                "some topic"
        );
        paperRepository.save(test);

        List<Paper> all = paperRepository.getAll();
    }
}
