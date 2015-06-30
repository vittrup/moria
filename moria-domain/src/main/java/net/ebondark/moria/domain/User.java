package net.ebondark.moria.domain;

import net.ebondark.moria.domain.utils.Length;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    private static final long serialVersionUID = -8275492272371421013L;

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "USERNAME", nullable = false, length = Length.STRING_STD)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = Length.STRING_STD)
    private String password;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Authority> authorities;

    @Column(name = "ENABLED", nullable = false)
    private Boolean enabled;

    public User() {
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(15, 37)
                .append(username)
                .append(password)
                .append(authorities)
                .append(enabled)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        User rhs = (User) obj;
        return new EqualsBuilder()
                .append(username, rhs.username)
                .append(password, rhs.password)
                .append(authorities, rhs.authorities)
                .append(enabled, rhs.enabled)
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("username", username).
                append("password", password).
                append("authorities", authorities).
                append("enabled", enabled).
                toString();
    }
}

