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
    private val _pos = MutableLiveData<Int>().apply {
        value = 0
    }

    val pos : LiveData<Int>
        get() = _pos



    private val _status = MutableLiveData<AnimalApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<AnimalApiStatus>
        get() = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsProperty
    // with new values
    private val _animals = MutableLiveData<List<Animal>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    private val _animal = MutableLiveData<Animal>()
    val animal: LiveData<Animal>
        get() =  _animal

    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getAnimals()
    }

    private fun getAnimals(){
        coroutineScope.launch {
            val getAnimalsDeferred = AnimalApi.retrofitService.getAnimals()
            try {
                _status.value = AnimalApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                val listResult = getAnimalsDeferred.await()
                _status.value = AnimalApiStatus.DONE
                _animals.value = listResult
                _animal.value = listResult.get(0)
            }catch (e: Exception){
                _status.value = AnimalApiStatus.ERROR
                _animals.value = ArrayList()
            }
        }
    }

    fun incrementPos(){
        _pos.value?.let { a->
            if (a<22){
                _pos.value = a+1
                _animal.value = _animals.value?.get(_pos.value!!.toInt())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
