package test;

import com.mall.test.MallTestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 *
 * @author zb
 * @date 2020/5/20 14:29
 */
@SpringBootTest(classes = MallTestApplication.class)
public class MallTestApplicationTests {

    @Autowired
    private RestTemplate  restTemplate;

    @Test
    public void test(){
        String forObject = restTemplate.getForObject("http://localhost:8081/swagger-ui.html", String.class);
        System.out.println(forObject);
    }

    @Test
    public void contextLoads(){
        System.out.println("测试");
    }

}
