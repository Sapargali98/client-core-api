package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {
    private static HashMap<String, ClientModel> clientMap = new HashMap<>();

    static {
        ClientModel clientModel1 = new ClientModel("K28","Kai","Kim","exo12@mail.ru");
        ClientModel clientModel2 = new ClientModel("Y30", "Yuri", "Katsuki", "yurik2@mail.ru");
        ClientModel clientModel3 = new ClientModel("V16", "Victor", "Nikiforov", "VN3@mail.ru");
        ClientModel clientModel4 = new ClientModel("A16", "Altyn", "Otabek", "altyn18@mail.ru");
        clientMap.put(clientModel1.getClientId(),clientModel1);
        clientMap.put(clientModel2.getClientId(),clientModel2);
        clientMap.put(clientModel3.getClientId(),clientModel3);
        clientMap.put(clientModel4.getClientId(),clientModel4);
    }

    @Override
    public void createClient(ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
        clientMap.put(clientModel.getClientId(), clientModel);
    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return clientMap.get(clientId);
    }

    @Override
    public void updateClientById(String clientId, ClientModel clientModel) {
        clientModel.setClientId(clientId);
        clientMap.put(clientId, clientModel);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientMap.remove(clientId);
    }
}