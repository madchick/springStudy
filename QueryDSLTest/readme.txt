
QueryDSL

환경설정 및 테스트
https://velog.io/@dbsrud11/QueryDSL-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%ED%99%98%EA%B2%BD%EC%84%A4%EC%A0%95

JPA repository 같이 사용하기
https://tecoble.techcourse.co.kr/post/2021-08-08-basic-querydsl/

JPA pagable 같이 사용하기
https://jddng.tistory.com/345

소팅
https://medium.com/quick-code/spring-boot-how-to-design-efficient-search-rest-api-c3a678b693a0

https://github.com/jeonguk/spring-jpa-querydsl-example



runtimeOnly 'org.mariadb.jdbc:mariadb-java-client' // MariaDB



D:\Program Files\MariaDB 10.6\bin

mysql -uroot -pYYYY
sudo mysql -u root

create database testdb;
create user 'testdb'@'%' identified by 'testdb';

grant all privileges on testdb.* to 'testdb'@'%';
flush privileges;

select host, user from mysql.user;

drop user testdb@'%';



Gradle → Tasks → build → clean
Gradle → Tasks → other → compileQuerydsl

build → generated → querydsl