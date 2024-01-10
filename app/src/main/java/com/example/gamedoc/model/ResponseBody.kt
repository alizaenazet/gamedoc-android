package com.example.gamedoc.model

class ResponseBody<Tres, Terr>(
    var statusCode: Int,
    val successResponseBody: Tres? = null,
    var errorResponse: Terr? = null
)

