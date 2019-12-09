package com.sj.kotlin_note.base

import android.util.Log

/**
 * 语法与控制语句
 * Created by SJ on 2019/9/18.
 */
object Base3_Grammar_ControlStatement {

    /**
     *  when结构语句类似java中的switch，但比switch功能更加强大
     *  when中可以使用任意对象
     *  代码块可以作为它的分支，代码块中的最后一个表达式会作为结果返回
     */
    fun funWhen(s1: SubjectEnum, s2: SubjectEnum) {
        println(
            "单个条件：${
            when (s1) {
                SubjectEnum.CHINESE -> "语文"
                SubjectEnum.MATH -> "数学"
                SubjectEnum.ENGLISH -> "英语"
                SubjectEnum.PHYSICS -> "物理"
                SubjectEnum.CHEMISTRY -> "化学"
                SubjectEnum.BIOLOGY -> "生物"
            }
            }" + "\n" +
                    "单个配多个：${
                    when (s1) {
                        SubjectEnum.CHINESE, SubjectEnum.MATH, SubjectEnum.ENGLISH -> "主课"
                        SubjectEnum.PHYSICS, SubjectEnum.CHEMISTRY, SubjectEnum.BIOLOGY -> "副课"
                    }
                    }"
        )
        println(
            "多个条件：${
            when (setOf(s1, s2)) {
                setOf(
                    SubjectEnum.CHINESE,
                    SubjectEnum.MATH
                ) -> "语文&数学"
                setOf(
                    SubjectEnum.ENGLISH,
                    SubjectEnum.PHYSICS
                ) -> "英语&物理"
                setOf(
                    SubjectEnum.CHEMISTRY,
                    SubjectEnum.BIOLOGY
                ) -> "化学&生物"
                else -> "none"
            }
            }"
        )
        println(
            "不传入参数：${
            when {
                s1 == SubjectEnum.CHINESE || s2 == SubjectEnum.MATH -> "语文or数学"
                s1 == SubjectEnum.ENGLISH || s2 == SubjectEnum.PHYSICS -> "英语or物理"
                s1 == SubjectEnum.CHEMISTRY || s2 == SubjectEnum.BIOLOGY -> "化学or生物"
                else -> "none"
            }
            }"
        )
    }

    fun funIntelTransformaiton() {
        Log.e(
            "Tag", "1. Kotlin中的智能转换 由is表示，代替Java中的 instanceof" + "\n" +
                    "2. is检查过类型后可以直接进行调用，而无须java中还要进行一次强转"
        )
    }

    /**
     * 循环
     * 1. while与Java当中基本无变化
     * 2. 区间迭代，Kotlin中没有常规的for循环，用于替代的是区间的概念
     */
    fun funcirculation() {
        //区间本质上就是两个值之间的间隔，通常是数字，用..运算符表示区间
        // ..表示正序 downTo表示倒序 step表示每次的跨度绝对值,必须为正数，区间已经决定了它的排序方向，为1时可不写
        // ..语法表示的区间是包含第二个边界值的，在Java中对数组遍历时是不包含size的，这里可以用until来代替
        for (i in 100 downTo 1 step 3) {
            Log.e("Tag", i.toString())
        }
        // in 表示检查区间之内的成员 !in 表示它的逆运算, ..语法还可以用来创造字符区间
        // in 检查语句也可以作为when 的分支表达式
        Log.e("Tag", "a in g~z=="+{'a' in 'g'..'z'} )
    }

    /**
     * if是表达式 不是语句，表达式有值，并且能作为另一个表达式的一部分使用，
     * 语句总是包围着它的代码块中的顶层元素，并且没有自己的值
     * 在Java中所有的控制结构都是语句，Kotlin中除了循环（for，while,do/while）外大多数控制结构都是表达式
     * Java中的赋值是表达式，在Kotlin中是语句，这样有助于避免比较和赋值之间的混淆
     * Kotlin中的异常中 throw结构也是表达式，同时Kotlin不区分是否受检异常，因此不用指定函数抛出的异常
     */
    fun funSupplement(){

    }

}
