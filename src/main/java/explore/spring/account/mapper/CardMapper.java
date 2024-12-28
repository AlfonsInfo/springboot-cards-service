package explore.spring.account.mapper;


import explore.spring.account.dto.loans.CardDto;
import explore.spring.account.dto.loans.CardResponseDto;
import explore.spring.account.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(target = "cardNumber", ignore = true)
    void updateCardFromDto(CardDto cardDto, @MappingTarget Card card);

    CardResponseDto mapToCardResponseDto(Card card);
}
