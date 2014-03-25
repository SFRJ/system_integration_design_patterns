import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    private static File API_EXAMPLES_FILE =  new File("/home/dev/Desktop/CDC_Example-master/apiexamples/api_example.txt");
    private static final String REQUEST_URL = "http://localhost:8080/calculator?a=5&b=9";
    private static String DATA = "<operation>\n" +
            "    <name>addition</name>\n" +
            "    <operand1>5</operand1>\n" +
            "    <operand2>9</operand2>\n" +
            "    <result>14</result>\n" +
            "</operation>";

    public static void main(String[] args) throws ServletException, LifecycleException, FileNotFoundException {
        TomcatServer tomcatServer = new TomcatServer();
        tomcatServer.start();
        publicApiExample();
    }

    /*
    [PART - 1]
    When the provider builds a new service, he will publish the API examples to a shared location.
    This is not necessary a programatical approach, it can be done via email,sms...
    Api examples should not be created by test data.
    The responsibility of createing the API examples will be of the build.
    In this example, just as a simulation of programmatical generation of the API examples, I am creating them in the main method.
     */
    private static void publicApiExample() throws FileNotFoundException {
        PrintStream printStream = new PrintStream(API_EXAMPLES_FILE);
        printStream.print("\nRequest url:\n" + REQUEST_URL + "\nResponse:\n" + DATA);
        printStream.close();
    }
}
