//------------------------------------------------------------------//
//                        COPYRIGHT NOTICE                          //
//------------------------------------------------------------------//
// Copyright (c) 2024, Francisco J. Moreno Velo                     //
//                                                                  //
// Permission is hereby granted, free of charge, to any person      //
// obtaining a copy of this software and associated documentation   //
// files (the "Software"), to deal in the Software without          //
// restriction, including without limitation the rights to use,     //
// copy, modify, merge, publish, distribute, sublicense, and/or     //
// sell copies of the Software, and to permit persons to whom the   //
// Software is furnished to do so, subject to the following         //
// conditions:                                                      //
//                                                                  //
// - The above copyright notice and this permission notice shall be //
//   included in all copies or substantial portions of the Software.//
//                                                                  //
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,  //
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES  //
// OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND         //
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT      //
// HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,     //
// WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING     //
// FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR    //
// OTHER DEALINGS IN THE SOFTWARE.                                  //
//------------------------------------------------------------------//

//------------------------------------------------------------------//
//                      Universidad de Huelva                       //
//          Departamento de Tecnologías de la Información           //
//   Área de Ciencias de la Computación e Inteligencia Artificial   //
//------------------------------------------------------------------//
//                                                                  //
//                         Urium compiler                           //
//                                                                  //
//------------------------------------------------------------------//

package urium.code;

import java.io.PrintStream;
import urium.ast.*;
import urium.ast.expression.*;
import urium.ast.statement.*;
import urium.ast.struct.*;

/**
 * Class that describes the intermediate code of a procedure
 * 
 * @author Francisco J. Moreno Velo
 */
public class ProcedureCodification implements CodeConstants {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//
	
	/**
	 * Procedure start label
	 */
	private String label;

	/**
	 * Counter used by the label generator
	 */
	private int labelcount;

	/**
	 * Counter used by the generator of temporary variables
	 */
	private int tmpcount;

	/**
	 * List of local and temporary variables
	 */
	private CodeVariable[] var;

	/**
	 * List of arguments
	 */
	private CodeVariable[] arg;

	/**
	 * Local variables defined in the Abstract Syntax Tree
	 */
	private Variable[] astvar;

	/**
	 * Procedure description in intermediate code 
	 */
	private CodeInstructionList list;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//
	
	/**
	 * Constructor
	 */
	public ProcedureCodification(Procedure proc)
	{	
		Variable[] arg = proc.getArguments();
		Variable[] local = proc.getLocalVariables();
		BlockStatement body = proc.getBody();
	
		this.label = proc.getLabel();
		this.labelcount = 0;
		this.tmpcount = 0;
		this.list = new CodeInstructionList();
		this.var = new CodeVariable[arg.length+local.length];
		this.astvar = new Variable[arg.length+local.length];
		this.arg = new CodeVariable[arg.length];
		
		for(int i=0; i<arg.length; i++) 
		{
			this.var[i] = new CodeVariable(arg[i].getType(), "arg_"+i,arg[i].getName());
			this.astvar[i] = arg[i];
			this.arg[i] = this.var[i];
		}
		int indent = arg.length;
		for(int i=0; i<local.length; i++) 
		{
			this.var[indent+i] = new CodeVariable(local[i].getType(), "local_"+i,local[i].getName());
			this.astvar[indent+i] = local[i];
		}
		
		this.list = generateCodeOfBlockStatement(body);
	}
	
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Gets the procedure start label
	 */
	public String getLabel()
	{
		return this.label;
	}
	
	/**
	 * Write the intermediate code of the procedure on a stream
	 */
	public void print(PrintStream stream) 
	{
		CodeLabel begin = new CodeLabel(label);
		CodeInstruction beginInst = new CodeInstruction(LABEL,begin,null,null);
		stream.println(beginInst);
		CodeInstruction[] instlist = list.getList();
		for(int i=0; i<instlist.length; i++) stream.println(instlist[i]);
	}
	
