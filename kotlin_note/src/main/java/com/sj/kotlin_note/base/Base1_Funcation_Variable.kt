package com.sj.kotlin_note.base

/**
 * 函数与变量
 * Created by SJ on 2019/9/18.
 */
object Base1_Funcation_Variable {
    /**
     * 关于Java kotlin 异同
     * 1. 可以省略语句后的分号
     * 2. 更好用的字符串模板
     */
     fun fun0() {
        println(" 1. 可以省略语句后的分号")
        val position = 2
        val p = arrayListOf(1,2,3,4)
        println(" $position. 更好用的字符串模板,直接引用变量")
        println(" $position.${p[0]} 插入数组中的元素")
        println(" $position.${p[1]} 嵌入表达式：${if (p.size>=3) p.size else "p.size<3"}")
        println(" $position.${p[1]} 转义输出\$position")

    }
    /**
     * 关于函数
     * 1. 函数可以写在类的外部
     */
     fun fun1() {
        //完整函数声明
        functionCompletion()
        //缩写函数声明
        functionAbbr1()//代码体可省略无返回值类型
        functionAbbr2(
            1,
            3
        )//表达体可省略返回值，因为类型推导，但建议显示的写出返回值与return语句便于阅读
    }

    /**
     * 关于变量
     */
     fun fun2() {
        //声明以关键字开始，然后是变量名称，最可以加上类型（不加也可以）：
        val hello2:String = "hello kotlin"
        //类型推导
        val hello1 = "hello kotlin"
        val i = 1 //默认Int
        val d = 1.1 //默认Double
        //没有初始化时必须指定类型
        val hello3:String
        //可变变量 var 相当于 Java的普通非final变量
        //不可变量 val 相当于 Java的final变量

        //val变量只能进行唯一一次初始化，val引用自身不可变，但是它指向的对象可能是可变的
        val box = arrayListOf("篮球")//box指向的内存地址不可更改
        box.add("足球")//但该内存存储的数据可以进行更改
        //var变量允许更改自己的值，但是它的类型无法改变。编译器只会根据初始化器来推断变量的类型，在决定类型的时候不会考虑后续的赋值操作
    }


    private fun functionAbbr1() {
        println("无返回值时可省略")
    }
    private fun functionAbbr2(a:Int,b:Int)=a+b
    private fun functionCompletion():Unit{
        println("完整的函数声明：" +
                "作用域：默认public" +
                "声明为函数：fun" +
                "方法名：调用方法名(传参)" +
                "返回值：“:类型”")
    }
}