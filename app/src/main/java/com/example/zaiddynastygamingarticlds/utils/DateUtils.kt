package com.example.zaiddynastygamingarticlds.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
   fun dateFormatter(date:String): String {
       val dateFormat = SimpleDateFormat(Constants.DEFAULT_DATE_FORMAT)
       val date = dateFormat.parse(date)
       val formatter = SimpleDateFormat(Constants.CUSTOM_DATE_FORMAT)
       return formatter.format(date)
   }
}