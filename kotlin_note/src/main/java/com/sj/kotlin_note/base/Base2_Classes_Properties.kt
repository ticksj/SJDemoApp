package com.sj.kotlin_note.base

/**
 * 类与属性
 * Created by SJ on 2019/9/18.
 */
object Base2_Classes_Properties {
    /**
     * 关于Java kotlin 异同
     * 1. 省略了getter setter方法，实际上声明属性也就声明了getter setter方法
     *    1.1 直接对象.属性 便可以取值赋值，同时也可以自定义访问器
     *    1.2 val声明的属性只能getter 没有setter，为只读属性
     * 2. 不使用new来实例化
     * 3. 类名后的括号为构造方法，可在当中使用val，var声明属性，也可传参后在内部声明属性
     * 类声明的各种方式
     */
    fun fun0() {
        var teacher = Teacher("SJ", 25)
        teacher.age = 26
        var age = teacher.age
    }

    /**
     * 各种特殊类的定义与创建
     * 1. 枚举类
     * 2. 数据类
     */
    fun fun1(){
        println("I like ${SubjectEnum.BIOLOGY.n}")
        println("I like ${SubjectData("生物").name}")
    }

    fun fun2(){

    }

}

class Teacher(val name: String,age:Int) {
    var age = age
    val personalInformation: String
        get() {
           return "Teacher's name is $name,age is $age"
        }
}

/**
 * 枚举类
 */
enum class SubjectEnum(val n:String){
    CHINESE("语文"),
    MATH("数学"),
    ENGLISH("英语"),
    PHYSICS("物理"),
    CHEMISTRY("化学"),
    BIOLOGY("生物")
}
/**
 * 数据类
 */
data class SubjectData(val name:String)