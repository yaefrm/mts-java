package com.example.catalogfilm;

import com.example.catalogfilm.constants.GenreEnum;
import com.example.catalogfilm.controller.FilmController;
import com.example.catalogfilm.model.Film;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FilmControllerTests {
	@Autowired
	FilmController filmController;
	@Test
	public void addFilm_addedFilm() {
		Film film = new Film();
		String title = "title";
		film.setGenre(GenreEnum.HORROR);
		film.setTitle(title);
		film.setRating(3);

		ResponseEntity createdFilm = filmController.addFilm(film);

		assertEquals(HttpStatus.OK, createdFilm.getStatusCode());
	}

}
