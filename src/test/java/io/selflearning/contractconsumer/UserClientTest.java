package io.selflearning.contractconsumer;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = "io.selflearning:user-service:+:stubs:6565",workOffline = true)
@Ignore("Cannot work on CI because workOffline is set to true.")
public class UserClientTest {

    @Autowired
    private UserClient userClient;

    @Test
    public void createUserCompliesToContract() {
        User user = new User();
        user.setFirstName("Steevan");
        user.setLastName("Dsouza");
        IdObject id = userClient.createUser(user);
        assertThat(id.getId()).isEqualTo(42L);
    }

}
