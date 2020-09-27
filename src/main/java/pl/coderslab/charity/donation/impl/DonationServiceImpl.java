package pl.coderslab.charity.donation.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.donation.DonationRepository;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.donation.domain.Donation;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    private final static String ERROR_MESSAGE = "Donation not found with id: ";

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation findById(Long id) {
        return donationRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
    }

    @Override
    public Long create(Donation donation) {
        Donation create = donationRepository.save(donation);
        return create.getId();
    }

    @Override
    public Donation update(Donation donation, Long id) {
        Donation donationById = donationRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        return donationRepository.save(donationById);
    }

    @Override
    public void delete(Long id) {
        Donation donationById = donationRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        donationRepository.delete(donationById);

    }

    @Override
    public Integer bagsQuantity() {
        return donationRepository.findSumBagsQuantity();
    }

    @Override
    public Long donationQuantity() {
        return donationRepository.count();
    }
}
