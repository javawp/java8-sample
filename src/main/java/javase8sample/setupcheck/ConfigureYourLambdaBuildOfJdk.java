package javase8sample.setupcheck;

import java.util.List;
import static java.util.Arrays.asList;

/**
 * 检查是否是JDK8的环境
 * @author benhail
 */
public class ConfigureYourLambdaBuildOfJdk {

    public static void main(String... args) {
        List<String> messages =  asList(
            "如果此类不能编译，说明开发环境还没有切换到JDK8",
            "如果成功运行，恭喜你");

        messages.forEach(System.out::println);
    }
}
