package br.com.trabalho.negocio;
import br.com.trabalho.util.Conexao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;


public abstract class AbstractDAO<T> implements Serializable {

    private Class classe;
    private EntityManager entityManager;

    public AbstractDAO(Class classe) {
        this.classe = classe;
        this.entityManager = Conexao.createInstance().getEntityManager();
    }

    public void salvar(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    public List<T> listaTodos() {
        Query q = getEntityManager().createQuery("from " + classe.getSimpleName(), classe);
        return q.getResultList();
    }

    protected abstract Logger getLogger();

    public Class getClasse() {
        return classe;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
