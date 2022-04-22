# Lab 07 Assignment

> 班级：202111
> 
> 学号：19241027
> 
> 姓名：胡峻诚

## Question1 简述`ArrayList`和`LinkedList`的区别 `简答`

> 类似于 C 语言的数组和链表。
>
> 1. ArrayList 基于动态数组实现的非线程安全的集合；LinkedList 基于链表实现的非线程安全的集合。
> 2. 对于随机 index 访问的 get 和 set 方法，一般 ArrayList 的速度要优于 LinkedList。因为 ArrayList 直接通过数组下标直接找到元素；LinkedList 要移动指针遍历每个元素直到找到为止。
> 3. 新增和删除元素，一般 LinkedList 的速度要优于 ArrayList。因为 ArrayList 在新增和删除元素时，可能扩容和复制数组；LinkedList 实例化对象需要时间外，只需要修改指针即可。
> 4. LinkedList 集合不支持高效的随机随机访问（RandomAccess）
> 5. ArrayList 的空间浪费主要体现在在 list 列表的结尾预留一定的容量空间，而 LinkedList 的空间花费则体现在它的每一个元素都需要消耗相当的空间
> 6. ArrayList 是实现了基于动态数组的数据结构，LinkedList 基于链表的数据结构。
> 7. 对于随机访问 get 和 set，ArrayList 觉得优于 LinkedList，因为 LinkedList 要移动指针。
> 8. 对于新增和删除操作 add 和 remove，LinedList 比较占优势，因为 ArrayList 要移动数据。

## Question2 写出以下程序的输出 `简答`

```java
I am an animal
I am a dog
I am an animal
I am type T and my type is Animal
I am type S and my type is Dog
```

![截屏2022-04-22 16.41.47](https://cdn.jsdelivr.net/gh/hjc-owo/allImgs/img/202204221642270.png)

## Question3 写出以下程序的输出(注意通配符的使用) `简答`

```java
I am an animal
I am a dog
I am an animal
My type is Dog
My type is Animal
```

![截屏2022-04-22 16.44.25](https://cdn.jsdelivr.net/gh/hjc-owo/allImgs/img/202204221645391.png)

## Question4 编写程序完成以下要求 `编程`

```java
//MyStack.java

import java.util.LinkedList;

public class MyStack<T> {
    private LinkedList<T> values = new LinkedList<T>();

    public void push(T t) {
        //Your code here
        values.add(t);
    }

    public T pull() {
        //Your code here
        T t = values.getLast();
        values.removeLast();
        return t;
    }

    public T peek() {
        //Your code here
        return values.getLast();
    }

    public static void main(String[] args) {
        /* Your test code here */
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
    }
}
```

![截屏2022-04-22 16.51.12](https://cdn.jsdelivr.net/gh/hjc-owo/allImgs/img/202204221651450.png)

## Question5 编写程序完成以下要求 `编程`

```java
import java.util.HashMap;
import java.util.Map;

public class EmailSplit {
    public static void main(String[] args) {
        String str = "aa@sohu.com,bb@163.com,cc@sina.com";
        Map<String, String> emailMap = new HashMap<String, String>();
        /* Your code here */
        String[] emails = str.split(",");
        for (String email : emails) {
            String[] emailArr = email.split("@");
            emailMap.put(emailArr[0], emailArr[1]);
        }
        System.out.println(emailMap.toString());
    }
}
```

![截屏2022-04-22 16.53.56](https://cdn.jsdelivr.net/gh/hjc-owo/allImgs/img/202204221654375.png)

## Question6 编写程序完成以下要求 `编程`

```java
import java.util.HashMap;
import java.util.Map;

public class TwoColorBall {
    public static void main(String[] args) {
        /* Your code here */
        Map<Integer, String> map = new HashMap<>();
        while (map.size() < 6) {
            int num = (int) (Math.random() * 33) + 1;
            if (!map.containsKey(num)) {
                map.put(num, "红球");
            }
        }
        int num = (int) (Math.random() * 16) + 1;
        map.put(num, "蓝球");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}
```

![截屏2022-04-22 16.58.38](https://cdn.jsdelivr.net/gh/hjc-owo/allImgs/img/202204221658882.png)