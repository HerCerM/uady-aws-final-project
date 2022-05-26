package hercerm.college.uadyawsfinalproject.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "aws")
@PropertySource("classpath:application.yml")
public class AwsConfig {
    String accessKeyId;
    String secretAccessKey;
    String sessionToken;
    String studentBucketName;
}
