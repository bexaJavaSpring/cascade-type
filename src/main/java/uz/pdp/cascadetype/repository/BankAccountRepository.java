package uz.pdp.cascadetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.cascadetype.entity.BankAccount;

@RepositoryRestResource(path = "account")
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {
}
