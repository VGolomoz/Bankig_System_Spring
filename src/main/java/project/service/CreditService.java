package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.ClientAccount;
import project.model.Credit;
import project.repository.CreditRepository;
import project.util.Currency;

@Service
public class CreditService {

    @Autowired
    CreditRepository creditRepository;

    @Transactional
    public void addCredit(String currency, String limit, String rate, ClientAccount clientAccount, Credit credit){

        credit.setBalance(0.0);
        credit.setCurrency(Currency.valueOf(currency));
        credit.setLimit(Double.valueOf(limit));
        credit.setRate(Double.valueOf(rate));
        credit.setAccruedInterest(0.0);
        credit.setClientAccount(clientAccount);
        clientAccount.setCredit(credit);
        creditRepository.save(credit);

    }
}
