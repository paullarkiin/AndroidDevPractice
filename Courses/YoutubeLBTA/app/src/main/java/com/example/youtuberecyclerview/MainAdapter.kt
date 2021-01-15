package com.example.youtuberecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

// mainAdapter now holds a constructor for a publicly accessable homefeed parameter
class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    val videoTitles = listOf("First", "second", "3rd")

    //numberOfItems
    override fun getItemCount(): Int {
       return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //val videoTitle = videoTitles.get(index = position)
        val video = homeFeed.videos.get(position)
        holder.itemView.textView_video_title?.text = video.name
        holder.itemView.textView_channel_name.text = video.channel.name + "\n20K Views  •  4 days ago"

        val thumbnailImageView = holder.itemView.imageView2_Thumbnail
        Picasso.get().load(video.imageUrl).into(thumbnailImageView);

        val channelProfile = holder.itemView.imageView_profile
        Picasso.get().load(video.channel.profileImageUrl).into(channelProfile);

        holder.video = video


    }
}
// manages the view for each one of your rows
class CustomViewHolder(val view: View, var video: Video? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val VIDEO_TITLE_KEY = "Video Title"
        val VIDEO_ID_KEY = "Video Title"
    }

    init {
        view.setOnClickListener{
            val intent = Intent(view.context, CourseDetailsActivity::class.java)

            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)

            view.context.startActivity(intent)
        }
    }
}