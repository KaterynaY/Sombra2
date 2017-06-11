package ua.com.clothes_shop.controller.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.clothes_shop.dto.filter.ItemOfClothingFilter;
import ua.com.clothes_shop.dto.form.ItemOfClothingForm;
import ua.com.clothes_shop.editor.BrandEditor;
import ua.com.clothes_shop.editor.ColorEditor;
import ua.com.clothes_shop.editor.ItemNameEditor;
import ua.com.clothes_shop.editor.SizeEditor;
import ua.com.clothes_shop.editor.TargetAudienceEditor;
import ua.com.clothes_shop.editor.TypeOfClothingEditor;
import ua.com.clothes_shop.entity.Brand;
import ua.com.clothes_shop.entity.Color;
import ua.com.clothes_shop.entity.ItemName;
import ua.com.clothes_shop.entity.ItemOfClothing;
import ua.com.clothes_shop.entity.Mail;
import ua.com.clothes_shop.entity.Size;
import ua.com.clothes_shop.entity.TargetAudience;
import ua.com.clothes_shop.entity.TypeOfClothing;
import ua.com.clothes_shop.entity.User;
import ua.com.clothes_shop.service.BrandService;
import ua.com.clothes_shop.service.ColorService;
import ua.com.clothes_shop.service.ItemNameService;
import ua.com.clothes_shop.service.ItemOfClothingService;
import ua.com.clothes_shop.service.SizeService;
import ua.com.clothes_shop.service.TargetAudienceService;
import ua.com.clothes_shop.service.TypeOfClothingService;
import ua.com.clothes_shop.service.UserService;


@Controller
@RequestMapping("/shopMen/{itemType}")
@SessionAttributes("itemOfClothing")
public class ShoppingMenContrl {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemOfClothingService itemOfClothingService;
	
	@Autowired
	private ItemNameService itemNameService;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private TargetAudienceService targetAudienceService;
	
	@Autowired
	private TypeOfClothingService typeOfClothingService;
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private SizeService sizeService;
	
	@InitBinder("itemOfClothing")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Brand.class, new BrandEditor(brandService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(ItemName.class, new ItemNameEditor(itemNameService));
		binder.registerCustomEditor(Size.class, new SizeEditor(sizeService));
		binder.registerCustomEditor(TargetAudience.class, new TargetAudienceEditor(targetAudienceService));
		binder.registerCustomEditor(TypeOfClothing.class, new TypeOfClothingEditor(typeOfClothingService));
	}
	
	@ModelAttribute("filter")
	public ItemOfClothingFilter getFilter(){
		return new ItemOfClothingFilter();
	}
	
	@ModelAttribute("itemOfClothing")
	public ItemOfClothingForm getForm(){
		return new ItemOfClothingForm();
	}
	
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") ItemOfClothingFilter filter, Principal principal, @PathVariable String itemType){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		
		int targetAudienceId = targetAudienceService.findByCategory("men").getId();
		List <Integer> intList = new ArrayList<>();
		intList.add(targetAudienceId);
		filter.setTargetAudienceId(intList);
		int itemTypeId = typeOfClothingService.findByItemType(itemType).getId();
		List <Integer> intTypeList = new ArrayList<>();
		intTypeList.add(itemTypeId);
		filter.setTypeOfClothingId(intTypeList);
		
		model.addAttribute("page", itemOfClothingService.findAll(pageable, filter));
		model.addAttribute("itemsOfClothing", itemOfClothingService.findAll());
		model.addAttribute("itemNames", itemNameService.findAll());
		model.addAttribute("brands", brandService.findByTargetAudienceAndType(targetAudienceId, itemTypeId));
		model.addAttribute("colors", colorService.findByTargetAudienceAndType(targetAudienceId, itemTypeId));
		model.addAttribute("sizes", sizeService.findByTargetAudienceAndType(targetAudienceId, itemTypeId));
//		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("targetAudiences", targetAudienceService.findAll());
		model.addAttribute("typesOfClothing", typeOfClothingService.findAll());
//		model.addAttribute("colors", colorService.findAll());
//		model.addAttribute("sizes", sizeService.findAll());
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("type", itemType);
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		
		return "user-shopMen";
	}
	
	@GetMapping("/addToCart/{itemId}")
	public String buy(Principal principal, @PathVariable int itemId, Model model){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));
		model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));
		if(principal!=null){
 			String email = principal.getName();
 			User user = userService.findByEmail(email);
 			int userId = user.getId();
 			userService.addToShoppingCart(userId, itemId);
 		}
		else{
			return "user-noCart";
 		}
		ItemOfClothing item = itemOfClothingService.findOne(itemId);
		String itemType = item.getTypeOfClothing().getItemType(); 
		return "redirect:/shopMen/{itemType}";
	}

}
