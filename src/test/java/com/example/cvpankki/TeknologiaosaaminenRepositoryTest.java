package com.example.cvpankki;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.cvpankki.domain.Teknologiaosaaminen;
import com.example.cvpankki.domain.TeknologiaosaaminenRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TeknologiaosaaminenRepositoryTest {

	@Autowired
	private TeknologiaosaaminenRepository repository;
	
    @Test
    public void testCreateNewTeknologiaosaaminen() {
    	Teknologiaosaaminen teknologiaosaaminen = new Teknologiaosaaminen();
		repository.save(teknologiaosaaminen);
    	assertThat(teknologiaosaaminen.getTeknologiaosaaminenId()).isNotNull();
    } 
    
    @Test
    public void testDeleteTeknologiaosaaminen() {
    	Teknologiaosaaminen teknologiaosaaminen1 = new Teknologiaosaaminen();
		repository.save(teknologiaosaaminen1);
    	repository.delete(teknologiaosaaminen1);
    	Optional<Teknologiaosaaminen> teknologiaosaaminen2 = repository.findById(teknologiaosaaminen1.getTeknologiaosaaminenId());
    	assertTrue(!teknologiaosaaminen2.isPresent());
    } 

    @Test
    public void testSearchTeknologiaosaaminen() {
    	Teknologiaosaaminen teknologiaosaaminen1 = new Teknologiaosaaminen();
		repository.save(teknologiaosaaminen1);
    	Optional<Teknologiaosaaminen> teknologiaosaaminen2 = repository.findById(teknologiaosaaminen1.getTeknologiaosaaminenId());
    	assertTrue(teknologiaosaaminen2.isPresent());
    } 

}
