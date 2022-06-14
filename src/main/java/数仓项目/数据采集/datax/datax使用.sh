
#DataX的使用十分简单，用户只需根据自己同步数据的数据源和目的地选择相应的Reader和Writer，并将Reader和Writer的信息配置在一个json文件中，
#然后执行如下命令提交数据同步任务即可。
python bin/datax.py path/to/your/job.json
##传参 "-Ddt=2020-06-14"
python bin/datax.py -p"-Ddt=2020-06-14" job/base_province.json
#4.2.2 DataX配置文件格式
#可以使用如下命名查看DataX配置文件模板。
python bin/datax.py -r mysqlreader -w hdfswriter
#配置文件模板如下，json最外层是一个job，job包含setting和content两部分，其中setting用于对整个job进行配置，content用户配置数据源和目的地
