package com.project.bookberry.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "age_limit")
    private Integer ageLimit;

    @Column(name = "author")
    private String author;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "discount")
    private Integer discount = 0;

    @Column(name = "language")
    private Integer language;

    @Column(name = "sold_count")
    private Integer soldCount = 0;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Users publisher;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Categories> categories;

    @Column(name = "number_pages")
    private Integer numberOfPage;

    @Column(name = "date_of_the_last_draw")
    private LocalDate dateOfTheLastDraw;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private List<Comments> comments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photos photo;
}
