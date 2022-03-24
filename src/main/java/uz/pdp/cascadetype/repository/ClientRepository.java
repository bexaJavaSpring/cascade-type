package uz.pdp.cascadetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.cascadetype.entity.BankAccount;
import uz.pdp.cascadetype.entity.Client;

@RepositoryRestResource(path = "client",collectionResourceRel = "list")
public interface ClientRepository extends JpaRepository<Client,Integer> {
}
