package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var carItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = repositories[position]
        holder.repositoryNameTv.text = repository.name
        holder.shareIcon.setOnClickListener {
            btnShareLister(repository)
        }
        holder.repositoryCard.setOnClickListener {
            carItemLister(repository)
        }
    }

    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val repositoryNameTv : TextView
        val shareIcon : ImageView
        val repositoryCard : CardView

        init {
            view.apply {
                repositoryNameTv = findViewById(R.id.tv_repository_name)
                shareIcon = findViewById(R.id.iv_share)
                repositoryCard = findViewById(R.id.cv_repository)
            }
        }

    }
}


