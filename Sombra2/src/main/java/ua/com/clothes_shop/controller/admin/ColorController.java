package ua.com.clothes_shop.controller.admin;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.clothes_shop.dto.filter.SimpleFilter;
import ua.com.clothes_shop.entity.Color;
import ua.com.clothes_shop.entity.Mail;
import ua.com.clothes_shop.service.ColorService;
import ua.com.clothes_shop.service.TypeOfClothingService;
import ua.com.clothes_shop.service.UserService;
import ua.com.clothes_shop.validator.ColorValidator;
import static ua.com.clothes_shop.util.ParamBuilder.*;

@Controller
@RequestMapping("/admin/color")
@SessionAttributes("color")
public class ColorController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TypeOfClothingService typeOfClothingService;
	
	@Autowired
	private ColorService colorService;
	
	@InitBinder("color")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new ColorValidator(colorService));
	}
	
	@ModelAttribute("color")
	public Color getForm(){
		return new Color();
	}
	
	@ModelAttribute("filter")
	 	public SimpleFilter getFilter(){
	 		return new SimpleFilter();
	 	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter, Principal principal){
		Mail mail = new Mail();
		model.addAttribute("mail", mail);
		try{
			model.addAttribute("typesOfClothingMen", typeOfClothingService.findByTargetAudience("men"));		
			model.addAttribute("typesOfClothingWomen", typeOfClothingService.findByTargetAudience("women"));}
		catch(Exception e){}
		if(principal!=null){
			String email = principal.getName();
			model.addAttribute("shoppingCart", userService.findShoppingCart(email));
		}else{
			model.addAttribute("shoppingCart", 0);
		}
		model.addAttribute("page", colorService.findAll(pageable, filter));
		return "admin-color";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter, Principal principal){
		model.addAttribute("color", colorService.findOne(id));
		return show(model, pageable, filter, principal);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
			colorService.delete(id);
			return "redirect:/admin/color"+getParams(pageable, filter);
		}
		
	@PostMapping
	public String save(@ModelAttribute("color") @Valid Color color, BindingResult br, Model model,SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter, Principal principal){
		if(br.hasErrors()) return show(model, pageable, filter, principal);
		colorService.save(color);
		status.setComplete();
		return "redirect:/admin/color"+getParams(pageable, filter);
	}

}
