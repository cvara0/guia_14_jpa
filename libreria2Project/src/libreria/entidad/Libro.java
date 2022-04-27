/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.entidad;

import java.io.Serializable;
import java.time.Year;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tabla_libro")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name="id_libro")
    private Integer id;
    
    @Column(name="isbn")
    private Long isbn;
    
    @Column(name="titulo")
    private String nombre;
    
    @Column(name="anio",columnDefinition="YEAR",nullable=false)
    private Short anio;
    
    @Column(name="cantidad_total")
    private Integer nroEjemplares;
   
    @Column(name="cantidad_prestados")
    private Integer nroEjemplaresPrestados;
    
    @Column(name="cantidad_restantes")
    private Integer nroEjemplaresRestantes;
    
    @Column(name="alta_libro")
    private Boolean alta;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_autor",referencedColumnName="id_autor",nullable=false)
    private Autor autor;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_editorial",referencedColumnName="id_editorial",nullable=false)
    private Editorial editorial;

    public Libro() {
    }

    public Libro(Integer id, Long isbn, String titulo, Short anio, Integer nroEjemplares, Integer nroEjemplaresPrestados, Integer nroEjemplaresRestantes, Boolean alta, Autor autor, Editorial editorial) {
        this.id = id;
        this.isbn = isbn;
        this.nombre = titulo;
        this.anio = anio;
        this.nroEjemplares = nroEjemplares;
        this.nroEjemplaresPrestados = nroEjemplaresPrestados;
        this.nroEjemplaresRestantes = nroEjemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return nombre;
    }

    public void setTitulo(String titulo) {//recordar que el metodo se llama titulo pero la variable nombre
        this.nombre = titulo;          //cambiar esto a todo nombre
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
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
//mapped by solo para bidireccional