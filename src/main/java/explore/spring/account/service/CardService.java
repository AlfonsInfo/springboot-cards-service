package explore.spring.account.service;


import explore.spring.account.dto.loans.CardDto;
import explore.spring.account.dto.loans.CardResponseDto;
import explore.spring.account.entity.Card;
import explore.spring.account.mapper.CardMapper;
import explore.spring.account.provider.CardProvider;
import explore.spring.account.repository.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
    // repository
    private final CardRepository cardRepository;
    // provider
    private final CardProvider cardProvider;
    // mapper
    private final CardMapper cardMapper;

    @Transactional
    public void createCards(String mobileNumber){
        Card card = new Card();
        card.setMobileNumber(mobileNumber);
        //set real value cards
        cardRepository.save(card);
    }

    public void updateCard(String cardNumber, CardDto cardDto){
        Card card = cardProvider.findByCardNumber(cardNumber);
        cardMapper.updateCardFromDto(cardDto,card);
        cardRepository.save(card);
    }

    public CardResponseDto getDetailCard(String cardNumber){
        Card card = cardProvider.findByCardNumber(cardNumber);
        return cardMapper.mapToCardResponseDto(card);
    }

    public void deleteCard(String cardNumber){
        Card card = cardProvider.findByCardNumber(cardNumber);
        cardRepository.delete(card);
    }


}
