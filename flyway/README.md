# centos-mysql

실행
* docker run --name mysql --rm -it -p 3306:3306 jobjava00/mysql bash

* mysql 실행
    * mysqld --initialize-insecure --datadir=/var/lib/mysql --user=root
        * --initialize-insecure : 초기 비밀번호 생성하지 않음
    * mysqld --skip-grant-tables --user=root &
        * --skip-grant-tables : 권한 테이블 사용하지 않음
