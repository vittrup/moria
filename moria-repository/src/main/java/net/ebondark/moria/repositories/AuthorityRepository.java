package net.ebondark.moria.repositories;

import net.ebondark.moria.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to manage {@link Authority} instances.
 *
 * @author Kenneth Vittrup
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    /**
     * Returns a page of {@link net.wmlabs.moria.domain.Customer}s with the given lastname.
     *
     * @param lastname
     * @param pageable
     * @return
     */
//    Page<Customer> findByLastname(String lastname, Pageable pageable);
}
