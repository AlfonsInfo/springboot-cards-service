package explore.spring.account.provider;

import explore.spring.account.entity.Card;
import explore.spring.account.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.function.Function;

@RequestScope
@RequiredArgsConstructor
@Component
public class CardProvider extends BaseProvider<Card> {
    private final CardRepository cardRepository;


    public Card findByMobileNumber(String mobileNumber){
        return findEntity(cardRepository::findCardByMobileNumber, mobileNumber);
    }

    public Card findByCardNumber(String cardNumber){
        return findEntity(cardRepository::findCardByCardNumber, cardNumber);
    }
}
