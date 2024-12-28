package explore.spring.account.validation.validator;

import explore.spring.account.entity.Card;
import explore.spring.account.provider.CardProvider;
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
public class CardNotRegisteredValidator implements ConstraintValidator<CardNotRegistered,String> {

    private final CardProvider cardProvider;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Card loans = cardProvider.findByMobileNumber(value);
        return Objects.isNull(loans);
    }
}
