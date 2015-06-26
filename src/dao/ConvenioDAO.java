/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.Convenio;
import utilidades.ConnectionFactory;

/**
 *
 * @author Nasser
 */
public class ConvenioDAO implements IDao {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    private EntityManager entity;

    public ConvenioDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object convenio) throws SQLException {
        if (convenio instanceof Convenio) {
            Convenio c = (Convenio) convenio;
            if (ehNome(c)) {
                if (!existeConvenio(c.getDescricao())) {
                    entity.getTransaction().begin();
                    entity.persist(c);
                    entity.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Convênio salvo com sucesso.");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean inserir(String descricao, String observacoes) throws SQLException {
        Convenio c = new Convenio(descricao, observacoes);
        if (ehNome(c)) {
            if (!existeConvenio(c.getDescricao())) {
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                }
                entity.persist(c);
                entity.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Convênio salvo com sucesso.");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluir(Object convenio) throws SQLException {
        if (convenio instanceof Convenio) {
            Convenio c = (Convenio) convenio;
            if (c.getPacienteList().isEmpty()) {
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                }
                entity.remove(c);
                entity.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Convênio excluido com sucesso.");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Esse convênio não pode ser excluido.");
        return false;
    }

    private boolean existeConvenio(String descricao) {
        Convenio c = null;
        List convenios = entity.createNamedQuery("Convenio.findByDescricao").setParameter("descricao", descricao).getResultList();
        if (!convenios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Já existe convenio cadastrado com essa descrição.");
            return true;
        }
        return false;
    }

    private boolean ehNome(Convenio convenio) {
        if (convenio.getDescricao().equals("") || convenio.getDescricao() == null) {
            JOptionPane.showMessageDialog(null, "Nome do convenio inválido");
            return false;
        } else {
            return true;
        }

    }

    @Override
    public Convenio pesquisarPorId(int id) throws SQLException {
        Convenio c = null;
        List convenios = entity.createNamedQuery("Convenio.findByIdconvenio").setParameter("idconvenio", id).getResultList();
        if (!convenios.isEmpty()) {
            c = (Convenio) convenios.get(0);
            return c;
        }
        return null;
    }

    @Override
    public boolean alterar(Object objeto, boolean mensagem) throws SQLException {
        if (objeto instanceof Convenio) {
            Convenio c = (Convenio) objeto;
            if (ehNome(c)) {
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                }
                entity.merge(c);
                entity.getTransaction().commit();
                if (mensagem) {
                    JOptionPane.showMessageDialog(null, "Convênio alterado com sucesso.");
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public List<? extends Object> pesquisarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<? extends Object> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        Query query = entity.createNativeQuery("Select * from Convenio order by " + criterioOrdenamento, Convenio.class);
        List convenios = query.getResultList();
        if (!convenios.isEmpty()) {
            return convenios;
        }
        return null;
    }

}
