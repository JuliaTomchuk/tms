package org.example.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @NaturalId
    private Long groupNumber;
    private String name;
    @Enumerated(EnumType.STRING)
    private CourseType type;
    private boolean availableForEnrolling;
    @Embedded
    private CourseSchedule schedule;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany( mappedBy = "courses",cascade = CascadeType.ALL)
    private List<StudentEntity> students= new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseEntity that)) return false;
        return getGroupNumber().equals(that.getGroupNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroupNumber());
    }
}
