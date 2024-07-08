package com.cem.elearningplatform.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "authors_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;// we chose course as the owner of the relationship
    // mappedby should be on the inverse side, join table should be on owner side,
    //joincolumns should have owner and inversejoincolumns should have inverse.

    @OneToMany(
            mappedBy = "course"
    )
    private List<Section> sections;
}
