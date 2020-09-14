package pl.coderslab.charity.institution.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.institution.InstitutionService;
import pl.coderslab.charity.institution.domain.Institution;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    @Override
    public List<Institution> findAll() {
        return null;
    }

    @Override
    public Institution findById(Long id) {
        return null;
    }

    @Override
    public Institution create(Institution institution) {
        return null;
    }

    @Override
    public Institution update(Institution institution, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
