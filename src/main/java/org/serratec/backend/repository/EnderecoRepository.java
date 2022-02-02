package org.serratec.backend.repository;

import java.util.Optional;
import javax.validation.Valid;
import org.serratec.backend.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

		
	Optional<Endereco> findById(Long id);

	boolean existsById(@Valid Long id);

	void deleteById(Long id);
	
//	@Bean
//    public ResponseEntity<Endereco> findyByCep(String cep);

}
