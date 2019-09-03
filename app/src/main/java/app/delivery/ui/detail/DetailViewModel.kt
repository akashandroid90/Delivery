package app.delivery.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.delivery.model.DeliveriesData
import javax.inject.Inject


class DetailViewModel @Inject constructor() : ViewModel() {
    var data: MutableLiveData<DeliveriesData> = MutableLiveData()

    fun setDeliveryDataValue(value: DeliveriesData) {
        data.value = value
    }

    override fun onCleared() {
        data.value = null
        super.onCleared()
    }
}