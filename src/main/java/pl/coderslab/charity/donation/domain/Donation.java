package pl.coderslab.charity.donation.domain;

import lombok.*;
import pl.coderslab.charity.category.domain.Category;
import pl.coderslab.charity.institution.domain.Institution;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer quantity;

    @OneToMany
    private List<Category> categories;

    @ManyToOne
    private Institution institution;

    @NotNull
    private String street;

    @NotNull
    private String city;

    @NotNull
    private String zipCode;

    @NotNull
    private LocalDate pickUpDate;

    @NotNull
    private LocalTime pickUpTime;

    @NotNull
    private String pickUpComment;
}

