package com.example.kotlin.crud.springboot.repository;

import com.example.kotlin.crud.springboot.entity.Anggota
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AnggotaRepository : JpaRepository<Anggota, Int> {

    fun findId(id: Int): Anggota?
    @Query("select a from Anggota a " +
            "where ( (:search is not null and a.anggotaNama like concat('%', :search, '%') ) or :search is null)")
    fun getAllAnggota(search: String, pageable: Pageable)
}