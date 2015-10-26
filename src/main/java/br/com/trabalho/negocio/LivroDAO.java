package br.com.trabalho.negocio;
import br.com.trabalho.entidade.Livro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LivroDAO extends AbstractDAO<Livro> {
   
    public LivroDAO() {
        super(Livro.class);
    }

    @Override
    protected Logger getLogger() {
        return LoggerFactory.getLogger(this.getClass());
    }

}




