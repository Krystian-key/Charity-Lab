package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.donation.domain.Donation;


public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM(d.quantity) FROM Donation d")
    Integer findSumBagsQuantity();

    @Query("SELECT COUNT(d) FROM Donation d")
    Integer findAllDonationCount();
}
