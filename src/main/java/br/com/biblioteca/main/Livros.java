package br.com.biblioteca.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livros implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo TÍTULO é obrigatório")
	@Length(min = 3, max = 100, message = "O campo TÍTULO deve ter entre 3 e 100 Caracteres")
	private String titulo;
	
	@NotEmpty(message = "Campo AUTOR é obrigatório")
	@Length(min = 3, max = 50, message = "O campo AUTOR deve ter entre 3 e 50 Caracteres")
	private String autor;
	
	@NotEmpty(message = "Campo TEXTO é obrigatório")
	@Length(min = 10, max = 2000000, message = "O campo TEXTO deve ter entre 10 e 2000000 Caracteres")
	private String texto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria_livros categoria;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "status_id")
	private StatusLivro statusLivro;
	 
	@JsonIgnore
	@ManyToMany(mappedBy = "livros")
	private List<Cliente> cliente = new ArrayList<>();

	public Livros() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livros(Integer id, String titulo, String autor, String texto, Categoria_livros categoria, StatusLivro statusLivro) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.texto = texto;
		this.categoria = categoria;
		this.statusLivro = statusLivro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria_livros getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria_livros categoria) {
		this.categoria = categoria;
	}
	
	public StatusLivro getStatusLivro() {
		return statusLivro;
	}

	public void setStatusLivro(StatusLivro statusLivro) {
		this.statusLivro = statusLivro;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livros other = (Livros) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}