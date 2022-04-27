
package libreria.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tabla_editorial")
public class Editorial implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_editorial")
    private Integer id;
    
    @Column(name = "nombre_editorial", length = 145, nullable = false)
    private String nombre;
    
    @Column(name = "alta_editorial")
    private Boolean alta;

    public Editorial() {
    }

    public Editorial(Integer id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
    
}
