package net.openu.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.openu.graphql.domain.Post;
import net.openu.graphql.dto.PostDto;
import net.openu.graphql.dto.PostDto.Res;
import net.openu.graphql.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor

@DgsComponent
@Transactional(readOnly = true)
public class DsgQueryFetcher {

    private final PostRepository postRepository;

    @DgsData(parentType = "Query", field = "recentPosts")
    public List<PostDto.Res> recentPosts(@InputArgument("count") Integer count, @InputArgument("offset") Integer offset) {

        final List<Post> all = postRepository.findAll();
        return PostDto.Res.from(all);
    }


}
