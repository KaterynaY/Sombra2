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
import ua.com.clothes_shop.entity.Brand;
import ua.com.clothes_shop.entity.Mail;
import ua.com.clothes_shop.service.BrandService;
import ua.com.clothes_shop.service.TypeOfClothingService;
import ua.com.clothes_shop.service.UserService;
import ua.com.clothes_shop.validator.BrandValidator;
import static ua.com.clothes_shop.util.ParamBuilder.*;

@Controller
@RequestMapping("/admin/brand")
@SessionAttributes("brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TypeOfClothingService typeOfClothingService;
	
	@InitBinder("brand")
		protected void bind(WebDataBinder binder){
			binder.setValidator(new BrandValidator(brandService));
		}
	
	@ModelAttribute("brand")
	public Brand getForm(){
		return new Brand();
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
		model.addAttribute("page", brandService.findAll(pageable, filter));
		return "admin-brand";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter, Principal principal){
		model.addAttribute("brand", brandService.findOne(id));
		return show(model, pageable, filter, principal);
	}
	
		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
			brandService.delete(id);
			return "redirect:/admin/brand"+getParams(pageable, filter);
		}
		
		@PostMapping
		public String save(@ModelAttribute("brand") @Valid Brand brand,  BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter, Principal principal){
			if(br.hasErrors()) return show(model, pageable, filter, principal);
			brandService.save(brand);
			status.setComplete();
			return "redirect:/admin/brand"+getParams(pageable, filter);
		}

}
