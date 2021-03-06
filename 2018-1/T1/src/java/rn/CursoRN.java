package rn;


import entidade.aCurso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

/**
 *
 * @author neimarmoises
 */
public class CursoRN {

    public aCurso inserir(aCurso curso) {
        new JPAUtil().execInsert(curso, true);        
        return curso;
    }

    
    public List<aCurso> listar() {
        EntityManager manager = JPAUtil.getManager();

        TypedQuery<aCurso> query = manager.createQuery("SELECT m FROM aCurso m",aCurso.class);
        List<aCurso> listaCursos = query.getResultList();

        System.out.println("Curso:");
        for (aCurso m : listaCursos) {
            view.View.msg(m.getIdCurso()+ "-" + m.getIdModalidade()+ "-" + m.getIdProjetoCurso()+ "-" + m.getNomeCurso());
        }

        manager.close();

        return (listaCursos);
    }

    
    public aCurso buscarPorId(Long id) {
        EntityManager manager = JPAUtil.getManager();
    
        aCurso curso = manager.find(aCurso.class, id);
        manager.close();
        return curso;        
    }
    
    
    public aCurso atualizar(Long id, aCurso curso) throws Exception{
        EntityManager manager = JPAUtil.getManager();        
        aCurso cursoAtual = manager.find(aCurso.class,id);
        
        if(cursoAtual == null) throw new Exception();
        
        manager.getTransaction().begin();
     
        if(curso.getIdModalidade()!=null && !curso.getIdModalidade().equals(id))
            cursoAtual.setIdModalidade(curso.getIdModalidade());
        
        if(curso.getIdProjetoCurso()!=null && !curso.getIdProjetoCurso().equals(id))
            curso.setIdProjetoCurso(curso.getIdProjetoCurso());
        
        if(curso.getNomeCurso()!=null && !curso.getNomeCurso().isEmpty())
            cursoAtual.setNomeCurso(curso.getNomeCurso());     
        
        manager.getTransaction().commit();
        
        manager.close();
        
        return cursoAtual;    }
    
    
    public aCurso deletar(Long id) throws Exception{
        EntityManager manager = JPAUtil.getManager();
        aCurso cursoAtual = manager.find(aCurso.class,id);
        new JPAUtil().execDelete(manager, cursoAtual, true);
        
        return (cursoAtual);

    }

}