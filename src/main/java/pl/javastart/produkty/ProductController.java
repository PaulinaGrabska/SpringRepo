package pl.javastart.produkty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @RequestMapping("/")
//    @ResponseBody
//    public String home() {
//        return home();
//    }

        @RequestMapping("/lista")
        @ResponseBody
    public String showList(@RequestParam (value = "kategoria" ,required = false)String category){

        productRepository.addProduct(new Product("Tv", 2000.0,Category.HOUSEHOLD));
        productRepository.addProduct(new Product("Komoda", 150.0,Category.HOUSEHOLD));
        productRepository.addProduct(new Product("Owoce", 11.99,Category.GROCERIES));
        productRepository.addProduct(new Product("Zeszyt", 4.5,Category.OTHER));

        if(("").equals(category)||category==null){
            return productRepository.showProducts();
        }
        return productRepository.showProductsByCategory(category)+"</br>Suma cen= "
                + productRepository.sumPrices(category);
    }

    @PostMapping("/add")
    public String addProduct (@RequestParam (value = "kategoria")String category,
                              @RequestParam (value = "nazwa")String name,
                              @RequestParam (value = "cena") Double price) {

        if(name==null || ("").equals(name) ||category==null|| ("").equals(category) || price==0|| ("").equals(price)){
            return "Wszystkie pola dotyczące produktu muszą być wypełnione.";
        }else {
            productRepository.addProduct(new Product(name,price, Category.convert(category)));
            return "Produkt został dodany.</br>";
        }
    }


}
