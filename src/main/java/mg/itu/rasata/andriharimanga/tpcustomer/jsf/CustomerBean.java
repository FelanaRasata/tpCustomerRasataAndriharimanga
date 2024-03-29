/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.rasata.andriharimanga.tpcustomer.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.itu.rasata.andriharimanga.tpcustomer.entity.Customer;
import mg.itu.rasata.andriharimanga.tpcustomer.service.CustomerManager;

/**
 * Backing bean pour la page JSF customerList
 *
 * @author rasat
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {

    private List<Customer> customerList;
    

    @Inject
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }

    /**
     * Retourne la liste des clients pour affichage dans une DataTable.
     */
    public List<Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }

    /**
     * Retourne la liste des Etats disponible pour affichage dans une DataTable.
     */
    public List<String> getStates() {
        List<String> states = customerManager.getAllCustomerStates();
        return states;
    }

}
