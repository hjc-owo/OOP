# Lab 02 Assignment

> 班级：hjc-owo
> 
> 学号：hjc-owo
> 
> 姓名：hjc-owo



### Question1: 简答题

标记的第4行编译会导致编译错误：原因`java: 可能尚未初始化变量m`

### Question2: 简答题 overload

- a. 对
- b. 对
- c. 对
- d. 错。只有`Overload(int m)`与`Overload(double m)`才是构造方法。

### Question3: 简答题 overload2

```
(a,b,c)=(-2,0,-1)
(a,b,c)=(5,6,-1)
(a,b,c)=(2,3,4)
```

![截屏2022-03-18 20.52.54](https://s2.loli.net/2022/04/09/KOz3dTLi82BuFjR.png)



### Question4: 简答题 finalize

| 注释标记行 | 可能的输出内容 |
| :--------: | :------------: |
|     1      |       0        |
|     2      |       1        |
|     3      |      0/1       |
|     4      |      0/1       |

有什么办法可以让`finalize()`在`main()`结束前一定被调用吗？



不能保证一定被调用。
因为Java无法保证finalize()会被及时执行并且根本无法保证它会被执行 (因为程序中其他线程的优先级远远高于finalize()函数线程的优先级)。

### Question5: 编程题

```java
目录名为：Question5
文件名有：Muphone.java
```

![截屏2022-03-18 21.26.01](https://s2.loli.net/2022/04/09/fH6ZIFmSTh9MK3s.png)

### Question6: 编程题

```java
目录名为：Question6
文件名有：TestPerson.java
```

![截屏2022-03-18 21.47.00](https://s2.loli.net/2022/04/09/aCOLEmfHAxJPuYr.png)

### Question7: 编程题

```java
目录名为：Question7
文件名有：Palindrome.java
```

![截屏2022-03-18 22.17.53](https://s2.loli.net/2022/04/09/wPaN25nhoLQGqdW.png)