package de.springbootbuch.database_examples.springdata;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "language")
@Immutable
public class LanguageEntity implements Serializable {
	
	private static final long serialVersionUID = 6982098119059495267L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private Integer id;
	
	private String name;

	protected LanguageEntity() {
	}

	public LanguageEntity(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
