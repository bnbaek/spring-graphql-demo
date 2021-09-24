package net.openu.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsEnableDataFetcherInstrumentation;
import com.netflix.graphql.dgs.InputArgument;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import net.openu.graphql.domain.Post;
import net.openu.graphql.dto.PostDto;
import net.openu.graphql.exception.MyException;
import net.openu.graphql.repository.PostRepository;
import net.openu.graphql.service.IpCheckService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j

@DgsComponent
@Transactional(readOnly = true)
public class DsgQueryFetcher {

    private final PostRepository postRepository;
    @Resource(name = "${service.ipcheck.impl}")
    private IpCheckService ipCheckService;

    public DsgQueryFetcher(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @DgsData(parentType = "Query", field = "recentPosts")
    public List<PostDto.Res> recentPosts(@InputArgument("count") Integer count,
        @InputArgument("offset") Integer offset) {
        String s = ipCheckService.checkProfiles();
        log.info("ERROR TEST {}", s);
        final List<Post> all = postRepository.findAll();
        return PostDto.Res.from(all);
    }

    @DgsComponent
    public class HelloDataFetcher {

        @DgsData(parentType = "Query", field = "hello")
        @DgsEnableDataFetcherInstrumentation(false)
        public PostDto.Res hello() {
            log.info("Test");

            throw new MyException();
        }
    }

}
