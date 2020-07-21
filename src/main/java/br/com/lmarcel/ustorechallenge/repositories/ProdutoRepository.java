package br.com.lmarcel.ustorechallenge.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.lmarcel.ustorechallenge.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Produto obj  WHERE obj.nome LIKE %:nome%")
	List<Produto> findDistinctByNomeContaining(@Param("nome") String nome);

}
