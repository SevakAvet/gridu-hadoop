import datetime
date = datetime.date.today()
n = 14

for i in xrange(1, n + 1):
    print("ALTER TABLE Orders ADD PARTITION (date='{}') location '/user/savetisyan/events/{}/{:02d}/{:02d}';".format(date, date.year, date.month, date.day))
    date = date + datetime.timedelta(days=1)