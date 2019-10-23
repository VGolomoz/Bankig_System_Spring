package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Client;
import project.model.ClientAccount;
import project.model.ClientDetails;
import project.repository.ClientRepository;
import project.util.UserRole;

import java.util.Date;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Transactional
    public boolean addClient(String email, String passHash, Client client, ClientDetails clientDetails, ClientAccount clientAccount) {

        if (clientRepository.existsByEmail(email))
            return false;

        client.setPassword(passHash);
        client.setRole(UserRole.CLIENT);
        clientAccount.setBalance(15.2);
        clientAccount.setValidity(new Date());
        clientAccount.setClientDetails(clientDetails);
        clientAccount.setClient(client);
        client.setClientAccount(clientAccount);
        clientRepository.save(client);

        return true;

    }


}
