package org.serratec.backend.repository;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.entity.Pedido;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



	@Repository
	public interface PedidoRepository extends JpaRepository<Pedido,Long>{

		Optional<Pedido> findById(Long id);

		boolean existsById(@Valid Long id);

		void deleteById(Long id);
		
		Pageable firstPageWithTwoElements = PageRequest.of(0, 14);

	
}
