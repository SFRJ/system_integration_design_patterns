import com.googlecode.totallylazy.Strings;

import javax.ws.rs.*;
import java.io.File;

import static java.lang.Integer.parseInt;

//http://localhost:8080/calculator?a=2&b=3
@Path("calculator")
public class Calculator {

        @GET
        @Consumes({"application/xml"})
        @Produces({"application/xml"})
        public String sum(@QueryParam("a") String firstNumber, @QueryParam("b") String secondNumber) {

            return prepareResponse(parseInt(firstNumber), parseInt(secondNumber)) + "";
        }

        protected String prepareResponse(int operandA, int operandB) {
            String response = Strings.toString(new File("src/main/resources/output_template.xml"));
            response = response.replace("$operand1$", operandA + "");
            response = response.replace("$operand2$", operandB + "");
            response = response.replace("$result$", sum(operandA, operandB) + "");
            return response;
        }

    private int sum(int a, int b) {
        return a + b;
    }
}
