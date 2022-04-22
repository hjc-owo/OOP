# Lab 06 Assignment

> 班级：202111
> 
> 学号：19241027
> 
> 姓名：胡峻诚

## Question01 InnerClass1 `代码填空`

```java
class Outer {
    public int num = 10;

    class Inner {
        public int num = 20;

        public void show() {
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Outer.this.num);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Outer.Inner oi = new Outer().new Inner();
        oi.show();
    }
}
```

![截屏2022-04-15 15.54.00](https://s2.loli.net/2022/04/15/3UELaSD16kAfwMz.png)

## Question02 InnerClass2 `代码填空`

```java
interface Inter {
    void show();
}

class Outer {
    static class Inner implements Inter {
        public Inner() {
        }

        @Override
        public void show() {
            System.out.println("DuluDulu");
        }
    }

    public static Inner method() {
        return new Outer.Inner();
    }
}

public class Test {
    public static void main(String[] args) {
        Outer.method().show();
    }
}
```

![截屏2022-04-15 16.02.33](https://s2.loli.net/2022/04/15/63aWG7esNM5IUSn.png)

## Question03 匿名类的 ShapeFactory `编程题|旧题`

<img src="https://s2.loli.net/2022/04/09/dLVCQgszRZprN1n.png" alt="截屏2022-04-09 00.34.29" style="zoom:50%;" />

## Question04 ShapeSequence `编程题`

![截屏2022-04-15 21.08.35](https://s2.loli.net/2022/04/15/TdKagLXRpmnNOFA.png)