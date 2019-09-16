package ua.ck.tars.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.adapter_item_text.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var items = listOf(
        ViewItem.TitleView("First"),
        ViewItem.ImageView(),
        ViewItem.TitleView("Second"),
        ViewItem.TitleView("Third"),
        ViewItem.ImageView()
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        // How get "Context" into "onBindViewHolder"
        // val context = holder.itemView.context

        when (val currentItem = items[position]) {
            is ViewItem.TitleView -> {
                holder.apply {
                    containerView.adapterItemText_textView_title.text = currentItem.title
                }
            }
            is ViewItem.ImageView -> {

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].layoutResource
    }

    inner class MainViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer
}