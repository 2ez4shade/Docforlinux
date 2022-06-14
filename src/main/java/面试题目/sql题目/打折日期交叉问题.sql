/*打折日期交叉问题
如下为平台商品促销数据：字段为品牌，打折开始日期，打折结束日期
brand	stt			edt        test2
oppo	2021-06-05	2021-06-09
oppo	2021-06-11	2021-06-21
vivo	2021-06-05	2021-06-15
vivo	2021-06-09	2021-06-21
redmi	2021-06-05	2021-06-21
redmi	2021-06-09	2021-06-15
redmi	2021-06-17	2021-06-26
huawei	2021-06-05	2021-06-26
huawei	2021-06-09	2021-06-15
huawei	2021-06-17	2021-06-21
计算每个品牌总的打折销售天数，注意其中的交叉日期，比如vivo品牌，第一次活动时间为2021-06-05到2021-06-15，
第二次活动时间为2021-06-09到2021-06-21其中9号到15号为重复天数，只统计一次，
即vivo总打折天数为2021-06-05到2021-06-21共计17天。*/
//brand	stt			edt        test2
set hive.exec.mode.local.auto=true;



select brand, sum(if(day >= 0, day + 1, 0))
from (select brand, datediff(edt, stt) day
      from (select brand,
                   if(edt2 is null, stt, if(stt > edt2, stt, date_add(edt2, 1))) stt,
                   edt
            from (select brand,
                         stt,
                         edt,
                         max(edt)
                             over (partition by brand order by stt rows between unbounded preceding and 1 preceding ) edt2
                  from test3) t1) t2) t3
group by brand;


select brand, sum(if(day >= 0, day + 1, 0))
from (select brand, datediff(edt, stt) day
      from (select brand,
                   if(stt > edt2, stt, date_add(edt2, 1)) stt,
                   edt
            from (select brand,
                         stt,
                         edt,
                         max(edt)
over (partition by brand order by stt rows between unbounded preceding and 1 preceding ) edt2
                  from test3) t1) t2) t3
group by brand;



select brand,
       sum(if(days >= 0, days + 1, 0)) days
from (select brand,
             datediff(edt, stt) days
      from (select brand,
                   if(maxEdt is null, stt, if(stt > maxEdt, stt, date_add(maxEdt, 1))) stt,
                   edt
            from (select brand,
                         stt,
                         edt,
                         max(edt)
                             over (partition by brand order by stt rows between UNBOUNDED PRECEDING and 1 PRECEDING) maxEdt
                  from test3) t1) t2) t3
group by brand;
