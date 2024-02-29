/*
 * Copyright 2016 - 2022 Anton Tananaev (anton.tananaev@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tananaev.logcat

import java.util.regex.Pattern

class Line(val content: String) {

    var date:String? = null
    var time:String? = null
    var PID:String? = null
    var TID:String? = null
    var priority:Char? = null
    var tag:String? = null
    var message:String? = null

    init {
        val list = content.split("\\s+".toRegex())
        if(list.size > 5) {
            date = list[0]
            time = list[1]
            PID = list[2] // process ID
            TID = list[3] // thread ID
            priority = list[4][0] // priority D,W,E,V
            tag = list[5]
            message = list.subList(6, list.size).let {
                var concat = ""
                for (i in it) concat += "$i "
                concat
            }
        }
    }
//
//    companion object {
//        private val linePattern =
//            Pattern.compile("\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d\\.\\d\\d\\d (\\w)/(\\w+).*")
//    }

}
