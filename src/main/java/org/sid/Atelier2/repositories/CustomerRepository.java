package org.sid.Atelier2.repositories;

import org.sid.Atelier2.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
