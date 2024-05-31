package se.lexicon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "creationDate")


@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "street_number", nullable = false)
    private String streetNumber;

    @Column(name = "apartment_number")
    private String apartmentNumber;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "zip_code", nullable = false, length = 5)
    private String zipCode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "creation_date")
    private LocalDate creationDate;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
