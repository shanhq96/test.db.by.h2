package cn.rknight.student;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StudentTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testQueryStudents() throws Exception {
        when().get("http://127.0.0.1:8081/student/")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(Arrays.asList(1, 2, 3, 4)))
                .body("name", Matchers.equalTo(Arrays.asList("shan1", "shan2", "shan3", "shan4")));
        assertThat(this.restTemplate.getForObject("/student/", String.class))
                .isEqualTo("[{\"id\":1,\"name\":\"shan1\"},{\"id\":2,\"name\":\"shan2\"},{\"id\":3,\"name\":\"shan3\"},{\"id\":4,\"name\":\"shan4\"}]");
    }

}
