package app.delivery.ui.list

import androidx.paging.PagedList
import app.delivery.model.DeliveriesData
import app.delivery.repository.network.NetworkRepository
import javax.inject.Inject

class DeliveryBoundryCallBack @Inject constructor(private val appRepository: NetworkRepository) :
    PagedList.BoundaryCallback<DeliveriesData>() {

    override fun onZeroItemsLoaded() {
        appRepository.getDataFromApi(true,0)
    }

    override fun onItemAtEndLoaded(itemAtEnd: DeliveriesData) {
        appRepository.getDataFromApi(false,itemAtEnd.id + 1)
    }
}