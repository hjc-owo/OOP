# Lab 05 Assignment

> 班级：hjc-owo
>
> 学号：hjc-owo
>
> 姓名：hjc-owo

## 实验题目

### Question01 多态 1 `输出/简答题`

- 运行`java Test`，程序的输出是什么？

  > private f()

- 如果将父类中的方法声明为 public，而子类为 private，编译能通过吗？如果能，最后会输出什么？

  > 不能。无法在子类中用 private 属性的方法去覆盖父类的 public 方法。

### Question02 多态 2 `输出/简答题`

- 运行`java Test`，程序的输出是什么？

  > sup.field = 0, sup.getField() = 1
  > sub.field = 1, sub.getField() = 1, sub.getSuperField() = 0

- 类的非静态属性能体现多态性吗？

  > 非静态属性不能。
  >
  > 例如只能通过 sup.field 访问父类的属性。而 getField 因为是子类的方法，所以访问的是子类的属性。

### Question03 多态 3 `输出/简答题`

- 运行`java Test`，程序的输出是什么？

  > Base staticGet()
  > Derived dynamicGet()

- 类的静态属性和静态方法能体现多态性吗？

  > 不能。
  >
  > 子类的静态属性或方法会直接把父类对应的属性或方法直接隐藏而不是重写。所以无法体现多态性。

### Question04 多态 4 `输出/简答题`

- 运行`java Test`，程序的输出是什么？

  > A() before draw()
  > B.draw(), b = 0
  > A() after draw()
  > B(), b = 5

- 结合之前实验的初始化顺序和多态，给出程序这样输出的解释。

  > 首先，根据之前实验的结果，先完成父类构造函数的装载之后才会装载子类构造函数。
  >
  > 所以一开始先进入了 `A()` 中并输出了`A() before draw()`。
  >
  > 在执行`draw()`的时候，因为 B 中对该方法进行了重写，所以调用的是 B 类中的`draw()`。
  >
  > B 的无参构造`draw()`的`b`的值还没有初始化，所以是 0。
  >
  > 然后完成 A 的装载。
  >
  > 最后才执行 B 的有参构造函数。

### Question05 ShapeFactory 1 `编程题`

<img src="https://s2.loli.net/2022/04/09/jafQVOp9xXvNA31.png" alt="截屏2022-04-08 17.00.59" style="zoom:50%;" />

### Question06 Overload？Override？ `简答题`

- 这段程序是无法通过编译的，都有哪些原因呢？尝试从继承、覆盖、重载的角度考虑。

  > 1. I0 接口中默认的方法是 public 类型的。在 Test01 重写的时候权限变为了 default，权限变小了，导致报错。
  > 2. Test02 23 在重写接口中的方法的时候也都出现了权限的问题。
  > 3. Test01 实现的两个接口有相同的 f()，不知道应该实现哪一个。
  > 4. Test02 在重写的时候，两个方法的传参一样，会产生矛盾。故无法实现重写。
  > 5. Test23 中访问 a 时，并没有指定是哪个接口中的属性。

- 如果 I1 extends I0，会引入新的错误吗？I2、I3 也 extends I0 呢？

  > I1 I3 均不会。I2 会。
  >
  > 这是因为 I2 中 f 的传参与 I1 中的一致，但返回类型不同，所以会报错。

## 附加题

### Extra 1 策略模式（Strategy Pattern） `编程题`

![截屏2022-04-08 23.48.25](https://cdn.jsdelivr.net/gh/hjc-owo/hjc-owo.github.io@img/202204172139659.png)

### Extra 2 真·工厂方法模式 `编程题`

<img src="https://s2.loli.net/2022/04/09/hHWRJBqNUltwjC6.png" alt="截屏2022-04-09 00.02.18" style="zoom:50%;" />

### Extra 3 匿名类的 ShapeFactory `编程题`

<img src="https://s2.loli.net/2022/04/09/dLVCQgszRZprN1n.png" alt="截屏2022-04-09 00.34.29" style="zoom:50%;" />

### Extra 4 命令模式 `编程题`

![202204172137474](https://cdn.jsdelivr.net/gh/hjc-owo/hjc-owo.github.io@img/202205071224454.png)
