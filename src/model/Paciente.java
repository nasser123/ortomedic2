/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import utilidades.Datas;
import utilidades.ValidaValores;

/**
 *
 * @author Nasser
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByIdpaciente", query = "SELECT p FROM Paciente p WHERE p.idpaciente = :idpaciente"),
    @NamedQuery(name = "Paciente.findByNome", query = "SELECT p FROM Paciente p WHERE p.nome = :nome"),
    @NamedQuery(name = "Paciente.findByTelefone1", query = "SELECT p FROM Paciente p WHERE p.telefone1 = :telefone1"),
    @NamedQuery(name = "Paciente.findByTelefone2", query = "SELECT p FROM Paciente p WHERE p.telefone2 = :telefone2"),
    @NamedQuery(name = "Paciente.findByEndereco", query = "SELECT p FROM Paciente p WHERE p.endereco = :endereco"),
    @NamedQuery(name = "Paciente.findByEmail", query = "SELECT p FROM Paciente p WHERE p.email = :email"),
    @NamedQuery(name = "Paciente.findByCpf", query = "SELECT p FROM Paciente p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Paciente.findByDataNasc", query = "SELECT p FROM Paciente p WHERE p.dataNasc = :dataNasc")})
public class Paciente implements Serializable {

    @Column(name = "cpf")
    private String cpf;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaciente")
    private Integer idpaciente;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone1")
    private String telefone1;
    @Column(name = "telefone2")
    private String telefone2;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "email")
    private String email;
    @Column(name = "data_nasc")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "idconvenio", referencedColumnName = "idconvenio")
    @ManyToOne(optional = false)
    private Convenio idconvenio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpaciente")
    private List<Consulta> consultaList;
    @Transient
    private Integer idade;

    public Paciente() {
    }

    public Paciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Paciente(Integer idpaciente, String nome) {
        this.idpaciente = idpaciente;
        this.nome = nome.toUpperCase();
    }

    public Integer getIdade() {
        if (this.dataNasc != null) {
            this.idade = Datas.calculaIdade(this.dataNasc);
            return this.idade;
        } else {
            return null;
        }
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        Integer oldIdpaciente = this.idpaciente;
        this.idpaciente = idpaciente;
        changeSupport.firePropertyChange("idpaciente", oldIdpaciente, idpaciente);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome.toUpperCase();
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getTelefone1() {
        if (ValidaValores.ehTelefone(telefone1)) {
            return telefone1;
        } else {
            this.telefone1 = "";
            return telefone1;
        }
    }

    public void setTelefone1(String telefone1) {
        String oldTelefone1 = this.telefone1;
        if (ValidaValores.ehTelefone(telefone1)) {
            this.telefone1 = telefone1;
        } else {
            this.telefone1 = "";
        }
        changeSupport.firePropertyChange("telefone1", oldTelefone1, telefone1);
    }

    public String getTelefone2() {
        if (ValidaValores.ehTelefone(telefone2)) {
            return telefone2;
        } else {
            this.telefone2 = null;
            return telefone2;
        }
    }

    public void setTelefone2(String telefone2) {
        String oldTelefone2 = this.telefone2;
        if (ValidaValores.ehTelefone(telefone2)) {
            this.telefone2 = telefone2;
        } else {
            this.telefone2 = null;
        }
        changeSupport.firePropertyChange("telefone2", oldTelefone2, telefone2);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco.toUpperCase();
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        Date oldDataNasc = this.dataNasc;
        this.dataNasc = dataNasc;
        changeSupport.firePropertyChange("dataNasc", oldDataNasc, dataNasc);
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        String oldObservacoes = this.observacoes;
        this.observacoes = observacoes;
        changeSupport.firePropertyChange("observacoes", oldObservacoes, observacoes);
    }

    public Convenio getIdconvenio() {
        return idconvenio;
    }

    public void setIdconvenio(Convenio idconvenio) {
        Convenio oldIdconvenio = this.idconvenio;
        this.idconvenio = idconvenio;
        changeSupport.firePropertyChange("idconvenio", oldIdconvenio, idconvenio);
    }

    @XmlTransient
    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaciente != null ? idpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idpaciente == null && other.idpaciente != null) || (this.idpaciente != null && !this.idpaciente.equals(other.idpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Paciente[ idpaciente=" + idpaciente + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public String getCpf() {
            return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

}
