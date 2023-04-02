package ARL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ARL.beans.Animals;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 2, 2023
 */

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Long>{}
