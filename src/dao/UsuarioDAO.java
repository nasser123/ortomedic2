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

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.TipoUsuario;
import model.Usuario;
import utilidades.ConnectionFactory;
import utilidades.Senhas;

/**
 *
 * @author Nasser
 */
public class UsuarioDAO implements IDao {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    private EntityManager entity;

    public UsuarioDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object usuario) throws SQLException {
        if (usuario instanceof Usuario) {
            Usuario u = (Usuario) usuario;
            if (!existeUsuario(u.getUsuario()) && dadosValidos(u)) {
                entity.getTransaction().begin();
                entity.persist(u);
                entity.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso.");
                return true;
            }
        }
        return false;
    }

    private boolean dadosValidos(Usuario u) {
        if (u.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'nome' não pode ser vazio");
            return false;
        } else {
            if (u.getSenha().equals("")) {
                JOptionPane.showMessageDialog(null, "Campo 'senha' não pode ser vazio");
                return false;
            } else {
                if (u.getUsuario().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campo 'senha' não pode ser vazio");
                    return false;
                }
            }
        }
        return true;

    }

    public boolean inserir(String nome, String telefone, String celular, char[] senha, String usuario, TipoUsuario tipoUsuario) throws SQLException {
        Usuario u = new Usuario(null, nome, celular, usuario, telefone, celular, tipoUsuario);

        if (!existeUsuario(u.getUsuario())) {
            u.setTelefone(telefone);

            if (!entity.getTransaction().isActive()) {
                entity.getTransaction().begin();
            }
            entity.persist(u);
            entity.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso.");
            return true;
        }
        JOptionPane.showMessageDialog(null, "Verifique os dados digitados");
        return false;
    }

    @Override
    public boolean excluir(Object usuario) throws SQLException {
        if (usuario instanceof Usuario) {
            Usuario u = (Usuario) usuario;
            if (!entity.getTransaction().isActive()) {
                entity.getTransaction().begin();
                entity.remove(u);
                entity.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso.");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Esse usuário não pode ser excluido.");
        return false;
    }

    private boolean existeUsuario(String usuario) {
        Usuario u = null;
        List usuarios = entity.createNamedQuery("Usuario.findByUsuario").setParameter("usuario", usuario).getResultList();
        if (!usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Já existe cadastro com esse usuario.");
            return true;
        }
        return false;
    }

    @Override
    public Usuario pesquisarPorId(int id) throws SQLException {
        Usuario u = null;
        List usuarios = entity.createNamedQuery("Usuario.findByIdusuario").setParameter("idusuario", id).getResultList();
        if (!usuarios.isEmpty()) {
            u = (Usuario) usuarios.get(0);
            return u;
        }
        return null;
    }

    public Usuario pesquisarPorUsuario(String usuario) throws SQLException {
        Usuario u = null;
        List usuarios = entity.createNamedQuery("Usuario.findByUsuario").setParameter("usuario", usuario).getResultList();
        if (!usuarios.isEmpty()) {
            u = (Usuario) usuarios.get(0);
            return u;
        }
        JOptionPane.showMessageDialog(null, "Usuário digitado não existe.");
        return null;
    }

    @Override
    public boolean alterar(Object objeto, boolean mensagem) throws SQLException {
        if (objeto instanceof Usuario) {
            Usuario u = (Usuario) objeto;
            if (dadosValidos(u)) {
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                }
                entity.merge(u);
                entity.refresh(u);
                entity.getTransaction().commit();
                if (mensagem) {
                    JOptionPane.showMessageDialog(null, "Usuario alterado com sucesso.");
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
        Query query = entity.createNativeQuery("Select * from Usuario order by " + criterioOrdenamento, Usuario.class
        );
        List usuarios = query.getResultList();

        if (!usuarios.isEmpty()) {
            return usuarios;
        }

        return null;
    }

    public boolean verificaLogin(String usuario, char[] senha) throws SQLException, NoSuchAlgorithmException {
        Usuario u = pesquisarPorUsuario(usuario);
        String s = Senhas.toMD5(senha);
        if (u != null) {
            if (Senhas.testaSenhasCadastro(s, u.getSenha())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