	/**
	 * Gets the list of intermediate code instructions
	 */
	public CodeInstruction[] getCodeInstructionList() 
	{
		return this.list.getList();
	}
	
	/**
	 * Gets the list of arguments
	 */
	public CodeVariable[] getArguments()
	{
		return this.arg;
	}
	
	/**
	 * Gets the list of local and temporary variables
	 */
	public CodeVariable[] getVariables()
	{
		return this.var;
	}
	
	//----------------------------------------------------------------//
	//         Private methods (intermediate code of statements)      //
	//----------------------------------------------------------------//
	
	/**
	 * Generates the intermediate code associated with an statement in the source code
	 */
	private CodeInstructionList generateCodeOfStatement(Statement stm) 
	{
		if(stm instanceof BlockStatement) 
		{
			return generateCodeOfBlockStatement((BlockStatement) stm);
		} 
		else if(stm instanceof IfStatement) 
		{
			return generateCodeOfIfStatement((IfStatement) stm);
		} 
		else if(stm instanceof WhileStatement) 
		{
			return generateCodeOfWhileStatement((WhileStatement) stm); 
		} 
		else if(stm instanceof EndpStatement) 
		{
			return generateCodeOfEndpStatement((EndpStatement) stm);
		} 
		else if(stm instanceof CallStatement) 
		{
			return generateCodeOfCallStatement((CallStatement) stm);
		} 
		else if(stm instanceof AssignStatement) 
		{
			return generateCodeOfAssignStatement((AssignStatement) stm);
		} 
		else 
		{
			return new CodeInstructionList();
		}
	}

	/**
	 * Generates the intermediate code associated with a block of statement in the source code
	 */
	private CodeInstructionList generateCodeOfBlockStatement(BlockStatement block) 
	{
		CodeInstructionList list = new CodeInstructionList();
		Statement[] inst = block.getStatementList();
		for(int i=0; i<inst.length; i++) 
		{
			CodeInstructionList instcode =  generateCodeOfStatement(inst[i]);
			list.addInstructionList(instcode.getList());
		}
		return list;
	}

	/**
	 * Generates the intermediate code associated with an if statement
	 */
	private CodeInstructionList generateCodeOfIfStatement(IfStatement inst) 
	{
		Expression condition = inst.getCondition();
		Statement thenInst = inst.getThenInstruction();
		Statement elseInst = inst.getElseInstruction();
		CodeLabel lbTrue = getNewLabel();
		CodeLabel lbFalse = getNewLabel();
		CodeInstruction lbTrueInst = new CodeInstruction(LABEL,lbTrue,null,null);
		CodeInstruction lbFalseInst = new CodeInstruction(LABEL,lbFalse,null,null);

		CodeInstructionList condinst = generateCodeForCondition(condition,lbTrue,lbFalse);
		CodeInstructionList theninst = generateCodeOfStatement(thenInst);
		CodeInstructionList elseinst = generateCodeOfStatement(elseInst);

		CodeInstructionList codelist = new CodeInstructionList();
		codelist.addInstructionList(condinst.getList());
		codelist.addInstruction(lbTrueInst);
		codelist.addInstructionList(theninst.getList());

		if(elseInst == null) 
		{
			codelist.addInstruction(lbFalseInst);
		} 
		else 
		{
			CodeLabel lbEnd = getNewLabel();
			CodeInstruction lbEndInst = new CodeInstruction(LABEL,lbEnd,null,null);	
			CodeInstruction gotoEnd = new CodeInstruction(JUMP,lbEnd,null,null);
			codelist.addInstruction(gotoEnd);
			codelist.addInstruction(lbFalseInst);
			codelist.addInstructionList(elseinst.getList());
			codelist.addInstruction(lbEndInst);
		}

		return codelist;
	}

