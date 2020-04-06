package com.example.cvpankki;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.cvpankki.domain.Henkilo;
import com.example.cvpankki.domain.HenkiloRepository;
import com.example.cvpankki.domain.Projekti;
import com.example.cvpankki.domain.Sertifikaatti;
import com.example.cvpankki.domain.Teknologiaosaaminen;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class HenkiloRepositoryTest {

	@Autowired
	private HenkiloRepository repository;
		
    @Test
    public void testCreateNewHenkilo() {
    	Henkilo henkilo = new Henkilo("Anni", "Testaaja", "050234156", "anninmaili@email.com", "Testaaja", "kuvaus blaa",
    			"FM", "Helsingin yliopisto", 2016, false, new ArrayList<Teknologiaosaaminen>(), 
    			new ArrayList<Sertifikaatti>(), new ArrayList<Projekti>());
    	repository.save(henkilo);
    	assertThat(henkilo.getHenkiloId()).isNotNull();
    } 
    
    @Test
    public void testDeleteHenkilo() {
    	Henkilo henkilo1 = new Henkilo("Anni", "Testaaja", "050234156", "anninmaili@email.com", "Testaaja", "kuvaus blaa",
    			"FM", "Helsingin yliopisto", 2016, false, new ArrayList<Teknologiaosaaminen>(), 
    			new ArrayList<Sertifikaatti>(), new ArrayList<Projekti>());
    	repository.save(henkilo1);
    	repository.delete(henkilo1);
    	Optional<Henkilo> henkilo2 = repository.findById(henkilo1.getHenkiloId());
    	assertTrue(!henkilo2.isPresent());
    } 

    @Test
    public void testSearchHenkilo() {
    	Henkilo henkilo1 = new Henkilo("Anni", "Testaaja", "050234156", "anninmaili@email.com", "Testaaja", "kuvaus blaa",
    			"FM", "Helsingin yliopisto", 2016, false, new ArrayList<Teknologiaosaaminen>(), 
    			new ArrayList<Sertifikaatti>(), new ArrayList<Projekti>());
    	repository.save(henkilo1);
    	Optional<Henkilo> henkilo2 = repository.findById(henkilo1.getHenkiloId());
    	assertTrue(henkilo2.isPresent());
    } 
}
