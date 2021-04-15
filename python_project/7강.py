Python 3.8.5 (default, Jan 27 2021, 15:41:15) 
[GCC 9.3.0] on linux
Type "help", "copyright", "credits" or "license()" for more information.
>>> # csv 파일로 데이터 다루기 (1)
>>> import csv, os
>>> os.chdir(r'/media/dlwpgjs0723/ESD-USB/대학교/4학년 1학기/python 프젝')
>>> f = open('a.csv','r')
Traceback (most recent call last):
  File "<pyshell#3>", line 1, in <module>
    f = open('a.csv','r')
FileNotFoundError: [Errno 2] No such file or directory: 'a.csv'
>>> os.chdir(r'~/Desktop/university/python_project')
Traceback (most recent call last):
  File "<pyshell#4>", line 1, in <module>
    os.chdir(r'~/Desktop/university/python_project')
FileNotFoundError: [Errno 2] No such file or directory: '~/Desktop/university/python_project'
>>> os.chdir(r'home/dlwpgjs0723/Desktop/university/python_project')
Traceback (most recent call last):
  File "<pyshell#5>", line 1, in <module>
    os.chdir(r'home/dlwpgjs0723/Desktop/university/python_project')
FileNotFoundError: [Errno 2] No such file or directory: 'home/dlwpgjs0723/Desktop/university/python_project'
>>> os.chdir(r'/home/dlwpgjs0723/Desktop/university/python_project')
>>> f = open('a.csv','r')
>>> new = csv.reader(f)
>>> new
<_csv.reader object at 0x7fc3d6eeae40>
>>> for i in new:
	print(i)

	
['국어', '영어', '수학']
['90', '80', '100']
>>> a_list = []
>>> for i in new:
	print(i)
	a_list.append(i)

	
>>> a_list
[]
>>> f.seek(0)
0
>>>  for i in new:
	print(i)
	a_list.append(i)

SyntaxError: unexpected indent
>>> for i in new:
	print(i)
	a_list.append(i)

	
['국어', '영어', '수학']
['90', '80', '100']
>>> a_list
[['국어', '영어', '수학'], ['90', '80', '100']]
>>> def opencsv(filename):
	f = open(filename,'r')
	reader = csv.reader(f)
	output = []
	for i in reader:
		output.append(i)
	return output

>>> opencsv('a,csv')
Traceback (most recent call last):
  File "<pyshell#32>", line 1, in <module>
    opencsv('a,csv')
  File "<pyshell#31>", line 2, in opencsv
    f = open(filename,'r')
FileNotFoundError: [Errno 2] No such file or directory: 'a,csv'
>>> opencsv('a.csv')
[['국어', '영어', '수학'], ['90', '80', '100']]
>>> openscv('b.csv')
Traceback (most recent call last):
  File "<pyshell#34>", line 1, in <module>
    openscv('b.csv')
NameError: name 'openscv' is not defined
>>> opencsv('b.csv')
[['Tom', ' Jerry', ' Mike'], ['100', ' 80', ' 90']]
>>> a = [['구','전체','내국인','외국인'],
     ['관악구','519864','502089','17775'],
     ['강남구','1','2','3']]
>>> f = open('abc.csv','w',newline='')
>>> csvobject = csv.writer(f,delimiter = ',')
>>> csvobject.writerows(a)
>>> f.close()
>>> def writercsv(filename,a_list):
	with open(filename, 'w', newline ='') as f:
		a= csv.writer(f,delimiter=',')
		a.writerows(a_list)

		
>>> writecsv('c.csv',a)
Traceback (most recent call last):
  File "<pyshell#49>", line 1, in <module>
    writecsv('c.csv',a)
NameError: name 'writecsv' is not defined
>>> writercsv
<function writercsv at 0x7fc3d4eda790>
>>> writercsv('c.csv',a)
>>> 
================================ RESTART: Shell ================================
>>> import usercsv
Traceback (most recent call last):
  File "<pyshell#52>", line 1, in <module>
    import usercsv
ModuleNotFoundError: No module named 'usercsv'
>>> import usercsv
Traceback (most recent call last):
  File "<pyshell#53>", line 1, in <module>
    import usercsv
ModuleNotFoundError: No module named 'usercsv'
>>> import userccsv
Traceback (most recent call last):
  File "<pyshell#54>", line 1, in <module>
    import userccsv
ModuleNotFoundError: No module named 'userccsv'
>>> Traceback (most recent call last):
	
SyntaxError: invalid syntax
>>> import usercsv
Traceback (most recent call last):
  File "<pyshell#56>", line 1, in <module>
    import usercsv
ModuleNotFoundError: No module named 'usercsv'
>>> 