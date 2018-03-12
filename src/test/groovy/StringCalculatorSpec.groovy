import spock.lang.Specification
import spock.lang.Unroll

class StringCalculatorSpec extends Specification {


    @Unroll
    def "Check that method add returns '#output' with '#input'"() {
        given: "A StringCalculator instance"
        StringCalculator stringCalculator = new StringCalculator()

        expect:
        stringCalculator.add(input) == output

        where:
        input          | output
        "1"            | "1"
        "0"            | "0"
        "1,2"          | "3"
        "1,5,4,10,100" | "120"
        "1\n2"         | "3"
        "//\$\n1\$2"   | "3"
    }

    def "Expect a IllegalArgumentException when invalid input is entered"() {
        given: "A StringCalculator instance"
        StringCalculator stringCalculator = new StringCalculator()

        and: "An invalid input"
        String input = "1,\n2"

        when: "Calling Stringcalculator.add with invalid input"
        stringCalculator.add(input)

        then: "Expect a IllegalArgumentException to be thrown"
        thrown IllegalArgumentException
    }
}
