/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.receivables.business.logic;

import com.receivables.business.message.ProductDetailMessage;
import com.receivables.business.message.ProductSummaryMessage;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface ProductLogicRemote {
    public long createProduct(ProductDetailMessage productDetail);
    
    public ProductSummaryMessage getProductSummary();
}
