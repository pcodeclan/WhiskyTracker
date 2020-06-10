package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindDistilleriesByRegion(){
		List<Distillery> found = distilleryRepository.findByRegion("Highland");
		assertEquals(3, found.size());
	}

	@Test
	public void canFindWhiskyByYear() {
		List<Whisky> found = whiskyRepository.findByYear(2020);
		assertEquals(1, found.size());
	}

	@Test
	public void canFindInDistilleryAllWhiskiesByAge(){
		List<Distillery> found = distilleryRepository.findByWhiskiesAge(15);
		assertEquals(2, found.size());
	}

	@Test
	public void canFindWhiskiesByDistilleryRegion() {
		List<Whisky> found = whiskyRepository.findByDistilleryRegion("Highland");
		assertEquals(7, found.size());
	}

	@Test
	public void canFindDistilleriesWithWhiskyAge12(){
		List<Distillery> found = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(6, found.size());
	}
}
