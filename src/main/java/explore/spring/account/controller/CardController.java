package explore.spring.account.controller;

import explore.spring.account.constant.StatusMessage;
import explore.spring.account.dto.ResponseDto;
import explore.spring.account.dto.loans.CardDto;
import explore.spring.account.dto.loans.CardResponseDto;
import explore.spring.account.service.CardService;
import explore.spring.account.validation.annotation.CardExist;
import explore.spring.account.validation.annotation.CardNotRegistered;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/cards")
@AllArgsConstructor
@Validated
@Tag(name = "CRUD REST APIs for Cards", description = "CREATE, READ, UPDATE, DELETE")
public class CardController {
    private final CardService cardService;

    @Operation(summary = "Create Cards")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseDto<Void> createCards(
            @RequestParam
            @CardNotRegistered
            @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
            String mobileNumber
    ){
        cardService.createCards(mobileNumber);
        return ResponseDto.<Void>builder()
                .statusCode(HttpStatus.CREATED.value())
                .statusMsg(StatusMessage.SUCCESS_CREATE_CARDS)
                .build();
    }

    @Operation(summary = "Update Cards")
    @PutMapping("/{cardNumber}")
    @ResponseStatus(HttpStatus.OK)
    ResponseDto<Void> updateCards(
            @PathVariable @CardExist(validateBy = CardExist.CardExistEnum.CARD_NUMBER) String cardNumber,
            @RequestBody CardDto cardDto
    ){
        cardService.updateCard(cardNumber, cardDto);
        return ResponseDto.<Void>builder()
                .statusCode(HttpStatus.OK.value())
                .statusMsg(StatusMessage.SUCCESS_UPDATED_CARDS)
                .build();
    }

    @Operation(summary = "Get Detail Cards")
    @GetMapping("/{cardNumber}")
    ResponseDto<CardResponseDto> getDetailCards(
            @PathVariable @CardExist(validateBy = CardExist.CardExistEnum.CARD_NUMBER) String cardNumber
    ){
        return ResponseDto.<CardResponseDto>builder()
                .data(cardService.getDetailCard(cardNumber))
                .statusCode(HttpStatus.OK.value())
                .statusMsg(StatusMessage.SUCCESS_GET_CARDS)
                .build();
    }


    @Operation(summary = "Delete Cards")
    @DeleteMapping("/{cardNumber}")
    ResponseDto<Void> deleteCards(
            @PathVariable @CardExist(validateBy = CardExist.CardExistEnum.CARD_NUMBER) String cardNumber
    ){
        cardService.deleteCard(cardNumber);
        return ResponseDto.<Void>builder()
                .statusCode(HttpStatus.OK.value())
                .statusMsg(StatusMessage.SUCCESS_DELETE_CARDS)
                .build();
    }
}
