package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Client;
import project.model.ClientAccount;
import project.model.ClientDetails;
import project.repository.ClientRepository;
import project.util.UserRole;

import java.util.Calendar;
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
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public boolean addClient(String email, String passHash, Client client, ClientDetails clientDetails, ClientAccount clientAccount) {

        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR, 1);
        Date validityDate = c.getTime();

        if (clientRepository.existsByEmail(email)) return false;

        clientAccount.setBalance(0.0);
        clientAccount.setValidity(validityDate);
        clientAccount.setClientDetails(clientDetails);
        clientAccount.setClient(client);
        clientDetails.setClientAccount(clientAccount);
        client.setClientAccount(clientAccount);
        client.setPassword(passHash);
        client.setRole(UserRole.CLIENT);
        clientRepository.save(client);

        return true;

    }


}
