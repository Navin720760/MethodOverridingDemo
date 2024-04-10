package com.methodoverriding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

//Method Overriding
//Signature Rule
//parent class/superclass
class Person
{
	//additional mathod
	public void property(int amount,String land,String gold)
	{
		System.out.println(amount+", "+land+", "+gold);
	}
	
	//overridden method
	public void marriage(String girl)
	{
		System.out.println(girl);
	}
}

//child class/subclass
class Child extends Person
{
	//override method with our own implementation.
	@Override
	public void marriage(String girl)
	{
		System.out.println(girl);   
	}
}


//Signaure Rule/method name and Return Types and order of types.
//parent class
class Calculator
{
	//overridden method
	public int add(int a,int b)
	{
		return a+b;
	}
	
	//additional mathod
	public void display()
	{
		System.out.println("display method");
	}
	
}

//child class
class Calc extends Calculator
{
	//override method with our own implementation.
	@Override
	public int add(int a,int b)
	{
		return a+b+5;   
	}
}


//Return Type Rule
//parent Object --> child Object allowed to override.
//child Object --> parent Object is not allowed to override.
//primitive return types are not allowed(double --> int) to override.
//covariant types/child return types are allowed.
//covaraint types only valid for object types(object,string etc) not for primitive types like (double --> int).
//Object(parent) --> Object, String, StringBuffer etc(childs) -> allowed
//Number(parent) --> Number, byte, short, Integer, Long, Float, Double(wrapper class)(childs) -> allowed
//parent class
class A
{
	//overridden method
	public Object m1()
	{
		return null;
	}
	
	//child return type
	//overridden not allowed
	/*public String m2()
	{
		return null;
	}*/
}

//child class
class B extends A
{
	//same return type are allowed or covariant/child of parent(object) types are allowed
	//
	/*@Override
	public Object m1()
	{
		return null;
	}*/
	
	//covariant types/child return types are allowed.
	//covaraint types only valid for object types(object,string etc) not for primitive types like (double --> int).
	//Object(parent) --> Object, String, StringBuffer etc(childs) -> allowed
	//Number(parent) --> Number, byte, short, Integer, long, float, double(wrapper class)(childs) -> allowed
	@Override
	public String m1()
	{
		return null;
	}
	
	//String(child) --> Object(parent) -> not allowed to override.
	//parent return  type not allowed to override.
	/*@Override 
	public Object m2()
	{
		return null;
	}*/
}


//Modifiers Rules
//private Modifier  
//private methods are not allowed to overrride because private methods are not visible to the child classes, but we can define same private method in subclass it is not override.
//parent class
class C
{
	//overridden is not allowed
	private void m1()
	{
		
	}
}

//child class
class D extends C
{
	//override is not allowed but we can define same method 
	//@override 
	private void m1()
	{
		
	}
}


//final Modifier
//final --> non-final or final --> final not allowed to override.
//non-final --> final is allowed to override but next level sub child class is not allowed to override.
//parent class
class E
{
	//overridden is not allowed
	/*public final void m1()
	{
	   
	}*/
	
	//overridden method
	public void m2()
	{
		
	}
}

//child class
class F extends E
{
	//override is not allowed
	//@override 
	/*public void m1()
	{
		
	}*/
	
	//override is not allowed
	//@override is not allowed
	/*public final void m1()
	{
		
	}*/
	
	//override is allowed but next level child class/sub child class can not override.
	@Override 
	public final void m2()
	{
		
	}
}

//sub child class
class G extends F
{
	//override is not allowed in sub child class.
	//@override 
	/*public final void m2()
	{
		
	}*/
}


//abstract modifier
//non-abstract --> abstract or abstract --> non-abstract override is allowed but abstract method class must be declared as abstract.
//parent class
class H
{
	//overridden method
	public void m1()
	{
		
	}
}

abstract class I extends H
{
	@Override
	public abstract void m1();
}

