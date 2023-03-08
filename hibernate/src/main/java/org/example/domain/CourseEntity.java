package org.example.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


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
    @ManyToOne
    @ToString.Exclude
    private TeacherEntity teacher;
    @ManyToMany( mappedBy = "courses",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
    private Set<StudentEntity> students= new HashSet<>();

    public void addStudent(StudentEntity student){
        students.add(student);
        student.getCourses().add(this);
    }

    public void deleteStudent(StudentEntity student){
         students.remove(student);
        student.getCourses().remove(this);
    }


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
