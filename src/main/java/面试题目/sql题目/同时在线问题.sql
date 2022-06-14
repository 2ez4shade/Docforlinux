/*同时在线问题
如下为某直播平台主播开播及关播时间，根据该数据计算出平台最高峰同时在线的主播人数。
id		stt						edt
1001	2021-06-14 12:12:12		2021-06-14 18:12:12
1003	2021-06-14 13:12:12		2021-06-14 16:12:12
1004	2021-06-14 13:15:12		2021-06-14 20:12:12
1002	2021-06-14 15:12:12		2021-06-14 16:12:12
1005	2021-06-14 15:18:12		2021-06-14 20:12:12
1001	2021-06-14 20:12:12		2021-06-14 23:12:12
1006	2021-06-14 21:12:12		2021-06-14 23:15:12
1007	2021-06-14 22:12:12		2021-06-14 23:10:12*/

set hive.exec.mode.local.auto=true;

select max(num)
from (select id,
             stt,
             sum(order by stt) num
      from (select id,
                   stt,
                   1 active
            from test4
            union all
            select id,
                   edt,
                   -1 active
            from test4) t1
      order by stt) t2;

select max(sum_p)
from (select id,
             dt,
             sum(p) over (order by dt) sum_p
      from (select id, stt dt, 1 p
            from test5
            union
            select id, edt dt, -1 p
            from test5) t1) t2;
