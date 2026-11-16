# 创建一个名为tb_user的表
create table tb_user(
    id int(32) primary key auto_increment,
    username varchar(32),
    address varchar(256)
);
# 插入3条数据
insert into tb_user values ('1', '小明', '北京');
insert into tb_user values ('2', '李华', '上海');
insert into tb_user values ('3', '李刚', '上海');

# 创建一个名称为tb_orders的表
CREATE TABLE tb_orders (
    id int(32) PRIMARY KEY AUTO_INCREMENT,
    number varchar(32) NOT NULL,
    user_id int(32) NOT NULL,
    FOREIGN KEY(user_id) REFERENCES tb_user(id)
);
# 插入3条数据
INSERT INTO tb_orders VALUES ('1', '1000011', '1');
INSERT INTO tb_orders VALUES ('2', '1000012', '1');
INSERT INTO tb_orders VALUES ('3', '1000013', '2');

# 创建一个名称为tb_product的表
drop table if exists tb_product;
CREATE TABLE tb_product (
    id INT(32) PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(32),
    price DOUBLE
);
# 插入3条数据
INSERT INTO tb_product VALUES ('1', 'Java基础入门', '44.5');
INSERT INTO tb_product VALUES ('2', 'Java Web程序开发入门', '38.5');
INSERT INTO tb_product VALUES ('3', 'SSM框架整合实战', '50');

# 创建一个名称为tb_ordersitem 的中间表
drop table if exists tb_ordersitem;
CREATE TABLE tb_ordersitem (
    id INT(32) PRIMARY KEY AUTO_INCREMENT,
    orders_id INT(32),
    product_id INT(32),
    FOREIGN KEY(orders_id) REFERENCES tb_orders(id),
    FOREIGN KEY(product_id) REFERENCES tb_product(id)
);
# 插入3条数据
INSERT INTO tb_ordersitem  VALUES ('1', '1', '1');
INSERT INTO tb_ordersitem  VALUES ('2', '1', '3');
INSERT INTO tb_ordersitem  VALUES ('3', '3', '3');

# 创建一个名称为tb_worker的表
create table tb_worker(
    id int primary key auto_increment,
    name varchar (32),
    age int,
    sex varchar(8),
    worker_id int unique
);
# 插入3条数据
insert into tb_worker(name,age,sex,worker_id)
values('张三',32,'女',1001);
insert into tb_worker(name,age,sex,worker_id)
values('李四',29,'男',1002);
insert into tb_worker(name,age,sex,worker_id)
values('王五',26,'男',1003);

USE mybatis;
# 创建一个名称为tb_idcard的表
drop table if exists tb_idcard;
CREATE TABLE  tb_idcard(
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           CODE VARCHAR(18)
);
# 插入2条数据
INSERT INTO tb_idcard(CODE) VALUES('152221198711020624');
INSERT INTO tb_idcard(CODE) VALUES('152201199008150317');
# 创建一个名称为tb_person的表
drop table if exists tb_person;
CREATE TABLE  tb_person(
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(32),
                           age INT,
                           sex VARCHAR(8),
                           card_id INT UNIQUE,
                           FOREIGN KEY(card_id) REFERENCES tb_idcard(id)
);
# 插入2条数据
INSERT INTO tb_person(name,age,sex,card_id) VALUES('Rose',22,'女',1);
INSERT INTO tb_person(name,age,sex,card_id) VALUES('jack',23,'男',2);

