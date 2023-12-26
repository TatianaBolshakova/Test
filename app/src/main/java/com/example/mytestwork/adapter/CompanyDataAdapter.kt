package com.example.mytestwork.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.mytestwork.data.constant.Constants
import com.example.mytestwork.domain.list.ListData
import com.example.mytestwork.viewholder.CompanyVH
import com.example.mytestwork.viewholder.RoomVH
import com.example.mytestwork.viewholder.SiteVH
import com.example.mytestwork.databinding.CompanyRowBinding
import com.example.mytestwork.databinding.RoomRowBinding
import com.example.mytestwork.databinding.SiteRowBinding
import com.example.mytestwork.domain.model.CompanyData
import com.example.mytestwork.domain.model.FirstItem
import com.example.mytestwork.domain.model.SecondItem


class CompanyDataAdapter(

    private val onClick: (SecondItem) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var data = ListData.listData
    fun setData(data: List<CompanyData>) {
        this.data = data

        notifyDataSetChanged()



    }
    private var companyDataList = data.toMutableList()
    private var textFirst = FirstItem()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == Constants.COMPANY) {
            return CompanyVH(
                CompanyRowBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
        return if (viewType == Constants.ROOM) {
            RoomVH(
                RoomRowBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

        } else SiteVH(
            SiteRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = companyDataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val data = companyDataList.getOrNull(position)
        if (data?.type == Constants.COMPANY) {
            holder as CompanyVH
            holder.binding.apply {
                parentTitle.text = data.title
                companyRow.setOnClickListener {
                    if (data.isExpanded) {
                        collapseParentRow(position)
                        downCompanyIv.setImageResource(com.example.mytestwork.R.drawable.ic_next)
                        companyRow.setBackgroundColor(Color.parseColor("#6A7180"))
                    } else {
                        expandParentRow(position)
                        downCompanyIv.setImageResource(com.example.mytestwork.R.drawable.ic_expand)
                        companyRow.setBackgroundColor(Color.parseColor("#598D9B"))
                    }
                }
            }
        }

        if (data?.type == Constants.ROOM) {

            holder as RoomVH
            holder.binding.apply {
                textFirst = data.items.first()
                roomTitle.text = textFirst.title
                roomRow.setOnClickListener {
                    if (data.isExpanded) {
                        collapseRow(position)
                        downIv.setImageResource(com.example.mytestwork.R.drawable.ic_next)
                        roomRow.setBackgroundColor(Color.parseColor("#6A7180"))
                    } else {
                        expandRow(position)
                        downIv.setImageResource(com.example.mytestwork.R.drawable.ic_expand)
                        roomRow.setBackgroundColor(Color.parseColor("#598D9B"))

                    }
                }
            }
        } else if (data?.type == Constants.SITE) {
            holder as SiteVH
            holder.binding.apply {
                val textSecond = textFirst.items.first()
                siteTitle.text = textSecond.title
                siteRow.setOnClickListener {
                    onClick(textSecond)
                }
            }
        }
    }

    private fun expandParentRow(position: Int) {
        val currentRow = companyDataList[position]
        currentRow.isExpanded = true
        var nextPosition = position
        currentRow.items.forEach { row ->
            val companyData = CompanyData()
            companyData.type = Constants.ROOM
            val firstItemsList: ArrayList<FirstItem> = ArrayList()
            firstItemsList.add(row)
            companyData.items = firstItemsList
            companyDataList.add(++nextPosition, companyData)
        }
        notifyDataSetChanged()
    }

    private fun expandRow(position: Int) {
        val currentRow = companyDataList[position]
        currentRow.isExpanded = true
        var nextPosition = position
        currentRow.items.forEach {
            it.items.forEach { row ->
                val companyData = CompanyData()
                companyData.type = Constants.SITE
                val secondItemsList: ArrayList<SecondItem> = ArrayList()
                secondItemsList.add(row)
                companyData.items.getOrNull(position)?.items = secondItemsList
                companyDataList.add(++nextPosition, companyData)
            }
        }
        notifyDataSetChanged()
    }

    private fun collapseParentRow(position: Int) {
        companyDataList[position].isExpanded = false
        companyDataList[position].items.forEach { _ ->
            companyDataList.removeAt(position + 1)
        }
        notifyDataSetChanged()
    }

    private fun collapseRow(position: Int) {
        companyDataList[position].isExpanded = false
        companyDataList[position].items.forEach {
            it.items.forEach { _ ->
                companyDataList.removeAt(position + 1)
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int = companyDataList[position].type

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}