package cleint.tracking.system.client.tracking.system.Service;

import cleint.tracking.system.client.tracking.system.model.Client;
import cleint.tracking.system.client.tracking.system.repository.ClientRepository;
import cleint.tracking.system.client.tracking.system.repository.JPAClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client) {
        return clientRepository.saveClient(client);
    }

    public List<Client> getAllClient() {
        return Streamable.of(clientRepository.getAllClient()).stream().toList();
    }

    public Optional<Client> getClientById(int clientId) {
        return clientRepository.getClientById(String.valueOf(clientId));
    }

    public Client updateClient(Client client) {
        return clientRepository.updateClient(client);
    }

    public Client deleteClient(int clientId) {
        return clientRepository.deleteClient(clientId);
    }
}
