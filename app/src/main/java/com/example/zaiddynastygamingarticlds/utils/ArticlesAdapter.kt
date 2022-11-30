package com.example.zaiddynastygamingarticlds.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zaiddynastygamingarticlds.R
import com.example.zaiddynastygamingarticlds.data.remote.responses.Article
import kotlinx.android.synthetic.main.articles_adapter.view.*

class ArticlesAdapter: RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>()  {

    inner class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    private val differentCallback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differentCallback)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.articles_adapter,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.image).into(ivArticleImage)
            tvTitle.text = article.title.english
            val author = article.author.username
            val createdDate = DateUtils.dateFormatter(article.createdDate)
            val description = "$author • $createdDate"
            tvDescription.text = description
            }
        }
}