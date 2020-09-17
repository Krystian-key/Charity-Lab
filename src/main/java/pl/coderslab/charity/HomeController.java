package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.InstitutionService;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;

    private final DonationService donationService;


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institution", institutionService.findAll());
        model.addAttribute("donations", donationService.donationQuantity());
        model.addAttribute("bags", donationService.bagsQuantity());
        return "index";
    }




}
