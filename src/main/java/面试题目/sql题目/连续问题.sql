/*连续问题
如下数据为蚂蚁森林中用户领取的减少碳排放量
table :
id		dt				lowcarbon
1001	2021-12-12		123
1002	2021-12-12		45
1001	2021-12-13		43
1001	2021-12-13		45
1001	2021-12-13		23
1002	2021-12-14		45
1001	2021-12-14		230
1002	2021-12-15		45
1001	2021-12-15		23
… …
找出连续3天及以上减少碳排放量在100以上的用户*/


select id,
       dt
from (select id,
             dt,
             count() over (partition by id,temp) c
      from (select id,
                   dt,
                   date_sub(dt, rk) temp
            from (select id,
                         dt,
                         rank() over (partition by id order by dt) rk
                  from (select id,
                               dt,
                               sum(lowcarbon) as lowsum
                        from table
                        group by id, dt) t1
                  where t1.lowsum > 100) t2) t3) t4
where t4.c >= 3;
-----------------------------------------------
select id,
       flag,
       count(*) ct
from (select id,
             dt,
             lowcarbon,
             date_sub(dt, rk) flag
      from (select id,
                   dt,
                   lowcarbon,
                   rank() over (partition by id order by dt) rk
            from (select id,
                         dt,
                         sum(lowcarbon) lowcarbon
                  from test1
                  group by id, dt
                  having lowcarbon > 100) t1) t2) t3
group by id, flag
having ct >= 3;






