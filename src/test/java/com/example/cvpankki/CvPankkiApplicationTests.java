package com.example.cvpankki;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.cvpankki.web.CvPankkiController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CvPankkiApplicationTests {

	@Autowired
	CvPankkiController cvPankkiController;
	
	@Test
	void contextLoads() throws Exception{
		assertThat(cvPankkiController).isNotNull();
	}

}
