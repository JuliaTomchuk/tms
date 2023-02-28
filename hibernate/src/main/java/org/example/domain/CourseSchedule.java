package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSchedule {
    private LocalDate startCourse;
    private LocalDate endCourse;
}
