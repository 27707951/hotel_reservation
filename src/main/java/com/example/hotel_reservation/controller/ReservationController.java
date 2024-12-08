package com.example.hotel_reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    @PostMapping("/reserve") // 必須和表單 action 一致
    public String reserve(@RequestParam String checkin,
                          @RequestParam String checkout,
                          @RequestParam String roomType,
                          Model model) {
        // 添加用戶提交的資料到模型中
        model.addAttribute("checkin", checkin);
        model.addAttribute("checkout", checkout);
        model.addAttribute("roomType", roomType);

        // 返回成功畫面名稱
        return "success";
    }
}

