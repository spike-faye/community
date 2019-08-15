## spike社区

## 部署
### 依赖
- Git
- JDK
- Maven
- MySQL
### 步骤
- ssh root@117.50.59.94
- yum update
- yum install git
- mkdir App
- cd App/
- git clone https://github.com/spike-faye/community.git
- yum install maven
- mvn -v
- mvn compile package
- more src/main/resources/application.properties
- cp src/main/resources/application.properties src/main/resources/application-production.properties
- vim src/main/resources/application-production.properties
- mvn package
- java -jar -Dspring.profiles.active=production target/community-0.0.1-SNAPSHOT.jar
- ps -aux | grep java
- git pull

## 资料
[Spring 文档](https://spring.io/guides/)
[Spring Web文档](https://spring.io/guides/gs/serving-web-content/)
[es社区](https://elasticsearch.cn/explore)
[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)
[Bootstrap 文档](https://v3.bootstrap.com/getting-started/)
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[Springboot 官方文档](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/)
[Thymeleaf官方文档](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.pdf)
[菜鸟教程](https://www.runoob.com/mysql/mysql-insert-query.html)
[MarkDown 插件](https://pandao.github.io/editor.md/)
[UFile SDK](https://github.com/ucloud/ufile-sdk-java)

## 工具
[Git](https://git-scm.com/download)
[Visual Paradigm](https://www.visual-paradigm.com)
[Flyway](https://flywaydb.org/)
[Lombok](https://www.projectlombok.org/)
[PostMan](https://www.getpostman.com/)


##脚本
```sql
CREATE TABLE USER (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `token` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `gmt_create` bigint DEFAULT NULL,
  `gmt_modified` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
)
```
```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```