文档总结
https://blog.csdn.net/sinat_27406925/article/details/73382169
redis windows 下载
https://www.cnblogs.com/M-LittleBird/p/5902850.html
官网下载地址：http://redis.io/download

github下载地址：https://github.com/MSOpenTech/redis/tags

启动命令

redis-server redis.windows.conf

设置服务命令

redis-server --service-install redis.windows-service.conf --loglevel verbose

常用的redis服务命令。

卸载服务：redis-server --service-uninstall

开启服务：redis-server --service-start

停止服务：redis-server --service-stop

linux下
启动redis
./bin/redis-server ./redis.conf
连接redis
./bin/redis-cli
jedis
可下载jar的地址

http://mvnrepository.com/artifact/redis.clients/jedis

http://mvnrepository.com/artifact/org.apache.commons/commons-pool2

--1、字符串的相关操作
--
两个字丶
1、set key value
设置key的value值
2、get key
获取key的value值
3、getset key value
先获取key的value值，再重新赋值
4、del key
删除key键
5、incr key
为key的value值+1，若key不存在，则把value赋值为0后+1；若value数据类型不为integer，则报错。
6、decr key
为key的value值-1，若key不存在，则把value赋值为0后-1；若value数据类型不为integer，则报错。
7、incrby key integer
为key的value值+integer，若key不存在，则把value赋值为0后+integer；若value数据类型不为integer，则报错。
8、decrby key integer
为key的value值-integer，若key不存在，则把value赋值为0后-integer；若value数据类型不为integer，则报错。
9、append key val
为key的原来的value值后拼接 字符串val。
10、keys *
获取所有的keys列表

D:\redis\Redis-x64-3.2.100>redis-cli.exe
127.0.0.1:6379> set compant chenweipeng
OK
127.0.0.1:6379> get compant
"chenweipeng"
127.0.0.1:6379> getset compant baidu
"chenweipeng"
127.0.0.1:6379> get compant
"baidu"
127.0.0.1:6379> set person cwp
OK
127.0.0.1:6379> get person
"cwp"
127.0.0.1:6379> del person
(integer) 1
127.0.0.1:6379> get person
(nil)
127.0.0.1:6379> incr num
(integer) 1
127.0.0.1:6379> get num
"1"
127.0.0.1:6379> incr num
(integer) 2
127.0.0.1:6379> get num
"2"
127.0.0.1:6379> incr compant
(error) ERR value is not an integer or out of range
127.0.0.1:6379> decr num
(integer) 1
127.0.0.1:6379> get num
"1"
127.0.0.1:6379> incrby num 5
(integer) 6
127.0.0.1:6379> get num
"6"
127.0.0.1:6379> incrby num3 5
(integer) 5
127.0.0.1:6379> decrby num3
(error) ERR wrong number of arguments for 'decrby' command
127.0.0.1:6379> decrby num3 3
(integer) 2
127.0.0.1:6379> append num3 5
(integer) 2
127.0.0.1:6379> get num3
"25"
127.0.0.1:6379> append num4 123
(integer) 3
127.0.0.1:6379> get num4
"123"

--2、hash哈希
--
存储k/v : hset key  k v

取k对应的v: hget key k

删除键k:hdel key k

对k加上一个增量(可以为负): hincrby key k delta

对k加上一个浮点数(可以为负): hincrbyfloat key k delta

存储多个k/v对: hmset key k1 v1 k2 v2 ... kn vn

取多个k对应的值: hmset key k1 k2 ... kn

取所有的k/v对: hgetall

取所有的键的值:hvals key

取键值对的个数:hlen key

取所有键名:hkeys key

判断是否存在k:hexists key k

