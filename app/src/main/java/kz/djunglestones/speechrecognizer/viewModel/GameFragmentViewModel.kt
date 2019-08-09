package kz.djunglestones.speechrecognizer.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kz.djunglestones.speechrecognizer.network.Animal
import kz.djunglestones.speechrecognizer.network.AnimalApi


enum class AnimalApiStatus{
    LOADING, ERROR, DONE
}

class GameFragmentViewModel : ViewModel(){



    private val _status = MutableLiveData<AnimalApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<AnimalApiStatus>
        get() = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsProperty
    // with new values
    private val _animals = MutableLiveData<List<Animal>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val animals: LiveData<List<Animal>>
        get() = _animals

    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private fun getAnimals(){
        coroutineScope.launch {
            var getAnimalsDeferred = AnimalApi.retrofitService.getAnimals()
            try {
                _status.value = AnimalApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                val listResult = getAnimalsDeferred.await()
                _status.value = AnimalApiStatus.DONE
                _animals.value = listResult
            }catch (e: Exception){
                _status.value = AnimalApiStatus.ERROR
                _animals.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
