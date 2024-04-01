/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.rasata.andriharimanga.tpcustomer.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.itu.rasata.andriharimanga.tpcustomer.entity.Discount;

/**
 *
 * @author rasat
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    public List<Discount> getAllDiscountsOrderedByRateDesc() {
        Query query = em.createNamedQuery("Discount.findAllOrderedByRateDesc");
        return query.getResultList();
    }

    
    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }
}
