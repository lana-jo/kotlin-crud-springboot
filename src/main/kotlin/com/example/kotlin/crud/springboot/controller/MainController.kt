package com.example.kotlin.crud.springboot.controller

import com.example.kotlin.crud.springboot.model.RequestModel
import com.example.kotlin.crud.springboot.model.ResultModel
import com.example.kotlin.crud.springboot.service.AnggotaService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import lombok.AllArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
@AllArgsConstructor
class MainController {
//    private val anggotaService = AnggotaService()
    private val anggotaService = AnggotaService()
    private  val requestModel = RequestModel()
    private var anggota = anggotaService.doService(requestModel)
    val mapper = jacksonObjectMapper()

    val serialized = mapper.writeValueAsString(anggota)


    fun anggotaController(@RequestBody requestModel: RequestModel) : ResultModel {
        val resultModel = ResultModel()
        if (requestModel != null) {
           /* when(requestModel.action){
                "getdata" ->{
                    anggotaService.doService(requestModel)
                }
                "getList" ->{

                }
            }*/
            resultModel.status= 1
            resultModel.data= serialized
            resultModel.message = "Sukses"
        } else{

            resultModel.status= 0
            resultModel.message = "Gagal"

        }


        return resultModel
    }
}