127.0.0.1:6379> hset myhash username cwp
(integer) 1
127.0.0.1:6379> hset myhash age 18
(integer) 1
127.0.0.1:6379> hmset myhash2 username cwp age 18
OK
127.0.0.1:6379> hget myhash username
"cwp"
127.0.0.1:6379> hget myhash age
"18"
127.0.0.1:6379> hmget myhash
(error) ERR wrong number of arguments for 'hmget' command
127.0.0.1:6379> hmget myhash username age
1) "cwp"
2) "18"
127.0.0.1:6379> hgetall myhash
1) "username"
2) "cwp"
3) "age"
4) "18"
127.0.0.1:6379>
127.0.0.1:6379>
127.0.0.1:6379> hset myhash username cwp
(integer) 1
127.0.0.1:6379> hset myhash age 18
(integer) 1
127.0.0.1:6379> hmset myhash2 username cwp age 18
OK
127.0.0.1:6379> hget myhash username
"cwp"
127.0.0.1:6379> hget myhash age
"18"
127.0.0.1:6379> hmget myhash
(error) ERR wrong number of arguments for 'hmget' command
127.0.0.1:6379> hmget myhash username age
1) "cwp"
2) "18"
127.0.0.1:6379> hgetall myhash
1) "username"
2) "cwp"
3) "age"
4) "18"
127.0.0.1:6379> hdel myhash2
(error) ERR wrong number of arguments for 'hdel' command
127.0.0.1:6379> hdel myhash2 username
(integer) 1
127.0.0.1:6379> hdel myhash2 age
(integer) 1
127.0.0.1:6379> hget myhash2
(error) ERR wrong number of arguments for 'hget' command
127.0.0.1:6379> hgetall myhash2
(empty list or set)
127.0.0.1:6379> hget myhash2 username
(nil)
127.0.0.1:6379> del myhash2
(integer) 0
127.0.0.1:6379> hget myhash age
"18"
127.0.0.1:6379> hincr myhash age
(error) ERR unknown command 'hincr'
127.0.0.1:6379> hincrby myhash age 5
(integer) 23
127.0.0.1:6379> hget myhash age
"23"
127.0.0.1:6379> hmget myhash username age
1) "cwp"
2) "23"
127.0.0.1:6379> hexists myhash username
(integer) 1
127.0.0.1:6379> hexists myhash age
(integer) 1
127.0.0.1:6379> hgetall myhash
1) "username"
2) "cwp"
3) "age"
4) "23"
127.0.0.1:6379> hlen myhash
(integer) 2
127.0.0.1:6379> hkeys myhash
1) "username"
2) "age"
127.0.0.1:6379> hvals myhash
1) "cwp"
2) "23"

--3、存储list 消息队列
--
ArrayList 数组的方式 
LinkedList 双向链表

lpush key str1,str2……strn 从左侧添加数据 若key不存在 为其创建一个list

rpush key str1,str2……strn  从右侧添加数据 若key不存在 为其创建一个list

lrange key start,end 查看指定角标之间的元素   角标可为负数，-1为最后一个元素，以此类推

lpop key 弹出左侧第一个元素 

rpop key 弹出右侧第一个元素

llen key 获取列表中元素个数

lpushx key val 向列表头部插入val  仅当key存在时可用  返回值为lit的长度

