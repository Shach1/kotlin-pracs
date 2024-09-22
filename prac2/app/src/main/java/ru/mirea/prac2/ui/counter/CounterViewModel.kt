package ru.mirea.prac2.ui.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mirea.prac2.data.model.Counter
import ru.mirea.prac2.data.repository.CounterRepository

class CounterViewModel : ViewModel()
{
    private val counterRepository = CounterRepository()

    private val _counter = MutableLiveData<Counter>()
    val counter: LiveData<Counter> get() = _counter

    init {
        fetchCounter()
    }

    fun fetchCounter(){
        _counter.value = counterRepository.getCounter()
    }
    fun plusOne () {
        counterRepository.plusOne()
        fetchCounter()
    }
    fun minusOne() {
        counterRepository.minusOne()
        fetchCounter()
    }
    fun multiplyByTwo() {
        counterRepository.multiplyByTwo()
        fetchCounter()
    }
}