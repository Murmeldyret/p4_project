package postfix.semantics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import postfix.semantics.Exceptions.InvalidExpressionException;

/**
 * Helper class for TypeVisitor
 */
public class TypeSystem {

    private static final Map<String, Map<String, String>> legalOperations;
    private static final Map<String, String> returnTypes;

    static {
        legalOperations = new HashMap<>();
        legalOperations.put("+", Map.of("int", "int", "float", "float", "string", "string"));
        legalOperations.put("-", Map.of("int", "int", "float", "float"));
        legalOperations.put("*", Map.of("int", "int", "float", "float"));
        legalOperations.put("/", Map.of("int", "int", "float", "float"));
        legalOperations.put("%", Map.of("int", "int"));
        legalOperations.put("<", Map.of("int", "int", "float", "float"));
        legalOperations.put("<=", Map.of("int", "int", "float", "float"));
        legalOperations.put(">", Map.of("int", "int", "float", "float"));
        legalOperations.put(">=", Map.of("int", "int", "float", "float"));
        legalOperations.put("==", Map.of("int", "int", "float", "float", "string", "string", "bool", "bool"));
        legalOperations.put("!=", Map.of("int", "int", "float", "float", "string", "string", "bool", "bool"));
        legalOperations.put("and", Map.of("bool", "bool"));
        legalOperations.put("or", Map.of("bool", "bool"));
    }

    static {
        returnTypes = new HashMap<>();
        returnTypes.put("<", "bool");
        returnTypes.put("<=", "bool");
        returnTypes.put(">", "bool");
        returnTypes.put(">=", "bool");
        returnTypes.put("==", "bool");
        returnTypes.put("!=", "bool");
        returnTypes.put("and", "bool");
        returnTypes.put("or", "bool");
    }

    private Set<String> operators = Set.of("+", "-", "*", "/", "%", "<", "<=", ">", ">=", "==", "!=", "and", "or");

    // public boolean isArithmeticType(String type) {
    // return type.equals("int") || type.equals("float");
    // }

    // public boolean isArithmeticOperator(String operator) {
    // return operator.equals("+") || operator.equals("-") || operator.equals("*")
    // || operator.equals("/")
    // || operator.equals("%");
    // }

    public boolean isBinaryInfixOperator(String Operator) {
        return operators.contains(Operator);
    }

    public boolean isUnaryOperator(String operator) {
        return "not".equals(operator);
    }

    public String lookupUnaryType(String operandType, String operator)
            throws InvalidExpressionException, IllegalArgumentException {
        // skal måske bruges til typecasting (hvis vi når det)
        if (!isUnaryOperator(operator)) {
            throw new IllegalArgumentException("Operator " + operator + " not recognized");
        }

        if (!"bool".equals(operandType)) {
            throw new InvalidExpressionException("Cannot perform " + operator + " on " + operandType);
        }

        return "bool";
    }

    // FIXME virker ikke
    public String lookupResultingTypeNew(String LType, String RType, String operator)
            throws InvalidExpressionException, IllegalArgumentException {
        Map<String, String> typeMapping = legalOperations.get(operator);

        if (typeMapping == null) {
            throw new IllegalArgumentException("Operator " + operator + " not recognized");
        }

        String resultType = typeMapping.get(LType);

        if (resultType == null || !resultType.equals(RType)) {
            throw new InvalidExpressionException("Cannot produce a valid value with " + LType + operator + RType);
        }

        if (returnTypes.containsKey(operator)) {
            return returnTypes.get(operator);
        }

        return resultType;
    }

    /**
     * An ordered pair of types that are legal under the given operator
     */
    // class binaryExpressionPairHelper implements
    // Comparable<binaryExpressionPairHelper> {

    // public binaryExpressionPairHelper(String LeftType, String RightType) {
    // this.LeftType = LeftType;
    // this.RightType = RightType;
    // }

