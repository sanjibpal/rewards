import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = RewardsApplication.class)
public class RewardsApplicationTest {

    @Autowired
    private RewardsApplication application;

    @Test
    public void contextLoads() {
        // Ensure that the application context loads successfully
    }
}