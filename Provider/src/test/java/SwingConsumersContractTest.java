import com.googlecode.totallylazy.Strings;
import org.apache.catalina.LifecycleException;
import org.junit.Test;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;

import static com.googlecode.totallylazy.Xml.document;
import static com.googlecode.totallylazy.Xml.matches;
import static junit.framework.TestCase.assertTrue;

public class SwingConsumersContractTest {

     /*
    [PART 4]
    The provider plugs consumer parser behaviour into a unit test and verifies expectations against its own API Examples
    (this acts as the Consumer Driven Contracts):
    */
    private String consumerDrivenContract;
    private boolean contractFulfilled;

    @Test
    public void contractWithSwingConsumerForResult() throws ServletException, LifecycleException, IOException {
        givenWehaveAConsumerDrivenContract();
        whenWeAplyTheContractToOurOwnAPIExample();
        thenTheContractIsFulfilled();
    }

    private void givenWehaveAConsumerDrivenContract() {
        consumerDrivenContract = Strings.toString(new File("/home/dev/Desktop/CDC_Example-master/contracts/contract.txt"));
    }

    private void whenWeAplyTheContractToOurOwnAPIExample() {
        String ownApiExamples = Strings.toString(new File("/home/dev/Desktop/CDC_Example-master/apiexamples/api_example.txt"));
        String theXMLFromTheExample = ownApiExamples.substring(ownApiExamples.indexOf("Response:") + 10);
        contractFulfilled = matches(document(theXMLFromTheExample), consumerDrivenContract);
    }

    private void thenTheContractIsFulfilled() {
        assertTrue(contractFulfilled);
    }


}
