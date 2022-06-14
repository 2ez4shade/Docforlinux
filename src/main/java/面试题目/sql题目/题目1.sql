/*有一个订单表order。已知字段有：order_id(订单ID), user_id(用户ID),amount(金额), pay_datetime(付费时间),channel_id(渠道ID),dt(分区字段)。

1. 在Hive中创建这个表。
2. 查询dt=‘2018-09-01‘里每个渠道的订单数，下单人数（去重），总金额。
3. 查询dt=‘2018-09-01‘里每个渠道的金额最大3笔订单。
4. 有一天发现订单数据重复，请分析原因*/

-- 1.
create table order
(
    order_id     string,
    user_id      int,
    amount       double,
    pay_datetime string,
    channel_id   int,
    dt           string
) partitioned by (dt)
    row format delimited fields terminated by '\t';
--2.
select count(1),
       count(distinct user_id),
       sum(amount)
from order
where dt = '2018-09-01'
group by channel_id;
--3.
select t1.order_id,
       t1.channel_id
from (select order_id,
             channel_id,
             rank() over (partition by channel_id order by amount desc) rk
      from order
      where dt = '2018-09-01') t1
where t1.rk <= 3;
--4.
-- 订单属于业务数据，在关系型数据库中不会存在数据重复
-- hive建表时也不会导致数据重复，
-- 我推测是在数据迁移时，迁移失败导致重复迁移数据冗余了
