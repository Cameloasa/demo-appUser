package se.lexicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface Address extends JpaRepository<Address, Long> {

    List<Address> findByUser(User user);

    void deleteByUser(User user);

    void deleteById(Long id);

    Optional<Address> findById(Long id);
}
