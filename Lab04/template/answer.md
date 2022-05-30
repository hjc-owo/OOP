# Lab 04 Assignment

## Question1. Package

在 A.java 添加：

```java
package com.oo.aa;
```

在 B.java 添加：

```java
package com.oo.bb;
import com.oo.aa.A;
```

在 C.java 添加：

```java
package com.oo.cc;
import com.oo.bb.B;
```

在 Main.java 添加：

```java
package com.oo;
import com.oo.cc.C;
```

在 BTest.java 添加：

```java
package test;
import com.oo.bb.B;
```

运行效果：

<img src="https://s2.loli.net/2022/04/09/ngwoQANhuBFVdr8.png" alt="截屏2022-04-01 17.03.01" style="zoom:50%;" />

<div STYLE="page-break-after: always;"></div>

## Question2. 权限

1. private 表示私有，只有自己类能访问

2. default 表示没有修饰符修饰，只有同一个包的类能访问

3. protected 表示可以被同一个包的类以及其他包中的子类访问

4. public 表示可以被该项目的所有包中的所有类访问

运行效果：

<img src="https://s2.loli.net/2022/04/09/5qBveXCksHMJzAw.png" alt="截屏2022-04-01 17.17.23" style="zoom:50%;" />

<div STYLE="page-break-after: always;"></div>

## Question3. Hide & Override

1. 运行结果：

   ![截屏2022-04-01 17.24.16](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140120961.png)

2. 不能，子类重写父类的方法不能降低权限。

3. 不能，子类重写父类的方法不能降低权限。

4. 不一致，静态方法会被隐藏，非静态方法会被重写，因此`f2.bar()`调用父类函数，`f2.foo()`便调用子类函数。

5. 只有非静态且非私有的方法可以重写，其余的均是隐藏。

<div STYLE="page-break-after: always;"></div>

## Question4. shape

![截屏2022-04-03 20.54.57](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140121292.png)

**题外话：**

我们知道属性不设置为 public 是为了保护数据，如果 a 和 b 在 Shape 中的访问权限被设置为 private，在不添加新的属性的情况下，子类想要实现自己的 `calcArea()`该怎么办？

> 父类设置`getter`方法，为公开的，子类调用父类的`getter`方法即可。

<div STYLE="page-break-after: always;"></div>

## Question5. 车车

<img src="https://s2.loli.net/2022/04/09/R6D1ZSaWK9AxBOt.png" alt="截屏2022-04-03 22.31.14" style="zoom:50%;" />

## Question6. 其实 OOP Lab 里面也可以写操作系统

<img src="https://s2.loli.net/2022/04/09/Q6TjzLiy8qI1GEK.png" alt="截屏2022-04-04 00.55.27" style="zoom:50%;" />
