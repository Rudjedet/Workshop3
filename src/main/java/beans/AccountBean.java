/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Account;
import entity.Klant;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import session.AccountFacade;
import session.KlantFacade;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class AccountBean {
    
    private Account account;
    private Klant klant;
    private int klantID;
    private List<Account> accountGegevens;
    @EJB
    private AccountFacade acFacade;
    @EJB
    private KlantFacade kFacade;
    
    
    public AccountBean() {
        account = new Account();
        klant = new Klant();
    }
    
    /*
    * CRUD methodes
    */
    public void leesAlleKlantAccounts() {
        setAccountGegevens(acFacade.findAll());
    }
    
    //TODO: public void leesAccountVanKlant() {}
    
    //TODO: public void voegAccountToe() {}
    
    //TODO: public void verwijderAccount() {}
    
    //TODO: public void editAccount() {}
    
    /*
    * Getters & Setters
    */
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public int getKlantID() {
        return klantID;
    }

    public void setKlantID(int klantID) {
        this.klantID = klantID;
    }

    public List<Account> getAccountGegevens() {
        return accountGegevens;
    }

    public void setAccountGegevens(List<Account> accountGegevens) {
        this.accountGegevens = accountGegevens;
    }
}
