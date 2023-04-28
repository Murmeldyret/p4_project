package postfix.semantics;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Helper class for TypeVisitor
 */
public class TypeSystem {

    /**
     * An ordered pair of types that are legal under the given operator
     */
    class binaryExpressionPairHelper {

        public binaryExpressionPairHelper(String LeftType, String RightType) {
            this.LeftType = LeftType;
            this.RightType = RightType;

        }

        private String LeftType, RightType;

        /*
         * Possible binary infix operators
         * +
         * -
         * *
         * /
         * %
         * <
         * >
         * <=
         * >=
         * !=
         * ==
         * and
         * or
         */

        // virker dumt
        private final binaryExpressionPairHelper[] possiblePlusCombinations = {
                new binaryExpressionPairHelper("string", "string"),
                new binaryExpressionPairHelper("int", "int"),
                new binaryExpressionPairHelper("float", "float"),

        },
                possibleMinusCombinations = possiblePlusCombinations,
                possibleMultiplicationCombinations = {
                        new binaryExpressionPairHelper("int", "int"),
                        new binaryExpressionPairHelper("float", "float"),
                },
                possibleDivisionCombinations = possibleMultiplicationCombinations,
                possibleModuloCombinations = {
                        new binaryExpressionPairHelper("int", "int"),
                },
                possibleLessThanCombinations = {
                        new binaryExpressionPairHelper("int", "int"),
                        new binaryExpressionPairHelper("float", "float"),
                },
                possibleLessThanEqualCombinations = possibleLessThanCombinations,
                possibleGreaterThanCombinations = possibleLessThanCombinations,
                possibleGreaterThanEqualCombinations = possibleLessThanCombinations,
                possibleInequalityCombinations = {
                        new binaryExpressionPairHelper("int", "int"),
                        new binaryExpressionPairHelper("float", "float"),
                        new binaryExpressionPairHelper("string", "string"),
                        new binaryExpressionPairHelper("bool", "bool"),
                // TODO Array?
                },
                possibleEqualityCombinations = possibleInequalityCombinations,
                possibleAndCombinations = {
                        new binaryExpressionPairHelper("bool", "bool"),
                },
                possibleOrCombinations = possibleAndCombinations;

        private final HashMap<String,binaryExpressionPairHelper[]> legalOperationsDic = new HashMap<>() {
            {
                put("+", possiblePlusCombinations);
                put("-", possibleMinusCombinations);
                put("*", possibleMultiplicationCombinations);
                put("/", possibleDivisionCombinations);
                put("%", possibleModuloCombinations);
                put("<", possibleLessThanCombinations);
                put("<=", possibleLessThanEqualCombinations);
                put(">", possibleGreaterThanCombinations);
                put(">=", possibleGreaterThanEqualCombinations);

            }
        }
                
        public binaryExpressionPairHelper[] getPossibleTypeCombinations(String operator) {
            binaryExpressionPairHelper[] resList = {};

            return resList;
        }

    }

    private String[] operators = { "+", "-", "*", "/", "%", "<", "<=", ">", ">=", "==", "!=", "and", "or" };

    /**
     * Returns the type of value produced by the input (sub)expression
     * 
     * @param LType    The left hand side type
     * @param RType    The right hand side type
     * @param operator The binary infix operator
     * @return The resulting type
     */
    public String LookupResultingType(String LType, String RType, String operator) {
        String res = "";
        return res;
    }

}
