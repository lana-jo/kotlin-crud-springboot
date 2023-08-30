package com.example.kotlin.crud.springboot.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

class ResultModel : Serializable {

    @JsonProperty("status")
    var status: Int = 0
    @JsonProperty("message")
    var message: String? = null
    @JsonProperty("data")
    var data: String? = null
}