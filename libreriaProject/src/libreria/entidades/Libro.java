package libreria.entidades;

import java.io.Serializable;
import javax.persistence.*;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

@Entity
@Table(name="tabla_libro")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    private Long isbn;
    @Column(name="titulo_libro")
    private String titulo;
    @Column(name="anio_libro")
    private Integer anio;
    @Column(name="nroEjemplares_libro")
    private Integer nroEjemplares;
    @Column(name="nroEjemplaresPrestados_libro")
    private Integer nroEjemplaresPrestados;
    @Column(name="nroEjemplaresRestantes_libro")
    private Integer nroEjemplaresRestantes;
    @Column(name="alta_libro")
    private Boolean alta;
    
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_autor",referencedColumnName="id_autor",nullable=false)
    private Autor autor;
    
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_editorial",referencedColumnName="id_editorial",nullable=false)
    private Editorial editorial;

    public Libro() {
    }

    public Libro(Long isbn, String titulo, Integer anio, Integer nroEjemplares, Integer nroEjemplaresPrestados, Integer nroEjemplaresRestantes, Boolean alta, Autor autor, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.nroEjemplares = nroEjemplares;
        this.nroEjemplaresPrestados = nroEjemplaresPrestados;
        this.nroEjemplaresRestantes = nroEjemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getNroEjemplares() {
        return nroEjemplares;
    }

    public void setNroEjemplares(Integer nroEjemplares) {
        this.nroEjemplares = nroEjemplares;
    }

    public Integer getNroEjemplaresPrestados() {
        return nroEjemplaresPrestados;
    }

    public void setNroEjemplaresPrestados(Integer nroEjemplaresPrestados) {
        this.nroEjemplaresPrestados = nroEjemplaresPrestados;
    }

    public Integer getNroEjemplaresRestantes() {
        return nroEjemplaresRestantes;
    }

    public void setNroEjemplaresRestantes(Integer nroEjemplaresRestantes) {
        this.nroEjemplaresRestantes = nroEjemplaresRestantes;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    
}
