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
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import utilidades.Datas;

/**
 *
 * @author Nasser
 */
@Entity
@Table(name = "consulta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c ORDER BY c.dataConsulta, c.horaConsulta"),
    @NamedQuery(name = "Consulta.findByIdconsulta", query = "SELECT c FROM Consulta c WHERE c.idconsulta = :idconsulta"),
    @NamedQuery(name = "Consulta.findByDataConsulta", query = "SELECT c FROM Consulta c WHERE c.dataConsulta = :dataConsulta ORDER BY c.horaConsulta"),
    @NamedQuery(name = "Consulta.findByDataConsultaMedico", query = "SELECT c FROM Consulta c WHERE c.dataConsulta = :dataConsulta and c.medico = :medico ORDER BY c.horaConsulta"),
    @NamedQuery(name = "Consulta.findByHoraConsulta", query = "SELECT c FROM Consulta c WHERE c.horaConsulta = :horaConsulta"),
    @NamedQuery(name = "Consulta.findByidPaciente", query = "SELECT c FROM Consulta c WHERE c.idpaciente = :idpaciente ORDER BY c.dataConsulta, c.horaConsulta"),
    @NamedQuery(name = "Consulta.findByDisponibilidade", query = "SELECT c FROM Consulta c WHERE c.dataConsulta = :dataConsulta and c.horaConsulta = :horaConsulta and c.medico = :medico"),
    @NamedQuery(name = "Consulta.findByCompareceu", query = "SELECT c FROM Consulta c WHERE c.compareceu = :compareceu")})
public class Consulta implements Serializable {

    @JoinColumn(name = "medico", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario medico;
    @Lob
    @Column(name = "atestado")
    private String atestado;
    @Lob
    @Column(name = "laudo")
    private String laudo;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconsulta")
    private Integer idconsulta;
    @Column(name = "data_consulta")
    @Temporal(TemporalType.DATE)
    private Date dataConsulta;
    @Lob
    @Column(name = "sintomas")
    private String sintomas;
    @Lob
    @Column(name = "exames")
    private String exames;
    @Column(name = "hora_consulta")
    @Temporal(TemporalType.TIME)
    private Date horaConsulta;
    @Column(name = "compareceu")
    private Boolean compareceu;
    @Lob
    @Column(name = "receita")
    private String receita;
    @Lob
    @Column(name = "medicacao")
    private String medicacao;
    @JoinColumn(name = "idpaciente", referencedColumnName = "idpaciente")
    @ManyToOne(optional = false)
    private Paciente idpaciente;
    @JoinColumn(name = "idtipo_consulta", referencedColumnName = "idtipo_consulta")
    @ManyToOne(optional = false)
    private TipoConsulta idtipoConsulta;
    

    
    

    public String getsDataConsulta() {
        return Datas.getDate(this.dataConsulta);
    }
    
    public String getsHoraConsulta() {
        return Datas.getTimeDataBase(this.horaConsulta);
    }

    public Consulta() {
    }

    public Consulta(Integer idconsulta) {
        this.idconsulta = idconsulta;
    }

    public Integer getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(Integer idconsulta) {
        Integer oldIdconsulta = this.idconsulta;
        this.idconsulta = idconsulta;
        changeSupport.firePropertyChange("idconsulta", oldIdconsulta, idconsulta);
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        Date oldDataConsulta = this.dataConsulta;
        this.dataConsulta = dataConsulta;
        changeSupport.firePropertyChange("dataConsulta", oldDataConsulta, dataConsulta);
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        String oldSintomas = this.sintomas;
        this.sintomas = sintomas;
        changeSupport.firePropertyChange("sintomas", oldSintomas, sintomas);
    }

    public String getExames() {
        return exames;
    }

    public void setExames(String exames) {
        String oldExames = this.exames;
        this.exames = exames;
        changeSupport.firePropertyChange("exames", oldExames, exames);
    }

    public Date getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(Date horaConsulta) {
        Date oldHoraConsulta = this.horaConsulta;
        this.horaConsulta = horaConsulta;
        changeSupport.firePropertyChange("horaConsulta", oldHoraConsulta, horaConsulta);
    }

    public Boolean getCompareceu() {
        return compareceu;
    }

    public void setCompareceu(Boolean compareceu) {
        Boolean oldCompareceu = this.compareceu;
        this.compareceu = compareceu;
        changeSupport.firePropertyChange("compareceu", oldCompareceu, compareceu);
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        String oldReceita = this.receita;
        this.receita = receita;
        changeSupport.firePropertyChange("receita", oldReceita, receita);
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        String oldMedicacao = this.medicacao;
        this.medicacao = medicacao;
        changeSupport.firePropertyChange("medicacao", oldMedicacao, medicacao);
    }

    public Paciente getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Paciente idpaciente) {
        Paciente oldIdpaciente = this.idpaciente;
        this.idpaciente = idpaciente;
        changeSupport.firePropertyChange("idpaciente", oldIdpaciente, idpaciente);
    }

    public TipoConsulta getIdtipoConsulta() {
        return idtipoConsulta;
    }

    public void setIdtipoConsulta(TipoConsulta idtipoConsulta) {
        TipoConsulta oldIdtipoConsulta = this.idtipoConsulta;
        this.idtipoConsulta = idtipoConsulta;
        changeSupport.firePropertyChange("idtipoConsulta", oldIdtipoConsulta, idtipoConsulta);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsulta != null ? idconsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.idconsulta == null && other.idconsulta != null) || (this.idconsulta != null && !this.idconsulta.equals(other.idconsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Consulta[ idconsulta=" + idconsulta + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public String getAtestado() {
        return atestado;
    }

    public void setAtestado(String atestado) {
        this.atestado = atestado;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
    }
    
}
