package postfix;
import postfix.analysis.*;
import postfix.node.*;

class Translation extends DepthFirstAdapter
{
public void outAAddToArrayArrayAdd(AAddToArrayArrayAdd node)
{// out of alternative {plus} in Expr, we print the plus.
System.out.print(node.getKwAdd());
System.out.print(node.getLPar());
System.out.print(node.getArrayExpr());
System.out.print(node.getRPar());
}

public void outAExprValPrimeExpr(AExprValPrimeExpr node)
{//
System.out.print(node.getBopNot());
System.out.print(node.getVal());
System.out.print(node.getExprPrime());
}

public void outAAssignmentStatementStmt(AAssignmentStatementStmt node)
{//
System.out.print(node.getAssignment());
}

public void outAPlusInfixBinInfixOp(APlusInfixBinInfixOp node)
{//
System.out.print(node.getOpPlus());
}

public void outAMinusInfixBinInfixOp(AMinusInfixBinInfixOp node)
{//
System.out.print(node.getOpMinus());
}

public void outAMultiplicationInfixBinInfixOp(AMultiplicationInfixBinInfixOp node)
{//
System.out.print(node.getOpMult());
}

public void outADivisionInfixBinInfixOp(ADivisionInfixBinInfixOp node)
{//
System.out.print(node.getOpDiv());
}

public void outAModuloInfixBinInfixOp(AModuloInfixBinInfixOp node)
{//
System.out.print(node.getOpMod());
}

public void outTRPar(TRPar node)
{//
System.out.print(node.getText());
}

public void outTLPar(TLPar node)
{//
System.out.print(node.getText());
}


}