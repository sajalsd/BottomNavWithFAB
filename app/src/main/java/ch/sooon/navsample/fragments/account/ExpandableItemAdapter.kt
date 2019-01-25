package ch.sooon.navsample.fragments.account

import android.animation.Animator
import android.view.View
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import ch.sooon.navsample.R
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity


class ExpandableItemAdapter(data: List<MultiItemEntity>): BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder>(data) {
    init {
        addItemType(TYPE_HEADER, R.layout.item_expandable_lv0)
        addItemType(TYPE_CHILD, R.layout.item_expandable_lv1)

    }

    override fun convert(helper: BaseViewHolder, item: MultiItemEntity) {
        when (helper.itemViewType) {
            TYPE_HEADER -> {
                val header = item as HeaderItem
                helper.setText(R.id.title, header.title)
                    .setText(R.id.sub_title, header.subTitle)
                    .setImageResource(R.id.iv, if (header.isExpanded) R.drawable.arrow_b else R.drawable.arrow_r)

                val imageIcon = helper.itemView.findViewById<View>(R.id.iv)

                helper.itemView.setOnClickListener {
                    val pos = helper.adapterPosition
                    if (header.isExpanded) {
                        val animation = imageIcon.animate()
                            .rotation(-90F)
                            .setDuration(500)
                            .setInterpolator(FastOutSlowInInterpolator())

                        animation.setListener(object : Animator.AnimatorListener{
                            override fun onAnimationRepeat(animation: Animator?) {

                            }

                            override fun onAnimationEnd(animation: Animator?) {
                                collapse(pos)
//                                imageIcon.rotation = 0F
                            }

                            override fun onAnimationCancel(animation: Animator?) {

                            }

                            override fun onAnimationStart(animation: Animator?) {

                            }
                        })


                    } else {
                        val animation = imageIcon.animate()
                            .rotation(90F)
                            .setDuration(500)
                            .setInterpolator(FastOutSlowInInterpolator())

                        animation.setListener(object : Animator.AnimatorListener{
                            override fun onAnimationRepeat(animation: Animator?) {

                            }

                            override fun onAnimationEnd(animation: Animator?) {
//                                imageIcon.rotation = 0F
                                expand(pos)
                            }

                            override fun onAnimationCancel(animation: Animator?) {

                            }

                            override fun onAnimationStart(animation: Animator?) {

                            }
                        })

                    }
                }
            }
            TYPE_CHILD -> {
                val childItem = item as ChildItem
                helper.setText(R.id.title, childItem.title)
                    .setText(R.id.sub_title, childItem.subTitle)
                    .setImageResource(R.id.iv, if (childItem.isExpanded) R.drawable.arrow_b else R.drawable.arrow_r)
            }
        }
    }

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_CHILD = 1
        const val TYPE_PERSON = 2
    }
}