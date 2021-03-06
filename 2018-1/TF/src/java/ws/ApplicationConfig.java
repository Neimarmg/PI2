/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author LHRIES
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ws.CursoWS.class);
        resources.add(ws.HorarioProfessorWS.class);
        resources.add(ws.HorariosAulasWS.class);
        resources.add(ws.MenusWS.class);
        resources.add(ws.PessoaWS.class);
        resources.add(ws.PlanoAulasWS.class);
        resources.add(ws.PredioWS.class);
        resources.add(ws.ProfessorWS.class);
        resources.add(ws.ProjetoCursoWS.class);
        resources.add(ws.SalasWS.class);
        resources.add(ws.TipoUtilitarioWS.class);
        resources.add(ws.TurmaDisciplinasWS.class);
        resources.add(ws.UnidadeHabilitacaoWS.class);
        resources.add(ws.UsuarioWS.class);
        resources.add(ws.UtilitarioWS.class);
        resources.add(ws.disciplinaWS.class);
        resources.add(ws.modalidadeWS.class);
    }
    
}
