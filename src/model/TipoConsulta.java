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
@Table(name = "tipo_consulta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoConsulta.findAll", query = "SELECT t FROM TipoConsulta t"),
    @NamedQuery(name = "TipoConsulta.findByIdtipoConsulta", query = "SELECT t FROM TipoConsulta t WHERE t.idtipoConsulta = :idtipoConsulta"),
    @NamedQuery(name = "TipoConsulta.findByDescricao", query = "SELECT t FROM TipoConsulta t WHERE t.descricao = :descricao")})
public class TipoConsulta implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_consulta")
    private Integer idtipoConsulta;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoConsulta")
    private List<Consulta> consultaList;

    public TipoConsulta() {
    }

    public TipoConsulta(Integer idtipoConsulta) {
        this.idtipoConsulta = idtipoConsulta;
    }

    public Integer getIdtipoConsulta() {
        return idtipoConsulta;
    }

    public void setIdtipoConsulta(Integer idtipoConsulta) {
        Integer oldIdtipoConsulta = this.idtipoConsulta;
        this.idtipoConsulta = idtipoConsulta;
        changeSupport.firePropertyChange("idtipoConsulta", oldIdtipoConsulta, idtipoConsulta);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
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
        hash += (idtipoConsulta != null ? idtipoConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoConsulta)) {
            return false;
        }
        TipoConsulta other = (TipoConsulta) object;
        if ((this.idtipoConsulta == null && other.idtipoConsulta != null) || (this.idtipoConsulta != null && !this.idtipoConsulta.equals(other.idtipoConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoConsulta[ idtipoConsulta=" + idtipoConsulta + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
