/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Atendimento
 */
@Entity
@Table(name = "sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sistema.findAll", query = "SELECT s FROM Sistema s"),
    @NamedQuery(name = "Sistema.findByIdsistema", query = "SELECT s FROM Sistema s WHERE s.idsistema = :idsistema"),
    @NamedQuery(name = "Sistema.findByResponsavel", query = "SELECT s FROM Sistema s WHERE s.responsavel = :responsavel"),
    @NamedQuery(name = "Sistema.findByEmail", query = "SELECT s FROM Sistema s WHERE s.email = :email"),
    @NamedQuery(name = "Sistema.findByDocumento", query = "SELECT s FROM Sistema s WHERE s.documento = :documento"),
    @NamedQuery(name = "Sistema.findByChave1", query = "SELECT s FROM Sistema s WHERE s.chave1 = :chave1"),
    @NamedQuery(name = "Sistema.findByChave2", query = "SELECT s FROM Sistema s WHERE s.chave2 = :chave2"),
    @NamedQuery(name = "Sistema.findByControlaHorario", query = "SELECT s FROM Sistema s WHERE s.controlaHorario = :controlaHorario"),
    @NamedQuery(name = "Sistema.findByDataImplantacao", query = "SELECT s FROM Sistema s WHERE s.dataImplantacao = :dataImplantacao"),
    @NamedQuery(name = "Sistema.findByDataImpressao", query = "SELECT s FROM Sistema s WHERE s.dataImpressao = :dataImpressao"),
    @NamedQuery(name = "Sistema.findByCidade", query = "SELECT s FROM Sistema s WHERE s.cidade = :cidade")})
public class Sistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idsistema")
    private Integer idsistema;
    @Column(name = "responsavel")
    private String responsavel;
    @Column(name = "email")
    private String email;
    @Column(name = "documento")
    private Integer documento;
    @Column(name = "chave1")
    private String chave1;
    @Column(name = "chave2")
    private String chave2;
    @Column(name = "controla_horario")
    private Boolean controlaHorario;
    @Column(name = "data_implantacao")
    @Temporal(TemporalType.DATE)
    private Date dataImplantacao;
    @Column(name = "data_impressao")
    private Boolean dataImpressao;
    @Column(name = "cidade")
    private String cidade;

    public Sistema() {
    }

    public Sistema(Integer idsistema) {
        this.idsistema = idsistema;
    }

    public Integer getIdsistema() {
        return idsistema;
    }

    public void setIdsistema(Integer idsistema) {
        this.idsistema = idsistema;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getChave1() {
        return chave1;
    }

    public void setChave1(String chave1) {
        this.chave1 = chave1;
    }

    public String getChave2() {
        return chave2;
    }

    public void setChave2(String chave2) {
        this.chave2 = chave2;
    }

    public Boolean getControlaHorario() {
        return controlaHorario;
    }

    public void setControlaHorario(Boolean controlaHorario) {
        this.controlaHorario = controlaHorario;
    }

    public Date getDataImplantacao() {
        return dataImplantacao;
    }

    public void setDataImplantacao(Date dataImplantacao) {
        this.dataImplantacao = dataImplantacao;
    }

    public Boolean getDataImpressao() {
        return dataImpressao;
    }

    public void setDataImpressao(Boolean dataImpressao) {
        this.dataImpressao = dataImpressao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsistema != null ? idsistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.idsistema == null && other.idsistema != null) || (this.idsistema != null && !this.idsistema.equals(other.idsistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Sistema[ idsistema=" + idsistema + " ]";
    }
    
}
