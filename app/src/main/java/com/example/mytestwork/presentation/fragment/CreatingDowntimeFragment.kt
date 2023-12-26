package com.example.mytestwork.presentation.fragment

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mytestwork.R
import com.example.mytestwork.data.constant.Constants
import com.example.mytestwork.data.shared.Shared
import com.example.mytestwork.databinding.FragmentCreatingDowntimeBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.Locale


class CreatingDowntimeFragment : Fragment() {

    private var _binding: FragmentCreatingDowntimeBinding? = null
    private val binding get() = _binding!!
    private val calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat(Constants.DATE_FORMAT, Locale.US)
    private val timeFormat = SimpleDateFormat(Constants.TIME_FORMAT, Locale.US)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreatingDowntimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Shared.pref = this.activity?.getSharedPreferences(Constants.NAME_PREF, Context.MODE_PRIVATE)
        Shared.sitePref =
            this.activity?.getSharedPreferences(Constants.NAME_SITE_PREF, Context.MODE_PRIVATE)

        initMyCardView()
        initDate()
        initTime()
    }

    private fun initMyCardView() {
        binding.apply {
            val site = Shared.sitePref?.getString(Constants.KEY_SITE, Constants.DEF_SITE)!!
            cardViewSite.setSignatureText(getString(R.string.site))
            cardViewSite.setTitleText(site)
            cardViewSite.setOnClickListener {
                findNavController().navigate(R.id.DepartmentSelectionFragment)
            }
            cardViewPlace.setSignatureText(getString(R.string.place))
            cardViewPlace.setTitleText(getString(R.string.empty_string))
            cardViewPlace.setOnClickListener {
                Snackbar.make(it, R.string.place, Snackbar.LENGTH_LONG).show()
            }
            cardViewDowntimeType.setSignatureText(getString(R.string.type_downtime))
            cardViewDowntimeType.setTitleText(getString(R.string.empty_string))
            cardViewDowntimeType.setOnClickListener {
                Snackbar.make(it, R.string.type_downtime, Snackbar.LENGTH_LONG).show()
            }
            cardViewAddDowntimeReason.setSignatureText(getString(R.string.add_downtime_reason))
            cardViewAddDowntimeReason.setTitleText(getString(R.string.empty_string))
            cardViewAddDowntimeReason.setOnClickListener {
                Snackbar.make(it, R.string.add_downtime_reason, Snackbar.LENGTH_LONG).show()
            }
            cardViewAddEquipment.setSignatureText(getString(R.string.add_equipment))
            cardViewAddEquipment.setTitleText(getString(R.string.empty_string))
            cardViewAddEquipment.setOnClickListener {
                Snackbar.make(it, R.string.add_equipment, Snackbar.LENGTH_LONG).show()
            }
            buttonAddDowntime.setOnClickListener {
                Snackbar.make(it, R.string.button_add_downtime_text, Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun initDate() {
        binding.apply {
            val dateS =
                Shared.pref?.getString(Constants.KEY_START_DATE, dateFormat.format(calendar.time))!!
            startDate.setDateText(
                signatures = getString(R.string.data_start_signature),
                date = dateS
            )
            startDate.setOnClickListener {
                choiceStartDate()
            }
            val dateE =
                Shared.pref?.getString(
                    Constants.KEY_EXPIRATION_DATE,
                    dateFormat.format(calendar.time)
                )!!
            expirationDate.setDateText(
                signatures = getString(R.string.data_expiration_signature),
                date = dateE
            )
            expirationDate.setOnClickListener {
                choiceExpirationDate()
            }
        }
    }

    private fun choiceStartDate() {
        val dateDialog = MaterialDatePicker.Builder.datePicker()
            .setTitleText(resources.getString(R.string.data_start_title_text))
            .build()
        dateDialog.show(parentFragmentManager, "Date")
        dateDialog.addOnPositiveButtonClickListener { date ->
            calendar.timeInMillis = date
            val startDate = dateFormat.format(calendar.time)
            binding.startDate.setDateText(
                signatures = getString(R.string.data_start_signature),
                date = startDate
            )
            Shared.saveStartDate(startDate)
        }
    }

    private fun choiceExpirationDate() {
        val dateDialog = MaterialDatePicker.Builder.datePicker()
            .setTitleText(resources.getString(R.string.data_expiration_title_text))
            .build()
        dateDialog.show(parentFragmentManager, "Date")
        dateDialog.addOnPositiveButtonClickListener { date ->
            calendar.timeInMillis = date
            val expirationDate = dateFormat.format(calendar.time)
            binding.expirationDate.setDateText(
                signatures = getString(R.string.data_expiration_signature),
                date = expirationDate
            )
            Shared.saveExpirationDate(expirationDate)
        }
    }

    private fun initTime() {
        binding.apply {
            val timeS =
                Shared.pref?.getString(Constants.KEY_START_TIME, timeFormat.format(calendar.time))!!
            startTime.setTimeText(
                signatures = getString(R.string.time_start_signature),
                time = timeS
            )
            startTime.setOnClickListener {
                choiceStartTime()
            }
            val timeE =
                Shared.pref?.getString(
                    Constants.KEY_EXPIRATION_TIME,
                    timeFormat.format(calendar.time)
                )!!
            expirationTime.setTimeText(
                signatures = getString(R.string.time_expiration_signature),
                time = timeE
            )
            expirationTime.setOnClickListener {
                choiceExpirationTime()
            }
        }
    }

    private fun choiceStartTime() {
        val timeDialog = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setTitleText(resources.getString(R.string.time_start_title_text))
            .build().apply {
            }
        timeDialog.addOnPositiveButtonClickListener {
            calendar.set(Calendar.HOUR, timeDialog.hour)
            calendar.set(Calendar.MINUTE, timeDialog.minute)
            val startTime = timeFormat.format(calendar.time)
            binding.startTime.setTimeText(
                signatures = getString(R.string.time_start_signature),
                time = startTime
            )
            Shared.saveStartTime(startTime)
        }
        timeDialog.show(parentFragmentManager, "Time")
    }

    private fun choiceExpirationTime() {
        val timeDialog = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setTitleText(resources.getString(R.string.time_expiration_title_text))
            .build().apply {
            }
        timeDialog.addOnPositiveButtonClickListener {
            calendar.set(Calendar.HOUR, timeDialog.hour)
            calendar.set(Calendar.MINUTE, timeDialog.minute)
            val expirationTime = timeFormat.format(calendar.time)
            binding.expirationTime.setTimeText(
                signatures = getString(R.string.time_expiration_signature),
                time = expirationTime
            )
            Shared.saveExpirationTime(expirationTime)
        }
        timeDialog.show(parentFragmentManager, "Time")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}