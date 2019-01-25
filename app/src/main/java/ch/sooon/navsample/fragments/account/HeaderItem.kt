package ch.sooon.navsample.fragments.account

import com.chad.library.adapter.base.entity.AbstractExpandableItem
import com.chad.library.adapter.base.entity.MultiItemEntity


data class HeaderItem(var title: String, var subTitle: String) : AbstractExpandableItem<ChildItem>(), MultiItemEntity {

    override fun getItemType(): Int {
        return ExpandableItemAdapter.TYPE_HEADER
    }

    override fun getLevel(): Int {
        return 0
    }
}
