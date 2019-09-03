package app.delivery.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import app.delivery.repository.database.DbRepository
import app.delivery.ui.list.ListActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var dbRepository: DbRepository

    @Inject
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        dbRepository.deleteDeliveryData()
        handler.postDelayed({
            startActivity(Intent(this, ListActivity::class.java))
            finish()
        }, 2000)
    }
}