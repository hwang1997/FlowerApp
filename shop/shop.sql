

--��������Ա��
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

--�����û���
create table users(
       name     varchar2(10)     not null,
       user_id  int              primary key,
       password varchar2(20)     not null
)

--������Ʒ��

create table goods(
       good_id         int            primary key,
       good_name       varchar(20)    not null,
       price           varchar(10)    not null,
       count           varchar2(10)   not null,
       des             varchar2(200)  not null��
       pic             varchar2(200)
)


--����������
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


--���ݲ���

--admin��
insert into admin values('������','admin','admin');
commit;

update admin set adminid=1  where admin_id = 'admin';

--users��
insert into users values('����',2016001,'123456');
insert into users values('�ŷ�',2016002,'123456');
insert into users values('����',2016003,'123456');
insert into users values('��Ȩ',2016004,'123456');
commit;

--goods��
insert into goods values(20190001,'õ�廨','239.8','32','���顢�Ȱ��������Ұ��㡢����, ϣ�����㷺����İ�'��'');
insert into goods values(20190002,'�۹�','125.6','125','����İ�,����İ���������һ���˶���(OR��)��������,����Լ�����İ��⡣'��'');
insert into goods values(20190003,'Ǿޱ','322.9','12','�������й���Ǿޱ�����顢ϲ�죬������Ů֮�以����ɫǾޱ����Ԣ�����֮�顣'��'');
insert into goods values(20190004,'������','239.8','32','���顢�Ȱ��������Ұ��㡢����, ϣ�����㷺����İ�'��'');
insert into goods values(20190005,'������','125.6','125','����İ�,����İ���������һ���˶���(OR��)��������,����Լ�����İ��⡣'��'');
insert into goods values(20190006,'÷��','322.9','12','�������й���Ǿޱ�����顢ϲ�죬������Ů֮�以����ɫǾޱ����Ԣ�����֮�顣'��'');
insert into goods values(20190007,'���ӻ�','239.8','32','���顢�Ȱ��������Ұ��㡢����, ϣ�����㷺����İ�'��'');
insert into goods values(20190008,'�ž黨','125.6','125','����İ�,����İ���������һ���˶���(OR��)��������,����Լ�����İ��⡣'��'');
insert into goods values(20190009,'�¼�','322.9','12','�������й���Ǿޱ�����顢ϲ�죬������Ů֮�以����ɫǾޱ����Ԣ�����֮�顣'��'');
insert into goods values(20190010,'�һ�','239.8','32','���顢�Ȱ��������Ұ��㡢����, ϣ�����㷺����İ�'��'');
insert into goods values(20190011,'������','125.6','125','����İ�,����İ���������һ���˶���(OR��)��������,����Լ�����İ��⡣'��'');
insert into goods values(20190012,'����','322.9','12','�������й���Ǿޱ�����顢ϲ�죬������Ů֮�以����ɫǾޱ����Ԣ�����֮�顣'��'');
insert into goods values(20190013,'¹�Ǻ���','239.8','32','���顢�Ȱ��������Ұ��㡢����, ϣ�����㷺����İ�'��'');
insert into goods values(20190014,'����ܰ','125.6','125','����İ�,����İ���������һ���˶���(OR��)��������,����Լ�����İ��⡣'��'');
insert into goods values(20190015,'��Ц','322.9','12','�������й���Ǿޱ�����顢ϲ�죬������Ů֮�以����ɫǾޱ����Ԣ�����֮�顣'��'');
commit;

--orders ��
insert into orders values('8800001','2016001','20190001','3','719.4','����','13233223232','��Ժ','�ֽ�','������');
insert into orders values('8800002','2016002','20190002','1','125.6','�ܲ�','18372654527','��Ժ','����֧��','�ѷ���');
insert into orders values('8800003','2016003','20190003','1','322.9','����','17386576523','��Ժ','�ֽ�','�����');
commit;

select order_id,good_id,good_name,price,count,sumPrice,order_name,phone,address,pay,state from orders natural join goods;

select * from (select rownum no,order_id,good_id,good_name,price,count,sumPrice,order_name,phone,address,pay,state from orders natural join goods where rownum<=2 order by order_id asc) where no>=1;

select count(*) as counts from orders;
select * from (select rownum no,order_id,good_id,good_name,price,amount,sumPrice,order_name,phone,address,pay,state from orders natural join goods where rownum<=5 order by order_id asc) where no>=1;

select * from orders natural join goods natural join users where order_id=8800001;

select * from (select rownum no,good_id,good_name,price,count,des,pic from goods where rownum<=6 order by good_id asc) where no>=1;







