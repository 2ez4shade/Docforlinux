--一个叫team的表，里面只有一个字段name,一共有4条纪录，分别是a,b,c,d,对应四个球队，
-- 现在四个球队进行比赛，用一条sql语句显示所有可能的比赛组合.
select a.name, b.name
from team a, team b
where a.name < b.name
-- 面试题：怎么把这样一个
-- year   month amount
-- 1991   1     1.1
-- 1991   2     1.2
-- 1991   3     1.3
-- 1991   4     1.4
-- 1992   1     2.1
-- 1992   2     2.2
-- 1992   3     2.3
-- 1992   4     2.4
-- 查成这样一个结果
-- year m1  m2  m3   m4
-- 1991 1.1 1.2 1.3 1.4
-- 1992 2.1 2.2 2.3 2.4
select
    year ,
    sum(case month when 1 then amount else 0 end) m1
    sum(case month when 2 then amount else 0 end) m2
    sum(case month when 3 then amount else 0 end) m3
    sum(case month when 4 then amount else 0 end) m4
    from
    aaa
group by year
order by year;
-- 表名：购物信息 aaa
--给出所有购入商品为两种或两种以上的购物人记录
-- 购物人 n     商品名称 g    数量 s
-- A            甲          2
-- B            乙          4
-- C            丙          1
-- A            丁          2
-- B            丙          5
select *
from  aaa
where n in (select n from aaa group by n having count(g)>=2)



