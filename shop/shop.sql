

--创建管理员表
create table admin(
       name     varchar2(10)    not null,
       admin_id varchar2(20)    primary key,
       password varchar2(20)    not null 
)

drop table admin;
drop table users;
drop table goods;
drop table orders;

drop sequence adminid;
drop sequence userid;
drop sequence orderid;
drop sequence goodid;

--创建用户表
create table users(
       name     varchar2(10)     not null,
       user_id  int              primary key,
       password varchar2(20)     not null
)

--创建商品表

create table goods(
       good_id         int            primary key,
       good_name       varchar(20)    not null,
       price           varchar(10)    not null,
       count           varchar2(10)   not null,
       des             varchar2(200)  not null，
       pic             varchar2(200)
)


--创建订单表
create table orders(
       order_id     int               primary key,
       user_id      int               not null,
       good_id      int               not null,
       amount       varchar2(20)      not null,
       sumPrice     varchar2(20)      not null,
       order_name   varchar(20)       not null,
       phone        varchar2(20)      not null,
       address      varchar2(50)      not null,
       pay          varchar2(20)      not null,
       state        varchar2(20)      not null,
       foreign key (user_id) references users(user_id) on delete cascade,
       foreign key (good_id) references goods(good_id) on delete cascade
)

drop table orders;
drop table goods;
drop table orders;


select * from orders natural join goods natural join users order by order_id asc;
select * from goods order by good_id asc;
select * from admin;
select * from users;
select * from goods;
select * from orders;


--数据插入

--admin表
insert into admin values('武则天','admin','admin');
commit;

update admin set adminid=1  where admin_id = 'admin';

--users表
insert into users values('关羽',2016001,'123456');
insert into users values('张飞',2016002,'123456');
insert into users values('赵云',2016003,'123456');
insert into users values('孙权',2016004,'123456');
commit;

--goods表
insert into goods values(20190001,'玫瑰花','239.8','32','热情、热爱着您　我爱你、热恋, 希望与你泛起激情的爱'，'');
insert into goods values(20190002,'桔梗','125.6','125','永恒的爱,不变的爱，代表着一个人对他(OR她)所爱的人,表达自己深深的爱意。'，'');
insert into goods values(20190003,'蔷薇','322.9','12','在我们中国，蔷薇代表爱情、喜庆，年轻男女之间互赠红色蔷薇花，寓意初恋之情。'，'');
insert into goods values(20190004,'风信子','239.8','32','热情、热爱着您　我爱你、热恋, 希望与你泛起激情的爱'，'');
insert into goods values(20190005,'紫罗兰','125.6','125','永恒的爱,不变的爱，代表着一个人对他(OR她)所爱的人,表达自己深深的爱意。'，'');
insert into goods values(20190006,'梅花','322.9','12','在我们中国，蔷薇代表爱情、喜庆，年轻男女之间互赠红色蔷薇花，寓意初恋之情。'，'');
insert into goods values(20190007,'栀子花','239.8','32','热情、热爱着您　我爱你、热恋, 希望与你泛起激情的爱'，'');
insert into goods values(20190008,'杜鹃花','125.6','125','永恒的爱,不变的爱，代表着一个人对他(OR她)所爱的人,表达自己深深的爱意。'，'');
insert into goods values(20190009,'月季','322.9','12','在我们中国，蔷薇代表爱情、喜庆，年轻男女之间互赠红色蔷薇花，寓意初恋之情。'，'');
insert into goods values(20190010,'桃花','239.8','32','热情、热爱着您　我爱你、热恋, 希望与你泛起激情的爱'，'');
insert into goods values(20190011,'曼陀罗','125.6','125','永恒的爱,不变的爱，代表着一个人对他(OR她)所爱的人,表达自己深深的爱意。'，'');
insert into goods values(20190012,'茉莉花','322.9','12','在我们中国，蔷薇代表爱情、喜庆，年轻男女之间互赠红色蔷薇花，寓意初恋之情。'，'');
insert into goods values(20190013,'鹿角海棠','239.8','32','热情、热爱着您　我爱你、热恋, 希望与你泛起激情的爱'，'');
insert into goods values(20190014,'康乃馨','125.6','125','永恒的爱,不变的爱，代表着一个人对他(OR她)所爱的人,表达自己深深的爱意。'，'');
insert into goods values(20190015,'含笑','322.9','12','在我们中国，蔷薇代表爱情、喜庆，年轻男女之间互赠红色蔷薇花，寓意初恋之情。'，'');
commit;

--orders 表
insert into orders values('8800001','2016001','20190001','3','719.4','刘禅','13233223232','汽院','现金','处理中');
insert into orders values('8800002','2016002','20190002','1','125.6','曹操','18372654527','汽院','线上支付','已发货');
insert into orders values('8800003','2016003','20190003','1','322.9','吕布','17386576523','汽院','现金','已完成');
commit;

select order_id,good_id,good_name,price,count,sumPrice,order_name,phone,address,pay,state from orders natural join goods;

select * from (select rownum no,order_id,good_id,good_name,price,count,sumPrice,order_name,phone,address,pay,state from orders natural join goods where rownum<=2 order by order_id asc) where no>=1;

select count(*) as counts from orders;
select * from (select rownum no,order_id,good_id,good_name,price,amount,sumPrice,order_name,phone,address,pay,state from orders natural join goods where rownum<=5 order by order_id asc) where no>=1;

select * from orders natural join goods natural join users where order_id=8800001;

select * from (select rownum no,good_id,good_name,price,count,des,pic from goods where rownum<=6 order by good_id asc) where no>=1;







