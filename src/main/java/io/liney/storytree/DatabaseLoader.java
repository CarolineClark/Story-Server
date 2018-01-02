package io.liney.storytree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final UserRepository repository;

	@Autowired
	public DatabaseLoader(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Storyline("Frodo went to Mount doom", "centre", "home"));
		this.repository.save(new Storyline("And he dropped the ring in the fire", "north", "home"));
		this.repository.save(new Storyline("And he declared he would keep the ring", "east", "home"));
		this.repository.save(new Storyline("Sam cried \"No!\"","south","home-north"));
	}
}