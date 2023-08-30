package com.example.kotlin.crud.springboot.service

import com.example.kotlin.crud.springboot.entity.Anggota
import com.example.kotlin.crud.springboot.model.RequestModel
import com.example.kotlin.crud.springboot.model.ResultModel
import com.example.kotlin.crud.springboot.repository.AnggotaRepository
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.vertx.core.json.Json.mapper
import lombok.AllArgsConstructor
import org.springframework.boot.json.JsonParser
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service


@Service
@AllArgsConstructor
class AnggotaService {

    private lateinit var anggotaRepository: AnggotaRepository
    private lateinit var anggota: Anggota
    val mapper = jacksonObjectMapper()
    var objectMapper: ObjectMapper = ObjectMapper()
    val serialized = mapper.writeValueAsString(anggota)
//    val serialize = objectMapper.writeValueAsString(anggota)
    var page: Pageable = PageRequest.of(0, 5, Sort.by("anggota_nama").ascending())
    val serialize = objectMapper.writeValueAsString(anggotaRepository.getAllAnggota(anggota.id.toString(), page))
    var list: List<Anggota> = mapper.readValue(serialized)
    fun doService(requestModel: RequestModel): ResultModel {
        val resultModel = ResultModel()

        when (requestModel.action) {
            "getList" -> {
                resultModel.status = 1
                requestModel.data = objectMapper.readValue(serialize)
                resultModel.message = "data Didapatkan"
            }

            "read" -> {
                resultModel.status = 1
                requestModel.data = mapper.readValue(serialized)
                resultModel.message = "data Didapatkan"
            }
            "create"->{
                if (anggota.id == null){
                resultModel.status = 1
                requestModel.data = serialized
//                requestModel.data = anggotaRepository.save(anggota).toString()
                resultModel.message = "data berhasil ditambah"
                } else{
                    resultModel.status = 1
                    requestModel.data = serialized
                    resultModel.message = "data berhasil diupdate"
                }
            }
            "delete" ->{
                resultModel.status = 1
                anggota.id?.let { anggotaRepository.deleteById(it) }
                resultModel.message = "data berhaasil dihapus"
            }
        }

        return resultModel
    }
}