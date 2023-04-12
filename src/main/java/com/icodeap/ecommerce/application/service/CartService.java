package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.domain.ItemCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class CartService {
    //
    private List<ItemCart> itemCarts;
    //paso mis 2 atributos integer objeto de itemcart para poder
    //para que no se repita mi producto
    private HashMap<Integer, ItemCart> itemCartHashMap;

    public CartService() {
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }

    //añadir productos al carro de compras 4 valores
    public void addItemCart(Integer quantity, Integer idProduct, String nameProduct, BigDecimal price){
    	ItemCart itemCart = new ItemCart();
        itemCart.Inicializar(idProduct, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getIdProduct(), itemCart);
        fillList();
    }
    
    //devuelvo el total de mi carrito de compra
    public  BigDecimal getTotalCart(){
        BigDecimal total = BigDecimal.ZERO;
        //voy a rrecorrer mi areglo sumo y obtengo el total
        for (ItemCart itemCart : itemCarts){
            total = total.add(itemCart.getTotalPriceItem());
        }
        return total;
    }
    
    //ekimnar un articulo en especial
    public void removeItemCart(Integer idProduct){
        itemCartHashMap.remove(idProduct);
        fillList();
    }
  //elimnar todos los articulos
    public void removeAllItemsCart(){
        itemCartHashMap.clear();;
        itemCarts.clear();
    }

    //mi llista vacia 
    private void fillList(){
        itemCarts.clear();
        itemCartHashMap.forEach(
                (integer, itemCart)-> itemCarts.add(itemCart)

        );
    }
    //para mirar por consola
    public List<ItemCart> getItemCarts(){
        return itemCarts;
    }

}