2) "23"
127.0.0.1:6379> lpush mylist a b c
(integer) 3
127.0.0.1:6379> lpush mylist 1 2 3
(integer) 6
127.0.0.1:6379> rpush a b c
(integer) 2
127.0.0.1:6379> rpush 1 2 3
(integer) 2
127.0.0.1:6379> lrange mtlist 0 -1
(empty list or set)
127.0.0.1:6379> lrange mylist 0 -1
1) "3"
2) "2"
3) "1"
4) "c"
5) "b"
6) "a"
127.0.0.1:6379> rpush mylist2 a b c
(integer) 3
127.0.0.1:6379> rpush mylist2 1 2 3
(integer) 6
127.0.0.1:6379> lrange mylist2 0 -1
1) "a"
2) "b"
3) "c"
4) "1"
5) "2"
6) "3"
127.0.0.1:6379> lpop mylist
"3"
127.0.0.1:6379> lrange mylist 0 -1
1) "2"
2) "1"
3) "c"
4) "b"
5) "a"
127.0.0.1:6379> rpop mylist2
"3"
127.0.0.1:6379> lrange mylist2 0 -1
1) "a"
2) "b"
3) "c"
4) "1"
5) "2"
127.0.0.1:6379> llen mylist
(integer) 5
127.0.0.1:6379> llen mylist2
(integer) 5
127.0.0.1:6379> llen mylist3
(integer) 0
127.0.0.1:6379> lpushx mylist x
(integer) 6
127.0.0.1:6379> lrange mylist 0 -1
1) "x"
2) "2"
3) "1"
4) "c"
5) "b"
6) "a"
127.0.0.1:6379> rpushx mylist2 y
(integer) 6
127.0.0.1:6379> lrange mylist2 0 -1
1) "a"
2) "b"
3) "c"
4) "1"
5) "2"
6) "y"
127.0.0.1:6379> rpush mylist3 1 2 3
(integer) 3
127.0.0.1:6379> rpush mylist3 1 2 3
(integer) 6
127.0.0.1:6379> rpush mylist3 1 2 3
(integer) 9
127.0.0.1:6379> lrange mylist3 0 -1
1) "1"
2) "2"
3) "3"
4) "1"
5) "2"
6) "3"
7) "1"
8) "2"
9) "3"
127.0.0.1:6379> lrem mylist3 2 3
(integer) 2
127.0.0.1:6379> lrange mylist3 0 -1
1) "1"
2) "2"
3) "1"
4) "2"
5) "1"
6) "2"
7) "3"
127.0.0.1:6379> lrem mylist3 -2 1
(integer) 2
127.0.0.1:6379> lrange mylist3 0 -1
1) "1"
2) "2"
3) "2"
4) "2"
5) "3"
127.0.0.1:6379> lrem mylist3 0 2
(integer) 3
127.0.0.1:6379> lrange mylist3 0 -1
1) "1"
2) "3"
127.0.0.1:6379> lrange mylist  0 -1
1) "x"
2) "2"
3) "1"
4) "c"
5) "b"
6) "a"
127.0.0.1:6379> lset mylist 3 mm
OK
127.0.0.1:6379> lrange mylist 0 -1
1) "x"
2) "2"
3) "1"
4) "mm"
5) "b"
6) "a"
127.0.0.1:6379> lpush mylist4 1a b c
(integer) 3
127.0.0.1:6379> lpush mylist4 a b c
(integer) 6
127.0.0.1:6379> lrange mylist 0 -1
1) "x"
2) "2"
3) "1"
4) "mm"
5) "b"
6) "a"
127.0.0.1:6379> lrange mylist4 0 -1
1) "c"
2) "b"
3) "a"
4) "c"
5) "b"
6) "1a"
127.0.0.1:6379> linsert mylist4 before b 11
(integer) 7
127.0.0.1:6379> lrange mylist4 0 -1
1) "c"
2) "11"
3) "b"
4) "a"
5) "c"
6) "b"
7) "1a"
127.0.0.1:6379> linsert mylist4 after b 22
(integer) 8
127.0.0.1:6379> lrange mylist4 0 -1
1) "c"
2) "11"
3) "b"
4) "22"
5) "a"
6) "c"
7) "b"
8) "1a"
127.0.0.1:6379> lpush mylist5 1 2 3
(integer) 3
127.0.0.1:6379> lpush mylist6 a b c
(integer) 3
127.0.0.1:6379> lrange mylist5 0 -1
1) "3"
2) "2"
3) "1"
127.0.0.1:6379> lrange mylist6 0 -1
1) "c"
2) "b"
3) "a"
127.0.0.1:6379> rpoplpush mylist5 mylist6
"1"
127.0.0.1:6379> lrange mylist5 0 -1
1) "3"
2) "2"
127.0.0.1:6379> lrange mylist6 0 -1
1) "1"
2) "c"
3) "b"
4) "a"

--4、set
--
不允许出现重复的元素
127.0.0.1:6379> sadd myset a b c
(integer) 3
127.0.0.1:6379> sadd myset a
(integer) 0
127.0.0.1:6379> srem myset a
(integer) 1
127.0.0.1:6379> smembers myset
1) "c"
2) "b"
127.0.0.1:6379> sismember myset b
(integer) 1
127.0.0.1:6379> sismember myset a
(integer) 0
127.0.0.1:6379> sadd mya1 a b c
(integer) 3
127.0.0.1:6379> sadd myb1 a c 1 2 3
(integer) 5
127.0.0.1:6379> sdiff mya1 myb1
1) "b"
127.0.0.1:6379> sdiff myb1 mya1
1) "1"
2) "2"
3) "3"
127.0.0.1:6379> sadd mya2 a b c
(integer) 3
127.0.0.1:6379> sadd myb2 a c 1 2 3
(integer) 5
127.0.0.1:6379> sinter mya2 myb2
1) "a"
2) "c"
127.0.0.1:6379> sadd mya3 a b c
(integer) 3
127.0.0.1:6379> sadd myb3 a c 1 2 3
(integer) 5
127.0.0.1:6379> sunion mya3 myb3
1) "3"
2) "c"
3) "b"
4) "a"
5) "2"
6) "1"
127.0.0.1:6379> smembers myset
1) "c"
2) "b"
127.0.0.1:6379> scard myset
(integer) 2
127.0.0.1:6379> srandmember myset
"c"
127.0.0.1:6379> srandmember myset
"c"
127.0.0.1:6379> sdiffstore my1 mya1 myb1
(integer) 1
127.0.0.1:6379> smembers my1
1) "b"
127.0.0.1:6379> sinterstore my2 mya2 myb2
(integer) 2
127.0.0.1:6379> smembers my2
1) "a"
2) "c"
127.0.0.1:6379> sunionstore my3 mya3 myb3
(integer) 6
127.0.0.1:6379> smembers my3
1) "3"
2) "c"
3) "b"
4) "a"
5) "2"
6) "1"

