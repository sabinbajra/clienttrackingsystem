package cleint.tracking.system.client.tracking.system.Controller;

import cleint.tracking.system.client.tracking.system.Service.ClientService;
import cleint.tracking.system.client.tracking.system.exception.ResourceNotFoundException;
import cleint.tracking.system.client.tracking.system.model.Client;
import cleint.tracking.system.client.tracking.system.repository.ClientRepository;
import cleint.tracking.system.client.tracking.system.repository.JPAClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // List all the clients
    @GetMapping("/all")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    // List employee by id
    @GetMapping("{client_id}")
    public ResponseEntity<Client> getClientById(@PathVariable int client_id) {
        Client client = clientService.getClientById(client_id).orElseThrow(() -> new ResourceNotFoundException("Client does not exists::"));
        return ResponseEntity.ok(client);
    }

    // add new client
    @PostMapping("/add")
    public Client saveStudent(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    // update client
    @PutMapping({"{client_id}"})
    public ResponseEntity<Client> updateClient(@PathVariable int client_id,@RequestBody Client client) {
        Client clientUpdate = clientService.getClientById(client_id).orElseThrow(() -> new ResourceNotFoundException("Client do not exists"));

        clientUpdate.setClient_id(client.getClient_id());
        clientUpdate.setFirst_name(client.getFirst_name());
        clientUpdate.setLast_name(client.getLast_name());
        clientUpdate.setAddress(client.getAddress());
        clientUpdate.setPhone(client.getPhone());
        clientUpdate.setCourse(client.getCourse());
        clientUpdate.setPotential(client.getPotential());

        clientService.updateClient(clientUpdate);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("{client_id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable int client_id) {
        Client client = clientService.deleteClient(client_id);

        if(client != null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return null;
    }

}
