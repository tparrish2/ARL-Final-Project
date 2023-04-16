package ARL.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ARL.beans.ARLInfo;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 10, 2023
 */
public interface ARLInfoRepository extends JpaRepository<ARLInfo, Long>{
	Optional<ARLInfo> findUserByUsername(String username); // Stuff for sign in page for an arl
}


