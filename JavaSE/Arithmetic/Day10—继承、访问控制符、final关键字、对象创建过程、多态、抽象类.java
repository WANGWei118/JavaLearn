今日内容：
1.继承  @Override 重写
2.访问控制符
3.final关键字
4.对象创建过程
5.多态
6.抽象类


2.访问控制符（熟悉）

2.1 常见的访问控制符
	public                 — 公有的 
	private                — 私有的
	protected            — 保护的
	空（什么都不写）  — 默认的

2.2 常见访问控制符区别
	访问控制符        访问权限       本类          本包的其他类        子类        其他包的其他类
       ———————————————————————————————————————
	public     		   公有的		ok 			ok		       ok                  ok
	protected		   保护的		ok                  ok                  ok                  no
	啥也不写		   默认的         ok                  ok                  no                  no
	private	          私有的         ok                  no                  no                  no

要求掌握内容：
	1.public修饰的内容表示可以在任意位置访问；
	2.private修饰的内容表示只能在当前类的内部访问；
	3.通常情况下，成员变量都使用private修饰，成员方法都是public修饰；

2.3 包的定义
	package 包名；
	package 包名1.包名2……包名n；（文件夹1下的文件夹2下的文件夹3等）

	作用：使用包的定义为了管理代码方便，避免同名文件的冲突问题。

3.final关键字（重点）
3.1 基本概念：
	“final”本意“最终的、不可更改的”，在java语言中该关键字主要修饰类、方法、变量

3.2 使用方式
	使用final关键字修饰类表示该类不能被继承。
		- 为了防止滥用继承，如：java.lang.String/System类等。
	使用final关键字修饰成员方法表示该方法不能被重写。
		- 为了防止不经意间造成的重写，如：java.text.SimpleDateFormat类format方法等。
	使用final关键字修饰成员变量表示该成员变量必须初始化而且不能更改。
		- 为了表达常量的概念，如：java.lang.Thread类中的MAX_PRIORITY等。

补充：
	在以后的开发中，static关键字和final关键字都很少单独使用，通常使用public static final 共同修饰来表达常量的概念，常量要求所有字幕大写，不同的单词之间使用下划线连接。
	如：public static final double PI = 3.14;


4.对象创建过程（看执行流程）
4.1 单个对象创建的过程
	4.1.1 当在main（）方法中创建对象时，会为该对象在堆区分配内存空间来记录成员变量的数值；
	4.1.2 当没有指定初始值时采用默认的初始值，否则采用指定的初始值来初始化；
	4.1.3 执行构造块中的语句，可以对成员变量进行赋值；
	4.1.4 执行构造方法体中的语句，可以对成员变量进行赋值；
	4.1.5 此时构造对象完成，继续执行下面的代码；
4.2 子类对象的创建过程
	1.当在main（）方法中创建子类对象时，会在堆区为子类对象分配内存空间；
	2.执行父类的静态语句块，再执行子类的静态语句块；
	3.执行父类的构造块，再执行父类的构造方法体，此时父类部分构造完毕；
	4.执行子类的构造块，再执行子类的构造方法体，此时子类部分构造完毕；
	5.继续执行下面代码；
总结：先父类再子类，先静态后方法



*****************************************************************************************************
                                                                         多 态
*****************************************************************************************************

5.多态（重中之重）：
5.1 基本概念：
	多态主要指同一种事物表现出来的多种形态；

5.2 语法格式：
	父类类型 引用名 = new 子类类型（）；
	***父类对象可以直接指向子类的对象
	如：
		Pet p1 = new Dog();
	解析：
		p1在编译阶段是Pet类型，在运行阶段是Cat类型的。
	练习：
	自定义Pet类，特征有：名字，实现该类的封装并提供打印特征的行为；
	自定义Cat类继承Pet类，特征有：牙齿数量，实现该类的封装并提供打印特征的行为；
	自定义TestPetCat类，在main（）方法中风别创建Pet类的对象和Cat对象并打印所有特征。

5.3 多态的效果
	1.父类的引用指向子类的对象时，父类的引用可以直接调用父类中的成员方法；
	2.父类的引用指向子类的对象时，父类的引用不可以直接调用子类中的成员方法；
	3.对于普通成员方法来说，在编译阶段调用父类的方法，在运行阶段调用子类的方法；
	4.对于静态成员方法来说，在编译阶段和运行阶段都是调用父类的方法，与对象无关；

5.4 引用类型之间的转换
	1.引用类型之间的转换分为：自动类型转换 和 强制类型转换；
		当子类类型向父类类转换时，应该发生自动类型转换，小到大，；
		当父类类型向子类类型转换时，应该发生强制类型转换，大到小，（（子类）父类引用）；
	2.引用类型之间的转换biubiu发生在父子类之间，否则编译报错；
	3.当拥有父子类关系进行强转是编译阶段可以通过，但转换的父类引用并没有真正指向该子类类型的对象时，会在运行阶段发生类型转换异常；
	4.为了避免上述错误的发生，则需要在每次进行强转之前判断类型是否一致，方式如下：
		if（父类引用 instanceof  子类类型）{。。。}
		当父类引用指向的对象确实是子类类型是，则上述条件返回true，否则返回flase；

5.5 实际作用
	多态的实际意义在于屏蔽不同子类的差异性，从而实现通用的编程，却能达到不同的效果。

