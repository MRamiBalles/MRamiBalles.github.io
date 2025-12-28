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

/**
 * Class describing an instruction of the intermediate code
 * 
 * @author Francisco J. Moreno Velo
 */
public class CodeInstruction implements CodeConstants {
	
	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//
	
	/**
	 * Instruction code
	 */
	private int kind;

	/**
	 * Address where the result is stored
	 */
	private CodeAddress target;

	/**
	 * Address of the first operand
	 */
	private CodeAddress source1;

	/**
	 * Address of the second operand
	 */
	private CodeAddress source2;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//
	
	/**
	 * Constructor
	 */
	public CodeInstruction(int kind, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		this.kind = kind;
		this.target = target;
		this.source1 = source1;
		this.source2 = source2;
	}
	
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Gets the instruction code
	 */
	public int getKind() 
	{
		return this.kind;
	}

	/**
	 * Gets the address where the result is stored
	 */
	public CodeAddress getTarget() 
	{
		return this.target;
	}

	/**
	 * Gets the address of the first operand
	 */
	public CodeAddress getSource1() 
	{
		return this.source1;
	}

	/**
	 * Gets the address of the second operand
	 */
	public CodeAddress getSource2() 
	{
		return this.source2;
	}
	
	/**
	 * Gets the description of the instruction with comments
	 */
	public String toString() 
	{
		String code = getCode();
		String comment = getComment();
		if(comment == null || comment.length() == 0) return code;
		StringBuffer buf = new StringBuffer(code);
		for(int i=code.length(); i<50; i++) buf.append(' ');
		buf.append("; ");
		buf.append(comment);
		return buf.toString();
	}

	//----------------------------------------------------------------//
	//                          Private methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Gets the name corresponding to the type of the instruction
	 */
	private String getInstructionName() 
	{
		switch(kind) 
		{
		case LABEL:  return "";
		case ASSIGN: return "assign";
		case ADD:    return "add";
		case SUB:    return "sub";
		case MUL:    return "mul";
		case DIV:    return "div";
		case MOD:    return "mod";
		case INV:    return "inv";
		case AND:    return "and";
		case OR:     return "or";
		case NOT:    return "not";
		case JMPEQ:  return "jmpeq";
		case JMPNE:  return "jmpne";
		case JMPGT:  return "jmpgt";
		case JMPGE:  return "jmpge";
		case JMPLT:  return "jmplt";
		case JMPLE:  return "jmple";
		case JUMP:   return "jump";
		case JMP1:   return "jmp1";
		case PARAM:  return "param";
		case CALL:   return "call";
		case ENDP:   return "endp";
		case PRECALL:  return "precall";
		case POINTER: return "pointer";
		default: return "";
		}
	}

	/**
	 * Gets the description of the instruction without comments
	 */
	private String getCode()
	{
		String tg = (target == null? "": target.toString());
		String s1 = (source1 == null? "": source1.toString());
		String s2 = (source2 == null? "": source2.toString());

		String inst = "\t"+getInstructionName();
		switch(kind) {
		case LABEL:  
			return tg+":";
		case ASSIGN: 
		case INV:
		case NOT:
		case JMP1:
		case POINTER:
		case PRECALL:
			return inst+" "+tg+", "+s1;
		case ADD:
		case SUB:
		case MUL:
		case DIV:
		case MOD:
		case AND:
		case OR:
		case JMPEQ:
		case JMPNE:
		case JMPGT:
		case JMPGE:
		case JMPLT:
		case JMPLE:
		case PARAM:
			return inst+" "+tg+", "+s1+", "+s2;
		case JUMP: 
		case CALL:
			return inst+" "+tg;
		case ENDP:
			return inst;
		default: 
			return "";
		}
	}

	/**
	 * Gets the comment of the instruction
	 */
	private String getComment() 
	{
		String tg = (target == null? "": target.getDescription());
		String s1 = (source1 == null? "": source1.getDescription());
		String s2 = (source2 == null? "": source2.getDescription());
		switch(kind) 
		{
		case LABEL: 
			return "";  
		case ASSIGN: 
			return tg+" <- "+s1;
		case INV:
			return tg+" <-  -"+s1;	
		case NOT:
			return tg+" <- ! "+s1;
		case JMP1:
			return "if("+s1+"==1) jump "+tg;
		case PARAM:
			int pos1 = Integer.parseInt(s1,16);
			int pos2 = Integer.parseInt(s2,16);
			return "param["+(pos1+pos2)/4+"] <- "+tg;
		case CALL:
			return tg+"()";
		case ADD:
			return tg+" <- "+s1+" + "+s2;
		case SUB:
			return tg+" <- "+s1+" - "+s2;
		case MUL:
			return tg+" <- "+s1+" * "+s2;
		case DIV:
			return tg+" <- "+s1+" / "+s2;
		case MOD:
			return tg+" <- "+s1+" % "+s2;
		case AND:
			return tg+" <- "+s1+" && "+s2;
		case OR:
			return tg+" <- "+s1+" || "+s2;
		case JMPEQ:
			return "if("+s1+" == "+s2+") jump "+tg;
		case JMPNE:
			return "if("+s1+" != "+s2+") jump "+tg;
		case JMPGT:
			return "if("+s1+" > "+s2+") jump "+tg;
		case JMPGE:
			return "if("+s1+" >= "+s2+") jump "+tg;
		case JMPLT:
			return "if("+s1+" < "+s2+") jump "+tg;
		case JMPLE:
			return "if("+s1+" <= "+s2+") jump "+tg;
		case JUMP: 
			return "jump "+tg;
		case ENDP:
			return "end procedure";
		case POINTER:
			return tg+" <- ptr( "+s1+" )";
		default: 
			return "";
		}
	}
}