--5、sorted set
--有分数进行排序，在集合中的位置是有序的 游戏的在线排行榜
127.0.0.1:6379> zadd mysort 70 zs 80 ls 90 ww
(integer) 3
127.0.0.1:6379> zadd mysort 100 zs
(integer) 0
127.0.0.1:6379> zadd mysort 60 tom
(integer) 1
127.0.0.1:6379> zscore mysort zs
"100"
127.0.0.1:6379> zcard mysort
(integer) 4
127.0.0.1:6379> zrem mysort tom ww
(integer) 2
127.0.0.1:6379> zcard mysort
(integer) 2
127.0.0.1:6379> zadd mysort 85 jack 95 rose
(integer) 2
127.0.0.1:6379> zrange mysort 0 -1
1) "ls"
2) "jack"
3) "rose"
4) "zs"
127.0.0.1:6379> zrange mysort 0 -1 withscore
(error) ERR syntax error
127.0.0.1:6379> zrange mysort 0 -1 withscores
1) "ls"
2) "80"
3) "jack"
4) "85"
5) "rose"
6) "95"
7) "zs"
8) "100"
127.0.0.1:6379> zrevrange mysort 0 -1 withscores
1) "zs"
2) "100"
3) "rose"
4) "95"
5) "jack"
6) "85"
7) "ls"
8) "80"
127.0.0.1:6379> zremrangebyrank mysort 0 4
(integer) 4
127.0.0.1:6379> zrange mysort 0 -1 withscores
(empty list or set)
127.0.0.1:6379> zrange mysort 0 -1 withscores
(empty list or set)
127.0.0.1:6379> zadd mysort 80 zs 90 ls 100 ww
(integer) 3
127.0.0.1:6379> zremrangebyscore mysort 80 100
(integer) 3
127.0.0.1:6379> zrange mysort 0 -1 withscores
(empty list or set)
127.0.0.1:6379> zadd mysort 70 zs 80 ls 90 ww
(integer) 3
127.0.0.1:6379> zrangebyscore mysort 0 100
1) "zs"
2) "ls"
3) "ww"
127.0.0.1:6379> zrangebyscore mysort 0 100 withscores
1) "zs"
2) "70"
3) "ls"
4) "80"
5) "ww"
6) "90"
127.0.0.1:6379> zrangebyscore mysort 0 100 withscores limit 0 2
1) "zs"
2) "70"
3) "ls"
4) "80"
127.0.0.1:6379> zincrby mysort 3 ls
"83"
127.0.0.1:6379> zscore mysort ls
"83"
127.0.0.1:6379> zcount mysort 80 90
(integer) 2

--6、redis的keys的通用操作
--

keys pattern:返回匹配正则表达式pattern的键

set key value:设置key的值value

setnx key value:当且仅当key不存在是设置value

incr key:key的值加1,如果key不存在则默认该key为0,然后加1.

del key:删除key
127.0.0.1:6379> keys *
 1) "name"
 2) "myb3"
 3) "compant"
 4) "myset"
 5) "myhash"
 6) "mylist"
 7) "myb2"
 8) "mya1"
 9) "myb1"
10) "my1"
11) "num"
12) "mylist4"
13) "mya3"
14) "my2"
15) "mylist3"
16) "a"
17) "num3"
18) "1"
19) "my3"
20) "mylist2"
21) "mysort"
22) "num4"
23) "mya2"
24) "mylist5"
25) "mylist6"
127.0.0.1:6379> keys my?
1) "my1"
2) "my2"
3) "my3"
127.0.0.1:6379> del my1
(integer) 1
127.0.0.1:6379> exists my1
(integer) 0
127.0.0.1:6379> del my?
(integer) 0
127.0.0.1:6379> keys my?
1) "my2"
2) "my3"
127.0.0.1:6379> key my*
(error) ERR unknown command 'key'
127.0.0.1:6379> keys my*
 1) "myb3"
 2) "myset"
 3) "myhash"
 4) "mylist"
 5) "myb2"
 6) "mya1"
 7) "myb1"
 8) "mylist4"
 9) "mya3"
