package ru.mirea.prac2.data.model

class Counter
{
    private var count: Int = 0
    fun plusOne (){count++}
    fun minusOne(){count--}
    fun multiplyByTwo(){count *= 2}
    fun getCount():Int {return count}
}