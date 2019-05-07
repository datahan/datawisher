package com.datawiser.annotation;

import org.springframework.util.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={IsMobile.MobileValidator.class})
public @interface IsMobile {

    String message() default "手机号码格式错误";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class MobileValidator implements ConstraintValidator<IsMobile,String> {

        @Override
        public void initialize(IsMobile isMobile) {

        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            if(StringUtils.isEmpty(s)){
                return false;
            }else {
                Pattern mobile_pattern = Pattern.compile("1\\d{10}");
                Matcher m = mobile_pattern.matcher(s);
                return m.matches();
            }
        }
    }
}
