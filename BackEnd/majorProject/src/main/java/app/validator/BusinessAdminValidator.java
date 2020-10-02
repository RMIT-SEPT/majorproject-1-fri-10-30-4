package app.validator;


import app.entity.Business;
import app.entity.user.BusinessAdmin;
import app.entity.user.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BusinessAdminValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return BusinessAdmin.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        BusinessAdmin user = (BusinessAdmin) object;

        if(user.getPassword().length() <6){
            errors.rejectValue("password","Length", "Password must be at least 6 characters");
        }

        if(!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword","Match", "Passwords must match");

        }

        //confirmPassword
    }
}
