package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel : ViewModel(){

    private val _users = MutableLiveData<List<User>>(
        listOf(
            User("dummy", "dummy@a.com"),
//            User("test","email")
        )
    )
    val users: LiveData<List<User>> = _users

    fun insertOneUser() = viewModelScope.launch {
        var placeholder = users.value!!.toMutableList()
        placeholder.add(
            User("test","test@a.com")
        )
        /*
        listof (
        User("dummy", "dummy@a.com"),
        User("test","test@a.com"),
        )
         */
        _users.value = placeholder

    }
}