    // private String LeftType, RightType;
    // private final HashMap<String, binaryExpressionPairHelper[]>
    // legalOperationsDic = new HashMap<>() {
    // {
    // put("+", possiblePlusCombinations);
    // put("-", possibleMinusCombinations);
    // put("*", possibleMultiplicationCombinations);
    // put("/", possibleDivisionCombinations);
    // put("%", possibleModuloCombinations);
    // put("<", possibleLessThanCombinations);
    // put("<=", possibleLessThanEqualCombinations);
    // put(">", possibleGreaterThanCombinations);
    // put(">=", possibleGreaterThanEqualCombinations);
    // put("!=", possibleInequalityCombinations);
    // put("==", possibleEqualityCombinations);
    // put("and", possibleAndCombinations);
    // put("or", possibleOrCombinations);
    // }
    // };

    // /**
    // * Returns an array of legal combinations with the given operator
    // *
    // * @param operator The operator whose legal combinations will be returned
    // * @return An array of legal combinations with the given operator
    // * @throws NullPointerException Throws if an illegal operator has been
    // specified
    // */
    // public binaryExpressionPairHelper[] getPossibleTypeCombinations(String
    // operator) throws NullPointerException {
    // binaryExpressionPairHelper[] resultType = legalOperationsDic.get(operator);
    // if (resultType == null) {
    // throw new NullPointerException("Operator " + operator + " not regocnized");
    // }
    // return resultType;
    // }

    // @Override
    // public int compareTo(binaryExpressionPairHelper o) {
    // if (o == null) {
    // throw new NullPointerException();
    // }
    // return this.LeftType.compareTo(o.RightType) +
    // this.RightType.compareTo(o.RightType);
    // }

    // @Override
    // public boolean equals(Object obj) {
    // if (obj == null) {
    // return false;
    // }
    // if (obj == this) {
    // return true;
    // }
    // if (!(obj instanceof binaryExpressionPairHelper)) {
    // return false;
    // }
    // boolean resultType = false;
    // binaryExpressionPairHelper resObj = (binaryExpressionPairHelper) obj;
    // resultType = this.LeftType.equals(resObj.LeftType) &&
    // this.RightType.equals(resObj.RightType);
    // return resultType;
    // }

    // @Override
    // public int hashCode() {
    // // TODO Auto-generated method stub
    // return LeftType.hashCode() + RightType.hashCode();
    // }

    // }

    // // virker dumt
    // private final binaryExpressionPairHelper[] possiblePlusCombinations = {
    // new binaryExpressionPairHelper("string", "string"),
    // new binaryExpressionPairHelper("int", "int"),
    // new binaryExpressionPairHelper("float", "float"),
    // },
    // possibleMinusCombinations = {
    // new binaryExpressionPairHelper("int", "int"),
    // new binaryExpressionPairHelper("float", "float") },
    // possibleMultiplicationCombinations = possibleMinusCombinations,
    // possibleDivisionCombinations = possibleMultiplicationCombinations,
    // possibleModuloCombinations = {
    // new binaryExpressionPairHelper("int", "int"),
    // },
    // possibleLessThanCombinations = {
    // new binaryExpressionPairHelper("int", "int"),
    // new binaryExpressionPairHelper("float", "float"),
    // },
    // possibleLessThanEqualCombinations = possibleLessThanCombinations,
    // possibleGreaterThanCombinations = possibleLessThanCombinations,
    // possibleGreaterThanEqualCombinations = possibleLessThanCombinations,
    // possibleInequalityCombinations = {
    // new binaryExpressionPairHelper("int", "int"),
    // new binaryExpressionPairHelper("float", "float"),
    // new binaryExpressionPairHelper("string", "string"),
    // new binaryExpressionPairHelper("bool", "bool"),
    // // TODO Array?
    // },
    // possibleEqualityCombinations = possibleInequalityCombinations,
    // possibleAndCombinations = {
    // new binaryExpressionPairHelper("bool", "bool"),
    // },
    // possibleOrCombinations = possibleAndCombinations;

