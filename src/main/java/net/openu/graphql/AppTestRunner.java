package net.openu.graphql;

import lombok.RequiredArgsConstructor;
import net.openu.graphql.domain.Post;
import net.openu.graphql.repository.PostRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by iopenu@gmail.com on 2021/09/23
 * Github : https://github.com/bnbaek
 */

@RequiredArgsConstructor
@Component
public class AppTestRunner implements ApplicationRunner {
  private final PostRepository postRepository;
  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<Post> all = postRepository.findAll();
    System.out.println(all.size());
  }
}
