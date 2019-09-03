package app.delivery.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import app.delivery.di.viewmodel.ViewModelProviderFactory
import dagger.android.AndroidInjection
import javax.inject.Inject


abstract class BaseActivity<B : ViewDataBinding, M : ViewModel> :
    AppCompatActivity() {
    protected lateinit var binding: B
    protected lateinit var modelData: M
    @LayoutRes
    abstract fun getLayoutId(): Int

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModelProvider: ViewModelProvider

    abstract fun getViewModel(): M

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initializeData()
    }

    private fun initializeData() {
        viewModelProvider = ViewModelProviders.of(this, factory)
        modelData = getViewModel()
        val layoutId = getLayoutId()
        if (layoutId != 0)
            binding = DataBindingUtil.setContentView(this, layoutId)
    }

    fun showToastWithAction(@StringRes message: Int, retry: Int) {
        showToastWithAction(getString(message), getString(retry))
    }

    abstract fun showToastWithAction(message: String, retry: String)
}