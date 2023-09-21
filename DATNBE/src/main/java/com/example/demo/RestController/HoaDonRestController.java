package com.example.demo.RestController;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.PageDTO;
import com.example.demo.repository.HoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/hoadon")
public class HoaDonRestController {

    @Autowired
    HoaDonRepo hoaDonRepo;

    @GetMapping()
    public ResponseEntity<?> getAll()  {
        return ResponseEntity.ok(hoaDonRepo.findAll());
    }

    @GetMapping("/phantrang")
    public PageDTO<HoaDon> getPagekhachhang(@RequestParam("page") Optional<Integer> page,
                                            @RequestParam("keyword") Optional<String> keyword) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        Page<HoaDon> khachHangPage;
        if (keyword != null) {
            khachHangPage = hoaDonRepo.search("%" +keyword.get() + "%", pageable);
        } else {
            khachHangPage = hoaDonRepo.findAll(pageable);
        }

        return new PageDTO<>(khachHangPage);

    }
}
