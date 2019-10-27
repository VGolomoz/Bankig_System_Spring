package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.ClientAccount;
import project.model.Deposit;
import project.repository.DepositRepository;
import project.util.Currency;

import java.util.Calendar;
import java.util.Date;

@Service
public class DepositService {

    @Autowired
    DepositRepository depositRepository;

    @Transactional
    public void addDeposit(String currency, String rate, ClientAccount clientAccount, Deposit deposit){
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR, 1);
        Date term = c.getTime();

        deposit.setBalance(0.0);
        deposit.setCurrency(Currency.valueOf(currency));
        deposit.setRate(Double.valueOf(rate));
        deposit.setTerm(term);
        deposit.setClientAccount(clientAccount);
        clientAccount.setDeposit(deposit);
        depositRepository.save(deposit);

    }
}
