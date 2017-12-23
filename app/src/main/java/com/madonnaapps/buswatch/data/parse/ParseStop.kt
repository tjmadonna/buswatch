/*
 * Copyright 2017 Tyler Madonna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.madonnaapps.buswatch.data.parse

import com.google.gson.annotations.SerializedName
import com.madonnaapps.buswatch.data.local.Stop

data class ParseStop(

        @SerializedName("stop_code") val code: Long,

        @SerializedName("stop_name") val title: String,

        @SerializedName("stop_lat") val latitude: Double,

        @SerializedName("stop_lon") val longitude: Double

) {
    companion object {

        fun listToDatabaseStops(parseStops: List<ParseStop>): List<Stop> {

            return parseStops.map {
                Stop(it.code, it.code, it.title, it.latitude, it.longitude)
            }

        }

    }

}