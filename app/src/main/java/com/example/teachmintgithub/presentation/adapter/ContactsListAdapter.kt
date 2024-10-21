package com.example.assignmenttrial1.presentation.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmenttrial1.ContactItem
import com.example.assignmenttrial1.R
import com.example.assignmenttrial1.presentation.RepoDetailsActivity

class ContactListAdapter(
    private val context: Context,
    private val listOfContacts: List<ContactItem>
) : RecyclerView.Adapter<ContactListAdapter.ContactListViewHolder>() {

    class ContactListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val textHeading: TextView = view.findViewById(R.id.text_heading)
        val textSubHeading: TextView = view.findViewById(R.id.text_sub_heading)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_rv_item, parent, false)
        return ContactListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        val contact = listOfContacts[position]
        holder.image.setImageResource(contact.imageRes)
        holder.textHeading.text = contact.headingText
        holder.textSubHeading.text = contact.textSubHeading

        // Load the avatar image using Glide
        Glide.with(holder.itemView.context)
            .load(contact.avatarUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.image)

        // Set click listener for the item
        holder.itemView.setOnClickListener {
            val intent = Intent(context, RepoDetailsActivity::class.java).apply {
                putExtra("imageUrl", contact.avatarUrl)
                putExtra("name", contact.headingText)
                putExtra("link", contact.htmlUrl) // Use html_url for the project link
                putExtra("description", contact.subHeading)
                // You can add the real owner and repo here if available
                putExtra("owner", "YourRepoOwner") // Replace with actual owner
                putExtra("repo", "YourRepoName") // Replace with actual repo name
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listOfContacts.size
    }
}
