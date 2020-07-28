package com.codingapps.newsarticle.repository

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import com.codingapps.newsarticle.api.RetrofitBuilder
import com.codingapps.newsarticle.model.Topic
import com.codingapps.newsarticle.persistence.FactDatabase
import kotlinx.coroutines.*

class Repository constructor(val application: Application) {
    companion object {
        fun createDB(application: Application) = FactDatabase.invoke(application)
    }

    //vars
    private val TAG = "Repository"
    private val factDatabase: FactDatabase? = createDB(application)
    var job: CompletableJob? = null
    var topic: Topic? = null

    suspend fun insertFactsIntoDB(topic: Topic) {
        coroutineScope {
            val job: Job = launch(Dispatchers.IO) {
                factDatabase?.getFactDao()?.saveTopic(topic)
            }
        }
    }

    suspend fun getFactsFromDB(): Topic? {
        return coroutineScope {
            val facts = async(Dispatchers.IO) { factDatabase?.getFactDao()?.loadTopic() }
            facts.await()
        }
    }

    suspend fun getTopics(): Topic? {
        topic = getFactsFromDB()
        if (topic == null) {
            if (isNetworkConnected()) {
                val topicNetwork = getFactsFromNetwork()
                if (topicNetwork.rows != null) {
                    insertFactsIntoDB(topicNetwork)
                }
                topic = getFactsFromDB()
                Log.d(TAG, "getfacts: facts = ${topic}")
                return topic
            } else {
                topic = null
                return topic
            }
        } else {
            topic = getFactsFromDB()
            /*if (isNetworkConnected()) {
                val topicNetwork = getFactsFromNetwork()
                if (topicNetwork.rows != null) {
                    insertFactsIntoDB(topicNetwork)
                }
                topic = getFactsFromDB()
                Log.d(TAG, "getfacts: facts = ${topic}")
                return topic
            }*/
            return topic
        }
        return topic
    }

    suspend fun getFactsFromNetwork(): Topic {
        return coroutineScope {
            val topic = async(Dispatchers.IO) { RetrofitBuilder.apiService.getFacts() }
            topic.await()
        }

    }

    fun cancelJobs() {
        job?.cancel()
    }

    fun isNetworkConnected(): Boolean {
        val connectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnected == true
        return isConnected
    }
}