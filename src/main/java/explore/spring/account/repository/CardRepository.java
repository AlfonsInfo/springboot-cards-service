package explore.spring.account.repository;

import explore.spring.account.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Card findCardByMobileNumber(String mobileNumber);
    Card findCardByCardNumber(String cardNumber);

}

