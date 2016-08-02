/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Account;
import entity.Klant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import session.AccountFacade;
import session.KlantAdresFacade;
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
    private List<Account> alleAccounts;
    @EJB
    private AccountFacade acFacade;
    @EJB
    private KlantFacade kFacade;
    @EJB
    private KlantAdresFacade kaFacade;
    
    
    public AccountBean() {
        account = new Account();
        klant = new Klant();
    }
    
    @PostConstruct
    public void init() {
        alleAccounts = new ArrayList<>();
    }
    
    /*
    * CRUD methodes
    */
    public void maakNieuwAccount() {
        //TODO: klant aanroepen voor welke een account gemaakt wordt
        //klant = [input voor id]
        //kFacade.find(klant);
        acFacade.create(account);
        alleAccounts.add(account);
    }
    
    public void leesAlleKlantAccounts() {
        setAlleAccounts(acFacade.findAll());
    }
    
    public void editAccount() {
        acFacade.edit(account);
    }
    
    public void verwijderAccount() {
        acFacade.remove(account);
        alleAccounts.remove(account);
    }
    
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

    public List<Account> getAlleAccounts() {
        return alleAccounts;
    }

    public void setAlleAccounts(List<Account> alleAccounts) {
        this.alleAccounts = alleAccounts;
    }
}
