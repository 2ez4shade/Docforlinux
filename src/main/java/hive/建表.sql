create table xdd
(
    id   int,
    name string
) partitioned by (day string)
    clustered by (id)
        into 4 buckets
    row format delimited
        fields terminated by "\t"
