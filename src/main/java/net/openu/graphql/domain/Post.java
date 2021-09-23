package net.openu.graphql.domain;

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
  private Long id;

  private String title;
  private String text;
  private String category;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "author_id")
  private Author author;

  public Post(String title, String text, String category) {
    this.title = title;
    this.text = text;
    this.category = category;
  }

  public void changeAuthor(Author author) {
    this.author = author;
  }
}