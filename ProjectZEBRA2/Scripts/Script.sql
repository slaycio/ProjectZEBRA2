select sum(ca.transamount)
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-01')
and ca.categid = 24
group by strftime('%Y-%m',ca.transdate), ca.categid
;



select strftime('%Y-%m',ca.transdate) period,
c.categname kategoria, 
sum(ca.transamount) suma
from checkingaccount_v1 ca,
category_v1 c
where c.categid = ca.categid
and strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-02')
group by period,  c.categname;


select cout.categname kategoria,
(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-01')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '01'
,(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-02')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '02'
,(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-03')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '03'
,(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-04')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '04'
,(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-05')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '05'
,(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-06')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '06'
,(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-07')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '07'
,(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-08')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '08'
,(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-09')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '09'
,(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-10')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '10'
,(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-11')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '11'
,(select round(sum(ca.transamount),2) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-12')
and ca.categid = cout.categid
group by strftime('%Y-%m',ca.transdate), ca.categid
) as '12'
from category_v1 cout
where 1=1
;



select sum(ca.transamount) suma
from checkingaccount_v1 ca
where strftime('%Y-%m',ca.transdate) = (strftime('%Y',date('now'))||'-01')
and ca.categid = 24
group by strftime('%Y-%m',ca.transdate), ca.categid
;

