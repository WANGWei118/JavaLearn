封装：
·定义：
	通常情况下，自定义类中的成员变量可以在测试类中访问并赋值给一些合法但不合理的数值，此时编译和运行阶段都不会有任何的提示。
	为了避免上述情况的发生，就需要对自定义类中的成员变量进行密封包装处理，就是封装，换句话说，封装就是一种保证成员变量值合法并合理的技术。
·流程：
	1.私有化所有变量，使用private修饰；
	2.提供公有的set、get方法，并在方法体中判断；
	3.构造方法中调用set成员变量方法来进行合理值判断；


Static：
·定义：
	通常情况下，成员变量隶属于对象层级，每当创建一个对象就会申请独立的内存空间，若所有对象中的某个成员变量的数值完全一样却又单独保存时，此时会造成内存空间的浪费。
	为了节省内存空间，可以把该成员变量从对象层级提升为类层级，被所有对象共享使用，此时需要使用static关键字修饰，表达静态的概念。
	static关键字还可以修饰成员方法也可以表示隶属于类层级，推荐使用类名.（类名后面加英文点）的方式进行访问。
·使用方式：
	（1）在非静态的成员方法中既可以访问非静态的成员也可以访问静态的成员（成员：成员变量+成员方法）；
	（2）在静态的成员方法中只能访问静态的成员不能访问非静态的成员（成员：成员变量+成员方法    静态的成员方法中没有this关键字）；
	  (3) 只有隶属于类层级的成员才能使用static修饰，不能滥用static；
单例设计模式（重中之重）：
·基本概念：
	在某些特殊场合中，只需要且仅需要一个类的一个对象，此时该类叫做单例类，而编写单例单例类的设计思想和方式叫做单例设计模式。
·基本流程：
	（1）私有化构造方法，使用private关键字修饰；
	（2）提供奔雷类型的引用指向本类的对象，并使用private static 关键字修饰；
	（3）提供公有的get方法，则将本类的对象返回出去，并使用static关键字修饰；
·基本分类：
	单例设计模式分为：饿汉式 和懒汉式，在以后的开发中推荐使用饿汉式。

继承（重中之重）：
`基本概念：
	当多个类中有相同的特征和行为时，可以将相同的内容提取出来组成一个公共类，然后让多个类分别吸收公共类的特征和行为，在多个类中只需要编写自己独有的特征和行为的机制，叫做继承，继承可以提高代码的复用性、扩展性以及可维护性。
	在JAVA语言中使用extends（扩展）关键字表达继承的关系。
	如：
		public class Student extends Person{ . . . . }  -表示Student类继承自Person类
		其中Person类叫做  超类、父类、基类
		其中Student类叫做派生类、子类、孩子类
`注意事项：
	（1）子类不能继承父类的内容：构造方法、私有方法，
		但私有成员变量可以继承不可以直接使用；
	（2）当创建子类对象时回自动调用父类中的无参构造方法来初始化父类中的成员变量，
		相当于在子类构造方法的第一行增加一行代码：super() 的效果；
	（3）java语言不支持多继承只支持单继承，也就是每个子类只能有一个父类，但一个父类有多个子类；
	（4）使用继承的条件是满足以下逻辑关系，否则不能使用继承
			子类 is  a  父类；


要求掌握内容：
	a.使用this.的方式通常用于区分同名的成员变量和形参变量；
	b.使用super（实参）的方式通常用于调用父类的构造方法；
	c.使用super.的方式通常用于调用父类中被重写的方法；

1.4方法的重写（Override）
	（1）基本概念：
		当父类的方法被子类继承后却不能满足子类的需求时，需要在子类中重新写一个和父类一样的方法，去覆盖从父类中继承下来的方法，这个过程叫方法的重写。
	（2）基本原则：
		a.要求方法名、参数列表、返回值类型都相同，从jdk1.5开始允许返回子类型；
		b.访问权限不能变小，可以相等或者变大；
		c.不能抛出更大的异常（异常机制）；
