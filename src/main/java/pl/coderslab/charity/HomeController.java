package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.donation.domain.Donation;
import pl.coderslab.charity.institution.InstitutionService;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;

    private final DonationService donationService;

    private final CategoryService categoryService;


    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institution", institutionService.findAll());
        model.addAttribute("donations", donationService.donationQuantity());
        model.addAttribute("bags", donationService.bagsQuantity());
        return "index";
    }

    @GetMapping("form")
    public String formAction(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("institution", institutionService.findAll());
        model.addAttribute("donation", new Donation());
        return "form";
    }

    // tutaj czy w home controller
    @PostMapping("form")
    public String createDonationAndRedirect(@ModelAttribute Donation donation) {
        donationService.create(donation);
        return "redirect:/confirm";
    }

    @GetMapping("confirm")
    public String confirmDonations() {
        return "form-confirmation";
    }
}
