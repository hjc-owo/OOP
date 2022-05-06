TunakTunakTun
addLine Line13 4 Dazhongshi 28 Zhichunlu 30 Wudaokou 48 Shangdi 96 Xierqi 121 Longze 148
addLine Manchu 2 Shahe 20 Hamazhen 59 Wulongbei 150 Tangshancheng 207 Gaolimen 281 Fenghuangcheng 272 Sitaizi 430 Jiguanshan 498 Benxihu 586
addTrain K0012 Line13 22 90 7 120
addTrain G1001 Manchu 22 90 7 120 2.4 200
addTrain 00026 Line13 3 100 7 10 2.4 0
addUser xiaoyangren F 041401700330
addUser xiaoyinren M 054502770201
addUser xiaoxuesheng F 016103550800 2
importCert cert.csv
login 041401700330 xiaoyangren
buyTicket K0012 Dazhongshi Zhichunlu 1A 50
listOrder
logout
importCert cert2.csv
login 041401700330 xiaoyangren
buyTicket G1001 Shahe Gaolimen SB 50
listOrder
cancelOrder G1001 Shahe Gaolimen SB 49
listTrain Manchu
listOrder
logout
login 016103550800 xiaoxuesheng
buyTicket G1001 Shahe Gaolimen SB 1
buyTicket G1001 Shahe Gaolimen SB 3
payOrder
checkBalance
rechargeBalance 5000
payOrder
checkBalance
listOrder
logout
login 054502770201 xiaoyinren
buyTicket G1001 Shahe Gaolimen SB 12
listOrder
logout
QUIT
