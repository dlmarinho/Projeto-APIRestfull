package org.serratec.backend.repository;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.dtos.ClienteDto;
import org.serratec.backend.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	
	
	@Repository
	public interface ClienteRepository extends JpaRepository<Cliente,Long>{

		Optional<Cliente> findById(Long id);

		boolean existsById(@Valid Long id);

		void deleteById(Long id);

		Cliente save(@Valid ClienteDto cliente);

		

	

		

	

	
}
