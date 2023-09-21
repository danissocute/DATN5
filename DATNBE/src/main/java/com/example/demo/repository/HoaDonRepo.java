package com.example.demo.repository;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface HoaDonRepo extends JpaRepository<HoaDon,UUID> {
    @Query("select kh from HoaDon  kh where kh.tongtien like ?1 ")
    Page<HoaDon> search(String keyword, Pageable pageable);
}
