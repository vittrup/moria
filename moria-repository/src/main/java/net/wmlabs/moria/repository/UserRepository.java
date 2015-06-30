package net.wmlabs.moria.repository;

import net.wmlabs.moria.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to manage {@link net.wmlabs.moria.domain.User} instances.
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
