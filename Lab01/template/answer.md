# Lab 01 Assignment

## Question01

（a）上述源文件的名字是什么？

- `Person.java`

（b）编译上述源文件将生成几个字节码文件？这些字节码文件的名字都是什么？

- 2 个字节码文件，名称分别为`Person.class` `Xiti.class`

（c）在命令行执行 `java Person` 得到怎样的错误提示？执行 `java xiti` 得到怎样的错误提示？执行 `java Xiti.class` 得到怎样的错误提示？执行 `java Xiti` 得到怎样的输出结果？

- 执行 `java Person`

![截屏2022-03-12 13.00.54](https://s2.loli.net/2022/04/09/96WODE7hHL3Zad2.png)

- 执行 `java xiti`

![截屏2022-03-12 13.01.16](https://s2.loli.net/2022/04/09/j2WlXCqAHoidTJ4.png)

- 执行 `java Xiti.class`

![截屏2022-03-12 13.01.39](https://s2.loli.net/2022/04/09/NoMVkOvjKZABneX.png)

- 执行 `java Xiti`

![截屏2022-03-12 13.01.51](https://s2.loli.net/2022/04/09/OpvScQsYoDegmLk.png)

## Question02

![截屏2022-03-12 13.13.59](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140125446.png)

## Question03

![截屏2022-03-12 13.16.16](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140125178.png)

## Question04

![截屏2022-03-12 13.17.55](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140125548.png)

## Question05

![截屏2022-03-12 13.33.40](https://s2.loli.net/2022/04/09/GU7kl5c1zVJRLM8.png)

## Question06

![截屏2022-03-12 13.35.29](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140126719.png)

## Question07

![截屏2022-03-13 22.10.34](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140127641.png)

## Question08

![截屏2022-03-13 22.15.34](https://s2.loli.net/2022/04/09/zuGnvDIZjskLHl7.png)

## Question09

![截屏2022-03-12 14.25.32](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140127628.png)

## Question10

![截屏2022-03-12 14.56.47](https://s2.loli.net/2022/04/09/9AU2XbuLodriDMN.png)

## Question13

![截屏2022-03-12 15.12.17](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140128923.png)

## Question 11

![截屏2022-03-12 15.13.39](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140128011.png)

## Question12

如图所示:

![截屏2022-03-12 15.16.59](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140128955.png)

- **浅拷贝**(同一个引用):被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。换言之，浅复制仅仅复制所考虑的对象，而不复制它所引用的对象。

- **深拷贝**(新引用):被复制对象的所有变量都含有与原来的对象相同的值，除去那些引用其他对象的变量。那些引用其他对象的变量将指向被复制过的新对象，而不再是原有的那些被引用的对象。换言之，深复制把要复制的对象所引用的对象都复制了一遍。

## Question13

![截屏2022-03-12 15.18.32](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140128374.png)

## Question14

![截屏2022-03-12 15.19.54](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140129083.png)

## Question15

![截屏2022-03-12 15.30.13](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140129504.png)

调用`strscat(new String[]{"a", "b"})`能通过编译吗？

- 可以

如果还有静态方法`String strscat(String[] args)`同时存在，代码能编译通过吗？这时传入的参数是什么？又会返回什么？

- 不能

如果我们声明的是`String strscat(String[] args)`，`strscat()`这样的调用还能通过编译吗？如果能，这时传入参数和返回值的情况和`String strscat(String... args)`通过相同吗？

- 可以。返回值和之前相同。

## Question16

![截屏2022-03-12 16.13.52](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140130753.png)

## Question17

![截屏2022-03-12 16.13.44](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140129473.png)
