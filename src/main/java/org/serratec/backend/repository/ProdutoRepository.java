package org.serratec.backend.repository;
import java.util.Optional;
import javax.validation.Valid;
import org.serratec.backend.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	
	
	@Repository
	public interface ProdutoRepository extends JpaRepository<Produto,Long>{

		Optional<Produto> findById(Long id);

		boolean existsById(@Valid Long id);

		void deleteById(Long id);

	
}
