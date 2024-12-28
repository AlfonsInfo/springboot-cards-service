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



}
