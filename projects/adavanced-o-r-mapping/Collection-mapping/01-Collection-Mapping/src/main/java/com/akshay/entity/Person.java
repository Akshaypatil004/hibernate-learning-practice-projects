package com.akshay.entity;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.ListIndexBase;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="PERSON_COLL_MAP")
@Getter
@Setter
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
public class Person {
	
	@Id
	@GeneratedValue
	private Integer pid;
	
	@Column(length = 40,nullable = false)
	@NonNull
	private String pname;
	
	@Column(length = 100,nullable = false)
	@NonNull
	private String address;
	
	
	// Collection mapping - 
	@ElementCollection
	@CollectionTable(name = "NICKNAME_COLL_MAP",joinColumns = @JoinColumn(name="PERSON_ID", referencedColumnName = "pid"))
	@Column(name="NICKNAME",  length = 30,nullable = false)
	@OrderColumn(name="IDX")
	@ListIndexBase(value = 1)
	@NonNull
	private List<String> nickNames;
	
	@ElementCollection
	@CollectionTable(name="FRIENDS_COLL_MAP",joinColumns = @JoinColumn(name="PERSON_ID",referencedColumnName = "pid"))
	@Column(name="FRIEND",nullable = false)
	@NonNull
	private List<String> friends;
	
	@ElementCollection
	@CollectionTable(name="CONTACT_COLL_MAP",joinColumns = @JoinColumn(name="PERSON_ID",referencedColumnName = "pid"))
	@Column(name="CONTACT_NUMBER",nullable = false)
	@NonNull
	private Set<Long> contactNumber;
	
	@ElementCollection
	@CollectionTable(name="IDDETAILS_COLL_MAP", joinColumns = @JoinColumn(name="PERSON_ID",referencedColumnName = "pid"))
	@MapKeyColumn(name="IDTYPE")
	@Column(name="ID_NUMBER",nullable = false)
	@NonNull
	private Map<String,Long> idDetails;
	

}
