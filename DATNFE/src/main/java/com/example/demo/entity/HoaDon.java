package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hoa_don")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String ma;

    @Column(name = "ngay_tao")
    private Date ngaytao;

    @Column(name = "ngay_thanh_toan")
    private Date ngaythanhtoan;

    @Column(name = "mo_ta")
    private String mota;

    @Column(name = "tong_tien")
    private String tongtien;

    @Column(name = "trangthai")
    private Integer trangthai;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;
}