	/**
	 * Generates the intermediate code associated with a while statement
	 */
	private CodeInstructionList generateCodeOfWhileStatement(WhileStatement inst) 
	{
		Expression condition = inst.getCondition();
		Statement block = inst.getBody();

		CodeLabel lbBegin = getNewLabel();
		CodeLabel lbTrue = getNewLabel();
		CodeLabel lbFalse = getNewLabel();

		CodeInstruction lbBeginInst = new CodeInstruction(LABEL,lbBegin,null,null);
		CodeInstruction lbTrueInst = new CodeInstruction(LABEL,lbTrue,null,null);
		CodeInstruction lbFalseInst = new CodeInstruction(LABEL,lbFalse,null,null);
		CodeInstruction jmpBegin = new CodeInstruction(JUMP,lbBegin,null,null);

		CodeInstructionList condinst = generateCodeForCondition(condition,lbTrue,lbFalse);
		CodeInstructionList blockinst = generateCodeOfStatement(block);

		CodeInstructionList codelist = new CodeInstructionList();
		codelist.addInstruction(lbBeginInst);
		codelist.addInstructionList(condinst.getList());
		codelist.addInstruction(lbTrueInst);
		codelist.addInstructionList(blockinst.getList());
		codelist.addInstruction(jmpBegin);
		codelist.addInstruction(lbFalseInst);

		return codelist;		
	}

	/**
	 * Generates the intermediate code associated with an endp statement
	 */
	private CodeInstructionList generateCodeOfEndpStatement(EndpStatement inst) 
	{
		CodeInstructionList codelist = new CodeInstructionList();
		codelist.addInstruction(new CodeInstruction(ENDP,null,null,null));
		return codelist;
	}

	/**
	 * Generates the intermediate code associated with a procedure call
	 */
	private CodeInstructionList generateCodeOfCallStatement(CallStatement inst) 
	{
		CodeInstructionList codelist = new CodeInstructionList();			
		
		Procedure proc = inst.getProcedure();
		CallParameters call = inst.getCallParameters();
		Expression[] paramexp = call.getParameters();

		int basicsize = 0;
		int refsize = 0;
		for(int i=0; i<paramexp.length; i++) 
		{
			if(TypeSystem.isReference(paramexp[i].getType())) refsize += 4;
			else basicsize += TypeSystem.getNumberOfBytes(paramexp[i].getType());
		}
		
		codelist.addInstruction(new CodeInstruction(PRECALL, new CodeLiteral(basicsize), new CodeLiteral(refsize), null));

		int basicpos=0;
		int refpos=0;
		CodeVariable[] param = new CodeVariable[paramexp.length];
		for(int i=0; i<param.length; i++) 
		{
			param[i] = generateCodeForExpression(paramexp[i],codelist);
			codelist.addInstruction(new CodeInstruction(PARAM,param[i],new CodeLiteral(basicpos),new CodeLiteral(refpos)));
			if(TypeSystem.isReference(paramexp[i].getType())) refpos += 4;
			else basicpos += TypeSystem.getNumberOfBytes(paramexp[i].getType());
		}

		CodeLabel proclabel = new CodeLabel(proc.getLabel());
		codelist.addInstruction(new CodeInstruction(CALL,proclabel,null,null));
		
		return codelist;
	}

	/**
	 * Generates the intermediate code associated with an assignment statement
	 */
	private CodeInstructionList generateCodeOfAssignStatement(AssignStatement inst) 
	{
		VariableExpression var = (VariableExpression) inst.getLeftHand();
		Expression exp = inst.getExpression();
		CodeVariable target = getCodeVariable(var.getVariable());
		CodeInstructionList codelist = new CodeInstructionList();		
		CodeVariable result = generateCodeForExpression(exp,codelist);
		CodeInstruction assign = new CodeInstruction(ASSIGN, target, result, null);			
		codelist.addInstruction(assign);
		return codelist;
	}

	//----------------------------------------------------------------//
	//        Private methods (intermediate code of expressions)      //
	//----------------------------------------------------------------//
	
