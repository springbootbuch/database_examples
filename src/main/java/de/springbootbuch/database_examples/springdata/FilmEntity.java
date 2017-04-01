package de.springbootbuch.database_examples.springdata;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class FilmEntity implements Serializable {

	private static final long serialVersionUID = 2568012478345384986L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private Integer id;

	private String title;

	@ManyToOne(optional = false)
	@JoinColumn(name = "language_id")
	private LanguageEntity language;

	private Integer releaseYear;

	protected FilmEntity() {
	}

	public FilmEntity(String title, LanguageEntity language) {
		this.title = title;
		this.language = language;
	}

	// Getter und Setter aus Gründen
	// der Übersicht weggelassen

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public LanguageEntity getLanguage() {
		return language;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
}
