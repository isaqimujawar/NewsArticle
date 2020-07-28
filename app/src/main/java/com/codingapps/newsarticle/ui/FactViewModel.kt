package com.codingapps.newsarticle.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.codingapps.newsarticle.model.Topic
import com.codingapps.newsarticle.repository.Repository
import kotlinx.coroutines.launch

class FactViewModel(application: Application) : ViewModel() {
    private val repository: Repository = Repository(application)
    private val TAG = "FactViewModel"
    private var topic: LiveData<Topic?>? = null

    init {
        Log.d(TAG, "init viewmodel: called")
        viewModelScope.launch {
            loadfacts()
        }
    }

    fun loadfacts() {
        this.topic = liveData {
            emit(repository.getTopics())
        }
    }

    fun getfacts(): LiveData<Topic?>? {
        return this.topic
    }

    fun cancelJobs() {
        repository.cancelJobs()
    }
}