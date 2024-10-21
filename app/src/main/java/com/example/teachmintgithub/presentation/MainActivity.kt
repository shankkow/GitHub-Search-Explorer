package com.example.teachmintgithub.presentation


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmenttrial1.presentation.ViewModel.ContributorViewModel
import com.example.assignmenttrial1.presentation.adapter.ContributorAdapter
import com.example.teachmintgithub.presentation.ViewModel.ContributorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var contributorRecyclerView: RecyclerView
    private lateinit var contributorAdapter: ContributorAdapter
    private val contributorViewModel: ContributorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contributorRecyclerView = findViewById(R.id.recycler_view_contributors)
        contributorRecyclerView.layoutManager = LinearLayoutManager(this)
        contributorAdapter = ContributorAdapter(this, mutableListOf())
        contributorRecyclerView.adapter = contributorAdapter

        contributorViewModel.contributors.observe(this) { contributors ->
            contributorAdapter.updateData(contributors)
        }

        contributorViewModel.fetchContributors("owncloud", "android", 0) // Initial fetch
    }
}
