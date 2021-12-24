package br.com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.main.StatusLivro;

@Repository
public interface StatusLivroRepository extends JpaRepository<StatusLivro, Integer>{

	@Query("SELECT obj FROM Livros obj WHERE obj.statusLivro.id = :id_livro ORDER BY titulo")
	StatusLivro findAllByStatusLivro(@Param(value="id_livro") Integer id_livro);

}
