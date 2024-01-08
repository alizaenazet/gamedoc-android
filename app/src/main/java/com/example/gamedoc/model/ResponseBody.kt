package com.example.gamedoc.model

class ResponseBody<Tres, Terr>(
   val statusCode: Int,
   val successResponseBody: Tres? = null,
   val errorResponse: Terr? = null
)

