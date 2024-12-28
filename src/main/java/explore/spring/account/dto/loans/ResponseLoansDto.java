package explore.spring.account.dto.loans;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Loans", description = "Schema to hold Loan information")
@Data
public class ResponseLoansDto {

    @Schema(description = "Mobile Number of Customer", example = "4365327698")
    private String mobileNumber;

    @Schema(description = "Loan Number of the customer", example = "548732457654")
    private String loanNumber;

    @Schema(description = "Type of the loan", example = "Home Loan")
    private String loanType;

    @Schema(description = "Total loan amount", example = "100000")
    private int totalLoan;

    @Schema(description = "Total loan amount paid", example = "1000")
    private int amountPaid;

    @Schema(description = "Total outstanding amount against a loan", example = "99000")
    private int outstandingAmount;

}
