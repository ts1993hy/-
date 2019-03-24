# Redis 教程

Redis是所谓的key-value（键值对）存储，通常称为NoSQL数据库。键值存储的本质是能够在键内存储一些称为值的数据。只有当我们知道用于存储它的确切密钥时，才可以得到它的数据。

我们可以使用`set`命令去存储值为`fido`，key为`server:name`：

```redis
SET server:name "fido"
```

Redis会永久的存储我们的数据，我们可以使用`GET`命令得到存储的数据

```redis
GET server:name
```

```redis
DEL server:name // 删除一个键
INCR server:name // 自动增加一个存储的数值
SETNX server:name "fido" // 如果不存在key，server:name
```
