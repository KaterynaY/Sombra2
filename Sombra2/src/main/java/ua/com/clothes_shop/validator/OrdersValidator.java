package ua.com.clothes_shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.clothes_shop.entity.Orders;
import ua.com.clothes_shop.service.OrdersService;

public class OrdersValidator implements Validator{
	
	private static final  Pattern REG = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	private static final  Pattern REGS = Pattern.compile("^\\+?[0-9. ()-]{10,25}$");
	
	private static final  Pattern REGN = Pattern.compile("[a-zA-Z]+\\.?");
	
    private final OrdersService ordersService;
    
	public OrdersValidator(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Orders.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Orders orders = (Orders) target;
		if(!REG.matcher(orders.getEmail()).matches()){
			errors.rejectValue("email", "", "Invalid email!");
		}
		if(!REGS.matcher(orders.getPhoneNumber()).matches()){
			errors.rejectValue("phoneNumber", "", "Invalid number!");
		}
		if(!REGN.matcher(orders.getName()).matches()){
			errors.rejectValue("name", "", "Invalid name!");
		}
		if(!REGN.matcher(orders.getSurname()).matches()){
			errors.rejectValue("surname", "", "Invalid surname!");
		}
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Can't be empty");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can't be empty");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "", "Can't be empty");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "Can't be empty");
	}

}
