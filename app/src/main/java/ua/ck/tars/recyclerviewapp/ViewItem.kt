package ua.ck.tars.recyclerviewapp

import androidx.annotation.LayoutRes

sealed class ViewItem(@LayoutRes val layoutResource: Int) {

    class TitleView(val title: String) : ViewItem(R.layout.adapter_item_text)
    class ImageView() : ViewItem(R.layout.adapter_item_image)

}