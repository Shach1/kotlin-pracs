package ru.mirea.prac2.data.repository

import ru.mirea.prac2.data.model.Counter

class CounterRepository
{
    private val counter = Counter()

    fun getCounter():Counter {return counter}
    fun plusOne () {counter.plusOne()}
    fun minusOne() {counter.minusOne()}
    fun multiplyByTwo() {counter.multiplyByTwo()}
}