	/**
	 * Generates the intermediate code associated with an expression
	 */
	private CodeVariable generateCodeForExpression(Expression exp, CodeInstructionList codelist) 
	{
		DataType type = exp.getType();

		if(exp instanceof IntegerLiteralExpression) 
		{
			return generateCodeForIntegerLiteralExpression((IntegerLiteralExpression) exp,codelist);
		} 
		else if(exp instanceof CharLiteralExpression) 
		{
			return generateCodeForCharLiteralExpression((CharLiteralExpression) exp,codelist);
		} 
		else if(exp instanceof BooleanLiteralExpression) 
		{
			return generateCodeForBooleanLiteralExpression((BooleanLiteralExpression) exp,codelist);
		} 
		else if(TypeSystem.isBoolean(type) && exp instanceof BinaryExpression) 
		{
			return generateCodeForBooleanExpression(exp,codelist);
		} 
		else if(TypeSystem.isBoolean(type) && exp instanceof UnaryExpression) 
		{
			return generateCodeForBooleanExpression(exp,codelist);
		} 
		else if(exp instanceof UnaryExpression) 
		{
			return generateCodeForUnaryExpression((UnaryExpression) exp, codelist);
		} 
		else if(exp instanceof BinaryExpression) 
		{
			return generateCodeForBinaryExpression((BinaryExpression) exp, codelist);
		} 
		else if(exp instanceof VariableExpression) 
		{
			return generateCodeForVariableExpression((VariableExpression) exp, codelist);
		}
		else if(exp instanceof OutVariableExpression) 
		{
			return generateCodeForOutVariableExpression((OutVariableExpression) exp, codelist);
		}
		return null;
	}
	
	/**
	 * Generates the intermediate code associated with a condition
	 */
	private CodeInstructionList generateCodeForCondition(Expression cond, CodeLabel lbtrue, CodeLabel lbfalse) 
	{
		if(cond instanceof BooleanLiteralExpression) // LITERALS TRUE OR FALSE
		{
			boolean val = ( (BooleanLiteralExpression) cond).getValue();
			CodeLabel lb = ( val? lbtrue : lbfalse);
			CodeInstructionList codelist = new CodeInstructionList();
			CodeInstruction jmp = new CodeInstruction(JUMP,lb,null,null);
			codelist.addInstruction(jmp);
			return codelist;
		} 
		else if(cond instanceof UnaryExpression) // NEGATION
		{
			Expression exp = ((UnaryExpression) cond).getExpression(); 
			return generateCodeForCondition(exp,lbfalse,lbtrue);
		} 
		else if(cond instanceof BinaryExpression)  // LOGICAL OPERATIONS AND COMPARISONS
		{
			BinaryExpression exp = (BinaryExpression) cond;
			Expression left = exp.getLeftExpression();
			Expression right = exp.getRightExpression();
			int operator = exp.getOperator();
			if(operator == BinaryExpression.AND) 
			{
				CodeLabel lb = getNewLabel();
				CodeInstruction lbInst = new CodeInstruction(LABEL,lb,null,null);
				CodeInstructionList leftcode = generateCodeForCondition(left,lb,lbfalse);
				CodeInstructionList rightcode = generateCodeForCondition(right,lbtrue,lbfalse);
				CodeInstructionList code = new CodeInstructionList();
				code.addInstructionList(leftcode.getList());
				code.addInstruction(lbInst);
				code.addInstructionList(rightcode.getList());
				return code;
			} 
			else if(operator == BinaryExpression.OR) 
			{
				CodeLabel lb = getNewLabel();
				CodeInstruction lbInst = new CodeInstruction(LABEL,lb,null,null);
				CodeInstructionList leftcode = generateCodeForCondition(left,lbtrue,lb);
				CodeInstructionList rightcode = generateCodeForCondition(right,lbtrue,lbfalse);
				CodeInstructionList code = new CodeInstructionList();
				code.addInstructionList(leftcode.getList());
				code.addInstruction(lbInst);
				code.addInstructionList(rightcode.getList());
				return code;
			} 
			else 
			{
				int codekind = getBinaryCode(operator);
				CodeInstructionList leftcode = new CodeInstructionList();
				CodeInstructionList rightcode = new CodeInstructionList();
				CodeVariable source1 = generateCodeForExpression(left,leftcode);
				CodeVariable source2 = generateCodeForExpression(right,rightcode);

				CodeInstructionList code = new CodeInstructionList();
				code.addInstructionList(leftcode.getList());
				code.addInstructionList(rightcode.getList());
				code.addInstruction(new CodeInstruction(codekind,lbtrue,source1,source2));
				code.addInstruction(new CodeInstruction(JUMP,lbfalse,null,null));
				return code;
			}
		} 
		else // other boolean expressions (variable references)
		{
			CodeInstructionList code = new CodeInstructionList();
			CodeVariable target = generateCodeForExpression(cond,code);
			code.addInstruction(new CodeInstruction(JMP1,lbtrue,target,null));
			code.addInstruction(new CodeInstruction(JUMP,lbfalse,null,null));
			return code;
		}
	}

