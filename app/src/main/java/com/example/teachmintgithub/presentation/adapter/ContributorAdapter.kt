package com.example.assignmenttrial1.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmenttrial1.R
import com.example.assignmenttrial1.data.local.ContributorEntity

class ContributorAdapter(
    private val context: Context,
    private var contributors: List<ContributorEntity>
) : RecyclerView.Adapter<ContributorAdapter.ContributorViewHolder>() {

    inner class ContributorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contributorImage: ImageView = view.findViewById(R.id.contributor_image)
        val contributorName: TextView = view.findViewById(R.id.contributor_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_contributor_item, parent, false)
        return ContributorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContributorViewHolder, position: Int) {
        val contributor = contributors[position]
        holder.contributorName.text = contributor.login
        Glide.with(context)
            .load(contributor.avatar_url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.contributorImage)
    }

    override fun getItemCount(): Int {
        return contributors.size
    }

    fun updateData(newContributors: List<ContributorEntity>) {
        contributors = newContributors
        notifyDataSetChanged()
    }
}
