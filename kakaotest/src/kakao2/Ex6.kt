package kakao2

import com.sun.org.apache.xerces.internal.xs.StringList
import java.util.regex.Pattern

fun main(args: Array<String>) {
    val word = "blind"
    val pages = arrayOf("<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blinD\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>")
    val result = solution(word, pages)

    println("결과: "+result)
}
fun solution(word: String, pages: Array<String>): Int {
    val newPages = mutableListOf<WebPage>()
    // WebPage 객체를 생성한다.
    for (page in pages) {
        newPages.add(WebPage(getUrl(page), findWord(word, page), countHrefLink(page), getHrefLinkArray(page)))
    }
    println(newPages)
    // 총점을 낸다

    // 결과 출력
    var answer = 0
    return answer
}

private fun getUrl(page: String): String {
    // 현재 페이지의 url을 가져오자
    val regex1 = "content="
    val regex2 = "/>"
    val url = page.substringAfterLast(regex1).substringBefore(regex2)
    println(url)
    return url
}

private fun findWord(word: String, page: String): Int {
    // body 태그 사이에 있는 string을 받아오자
    val regex1 = "<body>"
    val regex2 = "</body>"
    var count = 0
    val body = page.substringAfterLast(regex1).substringBefore(regex2)
    // 검색어의 갯수를 센다
    val groupMatcher = Pattern.compile("(?i)$word").matcher(body)
    while(groupMatcher.find()) {
        count++
    }

    return count
}

private fun countHrefLink(page: String): Int {
    // a태그 href 의 갯수를 센다
    val regex = "<a href="
    var count = 0
    val groupMatcher = Pattern.compile(regex).matcher(page)
    while(groupMatcher.find()) {
        count++
    }

    return count
}

private fun getHrefLinkArray(page:String): List<String> {
    // url리스트 생성
    val urlList = mutableListOf<String>()
    // body 태그 사이에 있는 string을 받아오자
    val body = page.substringAfterLast("<body>").substringBefore("</body>")
    // a태그 href의 url을 가져온다
    val regex1 = "<a href="
    val regex2 = ">"
    val code = body.split("</a>")
    for(i in code) {
        val url = i.substringAfterLast(regex1).substringBefore(regex2)
        if(url.isNotBlank())  urlList.add(url)
    }

    println(urlList)
    return urlList
}

data class WebPage(
        var url: String?,
        var common: Int?,
        var linkCount: Int?,
        var href: List<String>?
        )