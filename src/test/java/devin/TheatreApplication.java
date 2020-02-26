package devin;

import com.devin.util.LocaleMessageUtil;
import devin.model.dto.TheatrePropertiesEnum;
import org.apache.catalina.filters.RequestFilter;
import org.apache.juli.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheatreApplication {
    private static final Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    @Test
    public static void main(String[] args) {
        SpringApplication.run(TheatreApplication.class, args);
    }

    @Test
    public void sayDebug(){
        System.out.println(TheatrePropertiesEnum.THEATRE_LOCALE.getProp());
    }
}
