package org.example.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @NaturalId
    private Long insuranceNumber;
    private String name;
    @ToString.Exclude
     @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
    private Set<CourseEntity> courses = new HashSet<>();


      @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity that)) return false;
        return getInsuranceNumber().equals(that.getInsuranceNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInsuranceNumber());
    }
}
