package pl.coderslab.charity.donation.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.donation.domain.Donation;

import java.util.List;

@Service
/*@Transactional*/ // błąd z Eager, transacitonal + readonly = true
public class DonationServiceImpl implements DonationService {

    @Override
    public List<Donation> findAll() {
        return null;
    }

    @Override
    public Donation findById(Long id) {
        return null;
    }

    @Override
    public Donation create(Donation donation) {
        return null;
    }

    @Override
    public Donation update(Donation donation, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
