package ch.sooon.navsample.fragments.account


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import ch.sooon.navsample.R
import com.chad.library.adapter.base.entity.MultiItemEntity
import kotlinx.android.synthetic.main.fragment_account.*
import java.util.*


class AccountFragment : Fragment() {
    private lateinit var list: ArrayList<MultiItemEntity>
    private lateinit var adapter: ExpandableItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = generateData()


        adapter = ExpandableItemAdapter(list)
        recyclerView.adapter = adapter

        val manager = GridLayoutManager(view.context, 3)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (adapter.getItemViewType(position) == ExpandableItemAdapter.TYPE_PERSON) 1 else manager.spanCount
            }
        }

        // important! setLayoutManager should be called after setAdapter
        recyclerView.layoutManager = manager
    }

    companion object {
        fun newInstance() = AccountFragment()
    }

    private fun generateData(): ArrayList<MultiItemEntity> {
        val lv0Count = 9
        val lv1Count = 3
        val lv2Count = 5

        val nameList = arrayOf("Bob", "Andy", "Lily", "Brown", "Bruce")
        val random = Random()

        val res = ArrayList<MultiItemEntity>()
        for (i in 0 until lv0Count) {
            val headerItem = HeaderItem("This is " + i + "th item in Level 0", "subtitle of " + i)
            for (j in 0 until lv1Count) {
                val childItem = ChildItem("Level 1 item: " + j, "(no animation)")
                headerItem.addSubItem(childItem)
            }
            res.add(headerItem)
        }
        return res
    }
}
