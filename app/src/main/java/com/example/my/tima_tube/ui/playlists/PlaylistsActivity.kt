package com.example.my.tima_tube.ui.playlists

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.my.tima_tube.core.ext.ConnectionLiveData
import com.example.my.tima_tube.core.ui.BaseActivity
import com.example.my.tima_tube.databinding.ActivityPlaylistsBinding
import com.example.my.tima_tube.result.Status
import com.example.my.tima_tube.ui.detail.DetailActivity
import com.example.my.tima_tube.ui.playlists.adapter.PlaylistAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.my.tima_tube.data.remote.model.Item as Item1

class PlaylistsActivity : BaseActivity<ActivityPlaylistsBinding, PlaylistsViewModel>() {

    private var adapter = PlaylistAdapter(this::onClick)

    override val viewModel: PlaylistsViewModel by viewModel()

    override fun checkConnection() {
        super.checkConnection()
        ConnectionLiveData(application).observe(this) { isConnected ->
            if (isConnected) {
                binding.noInternetConnection.visibility = View.GONE
                binding.internetConnection.visibility = View.VISIBLE
            } else {
                binding.noInternetConnection.visibility = View.VISIBLE
                binding.internetConnection.visibility = View.GONE
            }
        }
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.loading.observe(this) {
            binding.progressBar.isVisible = it
        }
        viewModel.playlists().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.recyclerView.adapter = adapter
                    it.data?.let { it1 -> adapter.setList(it1.items) }
                    viewModel.loading.postValue(false)
                }

                Status.LOADING -> {
                    viewModel.loading.postValue(true)
                }

                Status.ERROR -> {
                    viewModel.loading.postValue(false)
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun inflateViewBinding(): ActivityPlaylistsBinding {
        return ActivityPlaylistsBinding.inflate(layoutInflater)
    }

    private fun onClick(item: Item1) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", item.id)
        intent.putExtra("title", item.snippet.title)
        intent.putExtra("desc", item.snippet.description)
        intent.putExtra("count", item.contentDetails.itemCount)
        startActivity(intent)
    }

    companion object {
        const val ID = "id"
    }

}