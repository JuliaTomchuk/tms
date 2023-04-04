package com.example.service1_rest.domain;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class EmployeeEntity {
    @Id
    private UUID id;
    @NaturalId
    private Long insuranceNumber;
    private String firstName;
    private String secondName;
    private int salary;
    @Enumerated(value = EnumType.STRING)
    private JobTitle jobTitle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEntity that)) return false;
        return getInsuranceNumber().equals(that.getInsuranceNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInsuranceNumber());
    }
}
