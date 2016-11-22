package ua.teachme.utility.math.model.calculations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
    LinksMapper class - create 'clean' RPN from 'dirty' RPN.
    Use recursion.
*/
public class LinksMapper {

    public static String buildCleanRPN(String rpn, Map<String, String> links) {
        if (!containsLinks(rpn)) {
            return rpn;
        }
        List<String> list = recursiveReplaceLinksToValues(rpn, links, new ArrayList<>());
        return String.join(" ", list);
    }

    private static List<String> recursiveReplaceLinksToValues(String rpn, Map<String, String> links, List<String> finalRPN) {

        if (!containsLinks(rpn)) {
            if (rpn.length() > 1 && !Token.isNumber(rpn)) {
                finalRPN.add(rpn);
            }
            return finalRPN;
        }

        StringTokenizer tokenizer = new StringTokenizer(rpn, " ");

        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();

            if (Token.isLink(token)) {
                token = links.get(token);
                recursiveReplaceLinksToValues(token, links, finalRPN);
            }
            if (Token.isOperator(token) || Token.isNumber(token))
                finalRPN.add(token);
        }

        return finalRPN;
    }

    private static boolean containsLinks(String potentialRPN) {

        StringTokenizer tokenizer = new StringTokenizer(potentialRPN, " ");
        List<String> tokens = new ArrayList<>();

        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }

        for (String token : tokens) {
            if (Token.isLink(token)) return true;
        }
        return false;
    }
}
