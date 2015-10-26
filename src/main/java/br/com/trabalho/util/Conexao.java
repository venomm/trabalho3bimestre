package br.com.trabalho.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public final class Conexao {

    private static Conexao instance;
    private static EntityManagerFactory factory;

    private Conexao() {
        factory = Persistence.createEntityManagerFactory("trabalhoPU");
    }

    public static Conexao createInstance() {
        if (instance == null) {
            instance = new Conexao();
        }
        return instance;
    }

    public static void begin() {
        getEntityManager().getTransaction().begin();
    }

    public static void commit() {
        getEntityManager().getTransaction().commit();
    }

    public static void close() {
        getEntityManager().close();
        factory.close();
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
