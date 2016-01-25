/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.receivables.presentation.bean;

import com.receivables.business.logic.ProductLogicRemote;
import com.receivables.business.message.ProductDetailMessage;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;

/**
 *
 * @author admin
 */
@ManagedBean
@RequestScoped
public class ProductDetailBean {
    
    private ProductDetailMessage productDetail;

    
    public ProductDetailBean(){
        productDetail=new ProductDetailMessage();
    }

    public ProductDetailMessage getProductDetail() {
        return productDetail;
    }
    
    public void save(){
        try {
        InitialContext context = new InitialContext();
        ProductLogicRemote logic=(ProductLogicRemote)
                context.lookup("java:global/Enterprise09Ejb/ProductLogic!com.godoro.receivables.business.logic.ProductLogicRemote");
        long productId=logic.createProduct(productDetail);
        if(productId!=0){
             productDetail.setProductId(productId);
             }else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ürün eklenemedi"));
        }
        
        
       
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getClass().getName()+" : "+e.getMessage()));
        }
        
        
        
        
    }
    
}