10) "my2"
11) "mylist3"
12) "my3"
13) "mylist2"
14) "mysort"
15) "mya2"
16) "mylist5"
17) "mylist6"
127.0.0.1:6379> get company
(nil)
127.0.0.1:6379> get compant
"baidu"
127.0.0.1:6379> rename compant newconpant
OK
127.0.0.1:6379> get conpant
(nil)
127.0.0.1:6379> get newcompant
(nil)
127.0.0.1:6379> get newconpant
"baidu"
127.0.0.1:6379> expire newconpant 1000
(integer) 1
127.0.0.1:6379> ttl newconpant
(integer) 993
127.0.0.1:6379> type newconpant
string
127.0.0.1:6379> type mylist
list
127.0.0.1:6379> type myset
set
127.0.0.1:6379> type myhash
hash
127.0.0.1:6379> type mysort
zset

--7、redis的特性
多数据库、事务特性
16个数据库，默认是0号数据库
multi 开启事务
exec 提交
discard 回滚
127.0.0.1:6379> select 1
OK
127.0.0.1:6379[1]> keys *
(empty list or set)
127.0.0.1:6379[1]> select 0
OK
127.0.0.1:6379> keys *
 1) "name"
 2) "myb3"
 3) "myset"
 4) "myhash"
 5) "mylist"
 6) "myb2"
 7) "mya1"
 8) "myb1"
 9) "num"
10) "mylist4"
11) "mya3"
12) "my2"
13) "mylist3"
14) "a"
15) "num3"
16) "1"
17) "newconpant"
18) "my3"
19) "mylist2"
20) "mysort"
21) "num4"
22) "mya2"
23) "mylist5"
24) "mylist6"
127.0.0.1:6379> move myset 1
(integer) 1
127.0.0.1:6379> select 1
OK
127.0.0.1:6379[1]> keys *
1) "myset"
127.0.0.1:6379[1]> type myset
set
127.0.0.1:6379[1]> select 0
OK
127.0.0.1:6379> set num 1
OK
127.0.0.1:6379> get num
"1"
127.0.0.1:6379> get num
"2"
127.0.0.1:6379> multi
OK
127.0.0.1:6379> incr num
QUEUED
127.0.0.1:6379> exec
1) (integer) 3
127.0.0.1:6379> multi
OK
127.0.0.1:6379> incr num
QUEUED
127.0.0.1:6379> discard
OK
127.0.0.1:6379> get num
"3"

--8、Redis持久化
--
两种方式RDB、AOF
RDB持久化 默认的方式不需要设置 一定的时间定时将内存的数据存储到硬盘
AOF持久化 以日志的方式记录数据的操作，当redis启动的时候会读取日志构建数据库，保证启动后的数据一致性
无持久化
同时使用RDB和AOF

RDB方式持久化
优势：只有一个文件，时间间隔的数据，可以归档为一个文件，方便压缩转移（就一个文件）

劣势：如果宕机，数据损失比较大，因为它是每一个时间段进行持久化操作的。也就是积攒的数据比较多，一旦懵逼，就彻底懵逼了

aof方式：

优势：1.带来更高的数据安全性。有三种同步策略。每秒同步、每修改同步、不同步。

    2.AOF 文件是一个只进行追加操作的日志文件，因此在写入过程中即使出现宕机现象也不影响之前已经存在的内容。

    3.如果日志过大，redis可以启动重写机制。在重写过程中产生的对数据库操作记录会保存在一个新文件中，等到重写完成后再追加到现有的文件中。

    4.AOF 文件有序地保存了对数据库执行的所有写入操作

劣势：1.对于相同数量的数据集而言，文件比rdb方式要大。

 	   2.效率比rdb低
配置在redis.windows.conf文件中	 

清空数据库flushall
  
FAQ
* 提示time out错误 需要再iptables防火墙上添加上6379端口 并重启防火墙服务

* 提示connection refuse错误 需要注释掉redis.conf 文件中的 bind 127.0.0.1

* 提示JedisDataException错误 需要将redis.conf文件中的protect-mode 置为no

如果是阿里云的话，需要开放6379端口策略，还有就是redis用127.0.0.1访问正常，但是用ip访问，就会报错，
解决方法，修改redis.conf文件1.bind 0.0.0.0设置允许访问的ip　
2.requirepass123456设置访问密码　
3.protected-mode no关闭保护模式，./redis-server .././redis.conf　启动，
这样设置了密码，跟老师讲的不一样了，
其中JedisPool连接池需要使用带有password 的参数，如：public JedisPool(poolConfig,host,port,timeout,password){}