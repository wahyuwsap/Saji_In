package com.saji_in.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SharedViewModel : ViewModel() {
    private val _lovedItems = MutableLiveData<List<FoodItem>>(emptyList())
    val lovedItems: LiveData<List<FoodItem>> get() = _lovedItems

    fun toggleLove(item: FoodItem) {
        val currentList = _lovedItems.value?.toMutableList() ?: mutableListOf()
        if (currentList.contains(item)) {
            currentList.remove(item)
        } else {
            currentList.add(item)
        }
        _lovedItems.value = currentList
    }
}
