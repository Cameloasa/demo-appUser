package se.lexicon.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@Getter
@Setter

@ToString(exclude = "creationDate")
@EqualsAndHashCode

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany
    private Set<Role> roles = new HashSet<>();


    public void addRole(Role role) {
        roles.add(role);
        role.setUser(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.setUser(null);
    }

    public void addRoles(Set<Role> roles) {
        roles.forEach(this::addRole);
    }

    public void removeRoles(Set<Role> roles) {
        roles.forEach(this::removeRole);
    }

    public void setAddress(Address address) {
        //if address is not null set the address of the user
        if (address != null) {
            address.setUser(this);
        } else if (this.address != null) {
            this.address.setUser(null);
        }
        this.address = address;
    }
}
