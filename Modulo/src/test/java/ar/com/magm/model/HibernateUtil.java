package ar.com.magm.model;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    private synchronized static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        //configuration.configure(new File("D:\\Users\\feder\\IUA\\ingWebIII\\cabanilla\\ing-web3-2017\\Modulo\\src\\test\\java\\hibernate.cfg.xml"));
        //configuration.configure(new File("D:\\IUA\\ingWeb3\\cabanilla\\ing-web3-2017\\Modulo\\src\\test\\java\\hibernate.cfg.xml"));
        configuration.configure(new File("C:\\Users\\matia\\Desktop\\web3Version1\\ing-web3-2017\\Modulo\\src\\test\\java\\hibernate.cfg.xml"));
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public synchronized static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            return buildSessionFactory();
        } else {
            return sessionFactory;
        }
    }

    public synchronized static void shutdown() {
        getSessionFactory().close();
    }

    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    public static Session getSession() throws HibernateException {
        Session session = threadLocal.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                buildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            threadLocal.set(session);
        }

        return session;
    }

    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }
}
