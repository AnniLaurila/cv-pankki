package com.example.cvpankki;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.cvpankki.domain.Projekti;
import com.example.cvpankki.domain.ProjektiRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProjektiRepositoryTest {

	@Autowired
	private ProjektiRepository repository;
	
    @Test
    public void testCreateNewProjekti() {
    	Projekti projekti = new Projekti();
		repository.save(projekti);
    	assertThat(projekti.getProjektiId()).isNotNull();
    } 
    
    @Test
    public void testDeleteProjekti() {
    	Projekti projekti1 = new Projekti();
		repository.save(projekti1);
    	repository.delete(projekti1);
    	Optional<Projekti> projekti2 = repository.findById(projekti1.getProjektiId());
    	assertTrue(!projekti2.isPresent());
    } 

    @Test
    public void testSearchProjekti() {
    	Projekti projekti1 = new Projekti();
		repository.save(projekti1);
    	Optional<Projekti> projekti2 = repository.findById(projekti1.getProjektiId());
    	assertTrue(projekti2.isPresent());
    } 

}
