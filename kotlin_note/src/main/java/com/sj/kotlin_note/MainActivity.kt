package com.sj.kotlin_note

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sj.kotlin_note.base.Base1_Funcation_Variable
import com.sj.kotlin_note.base.Base3_Grammar_ControlStatement

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Base1_Funcation_Variable.fun0()
        Base1_Funcation_Variable.fun1()
        Base1_Funcation_Variable.fun2()

        Base3_Grammar_ControlStatement.funcirculation()
    }


}
/**

数组在kotlin中就是类
if是表达式 不是语句，表达式有值，并且能作为另一个表达式的一部分使用，语句总是包围着它的代码块中的顶层元素，并且没有自己的值
在Java中所有的控制结构都是语句，Kotlin中除了循环（for，while,do/while）外大多数控制结构都是表达式
Java中的赋值是表达式，在Kotlin中是语句，这样有助于避免比较和赋值之间的混淆
Kotlin中public是默认的可见性
可以导入java包，也可以导入函数

setof Kotlin标准函数库 用于创建一个Set 包含所有制定为函数实参的对象，而不在乎它的顺序 只要两个Set包含一样的条目则他们就是相等的
变量
val 不可变引用，但引用的对象时可变的使用它声明的变量不可在初始化之后再次赋值，对应Java的final
var 可变引用，变量的值可以被改变，但类型不可变
默认情况下尽可能使用val关键字来声明所有Kotlin变量，仅在必要时候换成var

字符串模板
$
$加上变量名称即可，若是不存在的变量则不会转义
${}
{}中可加入表达式，来丰富想要的操作

类和属性
class person （val name:String） 值对象--只有数据没有其他代码、
属性
val 声明  只读属性  一个字段  只有一个gettter
var 声明 可写属性 一个字段 一个setter 一个getter
kotlin中直接可调用类的属性，实际上是调用了它的gettersetter方法

when结构
when(表达式，枚举){
    满足条件1-->11
    …
}
特殊 不带参数的
when｛
分支条件为任意的布尔表达式
｝优点是不会创建额外的对象，但更难理解

循环结构
特殊 区间概念 Kotlin的区间是包含或者闭合的，意味着第二个值始终是区间的一部分
val oneToTen = 1..10
for（i in 100 downTo 1 step 2)
for（i in 区间（1..100 100 downTo 1    until size不包括最后的值）step 步数绝对值)
.. 语法不仅可以创建数字区间 还可以创建字符区间

       */