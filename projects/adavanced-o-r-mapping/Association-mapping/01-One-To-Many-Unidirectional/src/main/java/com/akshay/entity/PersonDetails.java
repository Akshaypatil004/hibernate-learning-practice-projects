package com.akshay.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PERSON_OTM_UNIDIRECTIONAL") // OTM - ONE TO MANY
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class PersonDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;

	@Column(length = 30, nullable = false)
	@NonNull
	private String personName;

	@Column(length = 100, nullable = false)
	@NonNull
	private String address;

	// one to many - association mapping
	@OneToMany(targetEntity = PhoneNumber.class, // this is optional when generic are use with collection, recommend to
													// use when no generic
													// i.e List, Set, Map etc , can be omitted with generic , hibernate
													// can recongnise targetEntiy
													// from generic directly using (reflection)
			cascade = CascadeType.ALL, // "ALL" - because with person (parent) - phonenumbers(child) also be inserted (
										// non select operations )
			fetch = FetchType.LAZY, // "LAZY" - by default it is - but taken to show record are fetch lazily ( when
									// required only)
			orphanRemoval = true // "true" taken because with parent entity should be able to delete/remove child
									// entity
									// associated objects
	)
	@JoinColumn(name = "person_id", referencedColumnName = "personId") // for Foreign key column in db having
																		// relationship parent(person)
																		// referencedColumnName can be optional ,
																		// hibernate take parent primary key
																		// for key foreign key column
	private Set<PhoneNumber> phoneNumbers;

	@Override
	public String toString() {
		return "PersonDetails [personId=" + personId + ", personName=" + personName + ", address=" + address + "]";
	}

}
