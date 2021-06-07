package org.sochidrive.weathersd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sochidrive.weathersd.model.Repository
import org.sochidrive.weathersd.model.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: Repository = RepositoryImpl()
) : ViewModel() {

    val liveData: LiveData<AppState>
        get() = liveDataToObserve

    fun getWeatherFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            val data = repository.getWeatherFromLocalStorage()

            liveDataToObserve.postValue(
                AppState.Success(data)
            )
        }.start()
    }
}