    // /**
    // * The outer dictionary takes an operator as a key and returns a dictionary
    // with
    // * key-value mappings of legal combinations
    // * The inner dictionary key is a binaryExpressionPairHelper class that maps to
    // a
    // * resulting type (e.g int or string)
    // */
    // private final HashMap<String, HashMap<binaryExpressionPairHelper, String>>
    // resultingType = new HashMap<>() {
    // {
    // put("+", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("int", "int"), "int");
    // put(new binaryExpressionPairHelper("float", "float"), "float");
    // put(new binaryExpressionPairHelper("string", "string"), "string");
    // }
    // });
    // put("-", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("int", "int"), "int");
    // put(new binaryExpressionPairHelper("float", "float"), "float");
    // }
    // });
    // put("/", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("int", "int"), "int");
    // put(new binaryExpressionPairHelper("float", "float"), "float");
    // }
    // });
    // put("*", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("int", "int"), "int");
    // put(new binaryExpressionPairHelper("float", "float"), "float");
    // }
    // });
    // put("<", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("int", "int"), "bool");
    // put(new binaryExpressionPairHelper("float", "float"), "bool");
    // // string?
    // }
    // });
    // put("<=", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("int", "int"), "bool");
    // put(new binaryExpressionPairHelper("float", "float"), "bool");
    // // string?
    // }
    // });
    // put(">", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("int", "int"), "bool");
    // put(new binaryExpressionPairHelper("float", "float"), "bool");
    // // string?
    // }
    // });
    // put(">=", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("int", "int"), "bool");
    // put(new binaryExpressionPairHelper("float", "float"), "bool");
    // // string?
    // }
    // });
    // put("==", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("int", "int"), "bool");
    // put(new binaryExpressionPairHelper("float", "float"), "bool");
    // put(new binaryExpressionPairHelper("bool", "bool"), "bool");
    // put(new binaryExpressionPairHelper("string", "string"), "bool");
    // }
    // });
    // put("!=", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("int", "int"), "bool");
    // put(new binaryExpressionPairHelper("float", "float"), "bool");
    // put(new binaryExpressionPairHelper("bool", "bool"), "bool");
    // put(new binaryExpressionPairHelper("string", "string"), "bool");
    // }
    // });
    // put("and", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("bool", "bool"), "bool");
    // }
    // });
    // put("or", new HashMap<>() {
    // {
    // put(new binaryExpressionPairHelper("bool", "bool"), "bool");
    // }
    // });

    // }
    // };

    // /**
    // * Returns the type of value produced by the input (sub)expression
    // *
    // * @param LType The left hand side type
    // * @param RType The right hand side type
    // * @param operator The binary infix operator
    // * @return The resulting type
    // * @throws InvalidExpressionException if a valid value cannot be produced with
    // * the given types and operator
    // * @throws IllegalArgumentException if an invalid operator is used
    // */
    // public String LookupResultingType(String LType, String RType, String
    // operator)
    // throws InvalidExpressionException, IllegalArgumentException {
    // String resultType = "";
    // binaryExpressionPairHelper helper = new binaryExpressionPairHelper(LType,
    // RType);

    // try {
    // binaryExpressionPairHelper[] legalOperationswithOperator =
    // helper.getPossibleTypeCombinations(operator);

    // binaryExpressionPairHelper matchingCombination = null;

    // for (binaryExpressionPairHelper binaryExpressionPairHelper :
    // legalOperationswithOperator) {
    // if (helper.compareTo(binaryExpressionPairHelper) == 0) {
    // matchingCombination = binaryExpressionPairHelper;
    // }
    // }
    // if (matchingCombination == null) {
    // throw new InvalidExpressionException("Cannot produce a valid value with " +
    // LType + operator + RType);
    // }

    // resultType = resultingType.get(operator).get(matchingCombination);

    // return resultType;
    // } catch (NullPointerException e) {
    // throw new IllegalArgumentException(e);
    // }
    // }

    // public boolean isBinaryInfixOperator(String Operator)
    // {
    // for(String op : operators) {
    // if(op.equals(Operator)) {
    // return true;
    // }
    // }
    // return false;
    // }
}
