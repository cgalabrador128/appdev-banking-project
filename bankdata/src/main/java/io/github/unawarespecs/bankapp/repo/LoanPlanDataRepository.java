package io.github.unawarespecs.bankapp.repo;

import io.github.unawarespecs.bankapp.entity.LoanPlanData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanPlanDataRepository extends CrudRepository<LoanPlanData, Integer> {
}
