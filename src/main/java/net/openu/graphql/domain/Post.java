package net.openu.graphql.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String id;

    private String title;
    private String text;
    private String category;
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id")
    private Author author;

    public Post(String title, String text, String category, Author author) {
        this.id = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        this.title = title;
        this.text = text;
        this.category = category;
        this.author = author;
        this.createdDate = LocalDateTime.now();
    }

    public void changeAuthor(Author author) {
        this.author = author;
    }
}