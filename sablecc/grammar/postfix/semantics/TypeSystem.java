package postfix.semantics;

import java.util.ArrayList;

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

        private final ArrayList<binaryExpressionPairHelper> possiblePlusCombinations = new ArrayList<binaryExpressionPairHelper>() {{
            add(new binaryExpressionPairHelper("string", "string"));
            add(new binaryExpressionPairHelper("int", "int"));
            add(new binaryExpressionPairHelper("float", "float"));
            
        }};

        public ArrayList<binaryExpressionPairHelper> getPossibleTypeCombinations(String operator) {
            ArrayList<binaryExpressionPairHelper> resList = new ArrayList<TypeSystem.binaryExpressionPairHelper>() {

            };

            return resList;
        }

    }

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
