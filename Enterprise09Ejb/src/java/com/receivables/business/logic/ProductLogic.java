
package com.receivables.business.logic;

import com.receivables.business.message.ProductDetailMessage;
import com.receivables.business.message.ProductSummaryMessage;
import com.receivables.data.entity.Product;
import com.receivables.data.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class ProductLogic implements ProductLogicRemote {
    public long createProduct(ProductDetailMessage productDetail){
        Product product = new Product();
        product.setProductName(productDetail.getProductName());
        product.setSalesPrice(productDetail.getSalesPrice());
        ProductRepository productRepository=new ProductRepository();
        productRepository.persist(product);
        return product.getProductId();
    }
    public ProductSummaryMessage getProductSummary(){
        ProductSummaryMessage productSummary=new ProductSummaryMessage();
        productSummary.setProductDetailList(new ArrayList<ProductDetailMessage>());
        ProductRepository productRepository=new ProductRepository();
        List<Product> productList=productRepository.list();
        for(Product product: productList){
            ProductDetailMessage productDetail=new ProductDetailMessage();
            
            productDetail.setProductId(product.getProductId());
            productDetail.setProductName(product.getProductName());
            productDetail.setSalesPrice(product.getSalesPrice());
            productSummary.getProductDetailList().add(productDetail);
        }
        return productSummary;
    }
}
