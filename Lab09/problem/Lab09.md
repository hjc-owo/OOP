# Java 程序设计 LAB09

## 实验目的

- 理解并掌握控制台读入数据、标准输入输出、Scanner类（基础的输入输出）

- 理解并掌握Java文件管理（File类）、输入/输出流类及其派生类的使用（字节流的顺序读写）

- 理解并掌握读写器及其派生类的使用（字符流的顺序读写）

- 理解并掌握对象序列化（对象流的读写）



## 实验题目

### Question1 如果准备按字节读取一个文件的内容，应当使用 `FileInputStream` 流还是 `FileReader` 流，为什么？ `简答`

### Question2  `简答`

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        File f =new File("hello.txt");
        byte [] a="abcd".getBytes();
        try{
            FileOutputStream out=new FileOutputStream(f);
            out.write(a);
            out.close();
            FileInputStream in=new FileInputStream(f);
            byte [] tom= new byte[3];
            //Part Ⅰ
            int m = in.read(tom,0,3);
            System.out.println(m);//3
            String s=new String(tom,0,3);
            System.out.println(s);//abc
            //Part Ⅱ
            m = in.read(tom,0,3);
            System.out.println(m);//1
            s=new String(tom,0,3);
            System.out.println(s);//dbc        
        }
        catch(IOException e) {}
    }
}
```
(1) 请写出程序的输出

(2) 解释 `Part Ⅰ` 和 `Part Ⅱ` 的输出为什么不同

### Question3 设计一个方法，用于移除文件中的注释 `编程`

```java
public static void removeComments(String inputPath,String outPath) throws IOException;
```

**input.txt**

```java
File f = new File("./java.oop");
System.out.println("当前文件是：" +f);// 这是一条注释
//这是另一条注释
System.out.println("判断是否存在："+f.exists());
/*
这些还是注释
*/
System.out.println("判断是否是文件夹："+f.isDirectory());
       //这是个位置有点奇怪的注释
```



**out.txt**

在删除注释后， 你可以**自由选择是否删除空行**

一个可能的输出如下：

```java
File f = new File("D:\\java");
System.out.println("当前文件是：" +f);

System.out.println("判断是否存在："+f.exists());



System.out.println("判断是否是文件夹："+f.isDirectory());
       
```


### Question4 设计一个方法，使用 `Java` 的输入、输出流将一个文本文件的内容按行读出，每读出一行就顺序添加行号，并写入到另一个文件中 `编程`

```java
public static void addLineNo(String inputPath,String outPath) throws IOException;
```


### Question5 复制文件是常见的IO操作，设计如下方法，实现复制源文件 `sourceFile` 到目标文件 `targetFile` `编程`

```java
public static void copyFile (String sourceFile, String targetFile) throws IOException;
```


### Question6 复制一个文件夹下面所有文件和子文件夹内容到另一文件夹 `编程`

```java
public static void copyDirectiory(String sourceDir, String targetDir) throws IOException;
```

可以尝试复用 Q5 的代码