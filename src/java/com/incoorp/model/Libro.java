package com.incoorp.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro implements Serializable {
	@Id
        //@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ISBN;
	@Column(name = "TITULO")
	private String titulo;
	@Column(name = "AUTOR")
	private String autor;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "PAGINAS")
	private Long paginas;
        @Column(name = "EDICION")
	private String edicion;

        public Libro() {
        }

    public Libro(String ISBN, String titulo, String autor, String descripcion, Long paginas, String edicion) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.paginas = paginas;
        this.edicion = edicion;
    }

        public String getISBN() {
            return ISBN;
        }

        public void setISBN(String ISBN) {
            this.ISBN = ISBN;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Long getPaginas() {
            return paginas;
        }

        public void setPaginas(Long paginas) {
            this.paginas = paginas;
        }

        public String getEdicion() {
            return edicion;
        }

        public void setEdicion(String edicion) {
            this.edicion = edicion;
        }

    @Override
    public String toString() {
        return "ISBN:" + ISBN + "titulo:" + titulo;
    }

    public Libro(String ISBN) {
        this.ISBN = ISBN;
    }
        
        
        
        
}
