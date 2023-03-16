package kz.dar.academy.backend.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<ClientEntity,Long> {
    ClientEntity getClientEntityByClientId(String clientId);
    List<ClientEntity> getClintEntityBy();
    @Transactional
    void deleteClientEntityByClientId(String clientId);
}
