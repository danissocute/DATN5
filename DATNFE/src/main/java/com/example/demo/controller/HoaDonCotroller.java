package com.example.demo.controller;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.PageDTO;
import com.example.demo.repository.HoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HoaDonCotroller {

    @Autowired
    HoaDonRepo hoaDonRepo;

    @ModelAttribute("listdanhsach")
    public List<HoaDon> getall() {
        return hoaDonRepo.getAll();
    }

    @RequestMapping("/admin/hoadon")
    public String index(@ModelAttribute("hoadon") KhachHang khachHang
            , @RequestParam("page") Optional<Integer> pageNumber , Model model
            , @RequestParam("keyword") Optional<String> keyword) {
        PageDTO<HoaDon> page1 = hoaDonRepo.searchAndPaginate(pageNumber.orElse(0),"%" +keyword.orElse("") + "%");
        model.addAttribute("i", 0);
        model.addAttribute("listPKhachhang", page1);
        model.addAttribute("keyword", keyword.orElse(""));
        return "ban_hang_tai_quay/Table";
    }

}
