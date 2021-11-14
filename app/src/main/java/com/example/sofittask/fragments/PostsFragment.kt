package com.example.sofittask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.sofittask.adapters.PostsAdapter
import com.example.sofittask.databinding.FragmentPostsBinding
import com.example.sofittask.models.Post
import com.example.sofittask.network.RetroService
import com.example.sofittask.repositories.PostRepository
import com.example.sofittask.utils.showToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import com.example.sofittask.utils.isVisible
import com.example.sofittask.viewmodels.PostViewModel
import com.example.sofittask.viewmodels.PostViewModelFactory

class PostsFragment : Fragment() {
    private lateinit var postRepository: PostRepository
    private lateinit var postViewModel: PostViewModel
    private lateinit var fragmentPostsBinding: FragmentPostsBinding
    private val adapter = PostsAdapter()
    private lateinit var retroService: RetroService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentPostsBinding = FragmentPostsBinding.inflate(inflater, container, false)
        return fragmentPostsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retroService = RetroService.getInstance()
        postRepository = PostRepository(retroService)
        postViewModel = ViewModelProvider(
            this,
            PostViewModelFactory(postRepository)
        ).get(PostViewModel::class.java)

        fragmentPostsBinding.postsRecyclerView.adapter = adapter
        fragmentPostsBinding.postsRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireActivity(),
                DividerItemDecoration.VERTICAL
            )
        )



        postViewModel.loading.observe(viewLifecycleOwner,{
            if(it){
                fragmentPostsBinding.postsRecyclerView.isVisible(false)
                fragmentPostsBinding.progressBar.isVisible(true)
            }else{
                fragmentPostsBinding.postsRecyclerView.isVisible(true)
                fragmentPostsBinding.progressBar.isVisible(false)
            }
        })

        postViewModel.post.observe(viewLifecycleOwner,{
            adapter.setAllPosts(it)
        })

        postViewModel.error.observe(viewLifecycleOwner,{
            showToast(it)
        })

        postViewModel.getAllPosts()
    }

}