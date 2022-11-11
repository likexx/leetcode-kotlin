package solution

import kotlin.math.ceil
import kotlin.math.roundToInt

class Solution981 {
    class TimeMap() {
        val data = mutableMapOf<String, MutableList<Pair<Int, String>>>()

        fun set(key: String, value: String, timestamp: Int) {
            var values = data[key]
            if (values == null) {
                values= mutableListOf<Pair<Int, String>>()
                values.add(Pair(timestamp, value))
                data[key]=values
            } else {
                var l=0
                var r=values.size-1
                while (l<r) {
                    var m= ceil((l+r)/2.0).roundToInt()
                    if (values[m].first<=timestamp) {
                        l=m
                    } else {
                        r=m-1
                    }
                }
                values.add(l+1, Pair(timestamp, value))
            }
        }

        fun get(key: String, timestamp: Int): String {
            println("get $key")
            var values = data[key]
            if (values==null || values.size==0) {
                println("empty")
                return ""
            }

            var l=0
            var r=values.size-1
            while (l<r) {
//                println(values)
                var m= ceil((l+r)/2.0).roundToInt()
                if (values[m].first>timestamp) {
                    r=m-1
                } else {
                    l=m
                }
            }
            if (values[l].first > timestamp) {
                return ""
            }
            return values[l].second
        }
    }
}