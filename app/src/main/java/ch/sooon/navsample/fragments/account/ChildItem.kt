package ch.sooon.navsample.fragments.account

import com.chad.library.adapter.base.entity.AbstractExpandableItem
import com.chad.library.adapter.base.entity.MultiItemEntity



data class ChildItem(var title: String, var subTitle: String) : AbstractExpandableItem<String>(), MultiItemEntity {

    override fun getItemType(): Int {
        return ExpandableItemAdapter.TYPE_CHILD
    }

    override fun getLevel(): Int {
        return 1
    }
}
