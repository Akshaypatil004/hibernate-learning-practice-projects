package com.akshay.app;

import java.util.List;
import java.util.Set;

import com.akshay.dao.IPersonDetailsDAO;
import com.akshay.dao.PersonDetailDAOImpl;
import com.akshay.entity.PersonDetails;
import com.akshay.entity.PhoneNumber;
import com.akshay.util.HBUtil;

public class App {
	public static void main(String[] args) {
		try {
			IPersonDetailsDAO dao = new PersonDetailDAOImpl();
/*		
			System.out.println("=".repeat(50));
			System.out.println("SAVE OBJECT OPERATION");
			System.out.println("=".repeat(50));
			
			// prepare parent object
			PersonDetails person = new PersonDetails();
			person.setPersonName("Raja");
			person.setAddress("Hydrabad");
			// prepare child object
			PhoneNumber phoneNo1 = new PhoneNumber();
			phoneNo1.setNumberType("Residence");
			phoneNo1.setProvider("Airtel");
			phoneNo1.setMobileNumber(999999999L);

			PhoneNumber phoneNo2 = new PhoneNumber();
			phoneNo2.setNumberType("Office");
			phoneNo2.setProvider("Jio");
			phoneNo2.setMobileNumber(8888888888L);
			// set child object to parent object
			person.setPhoneNumbers(Set.of(phoneNo1, phoneNo2));

			// save the object
			int generatedIdvalue = dao.saveDataUsingParent(person);
			System.out.println("parent and associated childs are save");
			System.out.println("Generared ID value : " + generatedIdvalue);
			System.out.println("-".repeat(50));

			System.out.println("=".repeat(50));
			System.out.println("LOAD OBJECT OPERATION");
			System.out.println("=".repeat(50));
			
			dao.loadDataUsingParent();
			
			System.out.println("-".repeat(50));

			System.out.println("=".repeat(50));
			System.out.println("ADD CHILD TO EXISTING PARENT OBJECT OPERATION");
			System.out.println("=".repeat(50));
			
			dao.addChildToExistingParent();
			
			System.out.println("-".repeat(50));

			

			System.out.println("=".repeat(50));
			System.out.println("DELETE ALL CHILD OF A PARENT OBJECT OPERATION");
			System.out.println("=".repeat(50));
			
			dao.deleteAllChildsOfAParent();
			
			System.out.println("-".repeat(50));
	
			System.out.println("=".repeat(50));
			System.out.println("DELETE SPECIFIC ONE CHILD OF A PARENT  OPERATION");
			System.out.println("=".repeat(50));
			
			dao.deleteOneChildFromCollectionOfAParent();
			
			System.out.println("-".repeat(50));
*/
			System.out.println("=".repeat(50));
			System.out.println("DELETE PARENT AND ITS ASSOCIATED CHILDS OPERATION");
			System.out.println("=".repeat(50));
			
			dao.deleteParentAndItsChilds();
			
			System.out.println("-".repeat(50));	
			
		} catch (RuntimeException e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		} finally {
			HBUtil.shutdown(); // close session factory at last
		}
	}
}
