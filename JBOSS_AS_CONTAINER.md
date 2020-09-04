# JBOSS/Wildfly dengan docker container

running wildfly tidak langsung di main os tetapi dirunning sebagai container.

## Installation

disini di asumsikan docker sudah terinstal, pertama pull jboss image dari docker hub :
```bash
docker pull jboss/wildfly:latest
```
setelah image selesai di pull buat lah container berdasarkan image tersebut, disini container diberi nama jboss1, port yg dibuka adalah 8081 untuk aplikasi, 9991 untuk management

```bash
docker container create --name jboss1 -p 8081:8080 -p 9991:9990 -it jboss/wildfly /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0
```
running jboss1
```bash
docker container start jboss1
```
masuk kedalam container untuk config username password jboss console
```bash
docker exec -it jboss1 bash
```
masuk ke  folder wildfly/bin dan jalankan
```bash
./add-user.sh
```
pilih point a untuk menambah user management & ikuti perintah berikutnya yg terdapat pada console untuk membuat username & passwod
```bash
 a) Management User (mgmt-users.properties)
 b) Application User (application-users.properties)
(a): 
```
setelah itu restart container jboss sudah siap digunakan, ip:8081 untuk aplikasi ip:9991 untuk console admin
