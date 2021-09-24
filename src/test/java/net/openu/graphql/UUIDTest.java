package net.openu.graphql;

import java.util.UUID;
import org.junit.Test;

public class UUIDTest {

    @Test
    public void di() {
        for (int i = 0; i <= 2; i++) {
            String uid = UUID.randomUUID().toString().replace("-", "");
            System.out.println(uid);

        }
    }

}
