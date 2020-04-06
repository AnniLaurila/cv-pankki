package com.example.cvpankki;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.cvpankki.domain.Sertifikaatti;
import com.example.cvpankki.domain.SertifikaattiRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class SertifikaattiRepositoryTest {

	@Autowired
	private SertifikaattiRepository repository;
	
    @Test
    public void testCreateNewSertifikaatti() {
    	Sertifikaatti sertifikaatti = new Sertifikaatti();
		repository.save(sertifikaatti);
    	assertThat(sertifikaatti.getSertifikaattiId()).isNotNull();
    } 
    
    @Test
    public void testDeleteSertifikaatti() {
    	Sertifikaatti sertifikaatti1 = new Sertifikaatti();
		repository.save(sertifikaatti1);
    	repository.delete(sertifikaatti1);
    	Optional<Sertifikaatti> sertifikaatti2 = repository.findById(sertifikaatti1.getSertifikaattiId());
    	assertTrue(!sertifikaatti2.isPresent());
    } 

    @Test
    public void testSearchSertifikaatti() {
    	Sertifikaatti sertifikaatti1 = new Sertifikaatti();
		repository.save(sertifikaatti1);
    	Optional<Sertifikaatti> sertifikaatti2 = repository.findById(sertifikaatti1.getSertifikaattiId());
    	assertTrue(sertifikaatti2.isPresent());
    } 

}
