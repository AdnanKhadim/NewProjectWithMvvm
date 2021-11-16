package com.example.getstarted.utilities

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.getstarted.R
import com.google.gson.Gson
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class Helper {
    var baseUrl = "https://api.ciwac.com/"

    //    var socketUrl = "wss://http://api.ciwac.com/"
    val socketUrl = "wss://api.ciwac.com/socket/stream/?token="


    var language = 2


    fun removeFirstChar(s: String): String? {
        return s.substring(1)
    }

    fun showCalendar(activity: Context?, textView: TextView) {
        val c = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            activity!!,
            { view: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
                c[Calendar.YEAR] = year
                c[Calendar.MONTH] = month
                c[Calendar.DAY_OF_MONTH] = dayOfMonth
                textView.text = getFormattedDate(c.time, activity)
            },
            c[Calendar.YEAR],
            c[Calendar.MONTH],
            c[Calendar.DAY_OF_MONTH]
        )
//

///
        datePickerDialog.show()
        // Call once, the text change event will update it when user changes date...

    }
// date picker title change
//    var headerChangeFlag: Boolean = true
//    var headerTextView: TextView? = null
//    var headerDatePatternLocale: String? = null
//    var monthDayFormatLocale: SimpleDateFormat? = null


//    fun setHeaderMonthDay(
//        dialog: DatePickerDialog,
//        locale: Locale,
//        activity: Context,
//        c: Calendar
//    ) {
//        if (headerTextView == null) {
//
//            var id = activity.resources.getIdentifier("date_picker_header_date", "id", "android")
//            headerTextView = dialog.findViewById(id);
//
//            headerDatePatternLocale = android.text.format.DateFormat.getBestDateTimePattern(
//                Locale(locale.toString()),
//                "EMMMd"
//            )
//
//            monthDayFormatLocale = SimpleDateFormat(headerDatePatternLocale!!, locale)
//            headerTextView?.setTextColor(android.graphics.Color.WHITE);
//            headerTextView?.addTextChangedListener {
//                headerChangeFlag = !headerChangeFlag
//                if (!headerChangeFlag)
//                    return@addTextChangedListener
//                setHeaderMonthDay(dialog, locale, activity, c)
//            }
//        }


//        headerTextView?.setText(activity.getString(R.string.select_date))
//        val selectedDateLocale = monthDayFormatLocale?.format(c.time)
//
//        headerTextView?.text = getFormattedDate(c.time, activity)
//        headerTextView?.text = selectedDateLocale

//        val selectedDateLocale = monthDayFormatLocale?.format(Date())
//        headerTextView?.text = selectedDateLocale

//    }

