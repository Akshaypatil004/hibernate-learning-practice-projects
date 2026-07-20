package com.akshay.dao;


import com.akshay.entity.PersonDetails;

public interface IPersonDetailsDAO {
	
	int saveDataUsingParent(PersonDetails person);
	void loadDataUsingParent();
	void addChildToExistingParent();
	void deleteAllChildsOfAParent();
	void deleteOneChildFromCollectionOfAParent();
	void deleteParentAndItsChilds();
}
