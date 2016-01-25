/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.receivables.business.message;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductSummaryMessage implements Serializable{
    private List<ProductDetailMessage> productDetailList;
    
    public ProductSummaryMessage(){
    }
    
    public List<ProductDetailMessage> getProductDetailList(){
        return productDetailList;
    }

    public void setProductDetailList(List<ProductDetailMessage> productDetailList) {
        this.productDetailList = productDetailList;
    }
    
}
