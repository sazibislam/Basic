package com.btrac.basic.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.btrac.basic.databinding.ActivityHomeBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HomeActivity : AppCompatActivity() {

  private lateinit var binding: ActivityHomeBinding
  private lateinit var productAdapter: ProductListAdapter
  private lateinit var layoutManager: LayoutManager

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

    // val viewModel: HomeViewModel = getViewModel()

    // viewModel.getHomeData()

    // viewModel.homeDataList.observe(this) { response_ ->
    //   Log.d("home_screen", "$response_")
    // }
  }
}