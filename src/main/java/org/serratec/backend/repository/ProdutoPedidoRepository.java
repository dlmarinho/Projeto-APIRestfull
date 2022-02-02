package org.serratec.backend.repository;
import java.util.Optional;
import javax.validation.Valid;
import org.serratec.backend.entity.ProdutoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	
	
	@Repository
	public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido,Long>{

		Optional<ProdutoPedido> findById(Long id);

		boolean existsById(@Valid Long id);

		void deleteById(Long id);

	
}
