package se.lexicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByUsername(String username);

    User findByEmailOrUsername(String email, String username);

    User findByUsernameOrEmail(String username, String email);

    User findByAddressId(Long addressId);

    User findByRoleId(Long roleId);

    User findByAddressIdAndRoleId(Long addressId, Long roleId);

    User findByRoleIdAndAddressId(Long roleId, Long addressId);

    User findByAddressIdAndRoleIdAndUsername(Long addressId, Long roleId, String username);
}
