package com.project.bookberry.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Users author;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created;
}
