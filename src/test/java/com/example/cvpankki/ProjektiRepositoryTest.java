package com.example.cvpankki;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.cvpankki.domain.ProjektiRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProjektiRepositoryTest {

	@Autowired
	private ProjektiRepository pRepository;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
