package ua.com.clothes_shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.clothes_shop.entity.ItemOfClothing;
import ua.com.clothes_shop.entity.Orders;
import ua.com.clothes_shop.service.ItemOfClothingService;
import ua.com.clothes_shop.service.OrdersService;

@Controller
public class UnregisteredUserContrl {
	
	@Autowired
	private ItemOfClothingService itemOfClothingService;
	
	@Autowired
	private OrdersService ordersService;
	
	@GetMapping("/buy/{itemId}")
	public String show(Model model, @PathVariable int itemId){
		
		ItemOfClothing item = itemOfClothingService.findOne(itemId);
		model.addAttribute("item", item);
		return "user-unregisteredBuy";
		
	}
	
	@ModelAttribute("orders")
	public Orders getForm(){
		return new Orders();
	}
	
	
	@PostMapping("/save")
	public String save(@RequestParam String name, @RequestParam String surname, @RequestParam String address){
		Orders orders = new Orders ();
		orders.setName(name);
		orders.setSurname(surname);
		orders.setQuantity(1);
		orders.setAddress(address);
		ordersService.save(orders);
		return "redirect:/shopping";
	}
	


}
