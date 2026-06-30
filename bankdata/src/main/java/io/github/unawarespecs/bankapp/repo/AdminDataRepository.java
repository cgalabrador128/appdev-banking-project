package io.github.unawarespecs.bankapp.repo;

import io.github.unawarespecs.bankapp.entity.AdministratorData;
import org.springframework.data.repository.CrudRepository;

public interface AdminDataRepository extends CrudRepository<AdministratorData, Integer> {
}