class J extends I
{
	@Override
	public void m1()
	{
		
	}
}


//Synchronized modifier
//synchronized --> non-synchronized or non-synchronized --> synchronized override is allowed.
//superclass
class K
{
	//overridden method
	public synchronized void m1()
	{
		
	}
	
	//overridden method
	public void m2()
	{
			
	}
}

//subclass
class L extends K
{
	@Override
	public void m1()
	{
		
	}
	
	@Override
	public synchronized void m2()
	{
			
	}
}

//native Modifier
//native --> non-native or non-native --> native override is allowed.
//parent class
class M
{
	//overridden method
	public native void m1(); 
	
	//overridden method
	public void m2() 
	{
		
	}
}

//child class
class N extends M
{
	@Override
	public void m1() 
	{
				
	}
	
	@Override
	public native void m2();
}


//strictfp Modifier
//strictfp --> non-strictfp or non-strictfp --> strictfp override is allowed.
//parent class
class O
{
	//overridden method
	public strictfp void m1()
	{
		
	}
	
	//overridden method
	public void m2()
	{
			
	}
}

//child class
class P extends O
{
	@Override
	public void m1()
	{
		
	}
	
	@Override
	public strictfp void m2()
	{
		
	}
}


//static Modifier
//child class defines the same signature as its parent class static method but instead of overriding actually hides the parent class static method.
//by the parent reference can not invoke the child class static method, method invoked is determined at the compile-time not runtime.
//subclass hides the method of superclass.
//superclass
class Q
{
	//overridden is not allowed 
	//method hiding is possible
	public static void m1()
	{
		System.out.println("static method1 in Q");
	}

}

//subclass
class R extends Q
{
	//override is not allowed
	//@override 
	public static void m1()
	{
		System.out.println("static method in R");
	}
	
}


//Access Modifiers
//while oveeride we can increase the scope but we can not decrease the scope of the access modifier.
//==> private < default < protected < public 
//private --> is not allowed to override
//deafult --> default, protected, public
//protected --> protected, public
//public --> public
//public --> protected is not allowed to override.
class S
{
	//overridden method
	public void m1()
	{
		
	}
	
	//overridden is not allowed
	/*public void m2()
	{
		
	}*/
	
	//protected --> public is allowed to override.
	//overridden method
	protected void m3()
	{
			
	}
}

class T extends S
{
	@Override
	public void m1()
	{
		
	}
	
	//override is not allowed
	//@override
	/*protected void m2()
	{
		
	}*/
	
	//protected --> public is allowed to override.
	@Override
	public void m3()
	{
			
	}
}


//Exception Rules
//RunTime Exceptions Unchecked Exceptions and Errors are partially Checked Exceptons
//RuntimeException --> ArithmeticException, NullPointerException, ClassCastException, DateTimeException, IndexOutOfBoundException, ArrayIndexOutOfBoundsException, StringIndexOutOfBoundException, NegativeArraySizeException, ArrayStoreException, IllegalArgumentException, NumberFormatException, UnsupportedOperationException, NoSuchElementException, ConcurrentModificationException
//Error --> VM Error --> StackOverFlow, OutOfMemoryError, Error --> Assertion Error, Error --> Linkage Error --> Verify Error  etc
//Exceptions are Interrupted Exception, FileNotFoundException, and remote exceptions  etc are the Checked Exceptions.
//Exception --> IOException --> FileNotFoundException, Interrupted Exception, RemoteException etc
//if the override method throws the Checked Exception then overridden method compulsory to throw the same or its parent type class Exception.
//if the override method throws the Unchecked Exceptions then the overridden is not compulsory to throw the exception, it is optional.
//SuperClass
class U
{
	//overridden method
	public void m1()
	{
		
	}
	
	//optional to throw the exception of override method
	//overridden method
	public void m2()
	{
		
	}
	
	//overridden method
	public void m3() throws IOException
	{
		
	}
	
