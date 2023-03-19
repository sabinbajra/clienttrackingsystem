package cleint.tracking.system.client.tracking.system.repository;

import cleint.tracking.system.client.tracking.system.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientRepository {
    Client saveClient(Client client);
    List<Client> getAllClient();
    Optional<Client> getClientById(String client_id);
    Client updateClient(Client client);
    Client deleteClient(int clientId);
}
