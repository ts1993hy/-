1. @Resource默认是按照名称来装配注入的，只有当找不到与名称匹配的bean才会按照类型来装配注入。
1. @Autowired默认是按照类型装配注入的，如果想按照名称来转配注入，则需要结合@Qualifier一起使用。
1. @Resource注解是由JDK提供，而@Autowired是由Spring提供。
1. @Resource和@Autowired都可以书写标注在字段或者该字段的setter方法之上。

推荐使用setter方法注入