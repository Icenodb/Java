# 类介绍

1. **LibraryOut**

   这个类的用途是创建一个线程，用来把书借出去，借不借由Ticket的变量来决定

2. **LibraryIn**

   这个类用来创建线程，把书还回去，判断库存满不满的指标是Ticket类的num变量

3. **Ticket**

   用来对图书馆的书进行计数

   有一个变量num

   两个方法

   ```java
    public static int minusNum(){
           num--;
           return num;
       }
       public static int addNum(){
           num++;
           return num;
       }
   ```

   

4. **Main**

   主类