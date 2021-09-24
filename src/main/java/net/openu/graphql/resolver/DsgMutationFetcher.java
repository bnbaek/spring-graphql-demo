package net.openu.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.openu.graphql.domain.Author;
import net.openu.graphql.domain.Post;
import net.openu.graphql.dto.PostDto;
import net.openu.graphql.dto.PostDto.Res;
import net.openu.graphql.repository.AuthorRepository;
import net.openu.graphql.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor

@DgsComponent

public class DsgMutationFetcher {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;


    @DgsMutation
    @Transactional
    public Res writePost(@InputArgument(value = "post") PostDto.Submitted submitted){
        Author author = authorRepository.findById(1L).orElse(null);
        Post post = new Post(submitted.getTitle(),submitted.getText(),submitted.getCategory(),author);

        return PostDto.Res.from(postRepository.save(post));
    }
//    public List<Res> shows(@InputArgument("titleFilter") String titleFilter) {
//        if (titleFilter == null) {
//            return shows;
//        }
//        return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
//    }

}
