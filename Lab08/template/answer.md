# Lab 08 Assignment

## Question1 Java 中的检查型异常 `(checked exception)` 和非检查型异常 `(unchecked exception)` 有什么区别？ `简答`

- 检查型异常继承自 Exception，必须对其采用 `try...catch` 处理或者 `throws` 这个异常，接受 `throws` 的上级方法也必须对其处理，否则都不能通过编译。
- 非检查型异常继承自 Runtime Exception 或 Error，可以不用捕获，可以不在函数声明中添加 `throws` 语句，调用函数也不做强制处理，JVM 会自动处理。

## Question2 简述 Java 异常处理中 `throws` 和 `throw` 关键字的作用。 `简答`

- `throws` 关键字写在方法声明后面，表示这个方法可能会出现对应的异常，但没有对其处理，而是抛出异常到上一级去处理。
- `throw` 常用于主动抛出自定义异常，即使编译器可能并不觉得这是个异常。程序会在 throw 语句后立即终止，它后面的语句执行不到，然后在包含它的所有 try 块中（可能在上层调用函数中）从里向外寻找含有与其匹配的 catch 子句的 try 块。

## Question3 请列出 2 个常见的运行时异常和 2 个非运行时异常。 `简答`

- 运行时异常：NullPointerException（空指针），IndexOutOfBoundsException（下标越界）
- 非运行时异常：IOException，SQLException

## Question4 指出下列程序的错误并改正。 `改错`

RuntimeException 是 Exception 的一个子类，Exception 已经将 RuntimeException 捕捉到，导致编译失败。

修改后的代码如下：

```java
import java.io.IOException;

public class p04 {
    public static void start() throws IOException, RuntimeException {
        throw new RuntimeException("Unable to Start");
    }

    public static void main(String[] args) {
        try {
            start();
        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
```

修改后可以运行的截图如下：

![截屏2022-05-14 00.29.51](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140031846.png)

## Question5 指出下列程序的错误并改正。 `改错`

- SubClass 是 SuperClass 的继承，但是 SubClass 中的 start() 无法覆盖 SuperClass 中的 start()，原因是被覆盖的方法未抛出 java.lang.Exception 异常。
- SubClass 使用了 FileInputStream 函数，但是该函数必须考虑 java.io.FileNotFoundException 异常，必须对其进行捕获或声明以便抛出。

修改后的代码如下：

```java
//SuperClass.java

import java.io.IOException;

public class SuperClass {
    public void start() throws IOException {
        throw new IOException("Unable to start");
    }
}

//SubClass.java

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass extends SuperClass {
    public void start() throws IOException {
        throw new IOException("Unable to open file");
    }

    public void open(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
    }

    public static void main(String[] args) {
        System.out.println("Success.");
    }
}
```

修改后可以运行的截图如下：

![截屏2022-05-14 00.37.58](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140039910.png)

## Question6 写出以下程序的输出。 `程序输出`

![截屏2022-05-14 00.40.38](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140041722.png)

## Question7 写出以下程序的输出，试着解释三个函数不同输出的原因。 `程序输出`

![截屏2022-05-14 00.42.45](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140043392.png)

1. 执行顺序：try -> catch -> finally，finally 当中的语句必定被执行。
2. 一般 finally 不会修改返回值，除非 finally 修改了该引用指向的实际内存内容。
   - `get0()`中程序返回的是 int 型数据，int 类型是基本数据类型，返回时会在内存中生成一份与原来的值相同的 int 类型的拷贝，故输出 2 和 1
   - `get1()`中，程序返回的是 String 型数据，String 类型是引用数据类型，返回时会在内存中生成一份与原来的引用相同的 String 类型的拷贝，但由于 String 类型是不可变的数据类型，故在执行`i += "finally"`后，i 的引用发生了变化，故输出 okfinally 和 ok
   - `get2()`中，程序返回的是 StringBuilder 型数据，StringBuilder 类型是引用数据类型，返回时会在内存中生成一份与原来的引用相同的 StringBuilder 类型的拷贝，在执行 append 后，方法中的引用和返回值的引用都没有发生变化，故输出 okfinally 和 okfinally

## Question8 编写程序完成以下要求。 `编程`

代码如下：

```java
class Triangle {
    double x, y, z;

    public Triangle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void checkWhetherTriangle() throws NotTriangleException {
        if (x + y <= z || x + z <= y || y + z <= x) {
            throw new NotTriangleException(x, y, z);
        }
    }

    public double getArea() throws NotTriangleException {
        checkWhetherTriangle();
        double p = (x + y + z) / 2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }

    public void showInfo() throws NotTriangleException {
        checkWhetherTriangle();
        System.out.println("x = " + this.x);
        System.out.println("y = " + this.y);
        System.out.println("z = " + this.z);
    }
}

public class Triangle_Test {
    public static void main(String[] args) throws NotTriangleException {
        Triangle t1 = new Triangle(3, 4, 5);
        System.out.println(t1.getArea());
        t1.showInfo();

        Triangle t2 = new Triangle(2, 4, 6);
        System.out.println(t2.getArea());
        t2.showInfo();
    }
}

class NotTriangleException extends Exception {
    public NotTriangleException(double x, double y, double z) {
        super(x + " " + y + " " + z + " 这似乎好像不能组成一个三角形捏～");
    }
}
```

运行截图如下：

![截屏2022-05-14 01.05.42](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205140105657.png)
