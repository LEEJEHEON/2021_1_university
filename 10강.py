Python 3.8.5 (default, Jan 27 2021, 15:41:15) 
[GCC 9.3.0] on linux
Type "help", "copyright", "credits" or "license()" for more information.
>>> import numpy as np
>>> import os
>>> a = np.array([[1,2],[3,4]])
>>> a
array([[1, 2],
       [3, 4]])
>>> d = np.array([[1,2,3,4,5],[2,4,5,6,7],[5,6,7,8,9]])
>>> d
array([[1, 2, 3, 4, 5],
       [2, 4, 5, 6, 7],
       [5, 6, 7, 8, 9]])
>>> d[1][4]
7
>>> d[0:,3:]
array([[4, 5],
       [6, 7],
       [8, 9]])
>>> d[0:2,3:]
array([[4, 5],
       [6, 7]])
>>> d[0:2,3:4]
array([[4],
       [6]])
>>> d[0]
array([1, 2, 3, 4, 5])
>>> d[1]
array([2, 4, 5, 6, 7])
>>> [d2]
Traceback (most recent call last):
  File "<pyshell#12>", line 1, in <module>
    [d2]
NameError: name 'd2' is not defined
>>> d[2]
array([5, 6, 7, 8, 9])
>>> d[:,1]
array([2, 4, 6])
>>> d.shape
(3, 5)
>>> a.shape
(2, 2)
>>> b = np.array([1,2,3])
>>> b
array([1, 2, 3])
>>> b.shape
(3,)
>>> c= np.array([[1,2,3]])
>>> c.shape
(1, 3)
>>> d = np.array([[[1,2,3]]])
>>> d.shape
(1, 1, 3)
>>> d.dtype
dtype('int64')
>>> data = np.arange(1,5)
>>> data
array([1, 2, 3, 4])
>>> data.dtype
dtype('int64')
>>> data.astype('float64')
array([1., 2., 3., 4.])
>>> data
array([1, 2, 3, 4])
>>> data.astype('string')
Traceback (most recent call last):
  File "<pyshell#30>", line 1, in <module>
    data.astype('string')
TypeError: data type "string" not understood
>>> data.astype('uint16')
array([1, 2, 3, 4], dtype=uint16)
>>> a = np.zeros([2,3])
>>> a
array([[0., 0., 0.],
       [0., 0., 0.]])
>>> [0., 0., 0.]])
SyntaxError: unmatched ']'
>>> a.dtype
dtype('float64')
>>> a = np.zeros((2,3), dtype='uint36')
Traceback (most recent call last):
  File "<pyshell#36>", line 1, in <module>
    a = np.zeros((2,3), dtype='uint36')
TypeError: data type "uint36" not understood
>>> a = np.zeros((2,3), dtype='uint32')
>>> a
array([[0, 0, 0],
       [0, 0, 0]], dtype=uint32)
>>> b = np.ones([1,3])
>>> b
array([[1., 1., 1.]])
>>> b.dtype
dtype('float64')
>>> np.arange(1,5)
array([1, 2, 3, 4])
>>> np.arange(2.0)
array([0., 1.])
>>> np.arange(0,100,0.1)

>>> a
array([[0, 0, 0],
       [0, 0, 0]], dtype=uint32)
>>> a.transpose()
array([[0, 0],
       [0, 0],
       [0, 0]], dtype=uint32)
>>> np.transpose(ㅁ
	     )
Traceback (most recent call last):
  File "<pyshell#48>", line 1, in <module>
    np.transpose(ㅁ
NameError: name 'ᄆ' is not defined
>>> np.transpose(a)
array([[0, 0],
       [0, 0],
       [0, 0]], dtype=uint32)
>>> a= np.array([1,2,3],[4,5,6]])
SyntaxError: closing parenthesis ']' does not match opening parenthesis '('
>>> a= np.array([[1,2,3],[4,5,6]])
>>> b= np.array([[11,22,33],[44,55,66]])
>>> a+b
array([[12, 24, 36],
       [48, 60, 72]])
>>> a-c
array([[0, 0, 0],
       [3, 3, 3]])
>>> a-b
array([[-10, -20, -30],
       [-40, -50, -60]])
>>> a*b
array([[ 11,  44,  99],
       [176, 275, 396]])
>>> a/b
array([[0.09090909, 0.09090909, 0.09090909],
       [0.09090909, 0.09090909, 0.09090909]])
>>> c= np.array([[1,2,3],[4,5,6]])
>>> d= np.array([[1,2],[4,3],[4,6]])
>>> c.shape
(2, 3)
>>> d.shape
(3, 2)
>>> c.dot(d)
array([[21, 26],
       [48, 59]])
>>> d_list = [[1,2,3,4,5],[2,4,5,6,7],[5,6,7,8,9]]
>>> type(d_list)
<class 'list'>
>>> d = np.array(d_list)
>>> d
array([[1, 2, 3, 4, 5],
       [2, 4, 5, 6, 7],
       [5, 6, 7, 8, 9]])
>>> type(d)
<class 'numpy.ndarray'>
>>> type(d_list)
<class 'list'>
>>> d_list
[[1, 2, 3, 4, 5], [2, 4, 5, 6, 7], [5, 6, 7, 8, 9]]
>>> dlist[0]
Traceback (most recent call last):
  File "<pyshell#70>", line 1, in <module>
    dlist[0]
NameError: name 'dlist' is not defined
>>> d_ㅣist[0]=0
Traceback (most recent call last):
  File "<pyshell#71>", line 1, in <module>
    d_ㅣist[0]=0
NameError: name 'd_ᅵist' is not defined
>>> d_list[0]=0
>>> d_list
[0, [2, 4, 5, 6, 7], [5, 6, 7, 8, 9]]
>>> d
array([[1, 2, 3, 4, 5],
       [2, 4, 5, 6, 7],
       [5, 6, 7, 8, 9]])
>>> d[0]= 0
>>> d
array([[0, 0, 0, 0, 0],
       [2, 4, 5, 6, 7],
       [5, 6, 7, 8, 9]])
>>> arr4 = np.array(10)
>>> arr4
array(10)
>>> arr4 = np.arange(10)
>>> arr4
array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
>>> arr4[5:]
array([5, 6, 7, 8, 9])
>>> arr4[-3:-1]
array([7, 8])
>>> arr4[-5:8]
array([5, 6, 7])
>>> 