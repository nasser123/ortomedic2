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
import model.Paciente;
import utilidades.ConnectionFactory;
import utilidades.ValidaValores;

/**
 *
 * @author Nasser
 */
public class PacienteDAO implements IDao {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    private EntityManager entity;

    public PacienteDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object paciente) throws SQLException {
        if (paciente instanceof Paciente) {
            Paciente p = (Paciente) paciente;
            if (ehValido(p)) {
                entity.getTransaction().begin();
                entity.persist(p);
                entity.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Paciente salvo com sucesso.");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluir(Object paciente) throws SQLException {
        if (paciente instanceof Paciente) {
            Paciente p = (Paciente) paciente;
            if (p.getConsultaList().isEmpty()) {
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                    entity.remove(p);
                    entity.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Paciente excluido com sucesso.");
                    return true;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Esse paciente não pode ser excluido.");
            }
        }
        return false;
    }

    @Override
    public Paciente pesquisarPorId(int id) throws SQLException {
        Paciente p = null;
        List paciente = entity.createNamedQuery("Paciente.findByIdpaciente").setParameter("idpaciente", id).getResultList();
        if (!paciente.isEmpty()) {
            p = (Paciente) paciente.get(0);
            return p;
        }
        return null;
    }

    @Override
    public boolean alterar(Object paciente, boolean mensagem) throws SQLException {
        if (paciente instanceof Paciente) {
            Paciente p = (Paciente) paciente;

            if (ehValido(p)) {
                atualizaConsultas(p);
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                }
                entity.merge(p);
                entity.getTransaction().commit();
                if (mensagem) {
                    JOptionPane.showMessageDialog(null, "Paciente alterado com sucesso.");
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Paciente> pesquisarTodos() throws SQLException {
        List pacientes = entity.createNamedQuery("Paciente.findAll").getResultList();
        return pacientes;
    }

    @Override
    public List<Paciente> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        Query query = entity.createNativeQuery("Select * from Paciente order by " + criterioOrdenamento, Paciente.class);
        List pacientes = query.getResultList();
        if (!pacientes.isEmpty()) {
            return pacientes;
        }
        return null;
    }

    private boolean ehValido(Paciente paciente) {
        if (!ehNome(paciente)) {
            return false;
        }
        if (existeCPF(paciente)) {
            return false;
        }
        if (!ValidaValores.ehCPF(paciente.getCpf())) {
            JOptionPane.showMessageDialog(null, "Campo CPF inválido");
            return false;
        }
        if (paciente.getDataNasc() == null) {
            JOptionPane.showMessageDialog(null, "Data de nascimento inválida");
            return false;
        }
        return true;
    }

    private boolean ehNome(Paciente paciente) {

        if (paciente.getNome().equals("") || paciente.getNome() == null) {
            JOptionPane.showMessageDialog(null, "Nome do paciente inválido");
            return false;
        } else {
            return true;
        }
    }

    private boolean existeCPF(Paciente paciente) {
        if (paciente.getCpf() == null) {
            JOptionPane.showMessageDialog(null, "O campo CPF não pode estar em branco");
            return true;
        }
        List pacientes = entity.createNamedQuery("Paciente.findByCpf").setParameter("cpf", paciente.getCpf()).getResultList();
        if (pacientes.isEmpty()) {
            return false;
        }
        if (pacientes.size() > 1) {
            JOptionPane.showMessageDialog(null, "Já existe um paciente cadastrado com esse CPF");
            return true;
        }
        Paciente p = (Paciente) pacientes.get(0);
        if (p.equals(paciente)) {
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Já existe um paciente cadastrado com esse CPF");
            return true;
        }
    }

    private void atualizaConsultas(Paciente paciente) {
        for (int i = 0; i < paciente.getConsultaList().size(); i++) {
            if (paciente.getConsultaList().get(i).getExames() != null
                    || paciente.getConsultaList().get(i).getMedicacao() != null
                    || paciente.getConsultaList().get(i).getReceita() != null
                    || paciente.getConsultaList().get(i).getSintomas() != null) {
                paciente.getConsultaList().get(i).setCompareceu(true);
            }

        }

    }
}
