package org.example.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @NaturalId
    private Long insuranceNumber;
    private String name;
    private LocalDate birthday;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    private List<CourseEntity> courses;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherEntity teacher)) return false;
        return getInsuranceNumber().equals(teacher.getInsuranceNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInsuranceNumber());
    }
}

