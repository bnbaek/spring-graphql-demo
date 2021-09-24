package net.openu.graphql.resolver;

//import com.coxautodev.graphql.tools .GraphQLMutationResolver;
//import lombok.RequiredArgsConstructor;
//import net.openu.graphql.domain.Post;
//import net.openu.graphql.dto.PostDto;
//import net.openu.graphql.repository.AuthorRepository;
//import net.openu.graphql.repository.PostRepository;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Created by iopenu@gmail.com on 2021/09/23
// * Github : https://github.com/bnbaek
// */
//@RequiredArgsConstructor
//@Component
//@Transactional
//public class PostMutation implements GraphQLMutationResolver {
//  private final PostRepository postRepository;
//  private final AuthorRepository authorRepository;
//  public PostDto.Res writePost(String title, String text, String category) {
//    Post post = new Post(title,text,category);
//
//    Post saved= postRepository.save(post);
//    saved.changeAuthor(authorRepository.findById(1L).orElse(null));
//
//    return PostDto.Res.from(saved);
//  }
//}
