package br.com.lmarcel.ustorechallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.lmarcel.ustorechallenge.domain.Produto;
import br.com.lmarcel.ustorechallenge.repositories.ProdutoRepository;
import br.com.lmarcel.ustorechallenge.services.exceptions.DataIntegrityException;
import br.com.lmarcel.ustorechallenge.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;


	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Produto update(Produto obj) {
		find(obj.getId());
		return repo.save(obj);
		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("não é possível excluir o produto");
		}
	}
	
	public List<Produto> findAll(){
		return repo.findAll();
	}
	
	public List<Produto> search(String nome) {

		return repo.findDistinctByNomeContaining(nome);	
	}
	
}
