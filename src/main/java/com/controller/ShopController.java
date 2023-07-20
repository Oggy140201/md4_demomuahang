package com.controller;

import com.model.HoaDon;
import com.model.HoaDonChiTiet;
import com.model.SanPham;
import com.service.HoaDonChiTietService;
import com.service.HoaDonService;
import com.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    HttpSession httpSession;

    @Autowired
    HoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/shop")
    public ModelAndView index(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("sanpham", sanPhamService.getAll(PageRequest.of(page, size)));
        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView add(int id, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("/giohang");
        httpSession.setAttribute("sanphams",hoaDonService.addSanPham(sanPhamService.findById(id), session));
        return modelAndView;
    }

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        List<SanPham> list = (List<SanPham>) httpSession.getAttribute("sanphams");
        modelAndView.addObject("sanphams", list);
        modelAndView.addObject("total", httpSession.getAttribute("total"));
        return modelAndView;
    }

    @GetMapping("/thanhtoan")
    public String thanhtoan() {
        List<SanPham> sanPhams = (List<SanPham>) httpSession.getAttribute("sanPhams");
        if (sanPhams != null) {
            double total = (double) httpSession.getAttribute("total");
            HoaDon hoaDon = new HoaDon(0, new Date(System.currentTimeMillis()), total);
            hoaDonService.save(hoaDon);
            for (SanPham sp : sanPhams) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(0, sp.getQuantity(), hoaDon, (SanPham) sanPhams);
                hoaDonChiTietService.save(hoaDonChiTiet);

                SanPham sanPham = sanPhamService.findById(sp.getId());
                sanPham.setQuantity(sanPham.getQuantity() - sp.getQuantity());
                sanPhamService.edit(sanPham);
            }
            httpSession.setAttribute("sanPhams", null);
        }
        return "redirect:/shop";
    }

}
