package net.openu.graphql.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.openu.graphql.domain.Author;
import net.openu.graphql.domain.Post;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by iopenu@gmail.com on 2021/09/23 Github : https://github.com/bnbaek
 */
public class PostDto {

    @Getter
    @ToString
    public static class Res {

        private long seq;
        private String id;
        private String title;
        private String text;
        private String category;
        private Author author;
        private LocalDateTime createdDate;

        @Builder
        public Res(long seq, String id, String title, String text, String category, Author author, LocalDateTime createdDate) {
            this.seq = seq;
            this.id = id;
            this.title = title;
            this.text = text;
            this.category = category;
            this.author = author;
            this.createdDate = createdDate;
        }

        public static List<Res> from(Collection<Post> entities) {
            return entities.stream().map(Res::from).collect(Collectors.toList());
        }

        public static Res from(Post entity) {
            return Res.builder()
                .id(entity.getId())
                .seq(entity.getSeq())
                .title(entity.getTitle())
                .text(entity.getText())
                .category(entity.getCategory())
                .author(entity.getAuthor())
                .createdDate(entity.getCreatedDate())
                .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Submitted {

        private String title;
        private String text;
        private String category;
    }
}
