package io.github.unawarespecs.bankapp.repo;

import io.github.unawarespecs.bankapp.entity.CustomerData;
import org.springframework.data.repository.CrudRepository;

public interface CustDataRepository extends CrudRepository<CustomerData, Integer> {
}
