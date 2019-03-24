# java.lang.ThreadLocal

## 线程局部变量

> 线程局部变量为每个使用它的线程提供单独的线程局部变量值的副本。在C/C++等语言中，可以使用static或其他的关键字声明一个线程局部变量，但Java中不支持。不过在Java中可以通过ThreadLocal类实现这些支持。

## java.lang.ThreadLocal

> 要创建一个线程局部变量，需要实例化类ThreadLocal的一个对象。
因为线程局部变量是通过一个类来实现的，而不是作为Java语言本身的一部分，所以Java语言线程局部变量的使用相较于那些内建线程局部变量的语言要笨拙一些。

```Java
public class ThreadLocal { 
  public Object get();
  public void set(Object newValue);
  public Object initialValue();
}
```

1. `get()`检索变量的当前线程的值
1. `set()`修改当前线程的值。
1. `initialValue()`方法可以用来在线程未使用过某个变量时给予变量初始值。

## 进入源码

###源码对于ThreadLocal的描述

这个类提供了线程本地变量。这些变量不同于它们的普通副本，因为每个访问一个变量的线程都有自己的、独立初始化的变量副本。实例通常是希望将状态与线程关联的类中的私有静态字段(例如，用户ID或事务ID)。