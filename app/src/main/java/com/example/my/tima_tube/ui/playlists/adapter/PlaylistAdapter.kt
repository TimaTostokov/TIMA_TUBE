package com.example.my.tima_tube.ui.playlists.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.my.tima_tube.databinding.ItemPlaylistsBinding
import com.example.my.tima_tube.dataremote.model.Item

class PlaylistAdapter(private val onClick: (item: Item) -> Unit) :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Item>) {
        this.list = list as ArrayList<Item>
        notifyDataSetChanged()
    }

    private var list = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class PlaylistViewHolder(private val binding: ItemPlaylistsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Item) {
            binding.image.load(item.snippet.thumbnails.default.url)
            binding.tvTitle.text = item.snippet.title
            binding.tvVideo.text = "${item.contentDetails.itemCount} video"

            itemView.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }

}