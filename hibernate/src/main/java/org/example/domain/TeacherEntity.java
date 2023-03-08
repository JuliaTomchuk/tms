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
import javax.persistence.OneToMany;

import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


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
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
    private Set<CourseEntity> courses = new HashSet<>();

    public void addCourse(CourseEntity course){
        courses.add(course);
        course.setTeacher(this);
    }
    public void deleteCourse(CourseEntity course){
        courses.remove(course);
        course.setTeacher(null);
    }


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

