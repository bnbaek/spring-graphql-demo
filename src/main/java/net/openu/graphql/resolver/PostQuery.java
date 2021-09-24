package net.openu.graphql.resolver;

//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//import lombok.RequiredArgsConstructor;
//import net.openu.graphql.domain.Post;
//import net.openu.graphql.dto.PostDto;
//import net.openu.graphql.repository.PostRepository;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//
///**
// * Created by iopenu@gmail.com on 2021/09/23
// * Github : https://github.com/bnbaek
// */
//
//@RequiredArgsConstructor
//@Component
//@Transactional(readOnly = true)
//public class PostQuery implements GraphQLQueryResolver {
//  private final PostRepository postRepository;
//
//  public List<PostDto.Res> recentPosts(int count, int offset) {
//    final List<Post> all = postRepository.findAll();
//    return PostDto.Res.from(all);
//  }
//
//}
