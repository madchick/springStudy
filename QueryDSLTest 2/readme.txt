
QueryDSL

- https://jaime-note.tistory.com/67
- 페이징 : https://ttl-blog.tistory.com/228

https://velog.io/@yulhee741/Querydsl-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%ED%99%98%EA%B2%BD%EC%84%A4%EC%A0%95

https://github.com/jeonguk/spring-jpa-querydsl-example

https://tecoble.techcourse.co.kr/post/2021-08-08-basic-querydsl/



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



