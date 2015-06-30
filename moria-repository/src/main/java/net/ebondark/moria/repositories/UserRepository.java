package net.ebondark.moria.repositories;

import net.ebondark.moria.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to manage {@link User} instances.
 *
 * @author Kenneth Vittrup
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Returns a page of {@link net.wmlabs.moria.domain.Customer}s with the given lastname.
     *
     * @param lastname
     * @param pageable
     * @return
     */
//    Page<Customer> findByLastname(String lastname, Pageable pageable);
}
