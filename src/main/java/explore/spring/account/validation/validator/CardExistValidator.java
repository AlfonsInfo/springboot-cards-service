package explore.spring.account.validation.validator;

import explore.spring.account.entity.Card;
import explore.spring.account.provider.CardProvider;
import explore.spring.account.validation.annotation.CardExist;
import explore.spring.account.validation.annotation.CardNotRegistered;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class CardExistValidator implements ConstraintValidator<CardExist,String> {

    private final CardProvider cardProvider;
    private CardExist.CardExistEnum validateBy;

    @Override
    public void initialize(CardExist constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        validateBy = constraintAnnotation.validateBy();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null || value.isEmpty()){return true;}
        return switch (validateBy) {
            case CARD_NUMBER -> Objects.nonNull(cardProvider.findByCardNumber(value));
            case MOBILE_NUMBER -> Objects.nonNull(cardProvider.findByMobileNumber(value));
        };
    }
}
