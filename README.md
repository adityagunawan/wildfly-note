# INSTALLATION JBOSS/WILDFLY :

bisa diliat disini : [vitux.com](https://vitux.com/install-and-configure-wildfly-jboss-on-ubuntu/)

Note : 
 agar console dapat di akses dari luar server untuk sementara yg gw tau di tambahin ini di standalone/configuration/standalone.xml

```bash		
<interfaces>
   <interface name="management">
      <any-address/>
   </interface>
   <interface name="public">
      <any-address/>
   </interface>
</interfaces>
```

## Contoh credential di server local vmware

secret key JBOSS : YWRpdDEwMzA=

run wildfly/jboss :
```bash
 sudo systemctl start wildfly
```

check status wildfly :
```bash
 sudo systemctl status wildfly
```

login server local :
	adityagunawan | agunas

login wildfly :
	adityagunawan | adit1030


## Syarat war bisa di deploy di jboss/wildfly

main class wajib extends SpringBootServletInitializer

jika error seperti ini :
```bash
org.apache.tomcat.websocket.server.WsServerContainer cannot be cast to class io.undertow.websockets.jsr.ServerWebSocketContainer
```

tambahkan websocket di depedency :

```bash
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
	<exclusions>
		<exclusion>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-websocket</artifactId>
		</exclusion>
	</exclusions>
</dependency>
```

# DEPLOYMENT

untuk deploy bisa dilakukan dengan 2 cara
 
 1. upload war/jar melalui web console
 	- login ke console dan masuk ke http://192.168.114.128:9990/console/index.html#deployments
 	- kemudian klik "add" dan upload file war dari directory
 	- jika deploy sukses makan aplikasi akan bisa di akses
 	Note : nama root app sesuai dengan nama file war, misal demo.war berarti url app adalah IP_ADDRESS:8080/demo/

 2. copy file war/jar manual
 	- masuk ke WinSCP
 	- copy file war ke dalam folder /opt/wildfly/standalone/deployments/
 	- tunggu beberapa saat
 	- refresh directory, jika ada file nama_file_yang_diupload.war.deployed berarti war sudah berhasil di deploy

 untuk undeploy bisa dilakukan dengan beberapa cara
 1. hapus file war/jar atau file.war.dedeployed
 2. buat file nama_file.war.undeployed 
 	- bisa dengan command : sudo touch nama_file.war.undeployed


# LOG SERVER

 - log server bisa dilihat di /opt/wildfly/standalone/log/server.log
 - untuk memudahkan tracing log sebaiknya setiap method di tulis log message dengan
```bash
Logger logger = LoggerFactory.getLogger(NamaClass.class);

logger.info("start method getDataEmployee");
```




 ### TBE (TO BE EXPLORE) :
 	- memisahkan file log masing2 war yang di upload, kaya yg pernah di buat mas nono