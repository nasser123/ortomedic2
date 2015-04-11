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
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.Consulta;
import model.Paciente;
import model.Usuario;
import utilidades.ConnectionFactory;
import utilidades.Datas;

/**
 *
 * @author Nasser
 */
public class ConsultaDAO implements IDao {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    private EntityManager entity;

    public ConsultaDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object consulta) throws SQLException {
        if (consulta instanceof Consulta) {
            Consulta c = (Consulta) consulta;
            if (dadosValidos(c) && ehDisponivel(c.getDataConsulta(), c.getHoraConsulta())) {
                entity.getTransaction().begin();
                entity.persist(c);
                entity.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Consulta salva com sucesso.");
                return true;
            }
        }
        return false;
    }

    private boolean dadosValidos(Consulta c) {
        if (c.getDataConsulta() == null) {
            JOptionPane.showMessageDialog(null, "Data da consulta inválida");
            return false;
        }
        return true;
    }

    @Override
    public boolean excluir(Object Consulta) throws SQLException {
        if (Consulta instanceof Consulta) {
            Consulta c = (Consulta) Consulta;
            if (!entity.getTransaction().isActive()) {
                entity.getTransaction().begin();
                entity.remove(c);
                entity.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Consulta excluida com sucesso.");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Essa consulta não pode ser excluida.");
        return false;
    }

    @Override
    public Consulta pesquisarPorId(int id) throws SQLException {
        Consulta c = null;
        List consulta = entity.createNamedQuery("Consulta.findByIdconsulta").setParameter("idconsulta", id).getResultList();
        if (!consulta.isEmpty()) {
            c = (Consulta) consulta.get(0);
            return c;
        }
        return null;
    }

    public List<Consulta> pesquisarPorPaciente(Paciente paciente) throws SQLException {
        Paciente p = null;
        List pacientes = entity.createNamedQuery("Consulta.findByidPaciente").setParameter("idpaciente", paciente).getResultList();
        if (!pacientes.isEmpty()) {
            return pacientes;
        }
        //JOptionPane.showMessageDialog(null, "Não foram encontradas consultas para esse paciente.");
        return null;
    }

    @Override
    public boolean alterar(Object objeto, boolean mensagem) throws SQLException {
        if (objeto instanceof Consulta) {
            Consulta c = (Consulta) objeto;
            if (!entity.getTransaction().isActive()) {
                entity.getTransaction().begin();
            }
            entity.merge(c);
            entity.getTransaction().commit();
            if (mensagem) {
                JOptionPane.showMessageDialog(null, "Consulta alterada com sucesso.");
            }
            return true;
        }
        return false;
    }

    @Override
    public List<? extends Object> pesquisarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<? extends Object> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        Query query = entity.createNativeQuery("Select * from consulta order by " + criterioOrdenamento, Consulta.class);
        List usuarios = query.getResultList();
        if (!usuarios.isEmpty()) {
            return usuarios;
        }
        return null;
    }

    public boolean ehDisponivel(Date data, Date hora) {
        Query query = entity.createNamedQuery("Consulta.findByDisponibilidade").setParameter("dataConsulta", data).setParameter("horaConsulta", hora);
        List<Consulta> consultas = query.getResultList();
        if (!consultas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Horário não disponível");
            return false;
        }
        return true;
    }

}
