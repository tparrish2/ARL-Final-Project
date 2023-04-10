package ARL.beans;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 10, 2023
 */

// This bean is a database table for arl's to sign into for adding animals for adoption

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ARLInfo {
	
	@Id
	@GeneratedValue
	private int id;
	private String arlUserName;
	private String password;

}
