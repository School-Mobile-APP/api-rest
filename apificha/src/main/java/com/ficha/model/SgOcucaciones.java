
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;

/**
 *
 * @author Sofis Solutions
 */
@Entity
@Table(name = "sg_ocupaciones", uniqueConstraints = {
    @UniqueConstraint(name = "ocu_codigo_uk", columnNames = {"ocu_codigo"})
    ,
    @UniqueConstraint(name = "ocu_nombre_uk", columnNames = {"ocu_nombre"})}, schema = Constantes.SCHEMA_CATALOGO)
@XmlRootElement
@EntityListeners(EntidadListener.class)
@Audited
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ocuPk", scope = SgOcupacion.class)
public class SgOcupacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ocu_pk", nullable = false)
    private Long ocuPk;

    @Size(max = 45)
    @Column(name = "ocu_codigo", length = 45)
    private String ocuCodigo;

    @Size(max = 255)
    @Column(name = "ocu_nombre", length = 255)
    private String ocuNombre;

    @Size(max = 255)
    @Column(name = "ocu_nombre_busqueda", length = 255)
    private String ocuNombreBusqueda;

    @Column(name = "ocu_habilitado")
    private Boolean ocuHabilitado;

    @Column(name = "ocu_ult_mod_fecha")
    private LocalDateTime ocuUltModFecha;

    @Size(max = 45)
    @Column(name = "ocu_ult_mod_usuario", length = 45)
    private String ocuUltModUsuario;

    @Column(name = "ocu_version")
    @Version
    private Integer ocuVersion;

    public SgOcupacion() {
    }

    @PrePersist
    @PreUpdate
    public void preSave() {
        this.ocuNombreBusqueda = SofisStringUtils.normalizarParaBusqueda(this.ocuNombre);
    }

    public Long getOcuPk() {
        return ocuPk;
    }

    public void setOcuPk(Long ocuPk) {
        this.ocuPk = ocuPk;
    }

    public String getOcuCodigo() {
        return ocuCodigo;
    }

    public void setOcuCodigo(String ocuCodigo) {
        this.ocuCodigo = ocuCodigo;
    }

    public String getOcuNombre() {
        return ocuNombre;
    }

    public void setOcuNombre(String ocuNombre) {
        this.ocuNombre = ocuNombre;
    }

    public String getOcuNombreBusqueda() {
        return ocuNombreBusqueda;
    }

    public void setOcuNombreBusqueda(String ocuNombreBusqueda) {
        this.ocuNombreBusqueda = ocuNombreBusqueda;
    }

    public Boolean getOcuHabilitado() {
        return ocuHabilitado;
    }

    public void setOcuHabilitado(Boolean ocuHabilitado) {
        this.ocuHabilitado = ocuHabilitado;
    }

    public LocalDateTime getOcuUltModFecha() {
        return ocuUltModFecha;
    }

    public void setOcuUltModFecha(LocalDateTime ocuUltModFecha) {
        this.ocuUltModFecha = ocuUltModFecha;
    }

    public String getOcuUltModUsuario() {
        return ocuUltModUsuario;
    }

    public void setOcuUltModUsuario(String ocuUltModUsuario) {
        this.ocuUltModUsuario = ocuUltModUsuario;
    }

    public Integer getOcuVersion() {
        return ocuVersion;
    }

    public void setOcuVersion(Integer ocuVersion) {
        this.ocuVersion = ocuVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.ocuPk);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SgOcupacion other = (SgOcupacion) obj;
        if (!Objects.equals(this.ocuPk, other.ocuPk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SgOcupacion{" + "ocuPk=" + ocuPk + ", ocuCodigo=" + ocuCodigo + ", ocuNombre=" + ocuNombre + ", ocuNombreBusqueda=" + ocuNombreBusqueda + ", ocuHabilitado=" + ocuHabilitado + ", ocuUltModFecha=" + ocuUltModFecha + ", ocuUltModUsuario=" + ocuUltModUsuario + ", ocuVersion=" + ocuVersion + '}';
    }

}
