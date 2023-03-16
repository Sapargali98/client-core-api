package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.model.ClientRequest;
import kz.dar.academy.backend.model.ClientResponse;
import kz.dar.academy.backend.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest) {
        return clientService.createClient(clientRequest);
    }
    @PutMapping
    public ClientResponse updateClient(@RequestParam String clientId,@RequestBody ClientRequest clientRequest) {
        clientRequest.setClientId(clientId);
        return clientService.updateClient(clientRequest);
    }
    @GetMapping
    public  ClientResponse getClientById(@RequestParam String clientId) {
        return clientService.getClientById(clientId);
    }
    @GetMapping("/all")
    public List<ClientResponse> getAllClients() {
        return clientService.getAllClients();
    }
    @DeleteMapping
    public void deleteClientById(@RequestParam String clientId) {
        clientService.deleteClientById(clientId);
    }
}
