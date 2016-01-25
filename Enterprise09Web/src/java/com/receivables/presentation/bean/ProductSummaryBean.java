/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.receivables.presentation.bean;


import com.receivables.business.logic.ProductLogicRemote;
import com.receivables.business.message.ProductSummaryMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;

/**
 *
 * @author admin
 */
@ManagedBean
@RequestScoped
public class ProductSummaryBean {
    private ProductSummaryMessage productSummary;
    
    public ProductSummaryBean(){
        try {
            InitialContext context = new InitialContext();
        ProductLogicRemote logic=(ProductLogicRemote)
                context.lookup("java:global/Enterprise09Ejb/ProductLogic!com.godoro.receivables.business.logic.ProductLogicRemote");
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }

    public ProductSummaryMessage getProductSummary() {
        return productSummary;
    }
    
}
