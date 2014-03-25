import com.googlecode.totallylazy.Strings;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static gui.OperationParser.parse;
import static gui.OperationParser.parsedXpath;
import static java.lang.Integer.parseInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OperationParserTest {

    private final String apiExample = getApiExamplesFromRepository();
    private String response = apiExample.substring(apiExample.indexOf("Response:") + 10);

    private String getApiExamplesFromRepository() {
        try {
            return Strings.toString(new File("/home/dev/Desktop/CDC_Example-master/apiexamples/api_example.txt"));
        }
        catch (Exception e) {
            System.err.println("Provider did not publish examples. Go talk to them!");
        }
        return null;
    }

    /*
      [PART 2 - a]
      The consumer test drives the parser and if the test successes this will help discover the consumer contract.
     */
    @Test
    public void parsesTheResponseCorrectly() {
        // given parser receives an API Example acting as a response
         String apiExample = response;
        // when I parse the API Example
        int result = parseInt(parse(apiExample).trim());
        // then I receive a successful answer
        assertThat(result,is(14));
    }

    /*
     [PART 2 - b(Optional)]
     Automating the publishing of the contract into the contract repository is an interesting feature but is not really necessary
    */
    @After
    public void publishContract() throws FileNotFoundException {
        File file = new File("/home/dev/Desktop/CDC_Example-master/contracts/contract.txt");
        PrintStream printStream = new PrintStream(file);
        printStream.print(parsedXpath());
        printStream.close();
    }

}
