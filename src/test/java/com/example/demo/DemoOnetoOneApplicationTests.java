package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class DemoOnetoOneApplicationTests {

	@Test
	void contextLoads() {
		Set<Integer> setA = new HashSet<>();

		setA.add(1);


		System.out.println(setA.stream().reduce((one, two) -> two).get());
	}

}
