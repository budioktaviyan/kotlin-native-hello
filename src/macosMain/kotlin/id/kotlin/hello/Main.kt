package id.kotlin.hello

import kotlinx.cinterop.toKString
import libcurl.CURLE_OK
import libcurl.CURLOPT_FOLLOWLOCATION
import libcurl.CURLOPT_URL
import libcurl.curl_easy_cleanup
import libcurl.curl_easy_init
import libcurl.curl_easy_perform
import libcurl.curl_easy_setopt
import libcurl.curl_easy_strerror

@ExperimentalUnsignedTypes
fun main(args: Array<String>) {
  if (args.size == 1) {
    val curl = curl_easy_init()
    if (null != curl) {
      curl_easy_setopt(curl, CURLOPT_URL, args[0])
      curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L)

      val result = curl_easy_perform(curl)
      if (result != CURLE_OK) {
        println("curl_easy_perform() failed ${curl_easy_strerror(result)?.toKString()}")
      }

      curl_easy_cleanup(curl)
    }
  } else {
    println("Please provide a URL!")
  }
}