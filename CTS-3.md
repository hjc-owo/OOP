# CTS-3

> 咖喱铁路售票系统curry ticketing system -1



## 约定

+ 这次真的超级简单der

+ CTS-3会测试前面已实现的功能，但不会加强，所以只要CTS-2能过就不会出现旧功能的问题

+ 对于一行命令输入，只报优先级最高的一个错误，报错优先级为：

  命令名称 > 参数数量 > 参数合法性（从左至右） 其它情况请以功能描述要求的报错顺序为准



## 概览

​	本次CTS-3你需要实现的全部新功能（命令）如下表所示，详细要求请见下文。

| 命令      | 参数1       | 参数2  | 参数3  | 参数4    | 参数5 | 功能描述                   |
| --------- | ----------- | ------ | ------ | -------- | ----- | -------------------------- |
| login     | Aadhaar卡号 | 姓名   |        |          |       | 用户登录，是购票的前序操作 |
| logout    |             |        |        |          |       | 退出当前登录的用户账户     |
| buyTicket | 列车车次    | 出发站 | 目的站 | 席位代号 | 张数  | 用户购买车票               |
| listOrder |             |        |        |          |       | 查询已购买的车票           |



## login

​	

| 命令  | 参数1       | 参数2 | 功能描述                   |
| ----- | ----------- | ----- | -------------------------- |
| login | Aadhaar卡号 | 姓名  | 用户登录，是购票的前序操作 |

已注册用户通过该指令登录系统，登录后直到主动登出或者退出系统之前需维持当前登录状态，与超级管理员模式不冲突（不会不管不考）。

+ 输出
  + 登录成功输出`Login success`



+ 异常处理
  + 命令不存在，输出`Command does not exist`
  + 参数数量不正确，输出`Arguments illegal`
  + 当前已有用户登录，输出`You have logged in`
  + Aadhaar卡号不合法或不存在，输出`User does not exist`
  + 姓名与卡号不对应，输出`Wrong name`



+ 样例

  ```
  -addUser LaoWang M 002301220991
  -Name:LaoWang
   Sex:M
   Aadhaar:002301220991
  
  -login 002301220991 LaoWang
  -Login success
  ```

  

## logout

| 命令   | 功能描述               |
| ------ | ---------------------- |
| logout | 退出当前登录的用户账户 |

已登录用户通过该指令退出登录状态，用以切换其它账号。

+ 输出
  + 登出成功输出`Logout success`



+ 异常处理
  + 命令不存在，输出`Command does not exist`
  + 参数数量不正确（不为零），输出`Arguments illegal`
  + 当前无用户登录，输出`No user has logged in`

+ 样例

```
-addUser LaoWang M 002301220991
-Name:LaoWang
 Sex:M
 Aadhaar:002301220991
 
-login 002301220991 LaoWang
-Login success

-logout
-Logout success
```



## buyTicket

| 命令      | 参数1    | 参数2  | 参数3  | 参数4    | 参数5 | 功能描述     |
| --------- | -------- | ------ | ------ | -------- | ----- | ------------ |
| buyTicket | 列车车次 | 出发站 | 目的站 | 席位代号 | 张数  | 用户购买车票 |

已登录用户通过该指令购买车票，车票来源于CTS-2中添加的车次的初始票数，每次购买后从当前余票中减去购买的数量。购买的车票信息需保存起来直到系统退出。

席位代号包括 [ CC、SB、GG、SC、HC、1A、2A ]。

+ 输出
  + 购买成功输出`Thanks for your order`



+ 异常处理
  + 命令不存在，输出`Command does not exist`
  + 参数数量不正确，输出`Arguments illegal`
  + 当前无用户登录，输出`Please login first`
  + 列车车次不存在，输出`Train does not exist`
  + 出发站或目的站不存在（地球上不存在或该车次不经过该车站），输出`Station does not exist`
  + 席位代号与车次类型不符（席位代号非法或该车次没有这种席位），输出`Seat does not match`
  + 张数不为正整数，输出`Ticket number illegal`
  + 张数大于该车次该席位的剩余票数，输出`Ticket does not enough`

+ 样例

```
-TunakTunakTun
-DuluDulu

-addLine Line13 4 Dazhongshi 28 Zhichunlu 30 Wudaokou 48 Shangdi 96 Xierqi 121 Longze 148
-Add Line success

-addTrain K1151 Line13 22 90 7 120
-Add Train Success

-addUser LaoWang M 002301220991
-Name:LaoWang
 Sex:M
 Aadhaar:002301220991
 
-login 002301220991 LaoWang
-Login success

-buyTicket K1151 Zhichunlu Wudaokou 1A 10
-Thanks for your order
```



## listOrder

| 命令      | 功能描述         |
| --------- | ---------------- |
| listOrder | 查询已购买的车票 |

已登录用户通过该指令查询当前账号下已购买的车票，按照指定格式打印订单信息

注：从系统开始运行到退出系统期间，用户的订单信息始终保留，即使登出再登录后仍能查看历史订单。



+ 输出

  若历史订单不为空，按照最近购买日期优先顺序（下单顺序的倒序）输出订单信息，总价保留两位小数，格式为：

  ```
  [[列车车次]: [出发站]->[目的站]] seat:[席别代号] num:[张数] price:[总价(保留两位小数)]
  ```

  若历史订单为空，输出`No order`

  

+ 异常处理
  + 命令不存在，输出`Command does not exist`
  + 参数数量不正确（不为零），输出`Arguments illegal`
  + 当前无用户登录，输出`Please login first`



+ 样例

  ```
  -TunakTunakTun
  -DuluDulu
  
  -addLine Line13 4 Dazhongshi 28 Zhichunlu 30 Wudaokou 48 Shangdi 96 Xierqi 121 Longze 148
  -Add Line success
  
  -addTrain K1151 Line13 22 90 7 120
  -Add Train Success
  
  -addUser LaoWang M 002301220991
  -Name:LaoWang
   Sex:M
   Aadhaar:002301220991
   
  -login 002301220991 LaoWang
  -Login success
  
  -buyTicket K1151 Zhichunlu Wudaokou 1A 10
  -Thanks for your order
  
  -buyTicket K1151 Dazhongshi Shangdi 2A 20
  -Thanks for your order
  
  -listOrder
  -[K1151: Dazhongshi->Shangdi] seat:2A num:20 price:9520.00
   [K1151: Zhichunlu->Wudaokou] seat:1A num:10 price:3960.00
  ```

  