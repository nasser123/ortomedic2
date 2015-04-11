/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nasser
 */
@Entity
@Table(name = "convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convenio.findAll", query = "SELECT c FROM Convenio c"),
    @NamedQuery(name = "Convenio.findByIdconvenio", query = "SELECT c FROM Convenio c WHERE c.idconvenio = :idconvenio"),
    @NamedQuery(name = "Convenio.findByDescricao", query = "SELECT c FROM Convenio c WHERE c.descricao = :descricao")})
public class Convenio implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconvenio")
    private Integer idconvenio;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconvenio")
    private List<Paciente> pacienteList;

    public Convenio() {
    }

    public Convenio(Integer idconvenio) {
        this.idconvenio = idconvenio;
    }

    public Convenio(Integer idconvenio, String descricao) {
        this.idconvenio = idconvenio;
        this.descricao = descricao.toUpperCase();
    }

    public Convenio(String descricao, String observacoes) {
        this.descricao = descricao.toUpperCase();
        this.observacoes = observacoes;
    }

    public Integer getIdconvenio() {
        return idconvenio;
    }

    public void setIdconvenio(Integer idconvenio) {
        Integer oldIdconvenio = this.idconvenio;
        this.idconvenio = idconvenio;
        changeSupport.firePropertyChange("idconvenio", oldIdconvenio, idconvenio);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao.toUpperCase();
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        String oldObservacoes = this.observacoes;
        this.observacoes = observacoes;
        changeSupport.firePropertyChange("observacoes", oldObservacoes, observacoes);
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconvenio != null ? idconvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convenio)) {
            return false;
        }
        Convenio other = (Convenio) object;
        if ((this.idconvenio == null && other.idconvenio != null) || (this.idconvenio != null && !this.idconvenio.equals(other.idconvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Convenio[ idconvenio=" + idconvenio + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
