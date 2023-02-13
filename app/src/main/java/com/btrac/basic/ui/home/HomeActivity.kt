package com.btrac.basic.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.btrac.basic.data.ApiService
import com.btrac.basic.databinding.ActivityHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

  private lateinit var binding: ActivityHomeBinding
  private lateinit var productAdapter: ProductListAdapter
  private lateinit var layoutManager: LayoutManager

  private val apiService by lazy {
    ApiService.create()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    super.onCreate(savedInstanceState)

    binding = ActivityHomeBinding.inflate(layoutInflater)
    setContentView(binding.root)
    // setSupportActionBar(binding.toolbar)

    productAdapter = ProductListAdapter()
    layoutManager = LinearLayoutManager(this@HomeActivity)

    binding.rvProduct.apply {
      layoutManager = this@HomeActivity.layoutManager
      adapter = productAdapter
    }

    // lifecycleScope.launch(Dispatchers.IO) {
    //   val products = apiService.getProducts()
    //
    //   launch(Dispatchers.Main) {
    //     productAdapter.addDataToList(products)
    //   }
    // }
  }
}