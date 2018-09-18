package DataBase;

import DAO.UserDataSetDAO;
import DataSet.AddressDataSet;
import DataSet.PhoneDataSet;
import DataSet.UserDataSet;
import com.mysql.jdbc.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;

public class DBServiceImpl implements DBService {
    private final SessionFactory sessionFactory;

    public DBServiceImpl() {
       sessionFactory = createSessionFactory(getBaseConfiguration());
    }
    public DBServiceImpl(Configuration cfg) {
        sessionFactory = createSessionFactory(cfg);
    }
    public static Configuration getBaseConfiguration() {
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(UserDataSet.class);
        configuration.addAnnotatedClass(PhoneDataSet.class);
        configuration.addAnnotatedClass(AddressDataSet.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernatetest");
        configuration.setProperty("hibernate.connection.username", "java_testUser");
        configuration.setProperty("hibernate.connection.password", "123456789");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.setProperty("hibernate.connection.useSSL", "false");
        configuration.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return  configuration;
    }
    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
    @Override
    public void saveUser(UserDataSet user) throws SQLException {
        runInSession(session -> {new UserDataSetDAO(session).save(user); return null;});
    }

    @Override
    public UserDataSet getUserById(long id) throws SQLException {
        return runInSession(session -> new UserDataSetDAO(session).getById(id));
    }

    @Override
    public List<UserDataSet> getAllUsers() throws SQLException {
        return runInSession(session -> new UserDataSetDAO(session).getAll());
    }

    @Override
    public List<UserDataSet> getUserByName(String name) throws SQLException {
        return runInSession(session -> new UserDataSetDAO(session).getByName(name));
    }

    @Override
    public void shutdown() {
        sessionFactory.close();
    }

    private <T> T runInSession(Function<Session, T> function) {
        try (Session session = sessionFactory.openSession()){
            Transaction t = session.beginTransaction();
            T res = function.apply(session);
            t.commit();
            return res;
        }
    }
}
