package ARL.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 2, 2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {
	
	private String Name;
	private String phone;
	private String email;
	private String address;
	private String city;
	private String state;
	
}
