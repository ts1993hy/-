# Spring 拦截器

> 所有HandlerMapping实现都支持处理程序拦截器，这些拦截器在您要将特定功能应用于某些请求时很有用，例如，检查请求体。拦截器必须实现`org.springframework.web.servlet`包下的`HandlerInterceptor`接口，接口中的方法提供了足够的灵活性去进行各种预处理和后处理：

```Java
    // 在执行实际处理程序之前
    preHandle(..)
    // 处理程序执行后
    postHandle(..)
    // 完成请求后
    afterCompletion(..)
```

其中`preHandle(..)`方法返回一个布尔值。您可以使用此方法来中断或继续执行链的处理。当此方法返回true时，处理程序执行链继续执行。当它返回false时，DispatcherServlet假定拦截器本身已处理请求，并且不继续执行执行链中的其他拦截器和实际的业务逻辑。