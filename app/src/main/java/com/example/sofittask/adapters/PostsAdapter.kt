package com.example.sofittask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sofittask.databinding.AdapterPostBinding
import com.example.sofittask.models.Post

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    var posts: List<Post> = ArrayList()

    fun setAllPosts(posts:List<Post>){
        this.posts = posts
        notifyDataSetChanged()
    }

    class PostsViewHolder(val adapterPostBinding: AdapterPostBinding):RecyclerView.ViewHolder(adapterPostBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterPostBinding.inflate(inflater,parent,false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = posts[position]
        holder.adapterPostBinding.title.text = post.title
        holder.adapterPostBinding.body.text = post.body
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}