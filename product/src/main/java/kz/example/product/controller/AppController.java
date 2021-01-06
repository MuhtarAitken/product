package kz.example.product.controller;

import kz.example.product.model.Product;
import kz.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController /* контроллер - это медиатор (посредник) между view и model,
        кроме как связывать эти два компонента он ничего не должен делать,
        все делегируется в эти два слоя*/
public class AppController {

    @Autowired
    private ProductService service;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<Product> getList() {
        List<Product> listProducts = service.listAll();
        return listProducts;
    }

    @RequestMapping(value ="/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);

    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveProduct(@ModelAttribute("product") Product product) {
        if (product.getId() == null) {
            service.save(product);
        } else {
            Product productFromDb = service.get(product.getId());
            productFromDb.setBrand(product.getBrand());
            productFromDb.setPrice(product.getPrice());
            productFromDb.setMadein(product.getMadein());
            productFromDb.setName(product.getName());
            service.save(productFromDb);
        }
    }

   /* @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void editProduct(@ModelAttribute("product") Product productFromClient) {

        Product productFromDb = service.get(productFromClient.getId());
        productFromDb.setBrand(productFromClient.getBrand());
        productFromDb.setPrice(productFromClient.getPrice());
        productFromDb.setMadein(productFromClient.getMadein());
        productFromDb.setName(productFromClient.getName());
        service.save(productFromDb);

    }*/

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public  Product editProduct(@PathVariable(name = "id") int id) {
        return service.get(id);
    }

//
//    @RequestMapping("/get(id)")
//   public ModelAndView EditProductPage(@PathVariable(name = "id") int id) {
//       ModelAndView mav = new ModelAndView("product");
//       Product product = service.get(id);
//       mav.addObject("product", product);
//       return mav;}
   }



