/*********************************************************************************************************************
     **
     **  COnversion of Postfix and prefix expression to Infix 
     **  Input Postfix and Prefix expression must be in a desired format. 
     **  Operands and operator, both must be single character.
     **  Only '+'  ,  '-'  , '*', '/'  operators are expected. 
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/


import java.util.*;

class PostfixPrefix2Infix
{
	public static void main(String[] args)
	{
		String exp="ab*c+";
		System.out.println("POSTFIX EVALUATION : "+ postfix(exp));

		exp="*-A/BC-/AKL";
		System.out.println("PREFIX EVALUATION : "+ prefix(exp));

	}
	private static String postfix(String exp)
	{
		Stack<String> stack=new Stack();

		for(int i=0;i<exp.length();i++)
		{
			if(!isOperator(exp.charAt(i)))
				stack.push(exp.charAt(i)+"");
			else 
			{
				String s1=stack.pop();
				String s2=stack.pop();
				stack.push("("+s2+exp.charAt(i)+s1+")");
			}
		}
		return stack.pop();
	}

	private static String prefix(String exp)
	{
		Stack<String> stack=new Stack();

		for(int i=exp.length()-1;i>=0;i--)
		{
			if(!isOperator(exp.charAt(i)))
				stack.push(exp.charAt(i)+"");
			else 
			{
				String s1=stack.pop();
				String s2=stack.pop();
				stack.push("("+s1+exp.charAt(i)+s2+")");
			}
		}
		return stack.pop();
	}
	private static boolean isOperator(char c)
	{
		switch(c)
		{
			case '+':
			case '-':
			case '*':
			case '/':
			return true;
		}
		return false;
	}
	

}