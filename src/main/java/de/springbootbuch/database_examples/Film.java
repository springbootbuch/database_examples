package de.springbootbuch.database_examples;

import java.time.Year;

public class Film {
	private final String title;
	
	private final Year releaseYear;

	public Film(String title, Year releaseYear) {
		this.title = title;
		this.releaseYear = releaseYear;
	}

	public String getTitle() {
		return title;
	}

	public Year getReleaseYear() {
		return releaseYear;
	}
}
