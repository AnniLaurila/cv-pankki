package com.example.cvpankki;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.cvpankki.domain.TeknologiaosaaminenRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TeknologiaosaaminenRepositoryTest {

	@Autowired
	private TeknologiaosaaminenRepository toRepository;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
