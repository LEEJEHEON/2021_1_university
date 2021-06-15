Python 3.8.5 (default, May 27 2021, 13:30:53) 
[GCC 9.3.0] on linux
Type "help", "copyright", "credits" or "license()" for more information.
>>> import numpy as np
>>> discount = 0.05
>>> cf = 100
>>> def pv(cf,discount,k):
	return (cf / ((1+discount) **k))

>>> print(pv(cf,discount,1)
      )
95.23809523809524
>>> print(pv,(cf,discount,2))
<function pv at 0x7fce00962f70> (100, 0.05, 2)
>>> print(pv(200,0.045,5))
160.4902093001368
>>> for i in range(20):
	print(pv(100,0.05,i))

	
100.0
95.23809523809524
90.70294784580499
86.3837598531476
82.27024747918819
78.35261664684589
74.62153966366274
71.06813301301213
67.6839362028687
64.46089162177971
61.39132535407592
58.46792890864373
55.68374181775592
53.03213506452945
50.506795299551854
48.101709809096995
45.811152199140004
43.62966876108571
41.5520654867483
39.57339570166504
>>> sum = 0
>>> for i in range(1,21):
	sum += pv(100,0.05,i)

	
>>> print(sum
      )
1246.2210342539981
>>> loss = [-750,-250]
>>> profit = [100]
>>> profit
[100]
>>> profit = profit * 2
>>> prefit
Traceback (most recent call last):
  File "<pyshell#23>", line 1, in <module>
    prefit
NameError: name 'prefit' is not defined
>>> profit
[100, 100]
>>> profit = profit * 9
>>> profit
[100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100]
>>> len(profit
    )
18
>>> cf = loss + profit
>>> cf
[-750, -250, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100]
>>> len(cf)
20
>>> cashflow = np.array(cf_
		    dd
		    
SyntaxError: invalid syntax
>>> cashflow = np.array(cf)
>>> cashflow
array([-750, -250,  100,  100,  100,  100,  100,  100,  100,  100,  100,
        100,  100,  100,  100,  100,  100,  100,  100,  100])
>>>  type(cashflow)
 
SyntaxError: unexpected indent
>>> type(cashflow)
<class 'numpy.ndarray'>
>>> type(cf)
<class 'list'>
>>> npv = np.npv(0.045,cashflow)
>>> npv
174.4011295118405
>>> irr = np.irr(cashflow)
>>> irr
0.06434936937255586
>>> print(np.npv(0.064,cashflow)
      )
2.791781086654904
>>> print(np.npv(irr,cashflow))
-2.0250467969162855e-13
>>> print(np.npv(0.065,cashflow))
-5.16747580844596
>>> 