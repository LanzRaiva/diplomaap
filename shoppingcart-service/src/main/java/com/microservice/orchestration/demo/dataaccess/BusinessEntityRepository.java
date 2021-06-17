package com.microservice.orchestration.demo.dataaccess;

import org.springframework.data.repository.CrudRepository;


public interface BusinessEntityRepository extends CrudRepository<BusinessEntityJpa, String> {
}
