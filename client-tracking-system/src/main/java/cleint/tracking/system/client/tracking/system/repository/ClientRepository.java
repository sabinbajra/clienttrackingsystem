package cleint.tracking.system.client.tracking.system.repository;

import cleint.tracking.system.client.tracking.system.exception.ResourceNotFoundException;
import cleint.tracking.system.client.tracking.system.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements IClientRepository{
   @Autowired
   JPAClientRepository jpaClientRepository;

    public ClientRepository(JPAClientRepository jpaClientRepository) {
        this.jpaClientRepository = jpaClientRepository;
    }

    @Override
    @Transactional
    public Client saveClient(Client client) {
        return jpaClientRepository.save(client);
    }

    @Override
    public List<Client> getAllClient() {
        return Streamable.of(jpaClientRepository.findAll()).toList();
    }

    @Override
    public Optional<Client> getClientById(String client_id) {
        return jpaClientRepository.findById(client_id);
    }

    @Override
    @Transactional
    public Client updateClient(Client client) {
        return jpaClientRepository.save(client);
    }

    @Override
    public Client deleteClient(int clientId) {
        Client deletedClient = jpaClientRepository.findById(String.valueOf(clientId)).get();
        if(deletedClient == null){
            throw new ResourceNotFoundException("Client with id cannot be deleted");
        }
        jpaClientRepository.deleteById(String.valueOf(clientId));
        return deletedClient;
    }
}