	//overridden method
	public void m4() throws Exception
	{
		
	}
	
	//overridden method
	public void m5() throws IOException
	{
		
	}
	
	//overridden method
	public void m6() throws IOException
	{
		
	}
	
	//overridden is not allowed
	/*public void m7() throws IOException
	{
		
	}*/
}

//SubClass
class V extends U
{
	@Override
	public void m1()
	{
		
	}
	
	@Override
	public void m2() throws ArithmeticException, NullPointerException, IllegalArgumentException, NumberFormatException, ClassCastException, DateTimeException, IndexOutOfBoundsException, ArrayIndexOutOfBoundsException, StringIndexOutOfBoundsException, NegativeArraySizeException, ArrayStoreException, UnsupportedOperationException, NoSuchElementException, ConcurrentModificationException
	{
		
	}
	
	@Override
	public void m3() throws IOException
	{
		
	}
	
	@Override
	public void m4() throws IOException
	{
		
	}
	
	@Override
	public void m5() throws FileNotFoundException
	{
		
	}
	
	@Override
	public void m6() 
	{
		
	}
	
	//override is not allowed
	//@override
	/*public void m7() throws Exception
	{
		
	}*/
}


//VarArgs Rules
//SuperClass
class W
{
	//overridden method
	public void m1(int... i)
	{
		System.out.println("method in W");
	}
	
	//overridden is not happend here instead overloading is happend. 
	public void m2(int... i)
	{
		System.out.println("method in W");
	}
}

//SubClass
class X extends W
{
	@Override
	public void m1(int... i)
	{
		System.out.println("method in X");
	}
	
	//@override is not happened here instead overloading is happened. 
	public void m2(int i)
	{
		System.out.println("method in X");
	}
}
//JVM starts execution from main() method
public class LaunchDemo 
{

	public static void main(String[] args)
	{
		
		/*Person p = new Person();     //parent object creation.
		p.property(1000000, "Home", "100 grams");
		p.marriage("pullamma");*/  //jvm invokes the marriage method of the parent class.
		
		Person p = new Child();  //parent reference and child object.
		p.marriage("Madhavi");   //JVM invokes the override method in the child class, not the parent of overridden method. 
		
		Calculator calc = new Calc();            //parent reference and child object.
		System.out.println(calc.add(10, 20));    //JVM invokes the override method in the child class, not the parent of overridden method. 
		
		A a = new B();
		a.m1();
		
		C c = new D();    //override is not allowed to private modifier 
		
		E e = new G();
		e.m2();
		
		H h = new J();
		h.m1();
		
		
		K k = new L();
		k.m1(); k.m2();
		
		M m = new N();  
		//m.m1(); m.m2(); //we can not invoke the native methods, if we invoke that leads to the exception UnsatisfiedLinkError
		
		O o = new P();
		o.m1(); o.m2();
		
		
		Q.m1();         //static method in Q
		
		R.m1();         //static method in R	
		
		//by the parent reference we can not invoke the static method of child class, instead it invokes the parent static method.
		Q q1 = new R(); //static method in Q 
		q1.m1();
		
		S s = new T();
		s.m1();
		s.m3();
		
		U u = new V();
		u.m1(); u.m2(); 
		
		try 
		{
			u.m3();
		} catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
		try 
		{
			u.m4();
		} catch (Exception e1) 
		{
			e1.printStackTrace();
		} 
		
		try 
		{
			u.m5();
		} catch (IOException e1) 
		{
			e1.printStackTrace();
		} 
		
		try 
		{
			u.m6();
		} catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
		//override happened
		W w = new X();
		w.m1();        //it invokes the method of child class X. 
		w.m1(10);
		w.m1(10,20,30);
		
		//overloading is happend
		W w1 = new X();
		w1.m2(10,20);   //it invokes the method of W class instead method of X.
		
		X x = new X();
		x.m2(10);
	}

}
