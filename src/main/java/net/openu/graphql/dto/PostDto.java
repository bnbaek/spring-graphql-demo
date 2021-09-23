package net.openu.graphql.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.openu.graphql.domain.Author;
import net.openu.graphql.domain.Post;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by iopenu@gmail.com on 2021/09/23
 * Github : https://github.com/bnbaek
 */
public class PostDto {

  @Getter
  @ToString
  public static class Res {
    private long id;
    private String title;
    private String text;
    private String category;
    private Author author;

    @Builder
    public Res(long id, String title, String text, String category, Author author) {
      this.id = id;
      this.title = title;
      this.text = text;
      this.category = category;
      this.author = author;
    }

    public static List<Res> from(Collection<Post> entities) {
      return entities.stream().map(Res::from).collect(Collectors.toList());
    }

    public static Res from(Post entity) {
      return Res.builder()
          .id(entity.getId())
          .title(entity.getTitle())
          .text(entity.getText())
          .category(entity.getCategory())
          .author(entity.getAuthor())
          .build();
    }
  }
}
