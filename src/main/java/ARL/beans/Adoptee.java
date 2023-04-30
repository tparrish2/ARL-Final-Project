package ARL.beans;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 2, 2023
 */

/*The way this class is built to use the contact info first then get the addional description of info from and adoptee*/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adoptee {
	@Id
	@GeneratedValue
	private int id;
	@Autowired
	private ContactInfo contact;
	private int householdSize; // number of people in a household
	private int numberOfPetsInFamily; // number of pets in family, unsure if this is a good way to gauge this.
	private Boolean hasChildren; // unsure of this being the best way to gauge this
	private Boolean livingSpace; // checking to see is adoptee lives in a house(or other space) or apartment.
	private String description; // information the adoptee can add giving an arl a better idea of the canididate looking to adopt;
	
}
