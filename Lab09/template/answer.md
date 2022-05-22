# Lab 09 Assignment

> 班级：
> 
> 学号：
> 
> 姓名：

## Question1 如果准备按字节读取一个文件的内容，应当使用 `FileInputStream` 流还是 `FileReader` 流，为什么？ `简答`

应该选择 FileInputStream

- FileInputStream 流的 read 方法是按字节从文件中读取的
- FileReader 的 read 是按字符读取的

## Question2  `简答`

1. 请写出程序的输出

   ![截屏2022-05-22 10.42.28](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205221042875.png)

   ```java
   3
   abc
   1
   dbc
   ```

2. 解释 `Part Ⅰ` 和 `Part II` 的输出为什么不同

   m 的值是 read 函数的返回值，也就是读取的长度。

   因为文件一共只有 abcd 四个字符，之前读了三个，所以 Part II 的读入只读进来了 1 个字符，故 m 的输出是 1。

   tom 之前的内容是 "abc", 读入一个 "d" 后自然变成了 "dbc"。

## Question3 设计一个方法，用于移除文件中的注释 `编程`

![截屏2022-05-22 15.36.28](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205221537154.png)

## Question4 设计一个方法，使用 `Java` 的输入、输出流将一个文本文件的内容按行读出，每读出一行就顺序添加行号，并写入到另一个文件中 `编程`

![截屏2022-05-22 15.41.57](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205221542396.png)

## Question5 复制文件是常见的IO操作，设计如下方法，实现复制源文件 `sourceFile` 到目标文件 `targetFile` `编程`

![截屏2022-05-22 15.56.42](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205221557945.png)

## Question6 复制一个文件夹下面所有文件和子文件夹内容到另一文件夹 `编程`

![截屏2022-05-22 16.03.14](https://raw.githubusercontent.com/hjc-owo/hjc-owo.github.io/img/202205221603694.png)