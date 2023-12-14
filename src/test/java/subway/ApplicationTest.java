package subway;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        // 원래의 System.out을 캡처하여 임시 PrintStream으로 변경
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        // 테스트가 끝난 후에는 원래의 System.out으로 복구
        System.setOut(standardOut);
    }

    void systemIn(String... input) {
        System.setIn(new ByteArrayInputStream(String.join("\n", input).getBytes()));
    }

    String getOutput() {
        return outputStreamCaptor.toString();
    }

    @Test
    @DisplayName("기능_테스트")
    void FunctionTest() {
        systemIn("1", "1", "교대역", "양재역");
        Application.main(new String[]{});

        standardOut.println(getOutput());
        assertThat(getOutput())
                .contains("## 경로 기준");
    }
}