	/**
	 * Generates the intermediate code associated with an integer literal
	 */
	private CodeVariable generateCodeForIntegerLiteralExpression(IntegerLiteralExpression exp, CodeInstructionList codelist) 
	{
		CodeVariable temp = getNewTemp(DataType.int_type);
		CodeLiteral literal = new CodeLiteral(exp.getValue());
		codelist.addInstruction(new CodeInstruction(ASSIGN,temp,literal,null));
		return temp;
	}


	/**
	 * Generates the intermediate code associated with a character literal
	 */
	private CodeVariable generateCodeForCharLiteralExpression(CharLiteralExpression exp, CodeInstructionList codelist) 
	{
		CodeVariable temp = getNewTemp(DataType.char_type);
		CodeLiteral literal = new CodeLiteral(exp.getValue());
		codelist.addInstruction(new CodeInstruction(ASSIGN,temp,literal,null));
		return temp;
	}

	/**
	 * Generates the intermediate code associated with a boolean literal
	 */
	private CodeVariable generateCodeForBooleanLiteralExpression(BooleanLiteralExpression exp, CodeInstructionList codelist) 
	{
		CodeVariable temp = getNewTemp(DataType.boolean_type);
		int bvalue = (exp.getValue()? 1 : 0);
		CodeLiteral literal = new CodeLiteral(bvalue);
		codelist.addInstruction(new CodeInstruction(ASSIGN,temp,literal,null));
		return temp;
	}

	/**
	 * Generates the intermediate code associated with a boolean expression
	 */
	private CodeVariable generateCodeForBooleanExpression(Expression exp, CodeInstructionList codelist) 
	{
		CodeLabel lbTrue = getNewLabel();
		CodeLabel lbFalse = getNewLabel();
		CodeLabel lbNext = getNewLabel();

		CodeInstruction lbTrueInst = new CodeInstruction(LABEL, lbTrue, null, null);
		CodeInstruction lbFalseInst = new CodeInstruction(LABEL, lbFalse, null, null);
		CodeInstruction lbNextInst = new CodeInstruction(LABEL, lbNext, null, null);

		CodeVariable target = getNewTemp(DataType.boolean_type);
		CodeLiteral valueTrue = new CodeLiteral(1);
		CodeLiteral valueFalse = new CodeLiteral(0);

		CodeInstructionList code = generateCodeForCondition(exp,lbTrue,lbFalse);
		code.addInstruction(lbTrueInst);
		code.addInstruction(new CodeInstruction(ASSIGN,target,valueTrue, null));
		code.addInstruction(new CodeInstruction(JUMP,lbNext, null, null));
		code.addInstruction(lbFalseInst);
		code.addInstruction(new CodeInstruction(ASSIGN,target,valueFalse, null));
		code.addInstruction(lbNextInst);

		codelist.addInstructionList(code.getList());
		return target;
	}
	
