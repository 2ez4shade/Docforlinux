/*间隔连续问题
	某游戏公司记录的用户每日登录数据
id		dt        test1
1001	2021-12-12
1002	2021-12-12
1001	2021-12-13
1001	2021-12-14
1001	2021-12-16
1002	2021-12-16
1001	2021-12-19
1002	2021-12-17
1001	2021-12-20
计算每个用户最大的连续登录天数，可以间隔一天。解释：如果一个用户在1,3,5,6登录游戏，则视为连续6天登录。*/

select id, max(day) + 1
from (select id, datediff(max(dt), min(dt)) day
      from (select id, dt, sum(nm) over (partition by id order by dt ) nm2
            from (select id, dt, if(df > 2, 1, 0) nm
                  from (select id, dt, up, datediff(dt, up) df
                        from (select id, dt, lag(dt, 1, "0000-00-00") over (partition by id order by dt) up
                              from test1) t1) t2) t3) t4
      group by id, nm2) t5
group by id;
//总结先分组在判断

//答案的另一种做法(2次等差再合并)

select id, max(day) + 1
from (select id, sum(c2) day
      from (select id, c2, date_sub(dt2, dc2) dt3
            from (select id, dt2, count(dt2) c2, rank() over (partition by id order by dt2) dc2
                  from (select id, date_sub(dt, dc) dt2
                        from (select id, dt, rank() over (partition by id order by dt) dc
                              from test1) t1) t2
                  group by id, dt2) t3) t4
      group by id, dt3) t5
group by id