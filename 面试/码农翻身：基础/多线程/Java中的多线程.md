# Java中的多线程

## Runnable接口和Callable接口的区别

### Runnable接口

Runnable接口中的run()方法的返回值是void，它做的事情只是纯粹地去执行run()方法中的代码而已；

### Callable接口

Callable接口中的call()方法是有返回值的，是一个泛型，和Future、FutureTask配合可以用来获取异步执行的结果，还可以在等待时间太长没获取到所需要的数据的情况下取消该线程的任务。

## CyclicBarrier和CountDownLatch的区别
