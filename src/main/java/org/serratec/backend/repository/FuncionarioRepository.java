package org.serratec.backend.repository;
import java.util.Optional;


import javax.validation.Valid;
import org.serratec.backend.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



	@Repository
	public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{

		Optional<Funcionario> findById(Long id);

		boolean existsById(@Valid Long id);

		void deleteById(Long id);

	
}
