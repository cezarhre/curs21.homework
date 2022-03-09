package ro.fasttrackit.curs21.homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs21.homework.model.*;
import ro.fasttrackit.curs21.homework.repository.ActorRepository;
import ro.fasttrackit.curs21.homework.repository.MovieRatingRepository;
import ro.fasttrackit.curs21.homework.repository.MovieRepository;
import ro.fasttrackit.curs21.homework.repository.StudioRepository;

import java.util.List;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@Bean
	CommandLineRunner atStartup(MovieRepository repository,
								StudioRepository studioRepository,
								ActorRepository actorRepository){
		return args -> {
			Actor cruiseActor = actorRepository.save(new Actor("Tom Cruise",1962));
			Actor kilmerActor = actorRepository.save(new Actor("Val Kilmer",1959));
			Actor michelleActor = actorRepository.save(new Actor("Michelle Pfeiffer",1958));
			Actor freemanActor = actorRepository.save(new Actor("Morgan Freeman",1937));
			Studio universalStudio = studioRepository.save(new Studio("Universal Pictures","Culver City, SUA"));
			Studio dreamStudio = studioRepository.save(new Studio("Dream Works","California - SUA"));
			repository.saveAll(List.of(
					new Movie(universalStudio,"War of the worlds", 2005,
							new MovieRating(9,"MPAA"),
							List.of(new Review("Very Good","MPAA"),
									new Review("Good","IFIDA")),
							List.of(cruiseActor,freemanActor)),
					new Movie(universalStudio,"One too Many", 1985,new MovieRating(8, "MPAA"),
							List.of(new Review("Good","IFIDA"),
									new Review("Good","MPAA")),
							List.of(kilmerActor,michelleActor)),
					new Movie(universalStudio,"Oblivion", 2013, new MovieRating(7,"IFIDA"),
							List.of(new Review("Good", "MPAA"),
									new Review("Very good","IFIDA")),
							List.of(cruiseActor, freemanActor)),
					new Movie(dreamStudio,"Prince of Egypt", 1998, new MovieRating(8,"IMDB"),
							List.of(new Review("Good", "IFIDA"),
									new Review("Good","MPAA")),
							List.of(kilmerActor,michelleActor))
			));
		};
	}
}
