package br.com.trabalho.controle;
import br.com.trabalho.entidade.Livro;
import br.com.trabalho.negocio.LivroDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "livroBean")
@ViewScoped
public class LivroBean implements Serializable {

    private LivroDAO dao;
    private Livro livro;
    

    public LivroBean() {
        livro = new Livro();
        dao = new LivroDAO();        
    }

    public void salvar() {
        dao.salvar(livro);
        livro = new Livro();
    }
    
    public List<Livro> getLivros() {
        return dao.listaTodos();
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