	/**
	 * Generates the intermediate code associated with an arithmetic unary operation
	 */
	private CodeVariable generateCodeForUnaryExpression(UnaryExpression exp, CodeInstructionList codelist) 
	{
		Expression operand = exp.getExpression();

		CodeInstructionList code = new CodeInstructionList();
		CodeVariable source = generateCodeForExpression(operand,code);
		CodeVariable target = getNewTemp(exp.getType());

		code.addInstruction(new CodeInstruction(INV,target,source,null));
		codelist.addInstructionList(code.getList());

		return target;		
	}

	/**
	 * Generates the intermediate code associated with an arithmetic unary operation
	 */
	private CodeVariable generateCodeForBinaryExpression(BinaryExpression exp, CodeInstructionList codelist) 
	{
		int operator = exp.getOperator();
		Expression left = exp.getLeftExpression();
		Expression right = exp.getRightExpression();

		CodeVariable target = getNewTemp(exp.getType());

		CodeInstructionList code = new CodeInstructionList();
		CodeVariable source1 = generateCodeForExpression(left,code);
		CodeVariable source2 = generateCodeForExpression(right,code);

		int op = getBinaryCode(operator);
		code.addInstruction(new CodeInstruction(op,target,source1,source2));
		codelist.addInstructionList(code.getList());
		return target;		
	}

	/**
	 * Generates the intermediate code associated with the reference to a variable
	 */
	private CodeVariable generateCodeForVariableExpression(VariableExpression exp, CodeInstructionList codelist) 
	{
		Variable var = exp.getVariable();
		return getCodeVariable(var);
	}

	/**
	 * Generates the intermediate code associated with the reference to an output variable (a pointer)
	 */
	private CodeVariable generateCodeForOutVariableExpression(OutVariableExpression exp, CodeInstructionList codelist) 
	{
		CodeVariable source = getCodeVariable(exp.getVariable());
		CodeVariable target = getNewTemp(TypeSystem.getReference(source.getType()));
		codelist.addInstruction(new CodeInstruction(POINTER, target, source, null));
		return target;
	}
	
	//----------------------------------------------------------------//
	//               Private methods (auxiliary methods)              //
	//----------------------------------------------------------------//
	
	/**
	 * Generates a new label
	 */
	private CodeLabel getNewLabel() 
	{
		labelcount++;
		return new CodeLabel(label+"."+labelcount);
	}

	/**
	 * Generates a new temporary variable
	 */
	private CodeVariable getNewTemp(DataType type) 
	{
		String tmpname = "tmp_"+tmpcount;
		CodeVariable tmp = new CodeVariable(type, tmpname,tmpname);
		tmpcount++;
		CodeVariable[] aux = new CodeVariable[var.length+1];
		System.arraycopy(var,0,aux,0,var.length);
		aux[var.length] = tmp;
		this.var = aux;
		return tmp;
	}
	
	/**
	 * Gets the intermediate code description of a variable from its AST description 
	 */
	private CodeVariable getCodeVariable(Variable v) 
	{
		for(int i=0; i<astvar.length; i++) if(astvar[i] == v) return var[i];
		return null;
	}
	
	/**
	 * Gets the intermediate instruction code from the AST operator code  
	 */
	private int getBinaryCode(int op) 
	{
		switch(op) 
		{
		case BinaryExpression.EQ: return JMPEQ;
		case BinaryExpression.NEQ: return JMPNE;
		case BinaryExpression.GE: return JMPGE;
		case BinaryExpression.GT: return JMPGT;
		case BinaryExpression.LE: return JMPLE;
		case BinaryExpression.LT: return JMPLT;
		case BinaryExpression.PLUS: return ADD;
		case BinaryExpression.MINUS: return SUB;
		case BinaryExpression.PROD: return MUL;
		case BinaryExpression.DIV: return DIV;
		case BinaryExpression.MOD: return MOD;
		default: return 0;
		}		
	}
}
