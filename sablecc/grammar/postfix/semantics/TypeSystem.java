package postfix.semantics;

import java.util.HashMap;
import postfix.semantics.Exceptions.InvalidExpressionException;

/**
 * Helper class for TypeVisitor
 */
public class TypeSystem {

    /**
     * An ordered pair of types that are legal under the given operator
     */
    class binaryExpressionPairHelper implements Comparable<binaryExpressionPairHelper> {

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

        private final HashMap<String, binaryExpressionPairHelper[]> legalOperationsDic = new HashMap<>() {
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
                put("!=", possibleInequalityCombinations);
                put("==", possibleEqualityCombinations);
                put("and", possibleAndCombinations);
                put("or", possibleOrCombinations);

            }
        };

        // key is operator, nested key is operands
        // The horror
        private final HashMap<String, HashMap<binaryExpressionPairHelper, String>> resultingType = new HashMap<>() {
            {
                put("+", new HashMap<>() {
                    {
                        put(new binaryExpressionPairHelper("int", "int"), "int");
                        put(new binaryExpressionPairHelper("float", "float"), "float");
                        put(new binaryExpressionPairHelper("string", "string"), "string");
                    }
                });
                put("-", new HashMap<>() {
                    {
                        put(new binaryExpressionPairHelper("int", "int"), "int");
                        put(new binaryExpressionPairHelper("float", "float"), "float");
                    }
                });
                put("/", new HashMap<>() {
                    {
                        put(new binaryExpressionPairHelper("int", "int"), "int");
                        put(new binaryExpressionPairHelper("float", "float"), "float");
                    }
                });
                put("*", new HashMap<>() {
                    {
                        put(new binaryExpressionPairHelper("int", "int"), "int");
                        put(new binaryExpressionPairHelper("float", "float"), "float");
                    }
                });
                put("<", new HashMap<>(){
                    {
                        put(new binaryExpressionPairHelper("int", "int"), "bool");
                        put(new binaryExpressionPairHelper("float", "float"), "bool");
                        //string?
                    }
                });
                put("<=", new HashMap<>(){
                    {
                        put(new binaryExpressionPairHelper("int", "int"), "bool");
                        put(new binaryExpressionPairHelper("float", "float"), "bool");
                        //string?
                    }
                });
                put(">", new HashMap<>(){
                    {
                        put(new binaryExpressionPairHelper("int", "int"), "bool");
                        put(new binaryExpressionPairHelper("float", "float"), "bool");
                        //string?
                    }
                });
                put(">=", new HashMap<>(){
                    {
                        put(new binaryExpressionPairHelper("int", "int"), "bool");
                        put(new binaryExpressionPairHelper("float", "float"), "bool");
                        //string?
                    }
                });
                put("==", new HashMap<>(){
                    {
                        put(new binaryExpressionPairHelper("int", "int"), "bool");
                        put(new binaryExpressionPairHelper("float", "float"), "bool");
                        put(new binaryExpressionPairHelper("bool", "bool"), "bool");
                        put(new binaryExpressionPairHelper("string", "string"),"bool");
                    }
                });
                put("!=", new HashMap<>(){
                    {
                        put(new binaryExpressionPairHelper("int", "int"), "bool");
                        put(new binaryExpressionPairHelper("float", "float"), "bool");
                        put(new binaryExpressionPairHelper("bool", "bool"), "bool");
                        put(new binaryExpressionPairHelper("string", "string"),"bool");
                    }
                });
                put("and", new HashMap<>(){
                    {
                        put(new binaryExpressionPairHelper("bool", "bool"), "bool");
                    }
                });
                put("or", new HashMap<>(){
                    {
                        put(new binaryExpressionPairHelper("bool", "bool"), "bool");
                    }
                });

            }
        };

        /**
         * Returns an array of legal combinations with the given operator
         * 
         * @param operator The operator whose legal combinations will be returned
         * @return An array of legal combinations with the given operator
         * @throws NullPointerException Throws if an illegal operator has been specified
         */
        public binaryExpressionPairHelper[] getPossibleTypeCombinations(String operator) throws NullPointerException {
            binaryExpressionPairHelper[] res = legalOperationsDic.get(operator);
            if (res == null) {
                throw new NullPointerException("Operator " + operator + " not regocnized");
            }

            return res;
        }

        @Override
        public int compareTo(binaryExpressionPairHelper o) {
            if (o == null) {
                throw new NullPointerException();
            }
            return this.LeftType.compareTo(o.RightType) + this.RightType.compareTo(o.RightType);
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
        binaryExpressionPairHelper helper = new binaryExpressionPairHelper(LType, RType);

        try {
            binaryExpressionPairHelper[] legalOperationswithOperator = helper.getPossibleTypeCombinations(operator);

            binaryExpressionPairHelper doesLegalCombinationExist = null;
            for (binaryExpressionPairHelper binaryExpressionPairHelper : legalOperationswithOperator) {
                if (helper.compareTo(binaryExpressionPairHelper) == 0) {
                    doesLegalCombinationExist = binaryExpressionPairHelper;
                }
            }
            if (doesLegalCombinationExist == null) {
                throw new InvalidExpressionException("Cannot produce a valid value with " + LType + operator + RType);
            }

            // TODO resultattype af udtryk

        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        }

        return res;
    }

}
