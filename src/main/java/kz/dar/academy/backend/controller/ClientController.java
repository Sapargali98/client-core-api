package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.model.ClientModel;
import kz.dar.academy.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/check")
    public ResponseEntity<String> checkClient() {
        return new ResponseEntity<String>("client-core-api is working", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createClient(@RequestBody ClientModel clientModel) {
        clientService.createClient(clientModel);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @PutMapping("/clientId")
    public ResponseEntity<String> updateClientById(@PathVariable String clientId, @RequestBody ClientModel clientModel) {
        clientService.updateClientById(clientId, clientModel);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }

    @DeleteMapping("/clientId")
    public ResponseEntity<String> deleteClietn(@PathVariable String clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }
}
