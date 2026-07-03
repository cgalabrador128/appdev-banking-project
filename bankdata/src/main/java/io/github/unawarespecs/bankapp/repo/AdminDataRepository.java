package io.github.unawarespecs.bankapp.repo;

import io.github.unawarespecs.bankapp.entity.AdministratorData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdminDataRepository extends CrudRepository<AdministratorData, Integer> {
    List<AdministratorData> findAll();
    Optional<AdministratorData> findById(Integer id);
    Optional<AdministratorData> findByUuid(UUID uuid);
}
