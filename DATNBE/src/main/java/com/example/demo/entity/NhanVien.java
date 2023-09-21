package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String ma;

    @Column(name = "ho_ten")
    private String hoten;

    @Column(name = "ngay_sinh")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngaysinh;

    @Column(name = "dia_chi")
    private String diachi;

    @Column(name = "thanh_pho")
    private String thanhpho;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;

    @Column(name = "mat_khau")
    private String matkhau;

    @Column(name = "trangthai")
    private Integer trangthai;
}
