package net.wmlabs.moria.domain;

import net.wmlabs.moria.domain.utils.Length;
import net.wmlabs.moria.domain.utils.Sequence;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.naming.Name;
import javax.persistence.*;

@Entity
@Table(name = "AUTHORITIES")
public class Authority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = Length.STRING_STD)
    private String name;

    public Authority() {
    }

    public Authority(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(15, 37)
                .append(id)
                .append(name)
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
        Authority rhs = (Authority) obj;
        return new EqualsBuilder()
                .append(id, rhs.id)
                .append(name, rhs.name)
                .isEquals();
    }

}


