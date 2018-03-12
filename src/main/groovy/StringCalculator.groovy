class StringCalculator {

    private static final String SPLIT_PATTERN = ",\n"
    private static final String OPENING_BRACKET = "[" as char
    private static final String CLOSING_BRACKET = "]"

    static String add(String input) {

        if(input.isEmpty()){
            return "0"
        }

        String newSplitPattern = OPENING_BRACKET + SPLIT_PATTERN

        (newSplitPattern, input) = setDelimiter(input, newSplitPattern)
        newSplitPattern += CLOSING_BRACKET


        String[] inputArr = input.split(newSplitPattern)
        int output = 0
        output = iterate(inputArr, output)
        return String.valueOf(output)
    }

    private static List setDelimiter(String input, String newSplitPattern) {
        if (input.contains("//")) {
            if (input.substring(0, 2) == "//") {
                newSplitPattern += input.substring(2, input.indexOf("\n"))
                input = input.substring(input.indexOf("\n") + 1, input.length())
            }
        }
        return [newSplitPattern, input]
    }

    private static int iterate(String[] inputArr, int output) {
        inputArr.each { String s ->
            output += Integer.valueOf(s)
        }
        return output
    }
}