//

    @SuppressLint("SimpleDateFormat")
    fun getFormattedDate(date: Date?, context: Context): String? {
        val simpDate = SimpleDateFormat("yyyy-MM-dd")
        return simpDate.format(date).toString()
    }

    fun capitalizeString(str: String): String {
        var retStr = str
        try { // We can face index out of bound exception if the string is null
            retStr = str.substring(0, 1).toUpperCase() + str.substring(1)
        } catch (e: Exception) {
        }
        return retStr
    }

    fun todayDate(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val currentDate = sdf.format(Date())
        return currentDate
    }

    fun weekStartDate(): String {
        val cal = Calendar.getInstance()
        cal[Calendar.DAY_OF_WEEK] = cal.firstDayOfWeek
        val firstWkDay: Date = cal.getTime()
        cal.add(Calendar.DAY_OF_WEEK, 6)
        val lastWkDay: Date = cal.getTime()
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val firstDay = sdf.format(firstWkDay)
        val lastDay = sdf.format(lastWkDay)
        return firstDay
    }

    fun weekEndDate(): String {
        val cal = Calendar.getInstance()
        cal[Calendar.DAY_OF_WEEK] = cal.firstDayOfWeek
        val firstWkDay: Date = cal.getTime()
        cal.add(Calendar.DAY_OF_WEEK, 6)
        val lastWkDay: Date = cal.getTime()
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val firstDay = sdf.format(firstWkDay)
        val lastDay = sdf.format(lastWkDay)
        return lastDay
    }

    fun monthStartDate(): String {
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, 0)
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH))
        val nextMonthFirstDay: Date = calendar.getTime()
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
        val nextMonthLastDay: Date = calendar.getTime()
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return sdf.format(nextMonthFirstDay).toString()
    }

    fun monthEndDate(): String {
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, 0)
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH))
        val nextMonthFirstDay: Date = calendar.getTime()
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
        val nextMonthLastDay: Date = calendar.getTime()
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return sdf.format(nextMonthLastDay).toString()
    }

    fun yearStartDate(): String {
        val sdf2 = SimpleDateFormat("yyyy")
        val currentDate = sdf2.format(Date())

        val sdf = SimpleDateFormat("yyyy-MM-dd")

        val year = Integer.parseInt(currentDate.toString())
        val calendarStart = Calendar.getInstance()
        calendarStart[Calendar.YEAR] = year
        calendarStart[Calendar.MONTH] = 0
        calendarStart[Calendar.DAY_OF_MONTH] = 1
        // returning the first date
        // returning the first date
        val firstDay = sdf.format(calendarStart.time)
        // startDate = firstDay.toString()

        val calendarEnd = Calendar.getInstance()
        calendarEnd[Calendar.YEAR] = year
        calendarEnd[Calendar.MONTH] = 11
        calendarEnd[Calendar.DAY_OF_MONTH] = 31

        val endDay = sdf.format(calendarEnd.time)
        // endDate = endDay.toString()

        return firstDay.toString()
    }

    fun yearEndDate(): String {
        val sdf2 = SimpleDateFormat("yyyy")
        val currentDate = sdf2.format(Date())

        val sdf = SimpleDateFormat("yyyy-MM-dd")

        val year = Integer.parseInt(currentDate.toString())
        val calendarStart = Calendar.getInstance()
        calendarStart[Calendar.YEAR] = year
        calendarStart[Calendar.MONTH] = 0
        calendarStart[Calendar.DAY_OF_MONTH] = 1
        // returning the first date
        // returning the first date
        val firstDay = sdf.format(calendarStart.time)
        // startDate = firstDay.toString()

        val calendarEnd = Calendar.getInstance()
        calendarEnd[Calendar.YEAR] = year
        calendarEnd[Calendar.MONTH] = 11
        calendarEnd[Calendar.DAY_OF_MONTH] = 31

        val endDay = sdf.format(calendarEnd.time)
        // endDate = endDay.toString()

        return endDay.toString()
    }


    fun dateConvertToDisplay(inputString: String?): String? {
        try {
            @SuppressLint("SimpleDateFormat") val inputFormat: DateFormat =
                SimpleDateFormat("yyyy-MM-dd")
            val date = inputFormat.parse(inputString)
            // Format date into output format
            @SuppressLint("SimpleDateFormat") val outputFormat: DateFormat =
                SimpleDateFormat("yyyy-MM-dd")
            val outputString = outputFormat.format(date)
            return outputString
        } catch (e: Exception) {
            return ""
            e.printStackTrace()
        }
    }

    fun isNetworkAvailable(activity: Context): Boolean {
        val connectivity =
            activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivity != null) {
            val info = connectivity.allNetworkInfo
            if (info != null) {
                for (anInfo in info) {
                    if (anInfo.detailedState == NetworkInfo.DetailedState.CONNECTED) {
                        return true
                    }
                }
            }
        }
        return false
    }

    fun convertStringArrayToString(
        strArr: ArrayList<String?>?,
        delimiter: String?
    ): String? {
        return if (strArr != null && strArr.size > 0) {
            val sb = StringBuilder()
            for (str in strArr) sb.append(str).append(delimiter)
            sb.substring(0, sb.length - 1)
        } else {
            ""
        }
    }

    fun generateGlobalId(): String? {
        return "z" + System.currentTimeMillis()
    }

//    public void showSnackBar(View view, String message) {
//        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
//        snackbar.getView().setBackgroundColor(view.getContext().getResources().getColor(R.color.colorAccent));
//        TextView textView = snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
//        textView.setTextColor(view.getContext().getResources().getColor(R.color.white));
//        snackbar.show();
//    }

    //    public void showSnackBar(View view, String message) {
//        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
//        snackbar.getView().setBackgroundColor(view.getContext().getResources().getColor(R.color.colorAccent));
//        TextView textView = snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
//        textView.setTextColor(view.getContext().getResources().getColor(R.color.white));
//        snackbar.show();
//    }
    fun hideKeyboard(activity: Activity) {
        try {
            val inputManager = activity
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val currentFocusedView = activity.currentFocus
            if (currentFocusedView != null) {
                assert(inputManager != null)
                inputManager.hideSoftInputFromWindow(
                    currentFocusedView.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun showPopUp(mesg: String?, context: Context) {
        val dialog: AlertDialog
        val builder = AlertDialog.Builder(context)
        builder.setTitle(context.resources.getString(R.string.alert))
        builder.setMessage(mesg)
            .setCancelable(false)
            .setPositiveButton(
                context.resources.getString(R.string.ok)
            ) { dialog1, id -> dialog1.dismiss() }
        dialog = builder.create()
        dialog.show()
    }

    @SuppressLint("CheckResult")
    fun loadImage(
        context: Context?,
        url: String?,
        imageView: ImageView
    ) {
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.placeholder)
        requestOptions.error(R.drawable.placeholder)
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL)
        if (url != null) {
            Glide.with(context!!).load(url).into(imageView)
        } else {
            imageView.setImageResource(R.drawable.placeholder)
        }
    }

    fun isLocationEnabled(context: Context): Boolean {
        var locationMode = 0
        val locationProviders: String
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            locationMode = try {
                Settings.Secure.getInt(
                    context.contentResolver,
                    Settings.Secure.LOCATION_MODE
                )
            } catch (e: Exception) {
                e.printStackTrace()
                return false
            }
            locationMode != Settings.Secure.LOCATION_MODE_OFF
        } else {
            locationProviders = Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.LOCATION_PROVIDERS_ALLOWED
            )
            !TextUtils.isEmpty(locationProviders)
        }
    }

    fun get4StringsFirst(name: String?): String? {
        var log = ""
        return if (name != null && name.length > 4) {
            val a = name[0]
            val b = name[1]
            val c = name[2]
            val d = name[3]
            val e = name[4]
            log = "" + a + b + c + d + e
            log
        } else {
            name
        }
    }


}