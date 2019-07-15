package pl.javastart.produkty;


import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class ProductRepository {

    private List <Product> produkty;


    public ProductRepository() {
        produkty=new LinkedList<>();
    }

    public List<Product> getProdukty() {
        return produkty;
    }

    public void addProduct(Product product){
        produkty.add(product);
    }

    public String showProducts(){
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Wszystkie produkty: </h2><br>");
        for (Product p: produkty) {
            sb.append(p.toString()+"<br>");
        }
        return sb.toString();
    }

    public String showProductsByCategory(String category){
        StringBuilder sb = new StringBuilder();
        sb.append("<h3>Wszystkie produkty z kategorii: " + category +"</h2><br>");
        for (Product p: produkty) {
            if(p.getCategory().getDescription().equals(category)) {
                sb.append(p.toString() + "<br>");
            }
        }
        return sb.toString();
    }

    public double sumPrices(String category){
        double sum=0;
        for (Product p: produkty) {
            if(p.getCategory().getDescription().equals(category)) {
                sum+=p.getPrice();
            }
        }
        return sum;
    }

    public double sumAllPrices(){
        double sum=0;
        for (Product p: produkty) {
            sum+=p.getPrice();
        }
        return sum;
    }
}
